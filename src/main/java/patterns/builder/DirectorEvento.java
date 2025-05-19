package main.java.patterns.builder;

import main.java.model.Evento;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase que actúa como director en el patrón de diseño Builder para construir objetos {@link Evento}.
 * <p>
 * Encapsula el proceso de construcción de un evento utilizando un {@link Evento.EventoBuilder}.
 * </p>
 */
public class DirectorEvento {

    /**
     * Construye un objeto {@link Evento} utilizando el patrón Builder.
     *
     * @param builder          Instancia de {@link Evento.EventoBuilder} que se utilizará para construir el evento.
     * @param id               Identificador único del evento.
     * @param nombre           Nombre del evento.
     * @param numeroEntradas   Número de entradas disponibles para el evento.
     * @param fecha            Fecha en que se llevará a cabo el evento.
     * @param hora             Hora en que se llevará a cabo el evento.
     * @param ubicacion        Ubicación física donde se realizará el evento.
     * @param tipo             Tipo o categoría del evento.
     * @return                 Objeto {@link Evento} construido con los datos proporcionados.
     */
    public Evento construirEvento(Evento.EventoBuilder builder,
            int id,
            String nombre,
            int numeroEntradas,
            LocalDate fecha,
            LocalTime hora,
            String ubicacion,
            String tipo) {

        return builder
                .setId(id)
                .setNombre(nombre)
                .setNumeroEntradas(numeroEntradas)
                .setFecha(fecha)
                .setHora(hora)
                .setUbicacion(ubicacion)
                .setTipo(tipo)
                .build();
    }
}
