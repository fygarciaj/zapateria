/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios.seed;

import java.text.ParseException;
import negocios.ClientesBL;

/**
 *
 * @author REBOOTSYSTEM
 */
public class ClientesSeed {

    public static void insertClients() {

        ClientesBL cl = new ClientesBL();

        cl.create("77171435", "Fabian Garcia", "1972-12-18", "3166579426", "MZ I C 19 U LA CEIBA");
        cl.create("49787787", "Lisbeth Bolaño", "1975-12-10", "3166579426", "MZ I C 19 U LA CEIBA");

    }
}
