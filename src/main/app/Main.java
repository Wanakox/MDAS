package main.app;

import main.java.controller.EventoController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EventoController eventoController = new EventoController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- GESTIÓN DE EVENTOS ---");
            System.out.println("1. Crear evento");
            System.out.println("2. Modificar evento");
            System.out.println("3. Cancelar evento");
            System.out.println("4. Obtener evento por ID");
            System.out.println("5. Listar todos los eventos");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1": // Crear evento
                    System.out.print("ID: ");
                    int idCrear = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nombre: ");
                    String nombreCrear = scanner.nextLine();

                    System.out.print("Número de entradas: ");
                    int entradasCrear = Integer.parseInt(scanner.nextLine());

                    System.out.print("Fecha (YYYY-MM-DD): ");
                    LocalDate fechaCrear = LocalDate.parse(scanner.nextLine());

                    System.out.print("Hora (HH:MM): ");
                    LocalTime horaCrear = LocalTime.parse(scanner.nextLine());

                    System.out.print("Ubicación: ");
                    String ubicacionCrear = scanner.nextLine();

                    System.out.print("Tipo de evento (Concierto, Festival, Obra de Teatro, Evento Deportivo): ");
                    String tipoCrear = scanner.nextLine();

                    eventoController.crearEvento(nombreCrear, idCrear, entradasCrear, ubicacionCrear, tipoCrear, fechaCrear, horaCrear);

                    break;

                case "2": // Modificar evento
                    System.out.print("ID del evento a modificar: ");
                    int idMod = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nuevo nombre: ");
                    String nombreMod = scanner.nextLine();

                    System.out.print("Nuevo número de entradas: ");
                    int entradasMod = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nueva fecha (YYYY-MM-DD): ");
                    LocalDate fechaMod = LocalDate.parse(scanner.nextLine());

                    System.out.print("Nueva hora (HH:MM): ");
                    LocalTime horaMod = LocalTime.parse(scanner.nextLine());

                    System.out.print("Nueva ubicación: ");
                    String ubicacionMod = scanner.nextLine();

                    System.out.print("Nuevo tipo de evento (Concierto, Festival, Obra de Teatro, Evento Deportivo) ");
                    String tipoMod = scanner.nextLine();

                    eventoController.modificarEvento(nombreMod, idMod, entradasMod, ubicacionMod, tipoMod, fechaMod, horaMod);
                    break;

                case "3": // Cancelar evento
                    System.out.print("ID del evento a cancelar: ");
                    int idCancel = Integer.parseInt(scanner.nextLine());

                    eventoController.cancelarEvento(idCancel);
                    break;

                case "4": // Obtener evento
                    System.out.print("ID del evento a consultar: ");
                    int idConsultar = Integer.parseInt(scanner.nextLine());

                    eventoController.obtenerEvento(idConsultar);
                    break;

                case "5": // Listar eventos
                    eventoController.listarEventos();
                    break;

                case "6": // Salir
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
}
