package main.java.model;

public class UsuarioOrganizador extends Usuario {
    public UsuarioOrganizador(String nombre, String apellido, String correo, String contrasena, String dni, float cartera) {
        super(nombre, apellido, correo, contrasena, dni, "ORGANIZADOR", cartera); // Cambiado Rol.ORGANIZADOR a "ORGANIZADOR"
    }
}