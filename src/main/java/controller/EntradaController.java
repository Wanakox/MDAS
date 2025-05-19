package main.java.controller;

import main.java.model.Entrada;
import main.java.data.dao.EntradaDAO;

import java.util.List;

public class EntradaController {
    private EntradaDAO entradaDAO;

    public EntradaController() {
        this.entradaDAO = new EntradaDAO();
    }

    public void imprimirEntradasDeUsuario(String nombreUsuario) {
        List<Entrada> entradas = entradaDAO.buscarPorPoseedor(nombreUsuario);

        if (entradas.isEmpty()) {
            System.out.println("El usuario \"" + nombreUsuario + "\" no tiene entradas.");
        } else {
            System.out.println("Entradas del usuario \"" + nombreUsuario + "\":");
            for (Entrada entrada : entradas) {
                System.out.println("ID: " + entrada.getId() +
                        ", Precio: " + entrada.getPrecio() +
                        ", Asiento: " + entrada.getAsiento() +
                        ", Tipo: " + entrada.getTipo() +
                        ", Evento ID: " + entrada.getidEvento());
            }
        }
    }

    


}