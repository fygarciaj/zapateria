/**aqui se establecen los get y set de los datos de la clase Usuario
* Clase Usuario
 *
 * Contiene informacion de cada Usuario
 * 
 */
package datos;

import java.util.List;

/**
 *
 * @author REBOOTSYSTEM
 */
public class Usuario {
     //Atributos
// se establece los tipos de datos de cada uno de los items de la clase Usuario
    private static int Id;
    private String Identificacion;
    private String NombreCompleto;
    private Integer Edad;
    private String Direccion;
    private String Telefono;
    private String NombreUsuario;
    private String Password;
    private Rol RolId;
    
    //constructor default
    public Usuario() {
        /* se establece el estado inicial de cada uno de los items de la clase
        Usuario, es decir que inicialmente esten en null
        */
        this.Identificacion = null;
        this.NombreCompleto = null;
        this.Edad = null;
        this.Direccion = null;
        this.Telefono = null;
        this.RolId = null;
    }
//constructor con 6 parametros
    public Usuario(String Identificacion, String NombreCompleto, Integer Edad, String Direccion, String Telefono, Rol RolId) {
        this.Identificacion = Identificacion;
        this.NombreCompleto = NombreCompleto;
        this.Edad = Edad;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.RolId = RolId;
    }
    
    //Metodos publicos
    /**
     * Devuelve el Id del Usuario
     * @return Id del Usuario
     */
    public static int getId() {
        return Id;
    }
/**
     * Modifica el ID de un Usuario
     * @param Id
     */
    public static void setId(int Id) {
        Usuario.Id = Id;
    }
/**
     * Devuelve la Identificacion del Usuario
     * @return Identificacion del Usuario
     */
    public String getIdentificacion() {
        return Identificacion;
    }
/**
     * Modifica el ID de un Usuario
     * @param Identificacion
     */
    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }
/**
     * Devuelve el NombreCompleto del Usuario
     * @return NombreCompleto del Usuario
     */
    public String getNombreCompleto() {
        return NombreCompleto;
    }
/**
     * Modifica el NombreCompleto de un Usuario
     * @param NombreCompleto
     */
    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }
/**
     * Devuelve la Edad del Usuario
     * @return Edad del Usuario
     */
    public Integer getEdad() {
        return Edad;
    }
/**
     * Modifica la Edad de un Usuario
     * @param Edad
     */
    public void setEdad(Integer Edad) {
        this.Edad = Edad;
    }
/**
     * Devuelve la Direccion del Usuario
     * @return Direccion del Usuario
     */
    public String getDireccion() {
        return Direccion;
    }
/**
     * Modifica la Direccion de un Usuario
     * @param Direccion
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
/**
     * Devuelve el Telefono del Usuario
     * @return Telefono del Usuario
     */
    public String getTelefono() {
        return Telefono;
    }
/**
     * Modifica el Telefono de un Usuario
     * @param Telefono
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
/**
     * Devuelve el RolId del Usuario
     * @return RolId del Usuario
     */
    public Rol getRolId() {
        return RolId;
    }
/**
     * Modifica el RolId de un Usuario
     * @param RolId
     */
    public void setRolId(Rol RolId) {
        this.RolId = RolId;
    }
/**
     * Devuelve el NombreUsuario del Usuario
     * @return NombreUsuario del Usuario
     */
    public String getNombreUsuario() {
        return NombreUsuario;
    }
/**
     * Modifica el NombreUsuario de un Usuario
     * @param NombreUsuario
     */
    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }
/**
     * Devuelve el Password del Usuario
     * @return Password del Usuario
     */
    public String getPassword() {
        return Password;
    }
/**
     * Modifica el Password de un Usuario
     * @param Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

     //validacion
     
    public void setEdad(String edad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
