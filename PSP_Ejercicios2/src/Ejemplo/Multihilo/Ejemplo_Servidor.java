package Ejemplo.Multihilo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejemplo_Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(5555);

        while (true) {
            Socket cliente = servidor.accept();
            Hilo_Cliente hiloCliente = new Hilo_Cliente(cliente);

            hiloCliente.start();
        }
    }
}