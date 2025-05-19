package main.java.model;

import java.util.regex.Pattern;

/**
 * Representa un usuario del sistema con atributos personales, de autenticación y financieros.
 */
public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String dni;
    private String tipo; // Cambiado de Rol a String
    private float cartera;

    /**
     * Constructor para crear un nuevo usuario.
     *
     * @param nombre      Nombre del usuario.
     * @param apellido    Apellido del usuario.
     * @param correo      Correo electrónico del usuario.
     * @param contrasena  Contraseña del usuario.
     * @param dni         DNI del usuario.
     * @param tipo        Tipo de usuario (por ejemplo, "admin", "cliente").
     * @param cartera     Saldo de la cartera del usuario.
     */
    public Usuario(String nombre, String apellido, String correo, String contrasena, String dni, String tipo, float cartera) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.dni = dni;
        this.tipo = tipo;
        this.cartera = cartera;
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return ID del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param id ID a asignar.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre Nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del usuario.
     *
     * @return Apellido del usuario.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del usuario.
     *
     * @param apellido Apellido a asignar.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return Correo electrónico.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param correo Correo a asignar.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return Contraseña.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasena Contraseña a asignar.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el DNI del usuario.
     *
     * @return DNI del usuario.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del usuario.
     *
     * @param dni DNI a asignar.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el tipo de usuario.
     *
     * @return Tipo de usuario.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de usuario.
     *
     * @param tipo Tipo a asignar.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el saldo en la cartera del usuario.
     *
     * @return Saldo de la cartera.
     */
    public float getCartera() {
        return cartera;
    }

    /**
     * Establece el saldo en la cartera del usuario.
     *
     * @param cartera Monto a asignar.
     */
    public void setCartera(float cartera) {
        this.cartera = cartera;
    }

    /**
     * Valida si un DNI tiene el formato correcto (8 dígitos seguidos de una letra mayúscula).
     *
     * @param dni DNI a validar.
     * @return {@code true} si es válido, {@code false} en caso contrario.
     */
    public static boolean esDniValido(String dni) {
        return dni != null && dni.matches("^[0-9]{8}[A-Z]$");
    }

    /**
     * Valida si un correo electrónico tiene el formato correcto.
     *
     * @param correo Correo a validar.
     * @return {@code true} si es válido, {@code false} en caso contrario.
     */
    public static boolean esCorreoValido(String correo) {
        if (correo == null) return false;
        String regex = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(regex, correo);
    }

    /**
     * Verifica si una contraseña es segura. Debe tener al menos 8 caracteres, incluir una mayúscula,
     * una minúscula y un número.
     *
     * @param contrasena Contraseña a validar.
     * @return {@code true} si cumple con los requisitos, {@code false} en caso contrario.
     */
    public static boolean esContrasenaSegura(String contrasena) {
        if (contrasena == null) return false;
        return contrasena.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
    }

    /**
     * Representación en cadena del objeto Usuario.
     *
     * @return Cadena con los atributos del usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", correo='" + correo + '\'' +
                ", dni='" + dni + '\'' +
                ", tipo='" + tipo + '\'' +
                ", cartera=" + cartera +
                '}';
    }
}
