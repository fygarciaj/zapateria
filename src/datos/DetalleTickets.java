/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

public class DetalleTickets {

    private Integer row;
    private Integer reparacion_id;
    private String reparacion_descripcion;
    private Integer cantidad;
    private Double valor_unitario;
    private Double valor_total;

    public DetalleTickets(Integer row, String reparacion_descripcion, Integer cantidad, Double valor_unitario) {
        this.row = row;
        this.reparacion_descripcion = reparacion_descripcion;
        this.cantidad = cantidad;
        this.valor_unitario = valor_unitario;
       
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getReparacion_id() {
        return reparacion_id;
    }

    public void setReparacion_id(Integer reparacion_id) {
        this.reparacion_id = reparacion_id;
    }

    public String getReparacion_descripcion() {
        return reparacion_descripcion;
    }

    public void setReparacion_descripcion(String reparacion_descripcion) {
        this.reparacion_descripcion = reparacion_descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(Double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public Double getValor_total() {
        return valor_unitario*cantidad;
    }

}
