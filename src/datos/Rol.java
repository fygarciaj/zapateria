/**aqui se establecen los get y set de los datos de la clase Rol
 * Clase Rol
 *
 * Contiene informacion de los Roles
 * 
 */
package datos;

public class Rol {
//Atributos
    private Integer Id;
    private String Rol;
     //Metodos publicos
//se establece que el dato precardo de los item de la clase rol inicialmete son null.
    public Rol() {
        this.Id = null;
        this.Rol = null;
    }
    
    public Rol(String Rol) {
        this.Rol = Rol;
    }
    /**
     * Devuelve el Id del Rol
     * @return Id del Rol
     */
    public Integer getId() {
        return Id;
    }
/**
     * Devuelve el nombre del Rol
     * @return nombre del Rol
     */
    public String getRol() {
        return Rol;
    }
/**
     * Modifica el Rol de un Rol
     * @param Rol
     */
    public void setRol(String Rol) {
        this.Rol = Rol;
    }



}
