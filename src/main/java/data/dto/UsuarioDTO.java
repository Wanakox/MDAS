package main.java.data.dto;

public class UsuarioDTO {
    private String dni;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private float cartera;
    private String rol;

    public UsuarioDTO(String dni, String nombre, String apellido, String correo, String contrasena, float cartera, String rol) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.cartera = cartera;
        this.rol = rol;
    }

    // Getters y Setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public float getCartera() { return cartera; }
    public void setCartera(float cartera) { this.cartera = cartera; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}
