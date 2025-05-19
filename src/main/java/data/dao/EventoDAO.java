package main.java.data.dao;

import main.java.data.dto.EventoDTO;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {

    private static final String RUTA_ARCHIVO = "src/main/resources/evento.txt";
    private static final String CABECERA = "id,nombre,númeroEntradas,fecha,hora,ubicación,tipo";

    /**
     * Devuelve todos los eventos leídos del archivo.
     */
    public List<EventoDTO> obtenerTodos() {
        List<EventoDTO> eventos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = reader.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
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
     * Busca un evento por su ID.
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
     * Reemplaza un evento existente con el mismo ID.
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
     * Elimina un evento por ID.
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
     * Escribe todos los eventos al archivo, sobrescribiendo el contenido.
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
     * Convierte un EventoDTO a formato CSV.
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