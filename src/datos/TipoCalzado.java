/**
 * 
 */
package datos;

/**
 * Clase que representa el modelo de datos Tipo Calzados.
 * 
 * @author REBOOTSYSTEM
 *
 */
public class TipoCalzado {

    private static Integer Id;
    private String NombreCalzado;

    public TipoCalzado() {
    }

    public TipoCalzado(String NombreCalzado) {
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

    @Override
    public String toString() {
        return NombreCalzado;
    }
}
