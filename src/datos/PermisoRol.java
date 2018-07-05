/**aqui se establecen los get y set de los datos de la clase permisoRol
 * Clase PermisoRol
 *
 * Contiene informacion de cada PermisoRol
 */
package datos;

/**
 *
 * @author REBOOTSYSTEM
 */
public class PermisoRol {
   
    private Permiso PermisoId;
    private Rol RolId;
//Metodos publicos
    public PermisoRol() {
    }
//constructor
    public PermisoRol(Permiso PermisoId, Rol RolId) {
        this.PermisoId = PermisoId;
        this.RolId = RolId;
    }
/**
     * Devuelve el PermisoId de PermisoRol
     * @return PermisoId de PermisoRol
     */
    public Permiso getPermisoId() {
        return PermisoId;
    }
/**
     * Modifica el PermisoId de PermisoRol
     * @param PermisoId
     */
    public void setPermisoId(Permiso PermisoId) {
        this.PermisoId = PermisoId;
    }
/**
     * Devuelve el RolId de PermisoRol
     * @return RolId de PermisoRol
     */
    public Rol getRolId() {
        return RolId;
    }
/**
     * Modifica el RolId de PermisoRol
     * @param RolId
     */
    public void setRolId(Rol RolId) {
        this.RolId = RolId;
    }
    
    
    
}
