package main.java.data.dao;

import main.java.model.Usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO (Data Access Object) para manejar operaciones CRUD relacionadas con los usuarios.
 * Utiliza archivos de texto como sistema de almacenamiento.
 */
public class UsuarioDAO {

    /**
     * Ruta del archivo que contiene los datos de los usuarios.
     */
    private final String filePath = "./src/main/resources/usuarios.txt";

    /**
     * Obtiene todos los usuarios almacenados en el archivo.
     *
     * @return Una lista de objetos {@link Usuario}.
     */
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Saltar la primera línea si tiene encabezados
            String linea = br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 7) {
                    String nombre = datos[0].trim();
                    String apellido = datos[1].trim();
                    String correo = datos[2].trim();
                    String contrasena = datos[3].trim();
                    String dni = datos[4].trim();
                    String tipo = datos[5].trim();
                    float cartera = Float.parseFloat(datos[6].trim());

                    Usuario usuario = new Usuario(nombre, apellido, correo, contrasena, dni, tipo, cartera);
                    usuarios.add(usuario);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error al procesar los datos del archivo: " + e.getMessage());
        }

        return usuarios;
    }

    /**
     * Busca un usuario por su dirección de correo electrónico.
     *
     * @param correo El correo del usuario a buscar.
     * @return El objeto {@link Usuario} si se encuentra, o {@code null} si no existe.
     */
    public Usuario buscarUsuarioPorCorreo(String correo) {
        List<Usuario> usuarios = obtenerUsuarios();

        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equalsIgnoreCase(correo)) {
                return usuario;
            }
        }

        return null;
    }

    /**
     * Guarda un nuevo usuario en el archivo.
     *
     * @param usuario El objeto {@link Usuario} a guardar.
     * @return {@code true} si se guarda correctamente, {@code false} en caso contrario.
     */
    public boolean guardarUsuario(Usuario usuario) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            String linea = usuario.getNombre() + "," +
                    usuario.getApellido() + "," +
                    usuario.getCorreo() + "," +
                    usuario.getContrasena() + "," +
                    usuario.getDni() + "," +
                    usuario.getTipo() + "," +
                    usuario.getCartera();

            bw.write(linea);
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Error al guardar el usuario: " + e.getMessage());
            return false;
        }
    }

    /**
     * Elimina un usuario del archivo usando su correo electrónico.
     *
     * @param correo El correo del usuario a eliminar.
     * @return {@code true} si se elimina correctamente, {@code false} si no se encuentra o hay error.
     */
    public boolean eliminarUsuario(String correo) {
        List<String> usuariosActualizados = new ArrayList<>();
        boolean usuarioEliminado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.contains(correo)) {
                    usuariosActualizados.add(linea);
                } else {
                    usuarioEliminado = true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return false;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String usuario : usuariosActualizados) {
                bw.write(usuario);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            return false;
        }

        return usuarioEliminado;
    }

    /**
     * Obtiene el saldo actual de un usuario a partir de su correo electrónico.
     *
     * @param correoUsuario El correo del usuario.
     * @return El saldo disponible. Devuelve {@code 0.0} si no se encuentra el usuario.
     */
    public double obtenerSaldo(String correoUsuario) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[2].equalsIgnoreCase(correoUsuario)) {
                    return Double.parseDouble(datos[6]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return 0.0;
    }

    /**
     * Modifica el saldo de un usuario identificado por su correo.
     *
     * @param correoUsuario El correo del usuario.
     * @param saldoNuevo    El nuevo saldo a establecer.
     * @return {@code true} si el saldo se modifica correctamente, {@code false} en caso contrario.
     */
    public boolean modificarSaldo(String correoUsuario, double saldoNuevo) {
        List<String> usuariosActualizados = new ArrayList<>();
        boolean saldoModificado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[2].equalsIgnoreCase(correoUsuario)) {
                    datos[6] = String.valueOf(saldoNuevo);
                    saldoModificado = true;
                }
                usuariosActualizados.add(String.join(",", datos));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return false;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String usuario : usuariosActualizados) {
                bw.write(usuario);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            return false;
        }

        return saldoModificado;
    }

    /**
     * Obtiene el nombre de un usuario a partir de su correo electrónico.
     *
     * @param correo El correo del usuario.
     * @return El nombre del usuario, o {@code null} si no se encuentra.
     */
    public String correoConseguirNombre(String correo) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[2].equalsIgnoreCase(correo)) {
                    return datos[0];
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return null;
    }
}
