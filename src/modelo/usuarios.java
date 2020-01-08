package modelo;

public class usuarios {

    private int id;
    private String user;
    private String password;
    private String nombre;
    private String correo;
    private String last_sesion;
    private int id_tipo;

    //***************************
    //ID DE USUARIO
    //***************************
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //***************************
    //USUARIO
    //***************************
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    //***************************
    //PASSWORD
    //***************************
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //***************************
    //ID DE NOMBRE
    //***************************
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //***************************
    //ID DE CORREO
    //***************************
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    //***************************
    //HORA DE INICIO DE SESION
    //***************************
    public String getLast_sesion() {
        return last_sesion;
    }

    public void setLast_sesion(String last_sesion) {
        this.last_sesion = last_sesion;
    }

    //***************************
    //ID_TIPO
    //***************************
    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

}
