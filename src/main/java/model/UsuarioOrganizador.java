package main.java.model;

/**
 * Representa un usuario de tipo organizador dentro del sistema.
 * <p>
 * Esta clase extiende {@link Usuario} y establece automáticamente el tipo como "ORGANIZADOR".
 * </p>
 */
public class UsuarioOrganizador extends Usuario {

    /**
     * Constructor para crear un usuario organizador.
     *
     * @param nombre      Nombre del usuario.
     * @param apellido    Apellido del usuario.
     * @param correo      Correo electrónico del usuario.
     * @param contrasena  Contraseña del usuario.
     * @param dni         DNI del usuario.
     * @param cartera     Saldo inicial en la cartera del usuario.
     */
    public UsuarioOrganizador(String nombre, String apellido, String correo, String contrasena, String dni, float cartera) {
        super(nombre, apellido, correo, contrasena, dni, "ORGANIZADOR", cartera); // Cambiado Rol.ORGANIZADOR a "ORGANIZADOR"
    }
}
