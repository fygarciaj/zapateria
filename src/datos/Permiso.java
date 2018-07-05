/**aqui se establecen los get y set de los datos de la clase permiso de cada rol
 * Clase Permiso
 *
 * Contiene informacion de cada Permiso 
 */
package datos;

public class Permiso {

    private Integer Id;
    private String Nombre;
    private String Descripcion;
//metodos Publicos
    public Permiso() {
    }
//constructor
    public Permiso(String Nombre, String Descripcion) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }
/**
     * Devuelve el Id de permiso
     * @return Id de permiso
     */
    public Integer getId() {
        return Id;
    }
    /**
     * Devuelve el Id de permiso
     * @return Id de permiso
     */
    public String getNombre() {
        return Nombre;
    }
/**
     * Modifica el Nombre de un empleado
     * @param Nombre
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
/**
     * Devuelve la Descripcion de permiso
     * @return Descripcion de permiso
     */
    public String getDescripcion() {
        return Descripcion;
    }
/**
     * Modifica la Descripcion de un empleado
     * @param Descripcion
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    
    
}
