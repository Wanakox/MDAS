package main.java.controller;

import main.java.model.*;

import java.util.List;

import main.java.data.dao.*;

public class UsuarioController {

    /**
     * Método para realizar el inicio de sesión.
     * @param correo El correo del usuario.
     * @param contrasena La contraseña del usuario.
     * @return true si el inicio de sesión es exitoso, false en caso contrario.
     */
    public boolean iniciarSesion(String correo, String contrasena) {
        // Crear una instancia del DAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Buscar el usuario por correo
        Usuario usuario = usuarioDAO.buscarUsuarioPorCorreo(correo);

        // Verificar si el usuario existe y las credenciales coinciden
        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            // Mostrar el tipo de usuario
            System.out.println("Inicio de sesión exitoso. Tipo de usuario: " + usuario.getTipo());
            return true; // Inicio de sesión exitoso
        }

        // Si no se encuentra el usuario o las credenciales no coinciden
        System.out.println("Inicio de sesión fallido. Credenciales incorrectas.");
        return false;
    }
    public void listarUsuarios() {
        // Crear una instancia del DAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();
    
        // Obtener la lista de usuarios
        List<Usuario> usuarios = usuarioDAO.obtenerUsuarios();
    
        // Imprimir los usuarios en la consola utilizando el método toString
        System.out.println("Lista de usuarios:");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }
    }

/**
 * Método para registrar un nuevo usuario.
 * @param nuevoUsuario El usuario a registrar.
 * @return true si el registro es exitoso, false en caso contrario.
 */
public boolean registrarUsuario(Usuario nuevoUsuario) {
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    // Validar que el usuario no exista ya (por correo)
    Usuario usuarioExistenteCorreo = usuarioDAO.buscarUsuarioPorCorreo(nuevoUsuario.getCorreo());
    if (usuarioExistenteCorreo != null) {
        System.out.println("Registro fallido. Ya existe un usuario con el correo: " + nuevoUsuario.getCorreo());
        return false;
    }

    // Validar que el usuario no exista ya (por DNI)
    Usuario usuarioExistenteDni = usuarioDAO.buscarUsuarioPorDni(nuevoUsuario.getDni());
    if (usuarioExistenteDni != null) {
        System.out.println("Registro fallido. Ya existe un usuario con el DNI: " + nuevoUsuario.getDni());
        return false;
    }

    // Validar que el DNI sea válido
    if (!Usuario.esDniValido(nuevoUsuario.getDni())) {
        System.out.println("Registro fallido. El DNI no es válido.");
        return false;
    }

    // Guardar usuario
    boolean registrado = usuarioDAO.guardarUsuario(nuevoUsuario);
    if (registrado) {
        System.out.println("Registro exitoso. Usuario registrado: " + nuevoUsuario.toString());
        return true;
    } else {
        System.out.println("Registro fallido. No se pudo guardar el usuario.");
        return false;
    }
}
    /**
     * Método para eliminar un usuario.
     * @param correo El correo del usuario a eliminar.
     * @return true si la eliminación es exitosa, false en caso contrario.
     */
    public boolean eliminarUsuario(String correo) {
        // Crear una instancia del DAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Intentar eliminar el usuario
        boolean eliminado = usuarioDAO.eliminarUsuario(correo);
        if (eliminado) {
            System.out.println("Usuario eliminado con éxito.");
            return true; // Eliminación exitosa
        } else {
            System.out.println("Error al eliminar el usuario. Puede que no exista.");
            return false; // Fallo al eliminar
        }
    }

    public Usuario iniciarSesionConUsuario(String correo, String contrasena) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario usuario = usuarioDAO.buscarUsuarioPorCorreo(correo);

        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            System.out.println("Inicio de sesión exitoso. Tipo de usuario: " + usuario.getTipo());
            return usuario; // Devuelve el usuario autenticado
        }

        System.out.println("Inicio de sesión fallido. Credenciales incorrectas.");
        return null; // No autenticado
    }
}