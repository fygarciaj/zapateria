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
    private Integer ReparacionID;
    private String Estado;

    
    public Ticket() {
        this.Id = null;
        this.Fecha = null;
        this.UsuarioID = null;
        this.ClienteID = null;
        this.Estado = null;
        this.ReparacionID = null;
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

    public Integer getReparacionID() {
        return ReparacionID;
    }

    public void setReparacionID(Integer ReparacionID) {
        this.ReparacionID = ReparacionID;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }


    
}
