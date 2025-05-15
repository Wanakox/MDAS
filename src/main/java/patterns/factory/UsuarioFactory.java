package main.java.patterns.factory;

import main.java.model.*;

public class UsuarioFactory {
    public static Usuario crearUsuario(TipoUsuario tipo, String nombre, String apellido, String correo, String contrasena, String dni, float cartera) {
        switch (tipo) {
            case USUARIO:
                return new UsuarioNormal(nombre, apellido, correo, contrasena, dni, cartera);
            case ORGANIZADOR:
                return new UsuarioOrganizador(nombre, apellido, correo, contrasena, dni, cartera);
            case SOPORTE:
                return new UsuarioSoporte(nombre, apellido, correo, contrasena, dni, cartera);
            default:
                throw new IllegalArgumentException("Tipo de usuario no válido: " + tipo);
        }
    }
}