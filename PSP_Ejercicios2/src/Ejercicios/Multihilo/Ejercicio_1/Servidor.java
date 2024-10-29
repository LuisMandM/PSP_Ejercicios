package Ejercicios.Multihilo.Ejercicio_1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
            ServerSocket skServidor = new ServerSocket(4999, 5);
            int numCliente = 1;

            while (true) {
                System.out.println("Atiendo al cliente " + numCliente);
                Socket skCliente = skServidor.accept();
                HiloCliente hiloCliente = new HiloCliente(skCliente, numCliente);

                hiloCliente.start();
                numCliente++;
            }

    }
}