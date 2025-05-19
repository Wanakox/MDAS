package main.java.data.dto;

import java.time.LocalDate;

/**
 * Clase DTO (Data Transfer Object) que representa la información de un pago.
 * Se utiliza para transportar los datos de un pago entre las distintas capas de la aplicación.
 */
public class PagoDTO {
    private LocalDate fecha;
    private double precio;
    private String titularTarjeta;
    private String numeroTarjeta;
    private String caducidadTarjeta; // Formato MM/YY
    private int cvv;

    /**
     * Constructor vacío.
     * Se utiliza para crear un objeto sin inicializar los atributos.
     */
    public PagoDTO() {}

    /**
     * Constructor completo.
     * Inicializa todos los atributos del pago.
     *
     * @param fecha la fecha en la que se realiza el pago
     * @param precio el monto pagado
     * @param titularTarjeta el nombre del titular de la tarjeta
     * @param numeroTarjeta el número de la tarjeta de crédito/débito
     * @param caducidadTarjeta la fecha de caducidad de la tarjeta en formato MM/YY
     * @param cvv el código de seguridad de la tarjeta (CVV)
     */
    public PagoDTO(LocalDate fecha, double precio, String titularTarjeta, String numeroTarjeta, String caducidadTarjeta, int cvv) {
        this.fecha = fecha;
        this.precio = precio;
        this.titularTarjeta = titularTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.caducidadTarjeta = caducidadTarjeta;
        this.cvv = cvv;
    }

    /**
     * Obtiene la fecha del pago.
     *
     * @return la fecha en que se realizó el pago
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del pago.
     *
     * @param fecha la fecha en que se realizó el pago
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el precio del pago.
     *
     * @return el monto del pago
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del pago.
     *
     * @param precio el monto del pago
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el nombre del titular de la tarjeta.
     *
     * @return el nombre del titular
     */
    public String getTitularTarjeta() {
        return titularTarjeta;
    }

    /**
     * Establece el nombre del titular de la tarjeta.
     *
     * @param titularTarjeta el nombre del titular
     */
    public void setTitularTarjeta(String titularTarjeta) {
        this.titularTarjeta = titularTarjeta;
    }

    /**
     * Obtiene el número de la tarjeta utilizada en el pago.
     *
     * @return el número de la tarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Establece el número de la tarjeta utilizada en el pago.
     *
     * @param numeroTarjeta el número de la tarjeta
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Obtiene la fecha de caducidad de la tarjeta.
     *
     * @return la fecha de caducidad en formato MM/YY
     */
    public String getCaducidadTarjeta() {
        return caducidadTarjeta;
    }

    /**
     * Establece la fecha de caducidad de la tarjeta.
     *
     * @param caducidadTarjeta la fecha de caducidad en formato MM/YY
     */
    public void setCaducidadTarjeta(String caducidadTarjeta) {
        this.caducidadTarjeta = caducidadTarjeta;
    }

    /**
     * Obtiene el código de seguridad (CVV) de la tarjeta.
     *
     * @return el CVV de la tarjeta
     */
    public int getCvv() {
        return cvv;
    }

    /**
     * Establece el código de seguridad (CVV) de la tarjeta.
     *
     * @param cvv el CVV de la tarjeta
     */
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto PagoDTO.
     *
     * @return una cadena que representa el contenido del objeto
     */
    @Override
    public String toString() {
        return "PagoDTO{" +
                "fecha=" + fecha +
                ", precio=" + precio +
                ", titularTarjeta='" + titularTarjeta + '\'' +
                ", numeroTarjeta='" + numeroTarjeta + '\'' +
                ", caducidadTarjeta='" + caducidadTarjeta + '\'' +
                ", cvv=" + cvv +
                '}';
    }
}
