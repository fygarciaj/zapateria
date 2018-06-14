package datos;

public class Rol {

    private Integer Id;
    private String Rol;

    public Rol() {
        this.Id = null;
        this.Rol = null;
    }
    
    public Rol(String Rol) {
        this.Rol = Rol;
    }
    public Integer getId() {
        return Id;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }



}
