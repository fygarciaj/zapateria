package datos;

public class DetalleTicket {

    private Integer Id;
    private Ticket TicketId;
    private Reparacion ReparacionId;
    private Double ValorUnitario;
    private Integer Cantidad;
    private Double SubTotal;
    private Double Descuento;

    public DetalleTicket() {
        
    }

    public DetalleTicket(Ticket TicketId, Reparacion ReparacionId, Double ValorUnitario, Integer Cantidad, Double SubTotal, Double Descuento) {
        this.TicketId = TicketId;
        this.ReparacionId = ReparacionId;
        this.ValorUnitario = ValorUnitario;
        this.Cantidad = Cantidad;
        this.SubTotal = SubTotal;
        this.Descuento = Descuento;
    }

    public Integer getId() {
        return Id;
    }

    public Ticket getTicketId() {
        return TicketId;
    }

    public void setTicketId(Ticket TicketId) {
        this.TicketId = TicketId;
    }

    public Reparacion getReparacionId() {
        return ReparacionId;
    }

    public void setReparacionId(Reparacion ReparacionId) {
        this.ReparacionId = ReparacionId;
    }

    public Double getValorUnitario() {
        return ValorUnitario;
    }

    public void setValorUnitario(Double ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Double getDescuento() {
        return Descuento;
    }

    public void setDescuento(Double Descuento) {
        this.Descuento = Descuento;
    }

    

}
