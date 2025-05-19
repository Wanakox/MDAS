package main.java.model;
//ALBERTO

public class Reembolso {
    private float cantidad;
    private float destinatario;

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(float destinatario) {
        this.destinatario = destinatario;
    }

    public Reembolso(float cantidad, float destinatario) {
        this.cantidad = cantidad;
        this.destinatario = destinatario;
    }
}
