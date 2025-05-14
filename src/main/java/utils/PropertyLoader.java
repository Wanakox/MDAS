package main.java.utils;

import main.java.utils.exceptions.PropertiesNoEncontradoException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * La clase {@code PropertyLoader} se encarga de cargar las propiedades desde un archivo de propiedades.
 * 
 * Esta clase proporciona un mecanismo para cargar y acceder a las propiedades definidas en un archivo,
 * permitiendo a otras partes de la aplicación obtener configuraciones de manera fácil y centralizada.
 * 
 * @author Javier
 * @version 2.0
 */
public class PropertyLoader {
    private Properties properties = new Properties();

    /**
     * Constructor de la clase {@code PropertyLoader}.
     * 
     * Este constructor intenta cargar las propiedades desde el archivo especificado. Si el archivo
     * no se encuentra, se lanza una excepción {@link PropertiesNoEncontradoException}.
     *
     * @param filePath La ruta completa del archivo de propiedades a cargar.
     * @throws PropertiesNoEncontradoException Si el archivo de propiedades no se encuentra.
     */
    public PropertyLoader(String filePath) {
        loadProperties(filePath);
    }

    /**
     * Carga las propiedades desde el archivo especificado.
     * 
     * Este método utiliza un {@link FileInputStream} para cargar el archivo de propiedades
     * desde el sistema de archivos. Si el archivo no se encuentra o no puede cargarse,
     * se lanza una excepción {@link PropertiesNoEncontradoException}.
     *
     * @param filePath La ruta completa del archivo de propiedades a cargar.
     * @throws PropertiesNoEncontradoException Si el archivo de propiedades no se encuentra o no puede cargarse.
     */
    private void loadProperties(String filePath) {
        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Obtiene el valor de una propiedad especificada por su clave.
     * 
     * Este método permite acceder a una propiedad cargada desde el archivo de propiedades, devolviendo
     * el valor asociado a la clave especificada. Si la clave no existe, devuelve {@code null}.
     *
     * @param key La clave de la propiedad a obtener.
     * @return El valor de la propiedad, o {@code null} si la clave no existe.
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}