package main.java.data.dto;

public class PagoDTO {
    public String fecha; // formato "YYYY-MM-DD"
    public float precio;
    public String titularTarjeta;
    public long numeroTarjeta;
    public int caducidadTarjeta; // formato MMYY (ej. 0526)
    public int CVV;

    public PagoDTO() {}
}
