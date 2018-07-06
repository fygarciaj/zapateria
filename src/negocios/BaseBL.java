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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class BaseBL {

    private static Connection con = null;
    private static final ConexionDB cxn = null;
    private static PreparedStatement stmt = null;
    private static final ResultSet rs = null;
    private static final Logger LOG = Logger.getLogger(BaseBL.class.getName());

    public BaseBL() {
    }

    public static void delete(String tableName, Integer Id) {

        if (tableName != null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = ConexionDB.openDB();
                String sqlQuery = "DELETE FROM ? WHERE id=?";
                stmt = con.prepareStatement(sqlQuery);

                stmt.setString(1, tableName);
                stmt.setInt(2, Id);

                stmt.executeUpdate();
                con.close();

                con.close();

                JOptionPane.showMessageDialog(null, "Se ha eliminado el " + tableName + " con el indice #" + Id);

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar un " + tableName + " [" + e.getClass().getName() + ": " + e.getMessage() + "]");
                LOG.log(Level.SEVERE, null, e);
            }

        }

    }

}
