/*
 * aqui se declara la clase Security con la cual se restringe el acceso a la aplicacion
 */
package negocios;

import utils.BCrypt;
import datos.Usuario;

/**
 *
 * @author REBOOTSYSTEM
 */ 
public class Security {

    public Security() {
    }
//se establece el metodo condicional y las restricciones para el usuario y pasword
    public static Boolean checkAcceso(String username, String password) {
        boolean result = false;
        if ((username.length() > 0) || (password.length() > 0)) {
            String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
            Usuario user = UsuariosBL.findByUserName(username);
            if (BCrypt.checkpw(user.getNombreUsuario(), hashed)) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    public static void createUserPassword(String username, String password, Integer id) {

    }
}
