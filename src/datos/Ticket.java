/**
 *
 */
package datos;

import java.sql.Date;

/**
 * @author REBOOTSYSTEM
 *
 */
public class Ticket {

    private Integer Id;
    private Date Fecha;
    private Double ValorTotal;
    private Usuario UsuarioID;
    private Cliente ClienteID;

    
    public Ticket() {
        this.Id = null;
        this.Fecha = null;
        this.UsuarioID = null;
        this.ClienteID = null;
    }

    public Ticket(Date Fecha, Double ValorTotal, Usuario UsuarioID, Cliente ClienteID) {
        this.Fecha = Fecha;
        this.ValorTotal = ValorTotal;
        this.UsuarioID = UsuarioID;
        this.ClienteID = ClienteID;
    }

    public Integer getId() {
        return Id;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(Double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public Usuario getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(Usuario UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    public Cliente getClienteID() {
        return ClienteID;
    }

    public void setClienteID(Cliente ClienteID) {
        this.ClienteID = ClienteID;
    }

    
}
