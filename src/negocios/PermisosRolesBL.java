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
 *se establece la clase PermisosRolesBL y se extiende a la clase BaseBL 
 * para heredar sus atributos
 * @author REBOOTSYSTEM
 * 
 */
public class PermisosRolesBL extends BaseBL {

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

    public PermisosRolesBL() {

        if (!cxn.tableExist(tableName)) {
            Statement stmt = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                con = cxn.openDB();
                stmt = con.createStatement();

                String sql = "CREATE TABLE `permisos_roles` (\n"
                        + "	`permisos_id` INT(11) UNSIGNED NOT NULL,\n"
                        + "	`roles_id` INT(11) UNSIGNED NOT NULL,\n"
                        + "	PRIMARY KEY (`permisos_id`, `roles_id`),\n"
                        + "	INDEX `roles_id` (`roles_id`),\n"
                        + "	CONSTRAINT `FK_permisos_roles_permisos` FOREIGN KEY (`permisos_id`) REFERENCES `permisos` (`Id`),\n"
                        + "	CONSTRAINT `FK_permisos_roles_roles` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`)\n"
                        + ")\n"
                        + "COLLATE='utf8_spanish2_ci'\n"
                        + "ENGINE=InnoDB\n"
                        + ";";

                stmt.executeUpdate(sql);

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
                LOG.log(Level.SEVERE, null, e);
                System.exit(0);
            }
            System.out.println("Se ha creado la tabla " + tableName);
        }

    }

    /**
     * Crea un registro en $tableName
     * @param permisos_id
     * @param roles_id 
     */
    public static void create(Integer permisos_id, Integer roles_id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = cxn.openDB();
            String sqlQuery = "INSERT INTO permisos_roles(permisos_id, roles_id) VALUES(?, ?);";
            java.sql.PreparedStatement stmt = con.prepareStatement(sqlQuery);

            stmt.setInt(1, permisos_id);
            stmt.setInt(2, roles_id);

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

    public void update(Integer permisos_id, Integer roles_id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = cxn.openDB();
            String sqlQuery = "UPDATE ? roles_id=? WHERE permisos_id=?";
            stmt = con.prepareStatement(sqlQuery);

            stmt.setString(1, tableName);
            stmt.setInt(2, roles_id);
            stmt.setInt(3, permisos_id);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se ha modificado un " + tableName);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al modificar " + tableName);
            LOG.log(Level.SEVERE, null, e);
        }
    }

    public static void delete(Integer permisos_id) {
        if (permisos_id != null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = cxn.openDB();
                String sqlQuery = "DELETE FROM ? WHERE id=?";
                stmt = con.prepareStatement(sqlQuery);

                stmt.setString(1, tableName);
                stmt.setInt(2, permisos_id);

                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Se ha eliminado con el indice #" + permisos_id);

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
