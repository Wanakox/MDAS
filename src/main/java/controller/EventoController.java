package main.java.controller;

import main.java.data.dao.EventoDAO;
import main.java.data.dto.EventoDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class EventoController {

    private final EventoDAO eventoDAO;

    public EventoController() {
        this.eventoDAO = new EventoDAO();
    }

    /**
     * Crea un nuevo evento si no existe un evento con el mismo ID.
     */
    public boolean crearEvento(String titulo, int id, int numeroEntradas,
            String localizacion, String tipoEvento, LocalDate fecha, LocalTime hora) {
        if (eventoDAO.obtenerPorId(id) != null) {
            System.out.println("Error: ya existe un evento con ID " + id);
            return false;
        }

        EventoDTO nuevoEvento = new EventoDTO();
        nuevoEvento.setId(id);
        nuevoEvento.setNombre(titulo);
        nuevoEvento.setNumeroEntradas(numeroEntradas);
        nuevoEvento.setFecha(fecha);
        nuevoEvento.setHora(hora);
        nuevoEvento.setUbicacion(localizacion);
        String tipoFormateado = validarYFormatearTipo(tipoEvento);
        if (tipoFormateado == null) {
            System.out.println(
                    "Tipo de evento no válido. Opciones válidas: Concierto, Festival, Obra de Teatro, Evento Deportivo.");
            return false;
        }
        nuevoEvento.setTipo(tipoFormateado);

        eventoDAO.guardarEvento(nuevoEvento);
        System.out.println("Evento creado: " + titulo);
        return true;
    }

    /**
     * Modifica un evento existente si se encuentra por ID.
     */
    public boolean modificarEvento(String titulo, int id, int numeroEntradas,
            String localizacion, String tipoEvento, LocalDate fecha, LocalTime hora) {
        EventoDTO existente = eventoDAO.obtenerPorId(id);
        if (existente == null) {
            System.out.println("Error: no se encontró el evento con ID " + id);
            return false;
        }

        existente.setNombre(titulo);
        existente.setNumeroEntradas(numeroEntradas);
        existente.setFecha(fecha);
        existente.setHora(hora);
        existente.setUbicacion(localizacion);
        String tipoFormateado = validarYFormatearTipo(tipoEvento);
        if (tipoFormateado == null) {
            System.out.println(
                    "Tipo de evento no válido. Opciones válidas: Concierto, Festival, Obra de Teatro, Evento Deportivo.");
            return false;
        }
        existente.setTipo(tipoFormateado);

        eventoDAO.actualizarEvento(existente);
        System.out.println("Evento actualizado: " + titulo);
        return true;
    }

    /**
     * Elimina un evento si existe por su ID.
     */
    public boolean cancelarEvento(int id) {
        boolean eliminado = eventoDAO.eliminarEvento(id);
        if (eliminado) {
            System.out.println("Evento con ID " + id + " eliminado correctamente.");
            return true;
        } else {
            System.out.println("Error: no se encontró el evento con ID " + id);
            return false;
        }
    }

    /**
     * Busca y muestra un evento por ID.
     */
    public boolean obtenerEvento(int id) {
        EventoDTO evento = eventoDAO.obtenerPorId(id);
        if (evento != null) {
            System.out.println("Evento encontrado:");
            System.out.println("Nombre: " + evento.getNombre());
            System.out.println("Fecha: " + evento.getFecha() + " Hora: " + evento.getHora());
            System.out.println("Ubicación: " + evento.getUbicacion());
            System.out.println("Tipo: " + evento.getTipo());
            System.out.println("Entradas: " + evento.getNumeroEntradas());
            return true;
        } else {
            System.out.println("Evento no encontrado con ID: " + id);
            return false;
        }
    }

    /**
     * Lista todos los eventos disponibles.
     */
    public void listarEventos() {
        List<EventoDTO> eventos = eventoDAO.obtenerTodos();
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
        } else {
            System.out.println("Eventos disponibles:");
            for (EventoDTO evento : eventos) {
                System.out.println("- [" + evento.getId() + "] " + evento.getNombre()
                        + " (" + evento.getTipo() + ") - " + evento.getFecha() + " " + evento.getHora());
            }
        }
    }

    private static final String[][] TIPOS_VALIDOS = {
            { "concierto", "Concierto" },
            { "festival", "Festival" },
            { "obra de teatro", "Obra de Teatro" },
            { "evento deportivo", "Evento Deportivo" }
    };

    private String validarYFormatearTipo(String tipoUsuario) {
        String tipoNormalizado = tipoUsuario.trim().toLowerCase();
        for (String[] tipo : TIPOS_VALIDOS) {
            if (tipo[0].equals(tipoNormalizado)) {
                return tipo[1];
            }
        }
        return null;
    }

}