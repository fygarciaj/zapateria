/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
