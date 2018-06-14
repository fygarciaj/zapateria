/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;

/**
 *
 * @author REBOOTSYSTEM
 */
public class Usuario {

    private static int Id;
    private String Identificacion;
    private String NombreCompleto;
    private Integer Edad;
    private String Direccion;
    private String Telefono;
    private String NombreUsuario;
    private String Password;
    private Rol RolId;
    
    
    public Usuario() {
        this.Identificacion = null;
        this.NombreCompleto = null;
        this.Edad = null;
        this.Direccion = null;
        this.Telefono = null;
        this.RolId = null;
    }

    public Usuario(String Identificacion, String NombreCompleto, Integer Edad, String Direccion, String Telefono, Rol RolId) {
        this.Identificacion = Identificacion;
        this.NombreCompleto = NombreCompleto;
        this.Edad = Edad;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.RolId = RolId;
    }
    public static int getId() {
        return Id;
    }

    public static void setId(int Id) {
        Usuario.Id = Id;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer Edad) {
        this.Edad = Edad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public Rol getRolId() {
        return RolId;
    }

    public void setRolId(Rol RolId) {
        this.RolId = RolId;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setEdad(String edad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
