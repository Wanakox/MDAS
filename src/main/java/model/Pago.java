package main.java.model;

import java.time.LocalDate;

public class Pago {
    private LocalDate fecha;
    private double precio;
    private String titularTarjeta;
    private String numeroTarjeta;
    private String caducidadTarjeta; // Formato MM/YY
    private int cvv;

    // Constructor vacío
    public Pago() {}

    // Constructor completo
    public Pago(LocalDate fecha, double precio, String titularTarjeta, String numeroTarjeta, String caducidadTarjeta, int cvv) {
        this.fecha = fecha;
        this.precio = precio;
        this.titularTarjeta = titularTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.caducidadTarjeta = caducidadTarjeta;
        this.cvv = cvv;
    }

    // Getters y Setters
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTitularTarjeta() {
        return titularTarjeta;
    }

    public void setTitularTarjeta(String titularTarjeta) {
        this.titularTarjeta = titularTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCaducidadTarjeta() {
        return caducidadTarjeta;
    }

    public void setCaducidadTarjeta(String caducidadTarjeta) {
        this.caducidadTarjeta = caducidadTarjeta;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    // Método toString
    @Override
    public String toString() {
        return "Pago{" +
                "fecha=" + fecha +
                ", precio=" + precio +
                ", titularTarjeta='" + titularTarjeta + '\'' +
                ", numeroTarjeta='" + numeroTarjeta + '\'' +
                ", caducidadTarjeta='" + caducidadTarjeta + '\'' +
                ", cvv=" + cvv +
                '}';
    }
}