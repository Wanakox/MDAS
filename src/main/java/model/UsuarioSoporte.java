package main.java.model;

public class UsuarioSoporte extends Usuario {
    public UsuarioSoporte(String nombre, String apellido, String correo, String contrasena, String dni, float cartera) {
        super(nombre, apellido, correo, contrasena, dni, "SOPORTE", cartera); // Cambiado Rol.SOPORTE a "SOPORTE"
    }
}