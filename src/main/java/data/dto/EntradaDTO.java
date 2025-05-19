package main.java.data.dto;

public class EntradaDTO {
    public float precio;
    public String asiento;
    public String poseedor;
    public String tipo; // vip, general, etc.
    public int id;
    public int idEvento;

    public EntradaDTO() {}

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getPoseedor() {
        return poseedor;
    }

    public void setPoseedor(String poseedor) {
        this.poseedor = poseedor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
}
