package main.java.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsuarioOrganizador extends Usuario {
    public UsuarioOrganizador(String nombre, String apellido, String correo, String contrasena, String dni) {
        super(nombre, apellido, correo, contrasena, dni, Rol.ORGANIZADOR);
    }

    // Método para crear un evento
    //public Evento crearEvento(String titulo, String descripcion, String localizacion, String tipoEvento, LocalDateTime fechaHora) {
        // Posible fallo: La clase Evento debe estar definida y debe tener un constructor que acepte estos parámetros.
        // Si Evento no está implementado, este código generará un error de compilación.
        //return new Evento(titulo, descripcion, localizacion, tipoEvento, fechaHora, this);
    }

    // Método para cancelar un evento
    public void cancelarEvento(Evento evento) {
        if (evento != null) {
            // Posible fallo: La clase Evento debe tener un método setCancelado(boolean).
            // Si este método no existe, este código generará un error de compilación.
            //evento.setCancelado(true); // Marca el evento como cancelado
        } else {
            throw new IllegalArgumentException("El evento no puede ser nulo.");
        }
    }

    // Método para generar entradas
    public List<Entrada> generarEntradas(Evento evento, int cantidad, double precio, boolean numeradas) {
        if (evento == null) {
            throw new IllegalArgumentException("El evento no puede ser nulo.");
        }
        if (cantidad <= 0 || precio < 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0 y el precio no puede ser negativo.");
        }

        List<Entrada> entradas = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            // Posible fallo: La clase Entrada debe estar definida y debe tener un constructor que acepte estos parámetros.
            // Si Entrada no está implementada, este código generará un error de compilación.
            //Entrada entrada = new Entrada(evento, precio, numeradas ? i + 1 : -1); // Si es numerada, asigna un número
            //entradas.add(entrada);
        }
        return entradas;
    }


// Posible fallo: La clase Usuario debe estar definida y debe tener un constructor que acepte estos parámetros.
// Si Usuario no está implementada o no tiene el constructor adecuado, este código generará un error de compilación.

// Posible fallo: La enumeración Rol debe estar definida y debe contener el valor ORGANIZADOR.
// Si Rol no está implementada o no contiene este valor, este código generará un error de compilación.
