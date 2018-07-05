/**aqui se establecen los get y set de los datos de la clase RolUsuario
* Clase RolUsuario
 *
 * Contiene informacion del RolUsuario
 */
package datos;

/**
 *
 * @author REBOOTSYSTEM
 */
public class RolUsuario {
    
    private Rol RolId;
    private Usuario UsuarioId;
 //Metodos publicos
    public RolUsuario() {
        this.RolId = null;
        this.UsuarioId = null;
    }
//constructor por default
    public RolUsuario(Rol RolId, Usuario UsuarioId) {
        this.RolId = RolId;
        this.UsuarioId = UsuarioId;
    }
/**
     * Devuelve el RolId del RolUsuario
     * @return RolId del RolUsuario
     */
    public Rol getRolId() {
        return RolId;
    }
/**
     * Modifica el RolId de un RolUsuario
     * @param RolId
     */
    public void setRolId(Rol RolId) {
        this.RolId = RolId;
    }
/**
     * Devuelve el UsuarioId del RolUsuario
     * @return UsuarioId del RolUsuario
     */
    public Usuario getUsuarioId() {
        return UsuarioId;
    }
/**
     * Modifica el UsuarioId de un RolUsuario
     * @param UsuarioId
     */
    public void setUsuarioId(Usuario UsuarioId) {
        this.UsuarioId = UsuarioId;
    }
    
    
    
}
