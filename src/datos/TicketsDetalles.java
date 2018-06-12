package datos;

public class TicketsDetalles {

    private Integer Id;
    private Tickets TicketId;
    private Reparaciones ReparacionId;
    private Double ValorUnitario;
    private Integer Cantidad;
    private Double SubTotal;
    private Double Descuento;

    public TicketsDetalles() {
        
    }

    public TicketsDetalles(Tickets TicketId, Reparaciones ReparacionId, Double ValorUnitario, Integer Cantidad, Double SubTotal, Double Descuento) {
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

    public Tickets getTicketId() {
        return TicketId;
    }

    public void setTicketId(Tickets TicketId) {
        this.TicketId = TicketId;
    }

    public Reparaciones getReparacionId() {
        return ReparacionId;
    }

    public void setReparacionId(Reparaciones ReparacionId) {
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
