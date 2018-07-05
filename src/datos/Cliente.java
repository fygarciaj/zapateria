/**aqui se establecen los get y set de los datos de la clase cliente
 * Clase Cliente
 *
 * Contiene informacion de cada Cliente
 */
package datos;

/**
 * @author REBOOTSYSTEM
 *
 */
public class Cliente {
//declaracion de variables
    private Integer Id;
    private String Identificacion;
    private String NombreCompleto;
    private String FechaNacimiento;
    private String Telefono;
    private String Direccion;

    public Cliente() {
    }
    

     /**
     * Devuelve el Id de un cliente
     * @return Id del cliente
     */
    public Integer getId() {
        return Id;
    }
/**
     * Modifica el Id de un empleado
     * @param Id
     */
    public void setId(Integer Id) {
        this.Id = Id;
    }

    /**
     * Devuelve la Identificacion de un cliente
     * @return Identificacion del cliente
     */
    public String getIdentificacion() {
        return Identificacion;
    }
    /**
     * Modifica el Identificacion de un empleado
     * @param Identificacion
     */
    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    
     /**
     * Devuelve el NombreCompleto de un cliente
     * @return NombreCompleto del cliente
     */
    public String getNombreCompleto() {
        return NombreCompleto;
    }

    /**
     * Modifica el NombreCompleto de un empleado
     * @param NombreCompleto
     */
    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    /**
     * Devuelve la FechaNacimiento de un cliente
     * @return FechaNacimiento del cliente
     */
    public String getFechaNacimiento() {
        return FechaNacimiento;
    }
     /**
     * Modifica la FechaNacimiento de un empleado
     * @param FechaNacimiento
     */
    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }


    /**
     * Devuelve  Telefono de un cliente
     * @return Telefono del cliente
     */
    public String getTelefono() {
        return Telefono;
    }

    
     /**
     * Modifica el Telefono de un empleado
     * @param Telefono
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * Devuelve  Direccion de un cliente
     * @return Direccion del cliente
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * Modifica el Telefono de un empleado
     * @param Direccion
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

}
