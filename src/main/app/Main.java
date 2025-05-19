package main.app;

import main.java.controller.UsuarioController;
import main.java.controller.EntradaController;
import main.java.model.Usuario;
import main.java.model.Entrada;

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
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

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
                                //mostrarMenuOrganizador();
                                break;
                            case "SOPORTE":
                                //mostrarMenuSoporte();
                                break;
                            default:
                                System.out.println("Tipo de usuario no reconocido.");
                                break;
                        }
                    } else {
                        System.out.println("Credenciales incorrectas.");
                        break;
                    }

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
        int opcionUsuario;

        do {
            System.out.println("\n--- Menú Usuario ---");
            System.out.println("1. Ver perfil");
            System.out.println("2. Editar perfil");
            System.out.println("3. Ver entradas");
            System.out.println("4. Cerrar sesión");
            System.out.print("Seleccione una opción: ");

            opcionUsuario = scanner.nextInt();
            scanner.nextLine(); // consumir salto línea

            switch (opcionUsuario) {
                case 1:
                    System.out.println("Mostrando perfil...");
                    // aquí código para mostrar perfil
                    break;
                case 2:
                    System.out.println("Editando perfil...");
                    // aquí código para editar perfil
                    break;
                case 3:
                    System.out.println("Mostrando entradas...");
                    if (usuarioActual != null) {
                        entradaController.imprimirEntradasDeUsuario(usuarioActual.getNombre());
                    } else {
                        System.out.println("No hay sesión iniciada.");
                    }
                    break;
                case 4:
                    System.out.println("Cerrando sesión y volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionUsuario != 3);

        // Al salir de este método vuelve al menú principal en main
    }
}