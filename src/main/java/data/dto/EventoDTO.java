package main.java.data.dto;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase DTO (Data Transfer Object) que representa un evento.
 * Se utiliza para transportar datos de un evento entre capas de la aplicación
 * sin contener lógica de negocio.
 */
public class EventoDTO {
    private int id;
    private String nombre;
    private int numeroEntradas;
    private LocalDate fecha;
    private LocalTime hora;
    private String ubicacion;
    private String tipo;

    /**
     * Constructor por defecto.
     */
    public EventoDTO() {}

    /**
     * Obtiene el ID del evento.
     *
     * @return el identificador único del evento
     */
    public int getId() { return id; }

    /**
     * Establece el ID del evento.
     *
     * @param id el identificador único del evento
     */
    public void setId(int id) { this.id = id; }

    /**
     * Obtiene el nombre del evento.
     *
     * @return el nombre del evento
     */
    public String getNombre() { return nombre; }

    /**
     * Establece el nombre del evento.
     *
     * @param nombre el nombre del evento
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Obtiene el número de entradas disponibles para el evento.
     *
     * @return la cantidad de entradas disponibles
     */
    public int getNumeroEntradas() { return numeroEntradas; }

    /**
     * Establece el número de entradas disponibles para el evento.
     *
     * @param numeroEntradas la cantidad de entradas disponibles
     */
    public void setNumeroEntradas(int numeroEntradas) { this.numeroEntradas = numeroEntradas; }

    /**
     * Obtiene la fecha del evento.
     *
     * @return la fecha en la que se celebra el evento
     */
    public LocalDate getFecha() { return fecha; }

    /**
     * Establece la fecha del evento.
     *
     * @param fecha la fecha en la que se celebra el evento
     */
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    /**
     * Obtiene la hora del evento.
     *
     * @return la hora en la que comienza el evento
     */
    public LocalTime getHora() { return hora; }

    /**
     * Establece la hora del evento.
     *
     * @param hora la hora en la que comienza el evento
     */
    public void setHora(LocalTime hora) { this.hora = hora; }

    /**
     * Obtiene la ubicación del evento.
     *
     * @return la dirección o localización del evento
     */
    public String getUbicacion() { return ubicacion; }

    /**
     * Establece la ubicación del evento.
     *
     * @param ubicacion la dirección o localización del evento
     */
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    /**
     * Obtiene el tipo del evento.
     *
     * @return el tipo o categoría del evento (por ejemplo, concierto, conferencia)
     */
    public String getTipo() { return tipo; }

    /**
     * Establece el tipo del evento.
     *
     * @param tipo el tipo o categoría del evento
     */
    public void setTipo(String tipo) { this.tipo = tipo; }
}
