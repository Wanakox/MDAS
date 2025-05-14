package main.app;

import main.java.data.dao.*;
import main.java.data.dto.*;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        UsuarioDTO usuario = dao.buscarPorCorreoYContrasena("juan.garcia@example.com", "contrasena123");

        if (usuario != null) {
            System.out.println("Bienvenido, " + usuario.getNombre() + " (" + usuario.getRol() + ")");
        } else {
            System.out.println("Credenciales incorrectas");
        }
    }
}
