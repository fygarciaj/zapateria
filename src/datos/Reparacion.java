/**
 * 
 */
package datos;

public class Reparacion {

    private Integer Id;
    private String DescripcionReparacion;
    private Double Valor;
    private TipoCalzado TipoCalzado;

    public Reparacion() {
    }

    public Reparacion(String DescripcionReparacion, Double Valor, TipoCalzado TipoCalzado) {
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

    public TipoCalzado getTipoCalzado() {
        return TipoCalzado;
    }

    public void setTipoCalzado(TipoCalzado TipoCalzado) {
        this.TipoCalzado = TipoCalzado;
    }
    
    

}
