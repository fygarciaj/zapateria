package negocios.seed;

import negocios.ClientesBL;

/**
 * Clase para poder crear algunos registros iniciales en la base de datos 
 * @author Fabian Garcia
 * @version 0.0.1 beta
 */
public class ClientesSeed {

    /**
     * Inserta registros en la base de datos
     */
    public static void insertClients() {

        // Intancia del objeto de negocios
        ClientesBL cl = new ClientesBL();

        // Crea los registros
        cl.create("77171435", "Fabian Garcia", "1972-12-18", "3166579426", "MZ I C 19 U LA CEIBA");
        cl.create("49787787", "Lisbeth Bolaño", "1975-12-10", "3166579426", "MZ I C 19 U LA CEIBA");

    }
}
