/**
 * 
 */
package datos;

/**
 * @author REBOOTSYSTEM
 *
 */
public class TiposCalzados {

    private static Integer Id;
    private String NombreCalzado;

    public TiposCalzados() {
    }

    public TiposCalzados(String NombreCalzado) {
        this.NombreCalzado = NombreCalzado;
    }

    public static Integer getId() {
        return Id;
    }


    public String getNombreCalzado() {
        return NombreCalzado;
    }

    public void setNombreCalzado(String NombreCalzado) {
        this.NombreCalzado = NombreCalzado;
    }
    
    
    
}
