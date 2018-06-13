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
public class Usuarios {

    private static int Id;
    private Long Identificacion;
    private String NombreCompleto;
    private Integer Edad;
    private String Direccion;
    private String Telefono;
    private String NombreUsuario;
    private String Password;
    private Roles RolId;
    
    
    public Usuarios() {
        this.Identificacion = null;
        this.NombreCompleto = null;
        this.Edad = null;
        this.Direccion = null;
        this.Telefono = null;
        this.RolId = null;
    }

    public Usuarios(Long Identificacion, String NombreCompleto, int Edad, String Direccion, String Telefono, Roles RolId) {
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

    public Long getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(Long Identificacion) {
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

    public Roles getRolId() {
        return RolId;
    }

    public void setRolId(Roles RolId) {
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

    
    


}
