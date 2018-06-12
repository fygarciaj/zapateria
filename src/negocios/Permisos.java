/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author REBOOTSYSTEM
 */
public class Permisos extends Base {

    private static final Logger LOG = Logger.getLogger(Permisos.class.getName());
    private Integer id = null;
    private String nombre = null;
    private String descripcion = null;
    private static Connection con = null;
    private static ConexionDB cxn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;
    DefaultTableModel model = new DefaultTableModel();
    private static final String tableName = "permisos";

    /**
     * El constructor revisa si no existe la tabla, en tal caso la crea.
     *
     */
    public Permisos() {

        cxn = new ConexionDB();


        if (!cxn.tableExist(tableName)) {
            Statement stmt = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                con = cxn.openDB();
                stmt = con.createStatement();

                String sql = "CREATE TABLE `permisos` (\n"
                        + "	`Id` INT(10) NOT NULL AUTO_INCREMENT,\n"
                        + "	`nombre` VARCHAR(50) NOT NULL DEFAULT '0' COLLATE 'utf8_spanish2_ci',\n"
                        + "	`descripcion` VARCHAR(50) NULL DEFAULT '0' COLLATE 'utf8_spanish2_ci',\n"
                        + "	PRIMARY KEY (`Id`),\n"
                        + "	UNIQUE INDEX `nombre` (`nombre`)\n"
                        + ")\n"
                        + "COLLATE='utf8_spanish2_ci'\n"
                        + "ENGINE=InnoDB\n"
                        + ";";

                stmt.executeUpdate(sql);
                stmt.close();
                con.close();
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
                LOG.log(Level.SEVERE, null, e);
                System.exit(0);
            }
            System.out.println("Se ha creado la tabla " + tableName);
        }

    }

    /**
     * Crea un nuevo registro en la tabla $tableName
     *
     * @param nombre
     * @param descripcion
     */
    public static void create(String nombre, String descripcion) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = cxn.openDB();
            String sqlQuery = "INSERT INTO permisos(nombre, descripcion) VALUES(?, ?);";
            java.sql.PreparedStatement stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);

            stmt.executeUpdate();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
            LOG.log(Level.SEVERE, null, e);
        }

    }

    /**
     * Busca un registro por el id
     *
     * @param Id
     */
    public static void findById(Integer Id) {

    }

    /**
     * Busca un registro por un campo diferente al id
     */
    public static void findByField() {

    }

    public void update(String rol, Integer id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();
            String sqlQuery = "UPDATE ? SET nombre=?, descripcion=? WHERE id=?";
            stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, tableName);
            stmt.setString(2, nombre);
            stmt.setString(3, descripcion);
            stmt.setInt(4, id);

            stmt.executeUpdate();
            con.close();

            JOptionPane.showMessageDialog(null, "Se ha modificado un " + tableName);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al modificar " + tableName);
            LOG.log(Level.SEVERE, null, e);
        }
    }

    public static void delete(Integer Id) {
        if (Id != null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = cxn.openDB();
                String sqlQuery = "DELETE FROM ? WHERE id=?";
                stmt = con.prepareStatement(sqlQuery);

                stmt.setString(1, tableName);
                stmt.setInt(2, Id);

                stmt.executeUpdate();
                con.close();

                con.close();

                JOptionPane.showMessageDialog(null, "Se ha eliminado el rol con el indice #" + Id);

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar " + tableName + " " + e.getClass().getName() + ": " + e.getMessage() + "]");
                LOG.log(Level.SEVERE, null, e);
            }

        }
    }

    public DefaultTableModel listar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();

            Statement st = con.createStatement();
            String query = "SELECT * FROM " + tableName;
            rs = st.executeQuery(query);
            ResultSetMetaData rsMd = rs.getMetaData();

            int countColumns = rsMd.getColumnCount();

            for (int i = 0; i < countColumns; i++) {
                model.addColumn(rsMd.getColumnLabel(i + 1));
            }

            while (rs.next()) {
                Object[] fila = new Object[countColumns];
                for (int i = 0; i < countColumns; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
            LOG.log(Level.SEVERE, null, e);
            return model;
        }

        return model;
    }

}
