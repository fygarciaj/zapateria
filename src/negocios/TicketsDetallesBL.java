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
public class TicketsDetallesBL extends BaseBL {

    private static final Logger LOG = Logger.getLogger(ClientesBL.class.getName());
    private Integer id = null;
    private static Connection con = null;
    private static ConexionDB cxn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;
    DefaultTableModel model = new DefaultTableModel();
    private static final String tableName = "Reparaciones";

    public TicketsDetallesBL() {

        cxn = new ConexionDB();

        // Si no existe la tabla ClientesBL Crearla Automaticamente
        if (!cxn.tableExist(tableName)) {
            Statement stmt = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                con = cxn.openDB();
                stmt = con.createStatement();

                String sql = "CREATE TABLE IF NOT EXISTS `zapateria`.`tickets_detalles` (\n"
                        + "  `id` INT NOT NULL AUTO_INCREMENT,\n"
                        + "  `valor_unitario` DECIMAL(15,0) NOT NULL,\n"
                        + "  `cantidad` INT NOT NULL,\n"
                        + "  `subtotal` DECIMAL(15,0) NOT NULL,\n"
                        + "  `tickets_id` INT NOT NULL,\n"
                        + "  `reparaciones_id` INT NOT NULL,\n"
                        + "  PRIMARY KEY (`id`),\n"
                        + "  UNIQUE INDEX `id_UNIQUE` (`id` ASC),\n"
                        + "  INDEX `fk_tickets_detalles_tickets1_idx` (`tickets_id` ASC),\n"
                        + "  INDEX `fk_tickets_detalles_reparaciones1_idx` (`reparaciones_id` ASC),\n"
                        + "  CONSTRAINT `fk_tickets_detalles_tickets1`\n"
                        + "    FOREIGN KEY (`tickets_id`)\n"
                        + "    REFERENCES `zapateria`.`tickets` (`id`)\n"
                        + "    ON DELETE NO ACTION\n"
                        + "    ON UPDATE NO ACTION,\n"
                        + "  CONSTRAINT `fk_tickets_detalles_reparaciones1`\n"
                        + "    FOREIGN KEY (`reparaciones_id`)\n"
                        + "    REFERENCES `zapateria`.`reparaciones` (`id`)\n"
                        + "    ON DELETE NO ACTION\n"
                        + "    ON UPDATE NO ACTION)\n"
                        + "ENGINE = InnoDB;";

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

    
    public static void create(Double valor_unitario, Integer cantidad, Double subtotal, Integer tickets_id, Integer reparaciones_id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = cxn.openDB();
            String sqlQuery = "INSERT INTO tickets_detalles(valor_unitario, cantidad, subtotal, tickets_id, reparaciones_id) VALUES(?,?,?,?,?);";
            java.sql.PreparedStatement stmt = con.prepareStatement(sqlQuery);

            stmt.setDouble(1, valor_unitario);
            stmt.setInt(2, cantidad);
            stmt.setDouble(3, subtotal);
            stmt.setInt(4, tickets_id);
            stmt.setInt(5, reparaciones_id);

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

    public void update(Double valor_unitario, Integer cantidad, Double subtotal, Integer tickets_id, Integer reparaciones_id, Integer id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();
            String sqlQuery = "UPDATE usuarios SET valor_unitario=?, cantidad=?, subtotal=?, tickets_id=?, reparaciones_id=? WHERE id=?";
            stmt = con.prepareStatement(sqlQuery);
           
            stmt.setDouble(1, valor_unitario);
            stmt.setInt(2, cantidad);
            stmt.setDouble(3, subtotal);
            stmt.setInt(4, tickets_id);
            stmt.setInt(5, reparaciones_id);
            stmt.setInt(6, id);

            stmt.executeUpdate();
            con.close();

            JOptionPane.showMessageDialog(null, "Se ha modificado un registro en " + tableName);

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

                JOptionPane.showMessageDialog(null, "Se ha eliminado el registro con el indice #" + Id);

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
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
            LOG.log(Level.SEVERE, null, e);
            return model;
        }

        return model;
    }
    
}
