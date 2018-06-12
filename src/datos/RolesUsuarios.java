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
public class RolesUsuarios {
    
    private Roles RolId;
    private Usuarios UsuarioId;

    public RolesUsuarios() {
        this.RolId = null;
        this.UsuarioId = null;
    }

    public RolesUsuarios(Roles RolId, Usuarios UsuarioId) {
        this.RolId = RolId;
        this.UsuarioId = UsuarioId;
    }

    public Roles getRolId() {
        return RolId;
    }

    public void setRolId(Roles RolId) {
        this.RolId = RolId;
    }

    public Usuarios getUsuarioId() {
        return UsuarioId;
    }

    public void setUsuarioId(Usuarios UsuarioId) {
        this.UsuarioId = UsuarioId;
    }
    
    
    
}
