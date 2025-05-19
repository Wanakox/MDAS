package main.java.model;

import java.time.LocalDate;

/**
 * Representa un pago realizado mediante tarjeta.
 * Contiene información sobre la fecha del pago, el precio,
 * y los datos de la tarjeta utilizada.
 */
public class Pago {
    private LocalDate fecha;
    private double precio;
    private String titularTarjeta;
    private String numeroTarjeta;
    private String caducidadTarjeta; // Formato MM/YY
    private int cvv;

    /**
     * Constructor vacío.
     * Crea una instancia de Pago sin inicializar sus atributos.
     */
    public Pago() {}

    /**
     * Constructor completo.
     * Crea una instancia de Pago con todos sus atributos inicializados.
     *
     * @param fecha           Fecha en la que se realiza el pago.
     * @param precio          Monto del pago.
     * @param titularTarjeta  Nombre del titular de la tarjeta.
     * @param numeroTarjeta   Número de la tarjeta de crédito/débito.
     * @param caducidadTarjeta Fecha de caducidad de la tarjeta en formato MM/YY.
     * @param cvv             Código de verificación de la tarjeta.
     */
    public Pago(LocalDate fecha, double precio, String titularTarjeta, String numeroTarjeta, String caducidadTarjeta, int cvv) {
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
     * @return Fecha del pago.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del pago.
     *
     * @param fecha Nueva fecha del pago.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el precio del pago.
     *
     * @return Precio del pago.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del pago.
     *
     * @param precio Nuevo precio del pago.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el nombre del titular de la tarjeta.
     *
     * @return Titular de la tarjeta.
     */
    public String getTitularTarjeta() {
        return titularTarjeta;
    }

    /**
     * Establece el nombre del titular de la tarjeta.
     *
     * @param titularTarjeta Nuevo nombre del titular.
     */
    public void setTitularTarjeta(String titularTarjeta) {
        this.titularTarjeta = titularTarjeta;
    }

    /**
     * Obtiene el número de la tarjeta.
     *
     * @return Número de la tarjeta.
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Establece el número de la tarjeta.
     *
     * @param numeroTarjeta Nuevo número de tarjeta.
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Obtiene la fecha de caducidad de la tarjeta.
     *
     * @return Fecha de caducidad en formato MM/YY.
     */
    public String getCaducidadTarjeta() {
        return caducidadTarjeta;
    }

    /**
     * Establece la fecha de caducidad de la tarjeta.
     *
     * @param caducidadTarjeta Nueva fecha de caducidad en formato MM/YY.
     */
    public void setCaducidadTarjeta(String caducidadTarjeta) {
        this.caducidadTarjeta = caducidadTarjeta;
    }

    /**
     * Obtiene el código de verificación (CVV) de la tarjeta.
     *
     * @return CVV de la tarjeta.
     */
    public int getCvv() {
        return cvv;
    }

    /**
     * Establece el código de verificación (CVV) de la tarjeta.
     *
     * @param cvv Nuevo CVV de la tarjeta.
     */
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    /**
     * Representación en forma de cadena del objeto Pago.
     *
     * @return Cadena que representa el contenido del pago.
     */
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
