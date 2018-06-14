/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios.seed;

import negocios.UsuariosBL;

/**
 *
 * @author REBOOTSYSTEM
 */
public class UsuariosSeed {
    
    
    public static void insertUsuarios() {
    
        UsuariosBL u = new UsuariosBL();
        u.create("77171435", "Fabian Garcia Jurado", 45, "MZ I CA 19 U LA CEIBA", "231255222", "fygarciaj");
        u.create("49787878", "LISBETH R BOLAÑO", 38, "XXXXX", "XXXX", "lisbeth");
        
    }
    
    
}
