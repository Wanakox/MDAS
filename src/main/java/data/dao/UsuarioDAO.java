package main.java.data.dao;

import main.java.model.Usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    /**
     * Método para obtener todos los usuarios desde un archivo.
     * @return Una lista de objetos Usuario.
     */

    private final String filePath = "./src/main/resources/usuarios.txt";


    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String filePath = "./src/main/resources/usuarios.txt"; // Cambia esta ruta según la ubicación de tu archivo

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Saltar la primera línea (encabezados)
            String linea = br.readLine();

            // Leer el resto de las líneas
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); // Asumiendo que los datos están separados por comas
                if (datos.length == 7) { // Validar que haya 7 campos
                    String nombre = datos[0].trim();
                    String apellido = datos[1].trim();
                    String correo = datos[2].trim();
                    String contrasena = datos[3].trim();
                    String dni = datos[4].trim();
                    String tipo = datos[5].trim(); // Leer el tipo como String
                    float cartera = Float.parseFloat(datos[6].trim());

                    // Crear un objeto Usuario y agregarlo a la lista
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
     * Método para buscar un usuario por su correo.
     * @param correo El correo del usuario a buscar.
     * @return El objeto Usuario si se encuentra, o null si no existe.
     */
    public Usuario buscarUsuarioPorCorreo(String correo) {
        List<Usuario> usuarios = obtenerUsuarios(); // Obtener todos los usuarios del archivo

        // Buscar el usuario con el correo proporcionado
        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equalsIgnoreCase(correo)) {
                return usuario; // Usuario encontrado
            }
        }

        return null; // Usuario no encontrado
    }

    /**
     * Método para guardar un nuevo usuario en el archivo.
     * @param usuario El usuario a guardar.
     * @return true si el usuario se guarda correctamente, false en caso contrario.
     */
    public boolean guardarUsuario(Usuario usuario) {
        String filePath = "./src/main/resources/usuarios.txt"; // Cambia esta ruta según la ubicación de tu archivo

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            // Crear una línea con los datos del usuario separados por comas
            String linea = usuario.getNombre() + "," +
                        usuario.getApellido() + "," +
                        usuario.getCorreo() + "," +
                        usuario.getContrasena() + "," +
                        usuario.getDni() + "," +
                        usuario.getTipo() + "," + // Cambiado de usuario.getRol().name() a usuario.getTipo()
                        usuario.getCartera();

            // Escribir la línea en el archivo
            bw.write(linea);
            bw.newLine(); // Agregar un salto de línea
            return true; // Usuario guardado exitosamente
        } catch (IOException e) {
            System.err.println("Error al guardar el usuario: " + e.getMessage());
            return false; // Fallo al guardar el usuario
        }
    }

    /**
     * Método para eliminar un usuario del archivo por su correo.
     * @param correo El correo del usuario a eliminar.
     * @return true si la eliminación es exitosa, false en caso contrario.
     */
    public boolean eliminarUsuario(String correo) {
        String filePath = "./src/main/resources/usuarios.txt"; // Cambia esta ruta según la ubicación de tu archivo
        List<String> usuariosActualizados = new ArrayList<>();
        boolean usuarioEliminado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;

            // Leer el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                // Verificar si la línea contiene el correo del usuario a eliminar
                if (!linea.contains(correo)) {
                    usuariosActualizados.add(linea); // Mantener las líneas que no coincidan
                } else {
                    usuarioEliminado = true; // Usuario encontrado y marcado para eliminación
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return false; // Fallo al leer el archivo
        }

        // Sobrescribir el archivo con los usuarios actualizados
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String usuario : usuariosActualizados) {
                bw.write(usuario);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            return false; // Fallo al escribir en el archivo
        }

        return usuarioEliminado; // Retornar true si el usuario fue eliminado, false si no se encontró
    }
        /**
     * Método para obtener el saldo actual del usuario.
     * @param correoUsuario El correo del usuario.
     * @return El saldo actual del usuario.
     */
    public double obtenerSaldo(String correoUsuario) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[2].equalsIgnoreCase(correoUsuario)) { // Suponiendo que el correo está en la posición 2
                    return Double.parseDouble(datos[6]); // Suponiendo que el saldo está en la posición 6
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return 0.0; // Retornar 0 si no se encuentra el usuario
    }

    /**
     * Método para modificar el saldo del usuario en el archivo.
     * @param correoUsuario El correo del usuario.
     * @param saldoNuevo El nuevo saldo a establecer.
     * @return true si el saldo se modifica correctamente, false en caso contrario.
     */
    public boolean modificarSaldo(String correoUsuario, double saldoNuevo) {
        List<String> usuariosActualizados = new ArrayList<>();
        boolean saldoModificado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;

            // Leer el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[2].equalsIgnoreCase(correoUsuario)) { // Suponiendo que el correo está en la posición 2
                    datos[6] = String.valueOf(saldoNuevo); // Actualizar el saldo (posición 6)
                    saldoModificado = true;
                }
                usuariosActualizados.add(String.join(",", datos));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return false;
        }

        // Sobrescribir el archivo con los datos actualizados
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

    public String correoConseguirNombre(String correo) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); // Suponiendo que los datos están separados por comas
                if (datos[2].equalsIgnoreCase(correo)) { // Suponiendo que el correo está en la posición 2
                    return datos[0]; // Suponiendo que el nombre está en la posición 0
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return null; // Retornar null si no se encuentra el usuario
    }
}