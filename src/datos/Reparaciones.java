/**
 * 
 */
package datos;

public class Reparaciones {

    private Integer Id;
    private String DescripcionReparacion;
    private Double Valor;
    private TiposCalzados TipoCalzado;

    public Reparaciones() {
    }

    public Reparaciones(String DescripcionReparacion, Double Valor, TiposCalzados TipoCalzado) {
        this.DescripcionReparacion = DescripcionReparacion;
        this.Valor = Valor;
        this.TipoCalzado = TipoCalzado;
    }

    public Integer getId() {
        return Id;
    }

    public String getDescripcionReparacion() {
        return DescripcionReparacion;
    }

    public void setDescripcionReparacion(String DescripcionReparacion) {
        this.DescripcionReparacion = DescripcionReparacion;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double Valor) {
        this.Valor = Valor;
    }

    public TiposCalzados getTipoCalzado() {
        return TipoCalzado;
    }

    public void setTipoCalzado(TiposCalzados TipoCalzado) {
        this.TipoCalzado = TipoCalzado;
    }
    
    

}
