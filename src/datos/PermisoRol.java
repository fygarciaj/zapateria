/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author REBOOTSYSTEM
 */
public class PermisoRol {
    private Permiso PermisoId;
    private Rol RolId;

    public PermisoRol() {
    }

    public PermisoRol(Permiso PermisoId, Rol RolId) {
        this.PermisoId = PermisoId;
        this.RolId = RolId;
    }

    public Permiso getPermisoId() {
        return PermisoId;
    }

    public void setPermisoId(Permiso PermisoId) {
        this.PermisoId = PermisoId;
    }

    public Rol getRolId() {
        return RolId;
    }

    public void setRolId(Rol RolId) {
        this.RolId = RolId;
    }
    
    
    
}
