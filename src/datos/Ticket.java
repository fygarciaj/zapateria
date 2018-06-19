/**
 *
 */
package datos;

import java.util.Date;

/**
 * @author REBOOTSYSTEM
 *
 */
public class Ticket {

    private Integer Id;
    private String Fecha;
    private Double ValorTotal;
    private Integer UsuarioID;
    private Integer ClienteID;

    
    public Ticket() {
        this.Id = null;
        this.Fecha = null;
        this.UsuarioID = null;
        this.ClienteID = null;
    }

    public Ticket(String Fecha, Double ValorTotal, Integer UsuarioID, Integer ClienteID) {
        this.Fecha = Fecha;
        this.ValorTotal = ValorTotal;
        this.UsuarioID = UsuarioID;
        this.ClienteID = ClienteID;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public Double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(Double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public Integer getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(Integer UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    public Integer getClienteID() {
        return ClienteID;
    }

    public void setClienteID(Integer ClienteID) {
        this.ClienteID = ClienteID;
    }


    
}
