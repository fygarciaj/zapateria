/**aqui se establecen los get y set de los datos de la clase DetalleTicket
 * Clase DetalleTicket
 *
 * Contiene informacion de cada DetalleTicket
 */
package datos;

public class DetalleTicket {
    //Atributos o tipos de datos de cada dato de la clase DetalleTicket
    private Integer Id;
    private Ticket TicketId;
    private Reparacion ReparacionId;
    private Double ValorUnitario;
    private Integer Cantidad;
    private Double SubTotal;
    private Double Descuento;

    public DetalleTicket() {
        
    }
//constructor de la clase DetalleTicket
    public DetalleTicket(Ticket TicketId, Reparacion ReparacionId, Double ValorUnitario, Integer Cantidad, Double SubTotal, Double Descuento) {
        this.TicketId = TicketId;
        this.ReparacionId = ReparacionId;
        this.ValorUnitario = ValorUnitario;
        this.Cantidad = Cantidad;
        this.SubTotal = SubTotal;
        this.Descuento = Descuento;
    }
    //metodos Publicos de la clase DetalleTicket 
/**
     * Devuelve el Id de DetalleTicket
     * @return Id de DetalleTicket
     */
    public Integer getId() {
        return Id;
    }
/**
     * Devuelve el TicketId de DetalleTicket
     * @return TicketId de DetalleTicket
     */
    public Ticket getTicketId() {
        return TicketId;
    }
     /**
     * Modifica el NombreCompleto de un empleado
     * @param TicketId
     */
    public void setTicketId(Ticket TicketId) {
        this.TicketId = TicketId;
    }
/**
     * Devuelve el getReparacionId de DetalleTicket
     * @return getReparacionId de DetalleTicket
     */
    public Reparacion getReparacionId() {
        return ReparacionId;
    }
/**
     * Modifica  ReparacionId de un empleado
     * @param ReparacionId
     */
    public void setReparacionId(Reparacion ReparacionId) {
        this.ReparacionId = ReparacionId;
    }
/**
     * Devuelve el ValorUnitario de DetalleTicket
     * @return ValorUnitario de DetalleTicket
     */
    public Double getValorUnitario() {
        return ValorUnitario;
    }
/**
     * Modifica el ValorUnitario de un empleado
     * @param ValorUnitario
     */
    public void setValorUnitario(Double ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }
/**
     * Devuelve Cantidad de DetalleTicket
     * @return Cantidad de DetalleTicket
     */
    public Integer getCantidad() {
        return Cantidad;
    }
/**
     * Modifica el Cantidad de un empleado
     * @param Cantidad
     */
    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }
/**
     * Devuelve Descuento de DetalleTicket
     * @return Descuento de DetalleTicket
     */
    public Double getDescuento() {
        return Descuento;
    }
    /**
     * Modifica el Cantidad de un empleado
     * @param Descuento
     */
    public void setDescuento(Double Descuento) {
        this.Descuento = Descuento;
    }

    

}
