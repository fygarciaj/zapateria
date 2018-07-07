/**aqui se crea la lista de archivos para la clase ClienteSeed
 * Clase Cliente
 *
 * Contiene informacion de cada Cliente
 */
package negocios.seed;

import java.text.ParseException;
import negocios.ClientesBL;

/**comentado por Ervin
 * @author REBOOTSYSTEM
 */
public class ClientesSeed {

    public static void insertClients() {
/* crear una lista de archivos de cliente en base de datos */
        ClientesBL cl = new ClientesBL();

        cl.create("77171435", "Fabian Garcia", "1972-12-18", "3166579426", "MZ I C 19 U LA CEIBA");
        cl.create("49787787", "Lisbeth Bolaño", "1975-12-10", "3166579426", "MZ I C 19 U LA CEIBA");

    }
}
