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
public class RolUsuario {
    
    private Rol RolId;
    private Usuario UsuarioId;

    public RolUsuario() {
        this.RolId = null;
        this.UsuarioId = null;
    }

    public RolUsuario(Rol RolId, Usuario UsuarioId) {
        this.RolId = RolId;
        this.UsuarioId = UsuarioId;
    }

    public Rol getRolId() {
        return RolId;
    }

    public void setRolId(Rol RolId) {
        this.RolId = RolId;
    }

    public Usuario getUsuarioId() {
        return UsuarioId;
    }

    public void setUsuarioId(Usuario UsuarioId) {
        this.UsuarioId = UsuarioId;
    }
    
    
    
}
