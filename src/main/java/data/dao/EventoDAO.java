package main.java.data.dao;

import main.java.data.dto.EventoDTO;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO (Data Access Object) para manejar operaciones de lectura y escritura de eventos
 * en un archivo de texto plano.
 * 
 * Los eventos están almacenados en formato CSV en la ruta especificada.
 */
public class EventoDAO {

    private static final String RUTA_ARCHIVO = "src/main/resources/evento.txt";
    private static final String CABECERA = "id,nombre,númeroEntradas,fecha,hora,ubicación,tipo";

    /**
     * Lee todos los eventos del archivo y los devuelve como una lista de objetos EventoDTO.
     *
     * @return Lista de todos los eventos leídos del archivo.
     */
    public List<EventoDTO> obtenerTodos() {
        List<EventoDTO> eventos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = reader.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue; // Saltar la cabecera
                }

                String[] partes = linea.split(",", -1);
                if (partes.length != 7) continue;

                EventoDTO evento = new EventoDTO();
                evento.setId(Integer.parseInt(partes[0].trim()));
                evento.setNombre(partes[1].trim());
                evento.setNumeroEntradas(Integer.parseInt(partes[2].trim()));
                evento.setFecha(LocalDate.parse(partes[3].trim()));
                evento.setHora(LocalTime.parse(partes[4].trim()));
                evento.setUbicacion(partes[5].trim());
                evento.setTipo(partes[6].trim());

                eventos.add(evento);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return eventos;
    }

    /**
     * Busca y devuelve un evento según su identificador único.
     *
     * @param id ID del evento a buscar.
     * @return EventoDTO correspondiente si se encuentra, o null si no existe.
     */
    public EventoDTO obtenerPorId(int id) {
        return obtenerTodos()
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Guarda un nuevo evento añadiéndolo al final del archivo.
     *
     * @param nuevoEvento Evento a guardar.
     */
    public void guardarEvento(EventoDTO nuevoEvento) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, true))) {
            writer.newLine();
            writer.write(formatearEvento(nuevoEvento));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza un evento existente (por ID) en el archivo.
     * Si no se encuentra el evento, no se realiza ninguna acción.
     *
     * @param eventoActualizado Evento con los nuevos datos.
     */
    public void actualizarEvento(EventoDTO eventoActualizado) {
        List<EventoDTO> eventos = obtenerTodos();
        boolean encontrado = false;

        for (int i = 0; i < eventos.size(); i++) {
            if (eventos.get(i).getId() == eventoActualizado.getId()) {
                eventos.set(i, eventoActualizado);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            sobrescribirArchivo(eventos);
        } else {
            System.out.println("No se pudo actualizar: ID no encontrado.");
        }
    }

    /**
     * Elimina un evento del archivo según su ID.
     *
     * @param id ID del evento a eliminar.
     * @return true si el evento fue eliminado, false si no se encontró.
     */
    public boolean eliminarEvento(int id) {
        List<EventoDTO> eventos = obtenerTodos();
        boolean eliminado = eventos.removeIf(e -> e.getId() == id);
        if (eliminado) {
            sobrescribirArchivo(eventos);
        }
        return eliminado;
    }

    /**
     * Escribe todos los eventos proporcionados en el archivo, sobrescribiendo su contenido.
     *
     * @param eventos Lista de eventos a escribir.
     */
    private void sobrescribirArchivo(List<EventoDTO> eventos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))) {
            writer.write(CABECERA);
            for (EventoDTO evento : eventos) {
                writer.newLine();
                writer.write(formatearEvento(evento));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Convierte un objeto EventoDTO a su representación en formato CSV.
     *
     * @param e Evento a formatear.
     * @return Cadena en formato CSV representando al evento.
     */
    private String formatearEvento(EventoDTO e) {
        return String.join(",",
                String.valueOf(e.getId()),
                e.getNombre(),
                String.valueOf(e.getNumeroEntradas()),
                e.getFecha().toString(),
                e.getHora().toString(),
                e.getUbicacion(),
                e.getTipo());
    }
}
