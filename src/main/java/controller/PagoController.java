package main.java.controller;

import main.java.data.dao.EntradaDAO;
import main.java.data.dao.PagoDAO;
import main.java.data.dao.UsuarioDAO;

import main.java.model.Pago;

import java.time.LocalDate;
import java.util.Scanner;

public class PagoController {

    private final PagoDAO pagoDAO;
    private final UsuarioDAO usuarioDAO;
    private final EntradaDAO entradaDAO;


    // Constructor
    public PagoController() {
        this.pagoDAO = new PagoDAO();
        this.usuarioDAO= new UsuarioDAO();
        this.entradaDAO= new EntradaDAO();
    }

    /**
     * Método para solicitar el precio final al usuario.
     * @return El precio ingresado por el usuario.
     */
    public double solicitarPrecioFinal() {
        Scanner scanner = new Scanner(System.in);
        double precio = 0.0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Ingrese el precio final: ");
                precio = Double.parseDouble(scanner.nextLine().trim());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número válido.");
            }
        }
        return precio;
    }

    /**
     * Método para solicitar los datos de la tarjeta bancaria al usuario y guardarlos en el fichero.
     * @param precio El precio del pago.
     * @return Un objeto Pago con los datos ingresados.
     */
    public Pago solicitarDatosTarjeta(double precio) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del titular de la tarjeta: ");
        String titularTarjeta = scanner.nextLine();

        System.out.print("Ingrese el número de la tarjeta: ");
        String numeroTarjeta = scanner.nextLine();

        System.out.print("Ingrese la fecha de caducidad de la tarjeta (MM/YY): ");
        String caducidadTarjeta = scanner.nextLine();

        System.out.print("Ingrese el CVV de la tarjeta: ");
        int cvv = Integer.parseInt(scanner.nextLine().trim());

        // Crear un objeto Pago con los datos ingresados
        Pago pago = new Pago(LocalDate.now(), precio, titularTarjeta, numeroTarjeta, caducidadTarjeta, cvv);

        // Guardar el pago en el fichero
        boolean guardado = pagoDAO.guardarTarjeta(pago);
        if (guardado) {
            System.out.println("Los datos de la tarjeta se han guardado correctamente.");
        } else {
            System.out.println("Hubo un error al guardar los datos de la tarjeta.");
        }

        return pago;
    }


    /**
     * Método para notificar el resultado del proceso de pago.
     * @param exito true si el pago fue exitoso, false en caso contrario.
     */
    public void notificarProceso(boolean exito) {
        if (exito) {
            System.out.println("El pago se ha procesado correctamente.");
        } else {
            System.out.println("Hubo un error al procesar el pago.");
        }
    }

    public void RecargarCartera(double cantidad, String correoUsuario) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a recargar debe ser mayor a 0.");
            return;
        }
        // Llamar al DAO para obtener el saldo actual del usuario
        double saldoActual = usuarioDAO.obtenerSaldo(correoUsuario);
    
        // Calcular el nuevo saldo
        double saldoNuevo = saldoActual + cantidad;
    
        // Llamar al DAO para modificar el saldo
        boolean actualizado = usuarioDAO.modificarSaldo(correoUsuario, saldoNuevo);
    
        if (actualizado) {
            System.out.println("La recarga de la cartera se ha realizado correctamente. Nuevo saldo: " + saldoNuevo);
        } else {
            System.out.println("Hubo un error al recargar la cartera.");
        }
    }
    public void procesarPago(String correoUsuario, double cantidad) {
        if (cantidad <= 0) {
            System.out.println("El monto del pago debe ser mayor a 0.");
            return;
        }
    
        // Obtener el saldo actual del usuario
        double saldoActual = usuarioDAO.obtenerSaldo(correoUsuario);
    
        // Verificar si el usuario tiene suficiente saldo
        if (saldoActual < cantidad) {
            System.out.println("Saldo insuficiente para realizar el pago.");
            return;
        }
    
        // Descontar el dinero del saldo
        double saldoNuevo = saldoActual - cantidad;
    
        // Llamar al DAO para modificar el saldo del usuario
        boolean saldoActualizado = usuarioDAO.modificarSaldo(correoUsuario, saldoNuevo);
    
        if (!saldoActualizado) {
            System.out.println("Hubo un error al actualizar el saldo del usuario.");
            return;
        }
        
        String nombreUsuario = usuarioDAO.correoConseguirNombre(correoUsuario);

        boolean entradaComprada = entradaDAO.comprobarEntrada(nombreUsuario, cantidad);
        
        if (entradaComprada) {
            System.out.println("El pago se ha procesado correctamente. Nuevo saldo: " + saldoNuevo);
        } else {
            System.out.println("Hubo un error al procesar el pago.");
        }
    }
}