package main.java.model;

public class UsuarioSoporte extends Usuario {
    public UsuarioSoporte(String nombre, String apellido, String correo, String contrasena, String dni) {
        super(nombre, apellido, correo, contrasena, dni, Rol.SOPORTE);
    }

    // Métodos como gestionarTicket(), responderSoporte(), etc.
    public void gestionarTicket() {
        // Lógica para gestionar un ticket de soporte
    }
    public void responderSoporte() {
        // Lógica para responder a un ticket de soporte
    }
    public void asignarTicket() {
        // Lógica para asignar un ticket a un soporte
    }
    public void cerrarTicket() {
        // Lógica para cerrar un ticket de soporte
    }
}
