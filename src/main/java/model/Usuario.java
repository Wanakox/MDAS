package main.java.model;

import java.util.regex.Pattern;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String dni;
    private String tipo; // Cambiado de Rol a String
    private float cartera;

    // Constructor
    public Usuario(String nombre, String apellido, String correo, String contrasena, String dni, String tipo, float cartera) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.dni = dni;
        this.tipo = tipo;
        this.cartera = cartera;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    // Validación básica del DNI español (8 dígitos + letra)
    public static boolean esDniValido(String dni) {
        return dni != null && dni.matches("^[0-9]{8}[A-Z]$");
    }

    // Validación general de correo electrónico
    public static boolean esCorreoValido(String correo) {
        if (correo == null) return false;
        String regex = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(regex, correo);
    }

    // Validación de contraseña segura: mínimo 8 caracteres, al menos una mayúscula, una minúscula y un número
    public static boolean esContrasenaSegura(String contrasena) {
        if (contrasena == null) return false;
        return contrasena.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", correo='" + correo + '\'' +
                ", dni='" + dni + '\'' +
                ", tipo='" + tipo + '\'' +
                ", cartera=" + cartera +
                '}';
    }
}