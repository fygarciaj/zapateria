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
import datos.Usuario;
import utils.BCrypt;

/**
 *
 * @author REBOOTSYSTEM
 */
public class UsuariosBL {

    private static final Logger LOG = Logger.getLogger(ClientesBL.class.getName());
    private Integer id = null;
    private static Connection con = null;
    private static ConexionDB cxn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;
    DefaultTableModel model = new DefaultTableModel();
    private static final String tableName = "usuarios";

    public UsuariosBL() {

        cxn = new ConexionDB();
        // Si no existe la tabla ClientesBL Crearla Automaticamente
        if (!cxn.tableExist(tableName)) {

            try {
                Class.forName("com.mysql.jdbc.Driver");

                Connection con = cxn.openDB();
                Statement stmt = con.createStatement();

                String sql = "CREATE TABLE IF NOT EXISTS `zapateria`.`usuarios` (\n"
                        + "  `id` INT NOT NULL AUTO_INCREMENT,\n"
                        + "  `identificacion` VARCHAR(16) NOT NULL,\n"
                        + "  `nombre_completo` VARCHAR(100) NULL,\n"
                        + "  `edad` INT NULL,\n"
                        + "  `direccion` VARCHAR(100) NULL,\n"
                        + "  `telefono` VARCHAR(12) NULL,\n"
                        + "  `nombre_usuario` VARCHAR(50) NOT NULL,\n"
                        + "  `password` VARCHAR(255) NOT NULL,\n"
                        + "  UNIQUE INDEX `identificacion_UNIQUE` (`identificacion` ASC),\n"
                        + "  PRIMARY KEY (`id`),\n"
                        + "  UNIQUE INDEX `id_UNIQUE` (`id` ASC),\n"
                        + "  UNIQUE INDEX `nombre_usuario_UNIQUE` (`nombre_usuario` ASC))\n"
                        + "ENGINE = InnoDB;";

                int Result = stmt.executeUpdate(sql);
                
               // cxn.closeDB();
                
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
                LOG.log(Level.SEVERE, null, e);
                System.exit(0);
            }
            System.out.println("Se ha creado la tabla");
        }
    }

    public static void create(String identificacion, String nombreCompleto, Integer edad, String direccion, String telefono, String nombre_usuario) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = cxn.openDB();
            String sqlQuery = "INSERT INTO usuarios(identificacion, nombre_completo, edad, direccion, telefono, nombre_usuario, password) VALUES(?,?,?,?,?,?,?);";
            java.sql.PreparedStatement stmt = con.prepareStatement(sqlQuery);

            String hashed = BCrypt.hashpw(nombre_usuario, BCrypt.gensalt());
            
            stmt.setString(1, identificacion);
            stmt.setString(2, nombreCompleto);
            stmt.setInt(3, edad);
            stmt.setString(4, direccion);
            stmt.setString(5, telefono);
            stmt.setString(6, nombre_usuario);
            stmt.setString(7, hashed);

            int Result = stmt.executeUpdate();
            // cxn.closeDB();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
            LOG.log(Level.SEVERE, null, e);
        }

    }

    /**
     * Busca un usuario por el id
     *
     * @param id
     * @return Usuario
     */
    public static Usuario findById(Integer id) {
        Usuario usuario = new Usuario();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();
            String sqlQuery = "SELECT * FROM usuarios WHERE id=?";
            stmt = con.prepareStatement(sqlQuery);

            stmt.setInt(1, id);

            ResultSet rst = stmt.executeQuery();

            if (rst.next()) {
                usuario.setId(rst.getInt("id"));
                usuario.setIdentificacion(rst.getString("identificacion"));
                usuario.setNombreCompleto(rst.getString("nombre_completo"));
                usuario.setDireccion(rst.getString("direccion"));
                usuario.setTelefono(rst.getString("telefono"));
                usuario.setEdad(rst.getInt("edad"));
                usuario.setNombreUsuario(rst.getString("nombre_usuario"));
                usuario.setPassword(rst.getString("password"));
            }


        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error buscar el usuario " + tableName);
            LOG.log(Level.SEVERE, null, e);
        }

        return usuario;
    }


    /**
     * Busca un usuario por el nombre de usuario
     *
     * @param username
     * @return
     */
    public static Usuario findByUserName(String username) {
        ResultSet rst= null;
        Usuario usuario = new Usuario();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();
            String sqlQuery = "SELECT * FROM usuarios WHERE nombre_usuario=?";
            stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, username);

            rst = stmt.executeQuery();

            if (rst != null) {
                rst.next();
                usuario.setId(rst.getInt("id"));
                usuario.setIdentificacion(rst.getString("identificacion"));
                usuario.setNombreCompleto(rst.getString("nombre_completo"));
                usuario.setDireccion(rst.getString("direccion"));
                usuario.setTelefono(rst.getString("telefono"));
                usuario.setEdad(rst.getInt("edad"));
                usuario.setNombreUsuario(rst.getString("nombre_usuario"));
                usuario.setPassword(rst.getString("password"));
            }

            //con.close();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error buscar el usuario " + tableName);
            LOG.log(Level.SEVERE, null, e);
        }

        return usuario;
    }

    public void update(String identificacion, String nombreCompleto, Integer edad, String direccion, String telefono, Integer id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();
            String sqlQuery = "UPDATE usuarios SET identificacion=?, nombre_completo=?, edad=?, direccion=?, telefono=? WHERE id=?";
            stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, identificacion);
            stmt.setString(2, nombreCompleto);
            stmt.setInt(3, edad);
            stmt.setString(4, direccion);
            stmt.setString(5, telefono);
            stmt.setInt(6, id);

            stmt.executeUpdate();
            //con.close();

            JOptionPane.showMessageDialog(null, "Se ha modificado un registro en " + tableName);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al modificar " + tableName);
            LOG.log(Level.SEVERE, null, e);
        }
    }

    public static void update(Usuario usuario) {
        
    }
    
    
    public static void updatePassword(String password, Integer id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();
            String sqlQuery = "UPDATE usuarios SET password=?  WHERE id=?";
            stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, password);
            stmt.setInt(2, id);

            stmt.executeUpdate();
            //con.close();

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

    public static DefaultTableModel listar() {
        
        String[] columns = {"Id", "Identificación", "Nombres Completos", "Edad", "Dirección", "Telefono", "Nombre Usuario"};
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
            e.printStackTrace();
            
            return model;
        }

        return model;
    }

}
