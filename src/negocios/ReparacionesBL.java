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
import datos.Reparacion;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author REBOOTSYSTEM
 */
public class ReparacionesBL extends BaseBL {

    private static final Logger LOG = Logger.getLogger(ClientesBL.class.getName());


    private Integer id = null;
    private static Connection con = null;
    private static ConexionDB cxn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;
    DefaultTableModel model = new DefaultTableModel();
    private static final String tableName = "Reparaciones";

    public ReparacionesBL() {
        cxn = new ConexionDB();

        // Si no existe la tabla ClientesBL Crearla Automaticamente
        if (!cxn.tableExist(tableName)) {
            Statement stmt = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                con = cxn.openDB();
                stmt = con.createStatement();

                String sql = "CREATE TABLE IF NOT EXISTS `zapateria`.`reparaciones` (\n"
                        + "  `id` INT NOT NULL AUTO_INCREMENT,\n"
                        + "  `descripcion_reparacion` TEXT NULL,\n"
                        + "  `valor` DECIMAL(15,0) NULL,\n"
                        + "  `clientes_id` INT NOT NULL,\n"
                        + "  `usuarios_id` INT NOT NULL,\n"
                        + "  `tipos_calzados_id` INT NOT NULL,\n"
                        + "  PRIMARY KEY (`id`),\n"
                        + "  UNIQUE INDEX `id_UNIQUE` (`id` ASC),\n"
                        + "  INDEX `fk_reparaciones_clientes1_idx` (`clientes_id` ASC),\n"
                        + "  INDEX `fk_reparaciones_usuarios1_idx` (`usuarios_id` ASC),\n"
                        + "  INDEX `fk_reparaciones_tipos_calzados1_idx` (`tipos_calzados_id` ASC),\n"
                        + "  CONSTRAINT `fk_reparaciones_clientes1`\n"
                        + "    FOREIGN KEY (`clientes_id`)\n"
                        + "    REFERENCES `zapateria`.`clientes` (`id`)\n"
                        + "    ON DELETE NO ACTION\n"
                        + "    ON UPDATE NO ACTION,\n"
                        + "  CONSTRAINT `fk_reparaciones_usuarios1`\n"
                        + "    FOREIGN KEY (`usuarios_id`)\n"
                        + "    REFERENCES `zapateria`.`usuarios` (`id`)\n"
                        + "    ON DELETE NO ACTION\n"
                        + "    ON UPDATE NO ACTION,\n"
                        + "  CONSTRAINT `fk_reparaciones_tipos_calzados1`\n"
                        + "    FOREIGN KEY (`tipos_calzados_id`)\n"
                        + "    REFERENCES `zapateria`.`tipos_calzados` (`id`)\n"
                        + "    ON DELETE NO ACTION\n"
                        + "    ON UPDATE NO ACTION)\n"
                        + "ENGINE = InnoDB;";

                stmt.executeUpdate(sql);

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
                LOG.log(Level.SEVERE, null, e);
                System.exit(0);
            }
            System.out.println("Se ha creado la tabla");
        }
    }

    public static void create(String descripcion_reparacion, Double valor, Integer clientes_id, Integer usuarios_id, Integer tipos_calzados_id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = cxn.openDB();
            String sqlQuery = "INSERT INTO reparaciones(descripcion_reparacion, valor, clientes_id, usuarios_id, tipos_calzados_id) VALUES(?,?,?,?,?);";
            java.sql.PreparedStatement stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, descripcion_reparacion);
            stmt.setDouble(2, valor);
            stmt.setInt(3, clientes_id);
            stmt.setInt(4, usuarios_id);
            stmt.setInt(5, tipos_calzados_id);

            stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
            LOG.log(Level.SEVERE, null, e);
        }

    }

    public static void create(Reparacion reparacion) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = cxn.openDB();
            String sqlQuery = "INSERT INTO reparaciones(descripcion_reparacion, valor, clientes_id, usuarios_id, tipos_calzados_id) VALUES(?,?,?,?,?);";
            java.sql.PreparedStatement stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, reparacion.getDescripcionReparacion());
            stmt.setDouble(2, reparacion.getValor());
            stmt.setInt(3, reparacion.getClienteID());
            stmt.setInt(4, reparacion.getUsuariosId());
            stmt.setInt(5, reparacion.getTipoCalzadoId());

            stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
            LOG.log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

    }

    /**
     * Busca un registro por el id
     *
     * @param Id
     */
    public static Reparacion findById(Integer id) {
        Reparacion reparacion = new Reparacion();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();
            String sqlQuery = "SELECT * FROM reparaciones WHERE id=?";
            stmt = con.prepareStatement(sqlQuery);

            stmt.setInt(1, id);

            ResultSet rst = stmt.executeQuery();

            if (rst.next()) {
                reparacion.setId(rst.getInt("id"));
                reparacion.setDescripcionReparacion(rst.getString("descripcion_reparacion"));
                reparacion.setClienteID(rst.getInt("clientes_id"));
                reparacion.setUsuariosId(rst.getInt("usuarios_id"));
                reparacion.setValor(rst.getDouble("valor"));
                reparacion.setTipoCalzadoId(rst.getInt("tipos_calzados_id"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error buscar el reparacion " + tableName);
            LOG.log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

        return reparacion;
    }

    /**
     * Busca un registro por un campo diferente al id
     */
    public static void findByField() {

    }

    public void update(String descripcion_reparacion, Double valor, Integer reparacions_id, Integer usuarios_id, Integer tipos_calzados_id, Integer id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();
            String sqlQuery = "UPDATE usuarios SET descripcion_reparacion=?, valor=?, reparacions_id=?, usuarios_id=?, tipos_calzados_id=? WHERE id=?";
            stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, descripcion_reparacion);
            stmt.setDouble(2, valor);
            stmt.setInt(3, reparacions_id);
            stmt.setInt(4, usuarios_id);
            stmt.setInt(5, tipos_calzados_id);
            stmt.setInt(6, id);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se ha modificado un registro en " + tableName);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al modificar " + tableName);
            LOG.log(Level.SEVERE, null, e);
        }
    }

    public static void update(Reparacion reparacion, Integer id) {

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

                JOptionPane.showMessageDialog(null, "Se ha eliminado el registro con el indice #" + Id);

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar " + tableName + " " + e.getClass().getName() + ": " + e.getMessage() + "]");
                LOG.log(Level.SEVERE, null, e);
            }

        }
    }

    public static DefaultTableModel listar() {
        String[] columns = {"Id", "Descripción", "Valor", "Tipo Calzado"};
        DefaultTableModel model = new DefaultTableModel(null, columns);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();

            Statement st = con.createStatement();
            String query = "SELECT * FROM " + tableName;
            rs = st.executeQuery(query);
            ResultSetMetaData rsMd = rs.getMetaData();

            int countColumns = rsMd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[countColumns];
                for (int i = 0; i < countColumns; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
            LOG.log(Level.SEVERE, null, e);
            return model;
        }

        return model;
    }

    /**
     * Clase para llenar los combos de reparaciones
     */
    public static class ReparacionesCBO {
        
            Integer id;
            String descripcion_reparacion;
            Double valor;

        public ReparacionesCBO() {
        }

        public ReparacionesCBO(Integer id, String descripcion_reparacion, Double valor) {
            this.id = id;
            this.descripcion_reparacion = descripcion_reparacion;
            this.valor = valor;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getDescripcion_reparacion() {
            return descripcion_reparacion;
        }

        public void setDescripcion_reparacion(String descripcion_reparacion) {
            this.descripcion_reparacion = descripcion_reparacion;
        }

        public Double getValor() {
            return valor;
        }

        public void setValor(Double valor) {
            this.valor = valor;
        }

        @Override
        public String toString() {
            return descripcion_reparacion;
        }
            
        
            
    
    }
    
    
    public static DefaultComboBoxModel cboReparaciones() {

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();

            Statement st = con.createStatement();
            String query = "SELECT id, descripcion_reparacion, valor FROM reparaciones";
            rs = st.executeQuery(query);
            ResultSetMetaData rsMd = rs.getMetaData();

            int countColumns = rsMd.getColumnCount();

            while (rs.next()) {

//                Object[] fila = new Object[countColumns];
//                for (int i = 0; i < countColumns; i++) {
//                    fila[i] = rs.getObject(i + 1);
//                }
                model.addElement(new ReparacionesCBO(rs.getInt("id"), rs.getString("descripcion_reparacion"), rs.getDouble("valor")));
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
            
            return model;
        }

        return model;
    }
    
        public static DefaultComboBoxModel cboReparaciones(Integer cliente_id) {

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();
            
            String sqlQuery = "SELECT id, descripcion_reparacion, valor FROM reparaciones WHERE clientes_id =?;";
            stmt = con.prepareStatement(sqlQuery);;
            stmt.setInt(1, cliente_id);
            
            rs = stmt.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();

            int countColumns = rsMd.getColumnCount();

            while (rs.next()) {

//                Object[] fila = new Object[countColumns];
//                for (int i = 0; i < countColumns; i++) {
//                    fila[i] = rs.getObject(i + 1);
//                }
                model.addElement(new ReparacionesCBO(rs.getInt("id"), rs.getString("descripcion_reparacion"), rs.getDouble("valor")));
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
            
            return model;
        }

        return model;
    }
    
}
