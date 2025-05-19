package main.java.data.dao;

import main.java.model.Pago;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PagoDAO {

    private final String filePath = "./src/main/resources/pago.txt";

    /**
     * Método para guardar los datos de la tarjeta en el archivo.
     * @param pago El objeto Pago con los datos a guardar.
     * @return true si los datos se guardan correctamente, false en caso contrario.
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