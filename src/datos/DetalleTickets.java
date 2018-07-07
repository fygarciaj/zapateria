/**aqui se establecen los get y set de los datos de la clase DetalleTickets
 * Clase DetalleTickets
 *
 * Contiene informacion de cada DetalleTickets
 */
package datos;

public class DetalleTickets {
//Atributos o tipos de datos de cada dato de la clase DetalleTickets
    private Integer row;
    private Integer reparacion_id;
    private String reparacion_descripcion;
    private Integer cantidad;
    private Double valor_unitario;
    private Double valor_total;
   
//constructor de la clase DetalleTickets
    public DetalleTickets(Integer row, String reparacion_descripcion, Integer cantidad, Double valor_unitario) {
        this.row = row;
        this.reparacion_descripcion = reparacion_descripcion;
        this.cantidad = cantidad;
        this.valor_unitario = valor_unitario;
       
    }
/**
     * Devuelve el row de DetalleTicket
     * @return row de DetalleTickets
     */
    public Integer getRow() {
        return row;
    }
 
    public void setRow(Integer row) {
       
        this.row = row;
    }
    /* Devuelve el Reparacion_id de DetalleTickets
     * @return Reparacion_id de DetalleTickets
     */
    public Integer getReparacion_id() {
        return reparacion_id;
    }
    
    public void setReparacion_id(Integer reparacion_id) {
        this.reparacion_id = reparacion_id;
    }
/* Devuelve el Reparacion_descripcion de DetalleTickets
     * @return Reparacion_descripcion de DetalleTickets
     */
    public String getReparacion_descripcion() {
        return reparacion_descripcion;
    }

    public void setReparacion_descripcion(String reparacion_descripcion) {
        this.reparacion_descripcion = reparacion_descripcion;
    }
/* Devuelve  Cantidad de DetalleTickets
     * @return Cantidad de DetalleTickets
     */
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
/* Devuelve  Valor_unitario de DetalleTickets
     * @return Valor_unitario de DetalleTickets
     */
    public Double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(Double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }
/* Devuelve  Valor_total de DetalleTickets
     * @return Valor_total de DetalleTickets
     */
    public Double getValor_total() {
        return valor_unitario*cantidad;
    }

}
