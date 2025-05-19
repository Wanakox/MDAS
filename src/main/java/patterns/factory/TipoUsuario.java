package main.java.patterns.factory;

/**
 * Enumeración que representa los diferentes tipos de usuarios del sistema.
 * <p>
 * Esta enumeración se utiliza en la lógica de creación de usuarios dentro del patrón Factory,
 * permitiendo distinguir entre las distintas categorías de usuario.
 * </p>
 */
public enum TipoUsuario {
    
    /**
     * Representa a un usuario normal del sistema.
     */
    USUARIO,

    /**
     * Representa a un organizador de eventos o actividades.
     */
    ORGANIZADOR,

    /**
     * Representa al personal de soporte del sistema.
     */
    SOPORTE
}
