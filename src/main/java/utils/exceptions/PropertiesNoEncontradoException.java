package main.java.utils.exceptions;

/**
 * Excepción personalizada que se lanza cuando no se encuentra un archivo de propiedades
 * específico en el sistema.
 *
 * Esta excepción extiende la clase {@link Exception} y se utiliza cuando un archivo
 * de configuración (properties) no se encuentra en la ubicación esperada.
 * 
 * @author Javier
 * @version 2.0
 */
public class PropertiesNoEncontradoException extends Exception {

    /**
     * Crea una nueva instancia de {@code PropertiesNoEncontradoException} con un mensaje
     * detallado que indica que el archivo de propiedades especificado no se ha encontrado.
     *
     * @param fileName el nombre del archivo de propiedades que no se encuentra.
     */
    public PropertiesNoEncontradoException(String fileName) {
        super("Fichero properties: " + fileName + " no encontrado");
    }
}