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
public class RolesUsuariosBL {

    private static final Logger LOG = Logger.getLogger(PermisosBL.class.getName());
    private Integer id = null;
    private Integer roles_id = null;
    private Integer permisos_id = null;
    private static Connection con = null;
    private static ConexionDB cxn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;
    DefaultTableModel model = new DefaultTableModel();
    private static final String tableName = "permisos_roles";

    public RolesUsuariosBL() {
        if (!cxn.tableExist(tableName)) {
            Statement stmt = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                con = cxn.openDB();
                stmt = con.createStatement();

                String sql = "CREATE TABLE IF NOT EXISTS `zapateria`.`roles_usuarios` (\n"
                        + "  `roles_id` INT UNSIGNED NOT NULL,\n"
                        + "  `usuarios_id` INT UNSIGNED NOT NULL,\n"
                        + "  PRIMARY KEY (`roles_id`, `usuarios_id`),\n"
                        + "  INDEX `fk_roles_has_usuarios_usuarios1_idx` (`usuarios_id` ASC),\n"
                        + "  INDEX `fk_roles_has_usuarios_roles1_idx` (`roles_id` ASC),\n"
                        + "  CONSTRAINT `fk_roles_has_usuarios_roles1`\n"
                        + "    FOREIGN KEY (`roles_id`)\n"
                        + "    REFERENCES `zapateria`.`roles` (`id`)\n"
                        + "    ON DELETE NO ACTION\n"
                        + "    ON UPDATE NO ACTION,\n"
                        + "  CONSTRAINT `fk_roles_has_usuarios_usuarios1`\n"
                        + "    FOREIGN KEY (`usuarios_id`)\n"
                        + "    REFERENCES `zapateria`.`usuarios` (`id`)\n"
                        + "    ON DELETE NO ACTION\n"
                        + "    ON UPDATE NO ACTION)\n"
                        + "ENGINE = InnoDB";

                stmt.executeUpdate(sql);

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
                LOG.log(Level.SEVERE, null, e);
                System.exit(0);
            }
            System.out.println("Se ha creado la tabla " + tableName);
        }
    }

    public static void create(Integer roles_id, Integer usuarios_id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = cxn.openDB();
            String sqlQuery = "INSERT INTO roles_usuarios(roles_id, usuarios_id) VALUES(?, ?);";
            java.sql.PreparedStatement stmt = con.prepareStatement(sqlQuery);

            stmt.setInt(1, roles_id);
            stmt.setInt(2, usuarios_id);

            stmt.executeUpdate();

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

    public void update(Integer usuarios_id, Integer roles_id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();
            String sqlQuery = "UPDATE ? usuarios_id=? WHERE roles_id=?";
            stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, tableName);
            stmt.setInt(2, usuarios_id);
            stmt.setInt(3, roles_id);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se ha modificado un " + tableName);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al modificar " + tableName);
            LOG.log(Level.SEVERE, null, e);
        }
    }

    public static void delete(Integer roles_id) {
        if (roles_id != null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = cxn.openDB();
                String sqlQuery = "DELETE FROM ? WHERE id=?";
                stmt = con.prepareStatement(sqlQuery);

                stmt.setString(1, tableName);
                stmt.setInt(2, roles_id);

                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Se ha eliminado con el indice #" + roles_id);

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

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
            LOG.log(Level.SEVERE, null, e);
            return model;
        }

        return model;
    }
    
}
