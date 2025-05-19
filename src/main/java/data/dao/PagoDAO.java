package main.java.data.dao;

import main.java.model.Pago;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase DAO (Data Access Object) responsable de guardar la información de pagos
 * en un archivo de texto plano.
 * 
 * Cada pago se guarda en una línea del archivo en formato CSV.
 */
public class PagoDAO {

    /**
     * Ruta del archivo donde se almacenan los datos de pago.
     */
    private final String filePath = "./src/main/resources/pago.txt";

    /**
     * Guarda los datos de una tarjeta en el archivo de pagos.
     *
     * @param pago El objeto {@link Pago} que contiene los datos de la tarjeta a guardar.
     * @return {@code true} si los datos se guardan correctamente, {@code false} en caso de error.
     */
    public boolean guardarTarjeta(Pago pago) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            // Crear una línea con los datos del pago separados por comas
            String linea = pago.getFecha() + "," +
                           pago.getPrecio() + "," +
                           pago.getTitularTarjeta() + "," +
                           pago.getNumeroTarjeta() + "," +
                           pago.getCaducidadTarjeta() + "," +
                           pago.getCvv();

            // Escribir la línea en el archivo
            bw.write(linea);
            bw.newLine(); // Agregar un salto de línea
            return true; // Datos guardados exitosamente
        } catch (IOException e) {
            System.err.println("Error al guardar los datos de la tarjeta: " + e.getMessage());
            return false; // Fallo al guardar los datos
        }
    }
}
