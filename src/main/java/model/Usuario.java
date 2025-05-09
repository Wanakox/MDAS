package main.java.model;

import java.util.regex.Pattern;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String dni;
    private Rol rol;

    public enum Rol {
        USUARIO, ORGANIZADOR, SOPORTE
    }

    // Constructor
    public Usuario(String nombre, String apellido, String correo, String contrasena, String dni, Rol rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.dni = dni;
        this.rol = rol;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


    // Validación básica del DNI español (8 dígitos + letra)
    public static boolean esDniValido(String dni) {
        // La expresión regular valida tiene que tener 8 dígitos y debe tener una letra mayuscula
        return dni != null && dni.matches("^[0-9]{8}[A-Z]$");
    }

    // Validación general de correo electrónico
    public static boolean esCorreoValido(String correo) {
        if (correo == null) return false;
        // Debe comenzar con una combinacion de cualquier tipo debe tener un @ y varios caracteres y finalmente acabar con un .com 
        String regex = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(regex, correo);
    }

    // Validación de contraseña segura: mínimo 8 caracteres, al menos una mayúscula, una minúscula y un número
    public static boolean esContrasenaSegura(String contrasena) {
        if (contrasena == null) return false;
        // Debe tener una letra minuscula, mayuscula, tener un número y 8 caracteres
        return contrasena.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
    }
}

