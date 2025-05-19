package main.java.patterns.builder;

import main.java.model.Evento;
import java.time.LocalDate;
import java.time.LocalTime;

public class DirectorEvento {

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
