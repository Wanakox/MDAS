package main.java.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Representa un evento que puede tener entradas asociadas.
 * Contiene información como nombre, fecha, hora, ubicación, tipo y cantidad de entradas disponibles.
 * Esta clase utiliza el patrón de diseño Builder para su construcción.
 */
public class Evento {
    private final int id;
    private final String nombre;
    private final int numeroEntradas;
    private final LocalDate fecha;
    private final LocalTime hora;
    private final String ubicacion;
    private final String tipo;

    /**
     * Constructor privado que se utiliza desde el builder.
     *
     * @param builder Objeto EventoBuilder con los datos del evento.
     */
    private Evento(EventoBuilder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.numeroEntradas = builder.numeroEntradas;
        this.fecha = builder.fecha;
        this.hora = builder.hora;
        this.ubicacion = builder.ubicacion;
        this.tipo = builder.tipo;
    }

    /**
     * Obtiene el ID del evento.
     *
     * @return ID único del evento.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del evento.
     *
     * @return Nombre del evento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el número total de entradas disponibles para el evento.
     *
     * @return Número de entradas.
     */
    public int getNumeroEntradas() {
        return numeroEntradas;
    }

    /**
     * Obtiene la fecha del evento.
     *
     * @return Fecha del evento.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Obtiene la hora del evento.
     *
     * @return Hora del evento.
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Obtiene la ubicación del evento.
     *
     * @return Ubicación donde se realizará el evento.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Obtiene el tipo del evento.
     *
     * @return Tipo del evento (por ejemplo: concierto, conferencia, etc.).
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Devuelve una representación en forma de texto del objeto Evento.
     *
     * @return Cadena con los atributos del evento.
     */
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

    /**
     * Builder para la creación de objetos Evento de forma flexible y segura.
     */
    public static class EventoBuilder {
        private int id;
        private String nombre;
        private int numeroEntradas;
        private LocalDate fecha;
        private LocalTime hora;
        private String ubicacion;
        private String tipo;

        /**
         * Establece el ID del evento.
         *
         * @param id ID único del evento.
         * @return Instancia del builder.
         */
        public EventoBuilder setId(int id) {
            this.id = id;
            return this;
        }

        /**
         * Establece el nombre del evento.
         *
         * @param nombre Nombre del evento.
         * @return Instancia del builder.
         */
        public EventoBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        /**
         * Establece el número de entradas disponibles.
         *
         * @param numeroEntradas Número de entradas.
         * @return Instancia del builder.
         */
        public EventoBuilder setNumeroEntradas(int numeroEntradas) {
            this.numeroEntradas = numeroEntradas;
            return this;
        }

        /**
         * Establece la fecha del evento.
         *
         * @param fecha Fecha del evento.
         * @return Instancia del builder.
         */
        public EventoBuilder setFecha(LocalDate fecha) {
            this.fecha = fecha;
            return this;
        }

        /**
         * Establece la hora del evento.
         *
         * @param hora Hora del evento.
         * @return Instancia del builder.
         */
        public EventoBuilder setHora(LocalTime hora) {
            this.hora = hora;
            return this;
        }

        /**
         * Establece la ubicación del evento.
         *
         * @param ubicacion Ubicación del evento.
         * @return Instancia del builder.
         */
        public EventoBuilder setUbicacion(String ubicacion) {
            this.ubicacion = ubicacion;
            return this;
        }

        /**
         * Establece el tipo del evento.
         *
         * @param tipo Tipo del evento (concierto, teatro, etc.).
         * @return Instancia del builder.
         */
        public EventoBuilder setTipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        /**
         * Construye y devuelve una instancia de {@link Evento}.
         *
         * @return Objeto Evento construido con los valores establecidos.
         */
        public Evento build() {
            return new Evento(this);
        }
    }
}
