package main.java.model;

/**
 * Representa un usuario de tipo normal dentro del sistema.
 * <p>
 * Esta clase extiende {@link Usuario} y establece automáticamente el tipo como "USUARIO".
 * </p>
 */
public class UsuarioNormal extends Usuario {

    /**
     * Constructor para crear un usuario normal.
     *
     * @param nombre      Nombre del usuario.
     * @param apellido    Apellido del usuario.
     * @param correo      Correo electrónico del usuario.
     * @param contrasena  Contraseña del usuario.
     * @param dni         DNI del usuario.
     * @param cartera     Saldo inicial en la cartera del usuario.
     */
    public UsuarioNormal(String nombre, String apellido, String correo, String contrasena, String dni, float cartera) {
        super(nombre, apellido, correo, contrasena, dni, "USUARIO", cartera); // Cambiado Rol.USUARIO a "USUARIO"
    }
}
