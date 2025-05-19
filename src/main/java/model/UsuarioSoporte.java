package main.java.model;

/**
 * Representa un usuario con rol de soporte dentro del sistema.
 * <p>
 * Esta clase extiende {@link Usuario} y asigna automáticamente el tipo "SOPORTE".
 * </p>
 */
public class UsuarioSoporte extends Usuario {

    /**
     * Constructor para crear un usuario con rol de soporte.
     *
     * @param nombre      Nombre del usuario.
     * @param apellido    Apellido del usuario.
     * @param correo      Correo electrónico del usuario.
     * @param contrasena  Contraseña del usuario.
     * @param dni         DNI del usuario.
     * @param cartera     Saldo inicial en la cartera del usuario.
     */
    public UsuarioSoporte(String nombre, String apellido, String correo, String contrasena, String dni, float cartera) {
        super(nombre, apellido, correo, contrasena, dni, "SOPORTE", cartera); // Cambiado Rol.SOPORTE a "SOPORTE"
    }
}
