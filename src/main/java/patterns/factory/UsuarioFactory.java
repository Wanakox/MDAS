package main.java.patterns.factory;

import main.java.model.*;

/**
 * Clase fábrica para la creación de objetos {@link Usuario} según el tipo especificado.
 * <p>
 * Utiliza el patrón Factory para encapsular la lógica de creación de los diferentes tipos de usuario:
 * {@link UsuarioNormal}, {@link UsuarioOrganizador} y {@link UsuarioSoporte}.
 * </p>
 */
public class UsuarioFactory {

    /**
     * Crea una instancia de {@link Usuario} según el tipo proporcionado.
     *
     * @param tipo        el tipo de usuario a crear (USUARIO, ORGANIZADOR, SOPORTE)
     * @param nombre      el nombre del usuario
     * @param apellido    el apellido del usuario
     * @param correo      el correo electrónico del usuario
     * @param contrasena  la contraseña del usuario
     * @param dni         el DNI del usuario
     * @param cartera     el saldo inicial de la cartera del usuario
     * @return            una instancia de {@link Usuario} correspondiente al tipo especificado
     * @throws IllegalArgumentException si el tipo de usuario no es válido
     */
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
