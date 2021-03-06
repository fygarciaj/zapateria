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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author REBOOTSYSTEM
 */
public class TiposCalzadoBL extends BaseBL {

    private static final Logger LOG = Logger.getLogger(ClientesBL.class.getName());

    private Integer id = null;
    private String nombre_calzado = null;
    private static Connection con = null;
    private static ConexionDB cxn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;
    DefaultTableModel model = new DefaultTableModel();
    private static final String tableName = "tipos_calzados";

    public TiposCalzadoBL() {
        cxn = new ConexionDB();

        // Si no existe la tabla ClientesBL Crearla Automaticamente
        if (!cxn.tableExist(tableName)) {
            Statement stmt = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                con = cxn.openDB();
                stmt = con.createStatement();

                String sql = "CREATE TABLE IF NOT EXISTS `zapateria`.`tipos_calzados` (\n"
                        + "  `id` INT NOT NULL AUTO_INCREMENT,\n"
                        + "  `nombre_calzado` VARCHAR(100) NULL,\n"
                        + "  PRIMARY KEY (`id`),\n"
                        + "  UNIQUE INDEX `id_UNIQUE` (`id` ASC))\n"
                        + "ENGINE = InnoDB";

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
     * Crea un nuevo tipo de calzado
     * 
     * @param String nombreCalzado 
     */
    public static void create(String nombreCalzado) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = cxn.openDB();
            String sqlQuery = "INSERT INTO tipos_calzados(nombre_calzado) VALUES(?);";
            java.sql.PreparedStatement stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, nombreCalzado);

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

    public void update(String nombreCalzado, Integer id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();
            String sqlQuery = "UPDATE ? SET rol=? WHERE id=?";
            stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, tableName);
            stmt.setString(2, nombreCalzado);
            stmt.setInt(3, id);

            stmt.executeUpdate();

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

                JOptionPane.showMessageDialog(null, "Se ha eliminado el registro con el indice #" + Id);

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar " + tableName + " " + e.getClass().getName() + ": " + e.getMessage() + "]");
                LOG.log(Level.SEVERE, null, e);
            }

        }
    }

    /** 
     * Lista los datos de la tabla tipos_calzados
     * 
     * @return DefaultTableModel
     */
    public static DefaultTableModel listar() {
        String[] columns = {"Id", "Tipo Calzado"};
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

            Statement st = con.createStatement();
            String query = "SELECT * FROM tipos_calzados";
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
            e.printStackTrace();

            return model;
        }

        return model;
    }
    
    public static class TiposCalzadoscbo {
        
        private int Id;
        private String nombre_calzado;

        public TiposCalzadoscbo(int Id, String nombre_calzado) {
            this.Id = Id;
            this.nombre_calzado = nombre_calzado;
        }

        public TiposCalzadoscbo() {
        }
        

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getNombre_calzado() {
            return nombre_calzado;
        }

        public void setNombre_calzado(String nombre_calzado) {
            this.nombre_calzado = nombre_calzado;
        }

        @Override
        public String toString() {
            return nombre_calzado;
        }
        
        
        
    }

    public static DefaultComboBoxModel cboTiposCalzado() {

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();

            Statement st = con.createStatement();
            String query = "SELECT id, nombre_calzado FROM tipos_calzados";
            rs = st.executeQuery(query);
            ResultSetMetaData rsMd = rs.getMetaData();

            int countColumns = rsMd.getColumnCount();

            while (rs.next()) {

//                Object[] fila = new Object[countColumns];
//                for (int i = 0; i < countColumns; i++) {
//                    fila[i] = rs.getObject(i + 1);
//                }
                model.addElement(new TiposCalzadoscbo(rs.getInt("id"), rs.getString("nombre_calzado")));
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();

            return model;
        }

        return model;
    }

}
