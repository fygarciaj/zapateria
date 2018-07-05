/**aqui se establecen los get y set de los datos de la clase TipoCalzado
 * Clase TipoCalzado
 *
 * Contiene informacion de cada TipoCalzado
 *
 */
package datos;

/**
 * @author REBOOTSYSTEM
 *
 */
public class TipoCalzado {
//Atributos
    private static Integer Id;
    private String NombreCalzado;
    
//Metodos publicos
    public TipoCalzado() {
    }
//constructor
    public TipoCalzado(String NombreCalzado) {
        this.NombreCalzado = NombreCalzado;
    }
 /**
     * Devuelve el Id del TipoCalzado
     * @return Id del TipoCalzado
     */
    public static Integer getId() {
        return Id;
    }

 /**
     * Devuelve el NombreCalzado del TipoCalzado
     * @return NombreCalzado del TipoCalzado
     */
    public String getNombreCalzado() {
        return NombreCalzado;
    }
/**
     * Modifica el NombreCalzado de un TipoCalzado
     * @param NombreCalzado
     */
    public void setNombreCalzado(String NombreCalzado) {
        this.NombreCalzado = NombreCalzado;
    }
    
    
    
}
