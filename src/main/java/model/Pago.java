package main.java.model;
//ALBERTO
//IRealizarPago

import java.util.Date;

public class Pago {
    private Date fecha;
    private float precio;
    private String titularTarjeta;
    private int numeroTarjeta;
    private int caducidadTarjeta;
    private int CVV;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTitularTarjeta() {
        return titularTarjeta;
    }

    public void setTitularTarjeta(String titularTarjeta) {
        this.titularTarjeta = titularTarjeta;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getCaducidadTarjeta() {
        return caducidadTarjeta;
    }

    public void setCaducidadTarjeta(int caducidadTarjeta) {
        this.caducidadTarjeta = caducidadTarjeta;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public Pago(Date fecha, float precio, String titularTarjeta, int numeroTarjeta, int caducidadTarjeta, int CVV) {
        this.fecha = fecha;
        this.precio = precio;
        this.titularTarjeta = titularTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.caducidadTarjeta = caducidadTarjeta;
        this.CVV = CVV;
    }
}
