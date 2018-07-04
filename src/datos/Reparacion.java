/**
 *
 */
package datos;

public class Reparacion {

    private Integer Id;
    private String DescripcionReparacion;
    private Double Valor;
    private Integer ClienteID;
    private Integer UsuariosId;
    private Integer TipoCalzadoId;
    private String Estado;

    public Reparacion() {
    }

    public Reparacion(String DescripcionReparacion, Double Valor, Integer TipoCalzadoId) {
        this.DescripcionReparacion = DescripcionReparacion;
        this.Valor = Valor;
        this.TipoCalzadoId = TipoCalzadoId;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
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

    public Integer getTipoCalzadoId() {
        return TipoCalzadoId;
    }

    public void setTipoCalzadoId(Integer TipoCalzadoId) {
        this.TipoCalzadoId = TipoCalzadoId;
    }

    public Integer getClienteID() {
        return ClienteID;
    }

    public void setClienteID(Integer ClienteID) {
        this.ClienteID = ClienteID;
    }

    public Integer getUsuariosId() {
        return UsuariosId;
    }

    public void setUsuariosId(Integer UsuariosId) {
        this.UsuariosId = UsuariosId;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    

    @Override
    public String toString() {
        return DescripcionReparacion;
    }

}
