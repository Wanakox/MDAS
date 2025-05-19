package main.java.data.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventoDTO {
    private int id;
    private String nombre;
    private int numeroEntradas;
    private LocalDate fecha;
    private LocalTime hora;
    private String ubicacion;
    private String tipo;

    public EventoDTO() {}

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getNumeroEntradas() { return numeroEntradas; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHora() { return hora; }
    public String getUbicacion() { return ubicacion; }
    public String getTipo() { return tipo; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setNumeroEntradas(int numeroEntradas) { this.numeroEntradas = numeroEntradas; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}