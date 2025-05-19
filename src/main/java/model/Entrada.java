package main.java.model;

// @author: Alberto
// IComprarEntrada
// IVenderEntrada

/**
 * Representa una entrada para un evento.
 * Contiene información sobre el precio, asiento, poseedor, tipo, identificador único
 * y el identificador del evento al que pertenece.
 */
public class Entrada {
    private float precio;
    private String asiento;
    private String poseedor;
    private String tipo;
    private int id;
    private int idEvento;

    /**
     * Obtiene el precio de la entrada.
     *
     * @return Precio de la entrada.
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de la entrada.
     *
     * @param precio Precio que se desea asignar a la entrada.
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el asiento asignado a la entrada.
     *
     * @return Asiento de la entrada.
     */
    public String getAsiento() {
        return asiento;
    }

    /**
     * Establece el asiento de la entrada.
     *
     * @param asiento Asiento que se desea asignar.
     */
    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    /**
     * Obtiene el nombre del poseedor de la entrada.
     *
     * @return Nombre del poseedor.
     */
    public String getPoseedor() {
        return poseedor;
    }

    /**
     * Establece el nombre del poseedor de la entrada.
     *
     * @param poseedor Nombre del nuevo poseedor.
     */
    public void setPoseedor(String poseedor) {
        this.poseedor = poseedor;
    }

    /**
     * Obtiene el tipo de la entrada.
     *
     * @return Tipo de entrada.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la entrada.
     *
     * @param tipo Tipo de entrada (por ejemplo: VIP, general).
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el identificador único de la entrada.
     *
     * @return ID de la entrada.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el identificador del evento asociado a la entrada.
     *
     * @return ID del evento.
     */
    public int getidEvento() {
        return idEvento;
    }

    /**
     * Establece el identificador del evento asociado a la entrada.
     *
     * @param idEvento ID del evento al que pertenece la entrada.
     */
    public void setidEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * Constructor para crear una nueva entrada.
     *
     * @param id        Identificador único de la entrada.
     * @param precio    Precio de la entrada.
     * @param asiento   Asiento asignado.
     * @param poseedor  Poseedor actual de la entrada.
     * @param tipo      Tipo de entrada (VIP, general, etc.).
     * @param idEvento  Identificador del evento asociado.
     */
    public Entrada(int id, float precio, String asiento, String poseedor, String tipo, int idEvento) {
        this.precio = precio;
        this.asiento = asiento;
        this.poseedor = poseedor;
        this.tipo = tipo;
        this.id = id;
        this.idEvento = idEvento;
    }
}
