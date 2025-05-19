package main.java.model;
//ALBERTO
//IComprarEntrada
//IVenderEntrada

public class Entrada {
    private float precio;
    private String asiento;
    private String poseedor;
    private String tipo;
    private int id;
    private int idEvento;

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

    public int getId() {return id;}

    public int getidEvento() {
        return idEvento;
    }

    public void setidEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public Entrada(int id, float precio, String asiento, String poseedor, String tipo, int idEvento) {
        this.precio = precio;
        this.asiento = asiento;
        this.poseedor = poseedor;
        this.tipo = tipo;
        this.id = id;
        this.idEvento = idEvento;
    }



}