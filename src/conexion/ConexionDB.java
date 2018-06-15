/**
 *
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author REBOOTSYSTEM
 *
 */
public class ConexionDB {

    private static Connection cnx = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public ConexionDB() {
    }

    /**
     * Abre la conexion a la base de datos
     *
     * @return Connection una conexion a la base de datos
     * @throws java.lang.ClassNotFoundException
     */
    public static Connection openDB() throws SQLException, ClassNotFoundException {

        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                // Esta cadena esta configurada para utilizar con el profiler
                //cnx = DriverManager.getConnection("jdbc:mysql://localhost:4040/zapateria", "root", "");
                //Esta cadena esta configurada para conectar directo a mysql
                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/zapateria", "root", "");

            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx;
    }

    /**
     * Cierra la conexion a la base de datos
     *
     * @throws SQLException
     */
    public static void closeDB() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }

    /**
     * Retorna verdadero o falso si la tabla tableName Existe en la Base de
     * Datos
     *
     * @param tableName
     * @return true | false
     */
    public boolean tableExist(String tableName) {

        Boolean result = false;
        try {
            this.openDB();

            Statement st = cnx.createStatement();
            String sql = "SELECT * \n"
                    + "FROM information_schema\n"
                    + "    .tables WHERE table_schema  =  \n"
                    + "    'zapateria' \n"
                    + "    AND table_name =  \n"
                    + "    '" + tableName + "' \n"
                    + "    LIMIT 1";
            rs = st.executeQuery(sql);

            result = rs.next();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getClass().getName() + ": " + e.getMessage());
        }

        return result;

    }
}
