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

    /**
     * Crea un nuevo objeto reparaciones, verifica que la tabla exista, si no
     * existe crea auromaticamente la tabla.
     */
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
                        + "  `estado` ENUM('En reparación','Terminado','Facturado') NOT NULL DEFAULT 'En reparación' COLLATE 'utf8_spanish2_ci',\n"
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

    /**
     * Crea una reparación utilizando todos los parametros de la reparacion
     *
     * @param descripcion_reparacion
     * @param valor
     * @param clientes_id
     * @param usuarios_id
     * @param tipos_calzados_id
     */
    public static void create(String descripcion_reparacion, Double valor, Integer clientes_id, Integer usuarios_id, Integer tipos_calzados_id, String estado) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = cxn.openDB();
            String sqlQuery = "INSERT INTO reparaciones(descripcion_reparacion, valor, clientes_id, usuarios_id, tipos_calzados_id, estado) VALUES(?,?,?,?,?,?);";
            java.sql.PreparedStatement stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, descripcion_reparacion);
            stmt.setDouble(2, valor);
            stmt.setInt(3, clientes_id);
            stmt.setInt(4, usuarios_id);
            stmt.setInt(5, tipos_calzados_id);
            stmt.setString(6, estado);

            stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
            LOG.log(Level.SEVERE, null, e);
        }

    }

    /**
     * Crea una reparación
     *
     * @param reparacion
     */
    public static void create(Reparacion reparacion) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = cxn.openDB();
            String sqlQuery = "INSERT INTO reparaciones(descripcion_reparacion, valor, clientes_id, usuarios_id, tipos_calzados_id, estado) VALUES(?,?,?,?,?, ?);";
            java.sql.PreparedStatement stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, reparacion.getDescripcionReparacion());
            stmt.setDouble(2, reparacion.getValor());
            stmt.setInt(3, reparacion.getClienteID());
            stmt.setInt(4, reparacion.getUsuariosId());
            stmt.setInt(5, reparacion.getTipoCalzadoId());
            stmt.setString(6, reparacion.getEstado());

            stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
            LOG.log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

    }

    /**
     * Busca un registro de reparacion por el id
     *
     * @param id
     * @return 
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
                reparacion.setEstado(rst.getString("estado"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error buscar el reparacion " + tableName);
            LOG.log(Level.SEVERE, null, e);
        }

        return reparacion;
    }

    /**
     * Acualiza una reparacion por el indice
     *
     * @param descripcion_reparacion
     * @param valor
     * @param reparacions_id
     * @param usuarios_id
     * @param tipos_calzados_id
     * @param id
     */
    public void update(String descripcion_reparacion, Double valor, Integer reparacions_id, Integer usuarios_id, Integer tipos_calzados_id, Integer id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();
            String sqlQuery = "UPDATE reparaciones SET descripcion_reparacion=?, valor=?, reparacions_id=?, usuarios_id=?, tipos_calzados_id=? WHERE id=?";
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
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();
            String sqlQuery = "UPDATE reparaciones SET descripcion_reparacion=?, valor=?, clientes_id=?, usuarios_id=?, tipos_calzados_id=? WHERE id=?";
            stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, reparacion.getDescripcionReparacion());
            stmt.setDouble(2, reparacion.getValor());
            stmt.setInt(3, reparacion.getClienteID());
            stmt.setInt(4, reparacion.getUsuariosId());
            stmt.setInt(5, reparacion.getTipoCalzadoId());
            stmt.setInt(6, id);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se ha modificado un registro en " + tableName);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al modificar " + tableName);
            LOG.log(Level.SEVERE, null, e);
        }
    }

    /**
     * Elimina una reparacion por el indice
     *
     * @param Id
     */
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

    /**
     * Lista de todas las reparaciones
     *
     * @return DefaultTableModel
     */
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
     * Lista de las reparaciones por cliente
     *
     * @param id
     * @return
     */
    public static DefaultTableModel listarReparacionesCliente(Integer id) {

        String[] columns = {"", "Tipo Calzado", "Descripción", "Valor", "Estado"};
        DefaultTableModel model = new DefaultTableModel(null, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();

            String query = "SELECT reparaciones.id, tipos_calzados.nombre_calzado, \n"
                    + "reparaciones.descripcion_reparacion, reparaciones.valor, reparaciones.estado \n"
                    + "FROM tipos_calzados "
                    + "INNER JOIN reparaciones "
                    + "ON tipos_calzados.id = reparaciones.tipos_calzados_id\n"
                    + "WHERE (((reparaciones.clientes_id)=?));";
            PreparedStatement st = con.prepareStatement(query);

            st.setInt(1, id);

            rs = st.executeQuery();

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

    /**
     * Llena los datos del combobox de reparaciones
     *
     * @return
     */
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

    /**
     * Actualiza el estado de la reparacion
     *
     * @param Status
     * @param id
     */
    public static void updateStatus(String Status, Integer id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = ConexionDB.openDB();
            String sqlQuery = "UPDATE reparaciones SET estado=? WHERE id=?";
            stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, Status);
            stmt.setDouble(2, id);

            stmt.executeUpdate();

           // JOptionPane.showMessageDialog(null, "Se ha actualizado el estado de la reparación");

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al modificar " + tableName);
            LOG.log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

    }

}
