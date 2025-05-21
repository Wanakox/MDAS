package main.app;

/**
 * @file Main.java
 * @brief Clase principal de la aplicación.
 * @details Esta clase contiene el método main que inicia la aplicación y gestiona el menú principal.
 * @author Grupo 2
 */

import main.java.controller.UsuarioController;
import main.java.controller.EntradaController;
import main.java.controller.EventoController;
import main.java.model.Usuario;
import main.java.model.Entrada;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
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

            while (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entre 1 y 4.\n");
                scanner.next();
                System.out.print("Seleccione una opción: \n");
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion < 1 || opcion > 4) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Opción no válida. Por favor, ingrese un número entre 1 y 4.\n");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Registro de Usuario ---");

                    String nombre = "";
                    while (true) {
                        System.out.print("Nombre: ");
                        nombre = scanner.nextLine().trim();
                        if (!nombre.isEmpty())
                            break;
                        System.out.println("El nombre no puede estar vacío.");
                    }

                    String apellido = "";
                    while (true) {
                        System.out.print("Apellido: ");
                        apellido = scanner.nextLine().trim();
                        if (!apellido.isEmpty())
                            break;
                        System.out.println("El apellido no puede estar vacío.");
                    }

                    String correo = "";
                    while (true) {
                        System.out.print("Correo: ");
                        correo = scanner.nextLine().trim();
                        if (correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"))
                            break;
                        System.out.println("Correo inválido. Debe tener el formato correcto (ej: nombre@dominio.com).");
                    }

                    String contrasena = "";
                    while (true) {
                        System.out.print("Contraseña: ");
                        contrasena = scanner.nextLine();
                        if (!contrasena.trim().isEmpty())
                            break;
                        System.out.println("La contraseña no puede estar vacía.");
                    }

                    String dni = "";
                    while (true) {
                        System.out.print("DNI: ");
                        dni = scanner.nextLine().trim().toUpperCase();
                        if (dni.matches("^[0-9]{8}[A-Za-z]$"))
                            break;
                        System.out.println("DNI inválido. Debe tener 8 números seguidos de una letra (ej: 12345678A).");
                    }

                    String rol = "";
                    while (true) {
                        System.out.print("Rol (USUARIO, ORGANIZADOR, SOPORTE): ");
                        rol = scanner.nextLine().trim().toUpperCase();
                        if (rol.equals("USUARIO") || rol.equals("ORGANIZADOR") || rol.equals("SOPORTE"))
                            break;
                        System.out.println("Rol inválido. Debe ser USUARIO, ORGANIZADOR o SOPORTE.");
                    }

                    float cartera = 0.0f;
                    while (true) {
                        System.out.print("Cartera: ");
                        String entrada = scanner.nextLine().trim();
                        if (entrada.isEmpty()) {
                            System.out.println("La cartera no puede estar vacía.");
                            continue;
                        }
                        try {
                            cartera = Float.parseFloat(entrada);
                            break;
                        } catch (NumberFormatException e) {
                            System.out
                                    .println("Entrada no válida. Por favor, ingrese un número válido para la cartera.");
                        }
                    }

                    Usuario nuevoUsuario = new Usuario(nombre, apellido, contrasena, correo, dni, rol, cartera);
                    boolean registrado = usuarioController.registrarUsuario(nuevoUsuario);

                    if (registrado) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Usuario registrado correctamente.");
                    } else {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
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
                        System.out.println("Inicio de sesión exitoso. Bienvenido " + usuario.getNombre() + "!\n");

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
                                System.out.println("Tipo de usuario no reconocido.\n");
                                break;
                        }
                    } else {
                        System.out.println("Credenciales incorrectas.\n");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Lista de Usuarios ---");
                    usuarioController.listarUsuarios();
                    break;

                case 4:
                    System.out.println("Saliendo del programa...\n");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.\n");
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
            System.out.println("2. Comprar entradas (TODO)");
            System.out.println("3. Comprar entradas de otro usuario (TODO)");
            System.out.println("4. Ver entradas compradas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcionUsuario = scanner.nextInt();
            scanner.nextLine();

            switch (opcionUsuario) {
                case 1:
                    System.out.println("--Eventos disponibles--");
                    eventoController.listarEventos();
                    break;
                case 2:
                    System.out.println("Comprando entradas...");
                    break;
                case 3:
                    System.out.println("Comprando entradas de otro usuario...");

                    break;
                case 4:
                    System.out.println("Ver entradas compradas...");
                    entradaController.imprimirEntradasDeUsuario(usuarioActual.getNombre());
                    break;
                case 5:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Saliendo del menú de usuario...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionUsuario != 5);
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
            scanner.nextLine();

            if (opcionSoporte != 1) {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcionSoporte != 1);

        System.out.println("Regresando al menú principal...");
    }

    private static void mostrarMenuOrganizador() {
        Scanner scanner = new Scanner(System.in);
        int opcionSoporte = 0;
        EventoController eventoController = new EventoController();

        do {
            System.out.println("\n--- Menú Organizador ---");
            System.out.println("1. Crear evento");
            System.out.println("2. Editar evento");
            System.out.println("3. Ver eventos");
            System.out.println("4. Buscar evento por ID");
            System.out.println("5. Cancelar evento");
            System.out.println("6. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");

            String input = scanner.nextLine().trim();

            try {
                opcionSoporte = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida. Debe ser un número entre 1 y 6.");
                continue;
            }
            switch (opcionSoporte) {
                case 1:
                    System.out.println("\n----- Crear nuevo evento -----\n");

                    String titulo;
                    while (true) {
                        System.out.print("Título del evento: ");
                        titulo = scanner.nextLine().trim();
                        if (titulo.isEmpty()) {
                            System.out.println("El título no puede estar vacío. Intente de nuevo.");
                        } else {
                            break;
                        }
                    }

                    int id;
                    while (true) {
                        System.out.print("ID del evento (entero): ");
                        String inputId = scanner.nextLine().trim();
                        try {
                            id = Integer.parseInt(inputId);
                        } catch (NumberFormatException e) {
                            System.out.println("ID inválido. Debe ser un número entero.");
                            continue;
                        }
                        if (eventoController.existeEvento(id)) {
                            System.out.println("Ya existe un evento con ese ID. Introduzca otro.");
                        } else {
                            break;
                        }
                    }

                    int numeroEntradas;
                    while (true) {
                        System.out.print("Número de entradas: ");
                        input = scanner.nextLine().trim();
                        try {
                            numeroEntradas = Integer.parseInt(input);
                            if (numeroEntradas <= 0) {
                                System.out.println("Debe ser un número positivo.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. Introduzca un número entero.");
                        }
                    }

                    String localizacion;
                    while (true) {
                        System.out.print("Localización: ");
                        localizacion = scanner.nextLine().trim();
                        if (localizacion.isEmpty()) {
                            System.out.println("La localización no puede estar vacía.");
                        } else {
                            break;
                        }
                    }

                    String tipoEvento;
                    String[] tiposValidos = { "Concierto", "Festival", "Obra de Teatro", "Evento Deportivo" };
                    while (true) {
                        System.out.print("Tipo de evento (Concierto, Festival, Obra de Teatro, Evento Deportivo): ");
                        tipoEvento = scanner.nextLine().trim();
                        boolean valido = false;
                        for (String tipo : tiposValidos) {
                            if (tipo.equalsIgnoreCase(tipoEvento)) {
                                tipoEvento = tipo;
                                valido = true;
                                break;
                            }
                        }
                        if (!valido) {
                            System.out.println(
                                    "Tipo inválido. Introduzca uno de los siguientes: Concierto, Festival, Obra de Teatro, Evento Deportivo.");
                        } else {
                            break;
                        }
                    }

                    LocalDate fecha;
                    while (true) {
                        System.out.print("Fecha del evento (YYYY-MM-DD): ");
                        String fechaStr = scanner.nextLine().trim();
                        try {
                            fecha = LocalDate.parse(fechaStr);
                            if (!fecha.isAfter(LocalDate.now())) {
                                System.out.println("La fecha debe ser posterior al día de hoy.");
                            } else {
                                break;
                            }
                        } catch (DateTimeParseException e) {
                            System.out.println("Formato de fecha inválido. Use el formato YYYY-MM-DD.");
                        }
                    }

                    LocalTime hora;
                    while (true) {
                        System.out.print("Hora del evento (HH:MM): ");
                        String horaStr = scanner.nextLine().trim();
                        try {
                            hora = LocalTime.parse(horaStr);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("Formato de hora inválido. Use el formato HH:MM.");
                        }
                    }

                    boolean creado = eventoController.crearEvento(
                            titulo, id, numeroEntradas, localizacion, tipoEvento, fecha, hora);

                    if (creado) {
                        System.out.println("Evento \"" + titulo + "\" creado correctamente.");
                    } else {
                        System.out.println("No se pudo crear el evento \"" + titulo + "\".");
                    }
                    break;

                case 2:
                    System.out.println("Editar evento...");
                    System.out.println("\n----- Editar evento -----\n");

                    int id_editado = leerEntero(scanner, "ID del evento (entero): ");
                    boolean existeEvento = eventoController.imprimirEventoPorId(id_editado);
                    if (!existeEvento) {
                        System.out.println("No existe un evento con ID " + id_editado);
                        break;
                    }

                    String titulo_editado = leerCadenaNoVacia(scanner, "\nTítulo del evento: ");
                    int numeroEntradas_editado = leerEntero(scanner, "Número de entradas: ");
                    String localizacion_editado = leerCadenaNoVacia(scanner, "Localización: ");
                    String tipoEvento_editado = leerCadenaNoVacia(scanner,
                            "Tipo de evento (Concierto, Festival, Obra de Teatro, Evento Deportivo): ");

                    // Validar fecha
                    LocalDate fecha_editado = null;
                    while (fecha_editado == null) {
                        try {
                            String fechaStr_1 = leerCadenaNoVacia(scanner, "Fecha del evento (YYYY-MM-DD): ");
                            LocalDate posibleFecha = LocalDate.parse(fechaStr_1);

                            if (!posibleFecha.isAfter(LocalDate.now())) {
                                System.out.println("La fecha debe ser posterior al día de hoy.");
                            } else {
                                fecha_editado = posibleFecha;
                            }
                        } catch (DateTimeParseException e) {
                            System.out.println("Formato de fecha inválido. Intenta con YYYY-MM-DD.");
                        }
                    }

                    LocalTime hora_editado = null;
                    while (hora_editado == null) {
                        try {
                            String horaStr_1 = leerCadenaNoVacia(scanner, "Hora del evento (HH:MM): ");
                            hora_editado = LocalTime.parse(horaStr_1);
                        } catch (Exception e) {
                            System.out.println("Formato de hora inválido. Intenta con HH:MM.");
                        }
                    }

                    boolean editado = eventoController.modificarEvento(id_editado, titulo_editado,
                            numeroEntradas_editado, localizacion_editado, tipoEvento_editado, fecha_editado,
                            hora_editado);
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
                    System.out.println("Listar evento por ID...");
                    System.out.print("ID del evento a buscar: ");
                    int idEvento = scanner.nextInt();
                    scanner.nextLine();
                    eventoController.imprimirEventoPorId(idEvento);
                    break;
                case 5:
                    System.out.println("Cancelar evento...");
                    System.out.print("ID del evento a cancelar: ");
                    idEvento = scanner.nextInt();
                    scanner.nextLine();
                    boolean cancelado = eventoController.cancelarEvento(idEvento);
                    if (cancelado) {
                        System.out.println("Evento cancelado correctamente.");
                    } else {
                        System.out.println("No se pudo cancelar el evento.");
                    }
                    break;
                case 6:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Saliendo del menú de usuario...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionSoporte != 6);

        System.out.println("Regresando al menú principal...");
    }

    private static String leerCadenaNoVacia(Scanner scanner, String mensaje) {
        String entrada;
        do {
            System.out.print(mensaje);
            entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("Este campo no puede estar vacío. Inténtalo de nuevo.");
            }
        } while (entrada.isEmpty());
        return entrada;
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        int numero = -1;
        boolean valido = false;
        do {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número entero válido.");
            }
        } while (!valido);
        return numero;
    }
}