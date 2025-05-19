package main.java.data.dao;

import main.java.model.Entrada;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EntradaDAO {
    private static final String FILE_PATH = "src/main/resources/entrada.txt";

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
            e.printStackTrace(); // O usa un logger
        }

        return null; // No encontrada
    }

    public boolean borrarPorId(int idABorrar) {
        List<String> nuevasLineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");

                int id = Integer.parseInt(partes[0]);

                if (id != idABorrar) {
                    nuevasLineas.add(linea); // solo añadimos las que no queremos borrar
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return false;
        }

        // Escribimos las líneas restantes de nuevo en el archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            for (String nuevaLinea : nuevasLineas) {
                bw.write(nuevaLinea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true; // Borrado con éxito
    }

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
                    // Escribimos la entrada actualizada
                    String nuevaLinea = entradaActualizada.getId() + "," +
                            entradaActualizada.getPrecio() + "," +
                            entradaActualizada.getAsiento() + "," +
                            entradaActualizada.getPoseedor() + "," +
                            entradaActualizada.getTipo() + "," +
                            entradaActualizada.getidEvento();
                    bw.write(nuevaLinea);
                    actualizada = true;
                } else {
                    // Copiamos la línea original
                    bw.write(linea);
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        // Reemplazar el archivo original con el temporal
        if (actualizada) {
            archivoOriginal.delete();
            archivoTemporal.renameTo(archivoOriginal);
        }

        return actualizada;
    }

    public List<Entrada> buscarPorPoseedor(String poseedorBuscado) {
        List<Entrada> entradas = new ArrayList<>();
    
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            boolean primeraLinea = true;
            int contadorId = 1; // ID autogenerado
    
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false; // Saltar cabecera
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
     * Método para comprobar si existe una entrada asociada al usuario y al monto especificado.
     * @param nombreUsuario El nombre del usuario.
     * @param cantidad El monto de la entrada.
     * @return true si se encuentra la entrada, false en caso contrario.
     */
    public boolean comprobarEntrada(String nombreUsuario, double cantidad) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;

            // Leer el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); // Suponiendo que los datos están separados por comas

                // Verificar si el nombre del usuario y el monto coinciden
                if (datos[0].equalsIgnoreCase(nombreUsuario) && Double.parseDouble(datos[1]) == cantidad) {
                    return true; // Entrada encontrada
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al procesar el monto de la entrada: " + e.getMessage());
        }

        return false; // Entrada no encontrada
    }





}