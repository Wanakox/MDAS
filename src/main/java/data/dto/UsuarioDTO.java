package main.java.data.dto;

/**
 * Clase DTO (Data Transfer Object) que representa la información de un usuario.
 * Esta clase contiene los datos básicos para la gestión de usuarios en la aplicación.
 */
public class UsuarioDTO {
    /**
     * Nombre del usuario.
     */
    public String nombre;

    /**
     * Apellidos del usuario.
     */
    public String apellidos;

    /**
     * Contraseña del usuario.
     */
    public String contraseña;

    /**
     * Correo electrónico del usuario.
     */
    public String correo;

    /**
     * Documento Nacional de Identidad (DNI) del usuario.
     */
    public String DNI;

    /**
     * Tipo de usuario o rol (por ejemplo, "admin", "usuario", etc.).
     */
    public String tipo;

    /**
     * Saldo o cartera del usuario.
     */
    public float cartera;

    /**
     * Constructor vacío.
     * Permite crear un objeto UsuarioDTO sin inicializar sus atributos.
     */
    public UsuarioDTO() {}

    /**
     * Constructor completo.
     * Inicializa todos los atributos del usuario.
     *
     * @param nombre nombre del usuario
     * @param apellidos apellidos del usuario
     * @param contraseña contraseña del usuario
     * @param correo correo electrónico del usuario
     * @param DNI Documento Nacional de Identidad del usuario
     * @param tipo tipo o rol del usuario
     * @param cartera saldo o cartera del usuario
     */
    public UsuarioDTO(String nombre, String apellidos, String contraseña, String correo, String DNI, String tipo, float cartera) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contraseña = contraseña;
        this.correo = correo;
        this.DNI = DNI;
        this.tipo = tipo;
        this.cartera = cartera;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param nombre nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del usuario.
     * 
     * @return apellidos del usuario
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del usuario.
     * 
     * @param apellidos apellidos del usuario
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return contraseña del usuario
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del usuario.
     * 
     * @param contraseña contraseña del usuario
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * 
     * @return correo electrónico del usuario
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     * 
     * @param correo correo electrónico del usuario
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el Documento Nacional de Identidad (DNI) del usuario.
     * 
     * @return DNI del usuario
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Establece el Documento Nacional de Identidad (DNI) del usuario.
     * 
     * @param DNI DNI del usuario
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Obtiene el tipo o rol del usuario.
     * 
     * @return tipo o rol del usuario
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo o rol del usuario.
     * 
     * @param tipo tipo o rol del usuario
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el saldo o cartera del usuario.
     * 
     * @return saldo del usuario
     */
    public float getCartera() {
        return cartera;
    }

    /**
     * Establece el saldo o cartera del usuario.
     * 
     * @param cartera saldo del usuario
     */
    public void setCartera(float cartera) {
        this.cartera = cartera;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto UsuarioDTO.
     * 
     * @return una cadena que representa el contenido del objeto
     */
    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", correo='" + correo + '\'' +
                ", DNI='" + DNI + '\'' +
                ", tipo='" + tipo + '\'' +
                ", cartera=" + cartera +
                '}';
    }
}
