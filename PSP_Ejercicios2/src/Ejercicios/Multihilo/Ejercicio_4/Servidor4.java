package Ejercicios.Multihilo.Ejercicio_4;

import Ejercicios.Multihilo.Ejercicio_3.HiloCliente3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor4 {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(5000);
        HistorialTotal historialTotal = new HistorialTotal();

        while (true) {
            Socket cliente = servidor.accept();
            HiloCliente4 hiloCliente = new HiloCliente4(cliente, historialTotal);
            hiloCliente.start();
        }
    }
}
