/**aqui se declara la clase UsuariosSeed 
 * se establece el metodo para crear usuarios desde la base de datos
 *
 */
package negocios.seed;

import negocios.UsuariosBL;

/**
 * comentado por Ervin
 * @author REBOOTSYSTEM
 */
public class UsuariosSeed {
    
    
    public static void insertUsuarios() {
    /**
     * crear usuario en la base de datos 
     */
        UsuariosBL u = new UsuariosBL();
        u.create("77171435", "Fabian Garcia Jurado", 45, "MZ I CA 19 U LA CEIBA", "231255222", "fygarciaj");
        u.create("49787878", "LISBETH R BOLAÑO", 38, "XXXXX", "XXXX", "lisbeth");
        
    }
    
    
}
