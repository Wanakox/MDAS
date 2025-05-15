package main.java.model;

public class UsuarioNormal extends Usuario {
    public UsuarioNormal(String nombre, String apellido, String correo, String contrasena, String dni, float cartera) {
        super(nombre, apellido, correo, contrasena, dni, "USUARIO", cartera); // Cambiado Rol.USUARIO a "USUARIO"
    }
}