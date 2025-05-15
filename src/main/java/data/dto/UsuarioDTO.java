package main.java.data.dto;

public class UsuarioDTO {
    public String nombre;
    public String apellidos;
    public String contraseña;
    public String correo;
    public String DNI;
    public String tipo; // Cambiado de Rol a String
    public float cartera;

    // Constructor vacío
    public UsuarioDTO() {}

    // Constructor completo
    public UsuarioDTO(String nombre, String apellidos, String contraseña, String correo, String DNI, String tipo, float cartera) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contraseña = contraseña;
        this.correo = correo;
        this.DNI = DNI;
        this.tipo = tipo;
        this.cartera = cartera;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getCartera() {
        return cartera;
    }

    public void setCartera(float cartera) {
        this.cartera = cartera;
    }

    // Método toString
    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", correo='" + correo + '\'' +
                ", DNI='" + DNI + '\'' +
                ", tipo='" + tipo + '\'' +
                ", cartera=" + cartera +
                '}';
    }
}