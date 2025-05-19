package main.app;

import main.java.controller.UsuarioController;
import main.java.controller.EntradaController;
import main.java.controller.EventoController;
import main.java.model.Usuario;
import main.java.model.Entrada;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;



public class Main {
    private static Usuario usuarioActual = null;
    public static void main(String[] args) {
        UsuarioController usuarioController = new UsuarioController();
        Scanner scanner = new Scanner(System.in);
        int opcion;
    
        do {
            System.out.println("\n--- Menú de Opciones ---");
            System.out.println("1. Registrar un nuevo usuario");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Listar usuarios");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
    
            // Validar que la entrada sea un número entre 1 y 4
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entre 1 y 4.");
                scanner.next(); // Consumir la entrada no válida
                System.out.print("Seleccione una opción: ");
            }
    
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
    
            if (opcion < 1 || opcion > 4) {
                System.out.println("Opción no válida. Por favor, ingrese un número entre 1 y 4.");
                continue; // Volver al inicio del bucle
            }
    
            switch (opcion) {
                case 1:
                    // Registrar un nuevo usuario
                    System.out.println("\n--- Registro de Usuario ---");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String contrasena = scanner.nextLine();
                    System.out.print("DNI: ");
                    String dni = scanner.nextLine();
                    System.out.print("Rol (USUARIO, ORGANIZADOR, SOPORTE): ");
                    String rol = scanner.nextLine().toUpperCase(); // Leer el rol como String y convertir a mayúsculas
    
                    // Validar entrada para la cartera
                    System.out.print("Cartera: ");
                    float cartera = 0.0f;
                    boolean entradaValida = false;
    
                    while (!entradaValida) {
                        try {
                            cartera = Float.parseFloat(scanner.nextLine().trim()); // Leer como cadena y convertir a float
                            entradaValida = true; // Salir del bucle si la conversión es exitosa
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada no válida. Por favor, ingrese un número válido para la cartera.");
                        }
                    }
    
                    Usuario nuevoUsuario = new Usuario(nombre, apellido, correo, contrasena, dni, rol, cartera);
                    boolean registrado = usuarioController.registrarUsuario(nuevoUsuario);
                    if (registrado) {
                        System.out.println("Usuario registrado correctamente.");
                    } else {
                        System.out.println("Error al registrar el usuario.");
                    }
                    break;
    
                case 2:
                    System.out.println("\n--- Inicio de Sesión ---");
                    System.out.print("Correo: ");
                    String correoLogin = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String contrasenaLogin = scanner.nextLine();
    
                    Usuario usuario = usuarioController.iniciarSesionConUsuario(correoLogin, contrasenaLogin);
                    if (usuario != null) {
                        usuarioActual = usuario;
                        System.out.println("Inicio de sesión exitoso. Bienvenido " + usuario.getNombre() + "!");
    
                        switch (usuario.getTipo()) {
                            case "USUARIO":
                                mostrarMenuUsuario();
                                break;
                            case "ORGANIZADOR":
                                mostrarMenuOrganizador();
                                break;
                            case "SOPORTE":
                                mostrarMenuSoporte();
                                break;
                            default:
                                System.out.println("Tipo de usuario no reconocido.");
                                break;
                        }
                    } else {
                        System.out.println("Credenciales incorrectas.");
                    }
                    break;
    
                case 3:
                    // Listar usuarios
                    System.out.println("\n--- Lista de Usuarios ---");
                    usuarioController.listarUsuarios();
                    break;
    
                case 4:
                    // Salir
                    System.out.println("Saliendo del programa...");
                    break;
    
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);
    
        scanner.close();
    }
    private static void mostrarMenuUsuario() {
        Scanner scanner = new Scanner(System.in);
        EntradaController entradaController = new EntradaController();
        EventoController eventoController = new EventoController();

        int opcionUsuario;

        do {
            System.out.println("\n--- Menú Usuario ---");
            System.out.println("1. Ver eventos disponibles");
            System.out.println("2. Comprar entradas");
            System.out.println("3. Comprar entradas de otro usuario");
            System.out.println("4. Ver entradas compradas");
            System.out.print("Seleccione una opción: ");

            opcionUsuario = scanner.nextInt();
            scanner.nextLine(); // consumir salto línea

            switch (opcionUsuario) {
                case 1:
                    System.out.println("--Eventos disponibles--");
                    eventoController.listarEventos();
                    break;
                case 2:
                    System.out.println("Comprando entradas...");
                    // aquí código para editar perfil
                    break;
                case 3:
                    System.out.println("Comprando entradas de otro usuario...");

                    break;
                case 4:
                    System.out.println("Ver entradas compradas...");
                    entradaController.imprimirEntradasDeUsuario(usuarioActual.getNombre());
                    break;
                case 5:
                    System.out.println("Saliendo del menú de usuario...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionUsuario != 5);

        // Al salir de este método vuelve al menú principal en main
    }

    private static void mostrarMenuSoporte() {
        Scanner scanner = new Scanner(System.in);
        int opcionSoporte;
    
        do {
            System.out.println("\n--- Menú Soporte ---");
            System.out.println("En esta versión de prueba no puede acceder a esta sección.");
            System.out.println("1. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
    
            opcionSoporte = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
    
            if (opcionSoporte != 1) {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcionSoporte != 1);
    
        System.out.println("Regresando al menú principal...");
    } 
    private static void mostrarMenuOrganizador() {
        Scanner scanner = new Scanner(System.in);
        int opcionSoporte;
        EventoController eventoController = new EventoController();
    
        do {
            System.out.println("\n--- Menú Organizador ---");
            System.out.println("1. Crear evento");
            System.out.println("2. Editar evento");
            System.out.println("3. Ver eventos");
            System.out.println("4. Cancelar evento");
            System.out.println("5. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
    
            opcionSoporte = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            switch (opcionSoporte) {
                case 1:
                    // aquí código para mostrar perfil
                    
            System.out.println("----- Crear nuevo evento -----");

            System.out.print("Título del evento: ");
            String titulo = scanner.nextLine();

            System.out.print("ID del evento (entero): ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Número de entradas: ");
            int numeroEntradas = Integer.parseInt(scanner.nextLine());

            System.out.print("Localización: ");
            String localizacion = scanner.nextLine();

            System.out.print("Tipo de evento (Concierto, Festival, Obra de Teatro, Evento Deportivo): ");
            String tipoEvento = scanner.nextLine();

            System.out.print("Fecha del evento (YYYY-MM-DD): ");
            String fechaStr = scanner.nextLine();
            LocalDate fecha = LocalDate.parse(fechaStr);

            System.out.print("Hora del evento (HH:MM): ");
            String horaStr = scanner.nextLine();
            LocalTime hora = LocalTime.parse(horaStr);

            // Llamada a la función
            boolean creado = eventoController.crearEvento(titulo, id, numeroEntradas, localizacion, tipoEvento, fecha, hora);
            if (creado) {
                System.out.println("Evento"+ titulo +"creado correctamente.");
            } else {
                System.out.println("No se pudo crear el evento"+ titulo +".");
            }
                    break;
                case 2:
                System.out.println("Editar evento...");
                System.out.println("----- Editar evento -----");
                
                System.out.print("ID del evento (entero): ");
                int id_editado = Integer.parseInt(scanner.nextLine());
                boolean existeEvento = eventoController.buscarEventoPorId(id_editado);
                if (!existeEvento) {
                    System.out.println("No existe un evento con ID " + id_editado);
                    break;
                }
                
                System.out.print("Título del evento: ");
                String titulo_editado = scanner.nextLine();
                
                System.out.print("Número de entradas: ");
                int numeroEntradas_editado = Integer.parseInt(scanner.nextLine());
                
                System.out.print("Localización: ");
                String localizacion_editado = scanner.nextLine();
                
                System.out.print("Tipo de evento (Concierto, Festival, Obra de Teatro, Evento Deportivo): ");
                String tipoEvento_editado = scanner.nextLine();
                
                System.out.print("Fecha del evento (YYYY-MM-DD): ");
                String fechaStr_editado = scanner.nextLine();
                LocalDate fecha_editado = LocalDate.parse(fechaStr_editado);
                
                System.out.print("Hora del evento (HH:MM): ");
                String horaStr_editado = scanner.nextLine();
                LocalTime hora_editado = LocalTime.parse(horaStr_editado);
                
                // Llamada a la función
                boolean editado = eventoController.modificarEvento(id_editado, titulo_editado, numeroEntradas_editado, localizacion_editado, tipoEvento_editado, fecha_editado, hora_editado);
                if (editado) {
                    System.out.println("Evento " + titulo_editado + " modificado correctamente.");
                } else {
                    System.out.println("No se pudo modificar el evento " + titulo_editado + ".");
                }
                    break;                
                case 3:
                    System.out.println("Ver eventos...");
                    eventoController.listarEventos();
                    break;
                case 4:
                    System.out.println("Cancelar evento...");
                    // aquí código para cancelar evento
                    System.out.print("ID del evento a cancelar: ");
                    int idEvento = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto
                    // Llamada a la función
                    boolean cancelado = eventoController.cancelarEvento(idEvento);
                    if (cancelado) {
                        System.out.println("Evento cancelado correctamente.");
                    } else {
                        System.out.println("No se pudo cancelar el evento.");
                    }
                    break;
                case 5:
                System.out.println("Saliendo del menú de usuario...");
                break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionSoporte != 5);
    
        System.out.println("Regresando al menú principal...");
    }       
}