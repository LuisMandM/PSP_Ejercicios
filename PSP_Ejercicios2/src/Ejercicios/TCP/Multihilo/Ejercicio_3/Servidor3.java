package Ejercicios.TCP.Multihilo.Ejercicio_3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor3 {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(5000);

        while (true) {
            Socket cliente = servidor.accept();
            HiloCliente3 hiloCliente = new HiloCliente3(cliente);
            hiloCliente.start();
        }
    }
}
