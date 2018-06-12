/**
 *
 */
package datos;

import java.sql.Date;

/**
 * @author REBOOTSYSTEM
 *
 */
public class Tickets {

    private Integer Id;
    private Date Fecha;
    private Double ValorTotal;
    private Usuarios UsuarioID;
    private Clientes ClienteID;

    
    public Tickets() {
        this.Id = null;
        this.Fecha = null;
        this.UsuarioID = null;
        this.ClienteID = null;
    }

    public Tickets(Date Fecha, Double ValorTotal, Usuarios UsuarioID, Clientes ClienteID) {
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

    public Usuarios getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(Usuarios UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    public Clientes getClienteID() {
        return ClienteID;
    }

    public void setClienteID(Clientes ClienteID) {
        this.ClienteID = ClienteID;
    }

    
}
