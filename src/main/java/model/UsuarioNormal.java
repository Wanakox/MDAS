package main.java.model;

public class UsuarioNormal extends Usuario {
    public UsuarioNormal(String nombre, String apellido, String correo, String contrasena, String dni) {
        super(nombre, apellido, correo, contrasena, dni, Rol.USUARIO);
    }

    // Métodos específicos del comprador
    public void comprarEntradas() {
        // Lógica para comprar entradas
    }
    public void cancelarCompra() {
        // Lógica para cancelar una compra
    }
    public void verEventos() {
        // Lógica para ver eventos
    }
    public void verEntradasCompradas() {
        // Lógica para ver entradas compradas
    }
    public void verEntradasDisponibles() {
        // Lógica para ver entradas disponibles
    }
    public void verEventosCancelados() {
        // Lógica para ver eventos cancelados
    }
    public void verEventosPasados() {
        // Lógica para ver eventos pasados
    }
}
