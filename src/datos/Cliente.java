/**
 * 
 */
package datos;

import java.sql.Date;

/**
 * @author REBOOTSYSTEM
 *
 */
public class Cliente {

    private Integer Id;
    private Integer Identificacion;
    private String NombreCompleto;
    private Date FechaNacimiento;
    private String Telefono;
    private String Direccion;

    public Cliente() {
    }
    

    /**
     * @return the Id
     */
    public Integer getId() {
        return Id;
    }

    /**
     * @return the Identificacion
     */
    public Integer getIdentificacion() {
        return Identificacion;
    }

    /**
     * @param Identificacion the Identificacion to set
     */
    public void setIdentificacion(Integer Identificacion) {
        this.Identificacion = Identificacion;
    }

    /**
     * @return the NombreCompleto
     */
    public String getNombreCompleto() {
        return NombreCompleto;
    }

    /**
     * @param NombreCompleto the NombreCompleto to set
     */
    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    /**
     * @return the FechaNacimiento
     */
    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    /**
     * @param FechaNacimiento the FechaNacimiento to set
     */
    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the Direccion
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

}
