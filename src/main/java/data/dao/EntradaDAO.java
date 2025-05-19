package main.java.data.dao;

import main.java.model.Entrada;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO (Data Access Object) para gestionar las operaciones CRUD
 * sobre las entradas almacenadas en un archivo de texto.
 */
public class EntradaDAO {
    private static final String FILE_PATH = "src/main/resources/entrada.txt";

    /**
     * Busca una entrada por su ID.
     * 
     * @param idBuscado El ID de la entrada a buscar.
     * @return La entrada encontrada o null si no existe.
     */
    public Entrada buscarPorId(int idBuscado) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int id = Integer.parseInt(partes[0]);

                if (id == idBuscado) {
                    float precio = Float.parseFloat(partes[1]);
                    String asiento = partes[2];
                    String poseedor = partes[3];
                    String tipo = partes[4];
                    int idEvento = Integer.parseInt(partes[5]);

                    return new Entrada(id, precio, asiento, poseedor, tipo, idEvento);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Elimina una entrada del archivo por su ID.
     * 
     * @param idABorrar El ID de la entrada a eliminar.
     * @return true si se elimina correctamente, false si ocurre un error.
     */
    public boolean borrarPorId(int idABorrar) {
        List<String> nuevasLineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int id = Integer.parseInt(partes[0]);

                if (id != idABorrar) {
                    nuevasLineas.add(linea);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return false;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            for (String nuevaLinea : nuevasLineas) {
                bw.write(nuevaLinea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Crea una nueva entrada y la agrega al archivo.
     * 
     * @param nuevaEntrada La entrada a crear.
     * @return true si se crea correctamente, false si ocurre un error.
     */
    public boolean crearEntrada(Entrada nuevaEntrada) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String linea = nuevaEntrada.getId() + "," +
                    nuevaEntrada.getPrecio() + "," +
                    nuevaEntrada.getAsiento() + "," +
                    nuevaEntrada.getPoseedor() + "," +
                    nuevaEntrada.getTipo() + "," +
                    nuevaEntrada.getidEvento();

            bw.write(linea);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Actualiza los datos de una entrada existente.
     * 
     * @param entradaActualizada La entrada con la información actualizada.
     * @return true si se actualiza correctamente, false si no se encuentra o falla.
     */
    public boolean actualizarEntrada(Entrada entradaActualizada) {
        File archivoOriginal = new File(FILE_PATH);
        File archivoTemporal = new File("resources/entrada_temp.txt");
        boolean actualizada = false;

        try (
                BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal))
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int id = Integer.parseInt(partes[0]);

                if (id == entradaActualizada.getId()) {
                    String nuevaLinea = entradaActualizada.getId() + "," +
                            entradaActualizada.getPrecio() + "," +
                            entradaActualizada.getAsiento() + "," +
                            entradaActualizada.getPoseedor() + "," +
                            entradaActualizada.getTipo() + "," +
                            entradaActualizada.getidEvento();
                    bw.write(nuevaLinea);
                    actualizada = true;
                } else {
                    bw.write(linea);
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        if (actualizada) {
            archivoOriginal.delete();
            archivoTemporal.renameTo(archivoOriginal);
        }

        return actualizada;
    }

    /**
     * Busca todas las entradas asociadas a un poseedor.
     * 
     * @param poseedorBuscado El nombre del poseedor.
     * @return Lista de entradas del poseedor.
     */
    public List<Entrada> buscarPorPoseedor(String poseedorBuscado) {
        List<Entrada> entradas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            boolean primeraLinea = true;
            int contadorId = 1;

            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] partes = linea.split(",");

                if (partes.length < 5) {
                    System.err.println("Línea mal formateada: " + linea);
                    continue;
                }

                String poseedor = partes[2].trim();
                if (poseedor.equalsIgnoreCase(poseedorBuscado.trim())) {
                    float precio = Float.parseFloat(partes[0]);
                    String asiento = partes[1];
                    String tipo = partes[3];
                    int idEvento = Integer.parseInt(partes[4]);

                    entradas.add(new Entrada(contadorId++, precio, asiento, poseedor, tipo, idEvento));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return entradas;
    }

    /**
     * Busca todas las entradas asociadas a un evento.
     * 
     * @param idEventoBuscado El ID del evento.
     * @return Lista de entradas del evento.
     */
    public List<Entrada> buscarPorEvento(int idEventoBuscado) {
        List<Entrada> entradas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int idEvento = Integer.parseInt(partes[5]);

                if (idEvento == idEventoBuscado) {
                    int id = Integer.parseInt(partes[0]);
                    float precio = Float.parseFloat(partes[1]);
                    String asiento = partes[2];
                    String poseedor = partes[3];
                    String tipo = partes[4];

                    entradas.add(new Entrada(id, precio, asiento, poseedor, tipo, idEvento));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return entradas;
    }

    /**
     * Comprueba si existe una entrada con un nombre de usuario y una cantidad específica.
     * 
     * @param nombreUsuario Nombre del usuario.
     * @param cantidad Monto de la entrada.
     * @return true si se encuentra una entrada coincidente, false en caso contrario.
     */
    public boolean comprobarEntrada(String nombreUsuario, double cantidad) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos[0].equalsIgnoreCase(nombreUsuario) && Double.parseDouble(datos[1]) == cantidad) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al procesar el monto de la entrada: " + e.getMessage());
        }

        return false;
    }
}
