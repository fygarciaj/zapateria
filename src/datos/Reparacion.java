/**aqui se establecen los get y set de los datos de la clase Reparacion
* Clase Reparacion
 *
 * Contiene informacion de cada Reparacion
 *
 */
package datos;

public class Reparacion {
//Atributos
    private Integer Id;
    private String DescripcionReparacion;
    private Double Valor;
    private Integer ClienteID;
    private Integer UsuariosId;
    private Integer TipoCalzadoId;

    public Reparacion() {
    }
//Metodos publicos
    //constructor por defecto
    public Reparacion(String DescripcionReparacion, Double Valor, Integer TipoCalzadoId) {
        this.DescripcionReparacion = DescripcionReparacion;
        this.Valor = Valor;
        this.TipoCalzadoId = TipoCalzadoId;
    }
/**
     * Devuelve el Id de Reparacion
     * @return Id de  Reparacion
     */
    public Integer getId() {
        return Id;
    }
/**
     * Modifica el Id de una Reparacion
     * @param Id
     */
    public void setId(Integer Id) {
        this.Id = Id;
    }
/**
     * Devuelve el DescripcionReparacion de Reparacion
     * @return DescripcionReparacion de  Reparacion
     */
    public String getDescripcionReparacion() {
        return DescripcionReparacion;
    }
/**
     * Modifica  DescripcionReparacion de Reparacion
     * @param DescripcionReparacion
     */
    public void setDescripcionReparacion(String DescripcionReparacion) {
        this.DescripcionReparacion = DescripcionReparacion;
    }
/**
     * Devuelve el Valor de Reparacion
     * @return Valor de  Reparacion
     */
    public Double getValor() {
        return Valor;
    }
/**
     * Modifica  Valor de Reparacion
     * @param Valor
     */
    public void setValor(Double Valor) {
        this.Valor = Valor;
    }
/**
     * Devuelve el TipoCalzadoId de Reparacion
     * @return TipoCalzadoId de  Reparacion
     */
    public Integer getTipoCalzadoId() {
        return TipoCalzadoId;
    }
/**
     * Modifica  TipoCalzadoId de Reparacion
     * @param TipoCalzadoId
     */
    public void setTipoCalzadoId(Integer TipoCalzadoId) {
        this.TipoCalzadoId = TipoCalzadoId;
    }
/**
     * Devuelve el ClienteID de Reparacion
     * @return ClienteID de  Reparacion
     */
    public Integer getClienteID() {
        return ClienteID;
    }
/**
     * Modifica  ClienteID de Reparacion
     * @param ClienteID
     */
    public void setClienteID(Integer ClienteID) {
        this.ClienteID = ClienteID;
    }
/**
     * Devuelve el UsuariosId de Reparacion
     * @return UsuariosId de  Reparacion
     */
    public Integer getUsuariosId() {
        return UsuariosId;
    }
/**
     * Modifica  UsuariosId de Reparacion
     * @param UsuariosId
     */
    public void setUsuariosId(Integer UsuariosId) {
        this.UsuariosId = UsuariosId;
    }

    
   
}
