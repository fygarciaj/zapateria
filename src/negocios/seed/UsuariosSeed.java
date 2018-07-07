/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios.seed;

import negocios.UsuariosBL;

/**
 * Inserta algunos registros iniciales en la base de datos
 * @author Fabian Garcia
 * @version 0.0.1 beta
 * 
 */
public class UsuariosSeed {
    
    /**
     * Inserta registros en la db
     */
    public static void insertUsuarios() {
    
        // Instancia del objeto de negocio
        UsuariosBL u = new UsuariosBL();
        // Inserta los datos
        u.create("77171435", "Fabian Garcia Jurado", 45, "MZ I CA 19 U LA CEIBA", "231255222", "fygarciaj");
        u.create("49787878", "LISBETH R BOLAÑO", 38, "XXXXX", "XXXX", "lisbeth");
        
    }
    
    
}
