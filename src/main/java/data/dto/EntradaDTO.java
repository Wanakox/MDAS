package main.java.data.dto;

/**
 * Data Transfer Object (DTO) que representa una entrada para un evento.
 * Contiene información sobre el precio, asiento, poseedor, tipo, y referencias al evento.
 */
public class EntradaDTO {
    
    /**
     * Precio de la entrada.
     */
    public float precio;
    
    /**
     * Número o identificador del asiento asignado.
     */
    public String asiento;
    
    /**
     * Nombre del poseedor de la entrada.
     */
    public String poseedor;
    
    /**
     * Tipo de entrada (por ejemplo: vip, general, etc.).
     */
    public String tipo;
    
    /**
     * Identificador único de la entrada.
     */
    public int id;
    
    /**
     * Identificador del evento al que pertenece esta entrada.
     */
    public int idEvento;

    /**
     * Constructor vacío.
     */
    public EntradaDTO() {}

    /**
     * Obtiene el precio de la entrada.
     * @return precio de la entrada.
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de la entrada.
     * @param precio Precio a establecer.
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el asiento asignado a la entrada.
     * @return asiento asignado.
     */
    public String getAsiento() {
        return asiento;
    }

    /**
     * Establece el asiento asignado a la entrada.
     * @param asiento Asiento a establecer.
     */
    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    /**
     * Obtiene el nombre del poseedor de la entrada.
     * @return nombre del poseedor.
     */
    public String getPoseedor() {
        return poseedor;
    }

    /**
     * Establece el nombre del poseedor de la entrada.
     * @param poseedor Nombre del poseedor a establecer.
     */
    public void setPoseedor(String poseedor) {
        this.poseedor = poseedor;
    }

    /**
     * Obtiene el tipo de entrada.
     * @return tipo de entrada.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de entrada.
     * @param tipo Tipo a establecer (e.g. vip, general).
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el identificador único de la entrada.
     * @return id de la entrada.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único de la entrada.
     * @param id Identificador a establecer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador del evento al que pertenece la entrada.
     * @return id del evento.
     */
    public int getIdEvento() {
        return idEvento;
    }

    /**
     * Establece el identificador del evento al que pertenece la entrada.
     * @param idEvento Identificador del evento a establecer.
     */
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
}
