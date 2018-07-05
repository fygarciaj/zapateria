/**aqui se establecen los get y set de los datos de la clase ticket
 * Clase Ticket
 *
 * Contiene informacion de cada Ticket
 * 
 */
package datos;

import java.util.Date;

/**
 * @author REBOOTSYSTEM
 *
 */
public class Ticket {
//Atributos
    private Integer Id;
    private String Fecha;
    private Double ValorTotal;
    private Integer UsuarioID;
    private Integer ClienteID;
    
//Metodos publicos
    public Ticket() {
        this.Id = null;
        this.Fecha = null;
        this.UsuarioID = null;
        this.ClienteID = null;
    }
 //constructor default
    public Ticket(String Fecha, Double ValorTotal, Integer UsuarioID, Integer ClienteID) {
        this.Fecha = Fecha;
        this.ValorTotal = ValorTotal;
        this.UsuarioID = UsuarioID;
        this.ClienteID = ClienteID;
    }
/**
     * Devuelve el Id del Ticket
     * @return Id del Ticket
     */
    public Integer getId() {
        return Id;
    }
/**
     * Modifica el Id de un Ticket
     * @param Id
     */
    public void setId(Integer Id) {
        this.Id = Id;
    }
/**
     * Devuelve la Fecha del Ticket
     * @return la Fecha Ticket
     */
    public String getFecha() {
        return Fecha;
    }
/**
     * Modifica la Fecha de un Ticket
     * @param Fecha
     */
    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
/**
     * Devuelve el ValorTotal del Ticket
     * @return ValorTotal del Ticket
     */
    public Double getValorTotal() {
        return ValorTotal;
    }
/**
     * Modifica el ValorTotal de un Ticket
     * @param ValorTotal
     */
    public void setValorTotal(Double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }
/**
     * Devuelve el UsuarioID del Ticket
     * @return UsuarioID del Ticket
     */
    public Integer getUsuarioID() {
        return UsuarioID;
    }
/**
     * Modifica el UsuarioID de un Ticket
     * @param UsuarioID
     */
    public void setUsuarioID(Integer UsuarioID) {
        this.UsuarioID = UsuarioID;
    }
/**
     * Devuelve el ClienteID del Ticket
     * @return ClienteID del Ticket
     */
    public Integer getClienteID() {
        return ClienteID;
    }
/**
     * Modifica el ClienteID de un Ticket
     * @param ClienteID
     */
    public void setClienteID(Integer ClienteID) {
        this.ClienteID = ClienteID;
    }


    
}
