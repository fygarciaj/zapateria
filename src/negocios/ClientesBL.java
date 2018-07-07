/*
 * aqui se extiende la clase ClientesBL a la clase BaseBL 
y se establecen los metodos privados del objeto cliente.
 */
package negocios;

import java.sql.PreparedStatement;
import conexion.ConexionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import datos.Cliente;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 * comentado por Ervin
 * @author REBOOTSYSTEM
 */
public class ClientesBL extends BaseBL {

    private static final Logger LOG = Logger.getLogger(ClientesBL.class.getName());
// metodos privados del objeto cliente para crear tabla
 
    private Integer id = null;
    private String identificacion = null;
    private String nombreCompleto = null;
    private String fechaNacimiento = null;
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
                        + "     INDEX `identificacion` (`identificacion`)\n"
                        + ")\n"
                        + "COLLATE='utf8_spanish2_ci'\n"
                        + "ENGINE=InnoDB;";

                int Result = stmt.executeUpdate(sql);

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
                LOG.log(Level.SEVERE, null, e);
                System.exit(0);
            }
            System.out.println("Se ha creado la tabla");
        }
    }
   //se crea tabla mediante la concatenacion de los atributos del objeto 
    public static void create(String identificacion, String nombreCompleto, String fechaNacimiento, String telefono, String direccion) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = cxn.openDB();
            String sqlQuery = "INSERT INTO clientes(identificacion, nombre_completo, fecha_nacimiento, telefono, direccion) VALUES( ?, ?, ?, ?, ?);";
            java.sql.PreparedStatement stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, identificacion);
            stmt.setString(2, nombreCompleto);
            stmt.setString(3, fechaNacimiento);
            stmt.setString(4, telefono);
            stmt.setString(5, direccion);

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Se ha guardado el cliente");
            
// muestra un mensaje en pantalla que indica que se ha guardado los datos del cliente
        } catch (ClassNotFoundException | SQLException e) {

            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
            LOG.log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

    }
// se establecen exepciones para los recsultados 
    public static void create(Cliente cliente) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = cxn.openDB();
            String sqlQuery = "INSERT INTO clientes(identificacion, nombre_completo, fecha_nacimiento, telefono, direccion) VALUES( ?, ?, ?, ?, ?);";
            java.sql.PreparedStatement stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, cliente.getIdentificacion());
            stmt.setString(2, cliente.getNombreCompleto());
            stmt.setString(3, cliente.getFechaNacimiento());
            stmt.setString(4, cliente.getTelefono());
            stmt.setString(5, cliente.getDireccion());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se ha guardado el cliente");

        } catch (ClassNotFoundException | SQLException e) {

            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
            LOG.log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

    }

    /**
     * Busca un Cliente por el id
     *
     * @param Id
     */
    public static Cliente findById(Integer id) {

        Cliente cliente = new Cliente();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();
            String sqlQuery = "SELECT * FROM clientes WHERE id=?";
            stmt = con.prepareStatement(sqlQuery);

            stmt.setInt(1, id);

            ResultSet rst = stmt.executeQuery();

            if (rst.next()) {
                cliente.setId(rst.getInt("id"));
                cliente.setIdentificacion(rst.getString("identificacion"));
                cliente.setNombreCompleto(rst.getString("nombre_completo"));
                cliente.setFechaNacimiento(rst.getString("fecha_nacimiento"));
                cliente.setDireccion(rst.getString("direccion"));
                cliente.setTelefono(rst.getString("telefono"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error buscar el cliente " + tableName);
            LOG.log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

        return cliente;
    }

    public void update(String nombreCompleto, String fechaNacimiento, String telefono, String direccion, int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();
            String sqlQuery = "UPDATE clientes SET nombre_completo=?, fecha_nacimiento=?, telefono=?, direccion=? WHERE id=?";
            stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, nombreCompleto);
            stmt.setString(2, fechaNacimiento);
            stmt.setString(3, telefono);
            stmt.setString(4, direccion);

            stmt.setInt(5, id);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se ha actualizado un cliente");

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al modificar un cliente");
            LOG.log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }

    public void update(Cliente cliente, Integer id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();
            String sqlQuery = "UPDATE clientes SET nombre_completo=?, fecha_nacimiento=?, telefono=?, direccion=? WHERE id=?";
            stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, cliente.getNombreCompleto());
            stmt.setString(2, cliente.getFechaNacimiento());
            stmt.setString(3, cliente.getTelefono());
            stmt.setString(4, cliente.getDireccion());
            stmt.setInt(5, id);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se ha actualizado un cliente");

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al modificar un cliente");
            LOG.log(Level.SEVERE, null, e);
            e.printStackTrace();
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

                JOptionPane.showMessageDialog(null, "Se ha eliminado el cliente con el indice #" + Id);

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar un cliente [" + e.getClass().getName() + ": " + e.getMessage() + "]");
                LOG.log(Level.SEVERE, null, e);
            }

        }
    }

    public static DefaultTableModel listar() {

        String[] columns = {"Id", "Identificación", "Nombres Completos", "Fecha Nacimiento", "Teléfono", "Dirección"};
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
            String query = "SELECT * FROM clientes";
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

    /** 
     * Clase para los registros que se llenan el combobox de clientes
     * 
     */
    public static class ClientesCbo {

        private Integer id;
        private String nombre_completo;

        public ClientesCbo() {
        }

        public ClientesCbo(Integer id, String nombre_completo) {
            this.id = id;
            this.nombre_completo = nombre_completo;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNombre_completo() {
            return nombre_completo;
        }

        public void setNombre_completo(String nombre_completo) {
            this.nombre_completo = nombre_completo;
        }

        @Override
        public String toString() {
            return this.nombre_completo;
        }

    }

    public static DefaultComboBoxModel cboClientes() {

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();

            Statement st = con.createStatement();
            String query = "SELECT id, nombre_completo FROM clientes";
            rs = st.executeQuery(query);
            ResultSetMetaData rsMd = rs.getMetaData();

            int countColumns = rsMd.getColumnCount();

            while (rs.next()) {

//                Object[] fila = new Object[countColumns];
//                for (int i = 0; i < countColumns; i++) {
//                    fila[i] = rs.getObject(i + 1);
//                }
                model.addElement(new ClientesCbo(rs.getInt("id"), rs.getString("nombre_completo")));
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();

            return model;
        }

        return model;
    }

    /**
     *  Retorna un objeto DefaultTableModel para llenar una tabla de los clientes filtrados por el nombre, el telefono o la dirección
     * 
     * @param text
     * @return 
     */
    public static DefaultTableModel buscarCliente(String text) {

        String[] columns = {"Id", "Identificación", "Nombres Completos", "Fecha Nacimiento", "Teléfono", "Dirección"};
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

            String sqlQuery = "SELECT * FROM clientes "
                    + "WHERE nombre_completo LIKE ? "
                    + "OR telefono LIKE ? "
                    + "OR direccion LIKE ? ";

            String sqlQuery1 = "SELECT * FROM clientes "
                    + "WHERE(((clientes.nombre_completo) Like '%F%')) "
                    + "OR(((clientes.telefono) Like '%F%')) "
                    + "OR(((clientes.direccion) Like '%F%'));";

            stmt = con.prepareStatement(sqlQuery);

        stmt.setString(1, "%" + text + "%");
        stmt.setString(2, "%" + text + "%");
         stmt.setString(3, "%" + text + "%");

        rs = stmt.executeQuery();

        ResultSetMetaData rsMd = rs.getMetaData();

        int countColumns = rsMd.getColumnCount();

        while (rs.next()) {
            Object[] fila = new Object[countColumns];
            for (int i = 0; i < countColumns; i++) {
                fila[i] = rs.getObject(i + 1);
            }
            model.addRow(fila);
        }

    }
    catch (ClassNotFoundException | SQLException e

    
        ) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
        LOG.log(Level.SEVERE, null, e);
        e.printStackTrace();

        return model;
    }

    return model ;

}

}
