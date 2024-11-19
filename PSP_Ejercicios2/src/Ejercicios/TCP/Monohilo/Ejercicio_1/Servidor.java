package Ejercicios.TCP.Monohilo.Ejercicio_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket skServidor = new ServerSocket(4999, 5);
            int numCliente;

            for (numCliente = 1; numCliente < 6; numCliente++) {
                System.out.println("Atiendo al cliente " + numCliente);
                Socket skCliente = skServidor.accept();
                DataInputStream entrada = new DataInputStream(skCliente.getInputStream());
                DataOutputStream salida = new DataOutputStream(skCliente.getOutputStream());
                System.out.println();
                salida.writeUTF("Hola cliente " + numCliente);
                System.out.println(entrada.readUTF());

                salida.close();
                entrada.close();
                skCliente.close();
            }
            skServidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}