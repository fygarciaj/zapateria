package datos;

public class Roles {

    private Integer Id;
    private String Rol;

    public Roles() {
        this.Id = null;
        this.Rol = null;
    }
    
    public Roles(String Rol) {
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
