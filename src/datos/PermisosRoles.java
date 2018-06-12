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
public class PermisosRoles {
    private Permisos PermisoId;
    private Roles RolId;

    public PermisosRoles() {
    }

    public PermisosRoles(Permisos PermisoId, Roles RolId) {
        this.PermisoId = PermisoId;
        this.RolId = RolId;
    }

    public Permisos getPermisoId() {
        return PermisoId;
    }

    public void setPermisoId(Permisos PermisoId) {
        this.PermisoId = PermisoId;
    }

    public Roles getRolId() {
        return RolId;
    }

    public void setRolId(Roles RolId) {
        this.RolId = RolId;
    }
    
    
    
}
