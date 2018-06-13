/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import java.sql.PreparedStatement;
import conexion.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import datos.Clientes;

/**
 * 
 * @author REBOOTSYSTEM
 */
public class ClientesBL extends BaseBL {

    private static final Logger LOG = Logger.getLogger(ClientesBL.class.getName());
    private Integer id = null;
    private Integer identificacion = null;
    private String nombreCompleto = null;
    private Date fechaNacimiento = null;
    private String telefono = null;
    private String direccion = null;
    private static Connection con = null;
    private static ConexionDB cxn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;
    DefaultTableModel model = new DefaultTableModel();
    private static final String tableName = "clientes";

    public ClientesBL() {

        cxn = new ConexionDB();

        // Si no existe la tabla ClientesBL Crearla Automaticamente
        if (!cxn.tableExist(tableName)) {
            Statement stmt = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                con = cxn.openDB();
                stmt = con.createStatement();

                String sql = "CREATE TABLE `clientes` (\n"
                        + "	`id` INT(11) NOT NULL AUTO_INCREMENT,\n"
                        + "	`identificacion` VARCHAR(20) NOT NULL COLLATE 'utf8_spanish2_ci',\n"
                        + "	`nombre_completo` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8_spanish2_ci',\n"
                        + "	`fecha_nacimiento` DATE NULL DEFAULT NULL,\n"
                        + "	`telefono` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8_spanish2_ci',\n"
                        + "	`direccion` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8_spanish2_ci',\n"
                        + "	PRIMARY KEY (`id`),\n"
                        + "	UNIQUE INDEX `identificacion_UNIQUE` (`identificacion`),\n"
                        + "	UNIQUE INDEX `id_UNIQUE` (`id`)\n"
                        + ")\n"
                        + "COLLATE='utf8_spanish2_ci'\n"
                        + "ENGINE=InnoDB;";

                stmt.executeUpdate(sql);
                stmt.close();
                con.close();
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
                LOG.log(Level.SEVERE, null, e);
                System.exit(0);
            }
            System.out.println("Se ha creado la tabla");
        }
    }

    public static void create(Integer identificacion, String nombreCompleto, Date fechaNacimiento, String telefono, String direccion) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = cxn.openDB();
            String sqlQuery = "INSERT INTO clientes(identificacion, nombre_completo, fecha_nacimiento, telefono, direccion) VALUES( ?, ?, ?, ?, ?);";
            java.sql.PreparedStatement stmt = con.prepareStatement(sqlQuery);

            stmt.setInt(1, identificacion);
            stmt.setString(2, nombreCompleto);
            stmt.setDate(3, fechaNacimiento);
            stmt.setString(4, telefono);
            stmt.setString(5, direccion);

            stmt.executeUpdate();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
            LOG.log(Level.SEVERE, null, e);
        }

    }

    /**
     * Busca un Cliente por el id
     *
     * @param Id
     */
    public static void findById(Integer Id) {

    }

    /**
     * Busca un cliente por un campo diferente al id
     */
    public static void findByField() {

    }

    public void update(String nombreCompleto, Date fechaNacimiento, String telefono, String direccion, int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();
            String sqlQuery = "UPDATE clientes SET nombre_completo=?, fecha_nacimiento=?, telefono=?, direccion=? WHERE id=?";
            stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, nombreCompleto);
            stmt.setDate(2, fechaNacimiento);
            stmt.setString(3, telefono);
            stmt.setString(4, direccion);

            stmt.executeUpdate();
            con.close();

            JOptionPane.showMessageDialog(null, "Se ha modificado un cliente");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al modificar un cliente");
            LOG.log(Level.SEVERE, null, e);
        }
    }

    public static void delete(Integer Id) {
        if (Id != null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = cxn.openDB();
                String sqlQuery = "DELETE FROM clientes WHERE id=?";
                stmt = con.prepareStatement(sqlQuery);

                stmt.setInt(1, Id);

                stmt.executeUpdate();
                con.close();

                con.close();

                JOptionPane.showMessageDialog(null, "Se ha eliminado el cliente con el indice #" + Id);

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar un cliente [" + e.getClass().getName() + ": " + e.getMessage() + "]");
                LOG.log(Level.SEVERE, null, e);
            }

        }
    }

    public DefaultTableModel listar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();

            Statement st = con.createStatement();
            String query = "SELECT * FROM clientes";
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
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
            LOG.log(Level.SEVERE, null, e);
            return model;
        }

        return model;
    }

}
