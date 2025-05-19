package main.java.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
    private final int id;
    private final String nombre;
    private final int numeroEntradas;
    private final LocalDate fecha;
    private final LocalTime hora;
    private final String ubicacion;
    private final String tipo;

    private Evento(EventoBuilder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.numeroEntradas = builder.numeroEntradas;
        this.fecha = builder.fecha;
        this.hora = builder.hora;
        this.ubicacion = builder.ubicacion;
        this.tipo = builder.tipo;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroEntradas() {
        return numeroEntradas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numeroEntradas=" + numeroEntradas +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", ubicacion='" + ubicacion + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    // Builder interno
    public static class EventoBuilder {
        private int id;
        private String nombre;
        private int numeroEntradas;
        private LocalDate fecha;
        private LocalTime hora;
        private String ubicacion;
        private String tipo;

        public EventoBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public EventoBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public EventoBuilder setNumeroEntradas(int numeroEntradas) {
            this.numeroEntradas = numeroEntradas;
            return this;
        }

        public EventoBuilder setFecha(LocalDate fecha) {
            this.fecha = fecha;
            return this;
        }

        public EventoBuilder setHora(LocalTime hora) {
            this.hora = hora;
            return this;
        }

        public EventoBuilder setUbicacion(String ubicacion) {
            this.ubicacion = ubicacion;
            return this;
        }

        public EventoBuilder setTipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        public Evento build() {
            return new Evento(this);
        }
    }
}