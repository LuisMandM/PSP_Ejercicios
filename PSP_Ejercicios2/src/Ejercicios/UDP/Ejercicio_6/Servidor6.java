package Ejercicios.UDP.Ejercicio_6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor6 {
    public static void main(String[] args) throws IOException {
        DatagramSocket recibido = new DatagramSocket(8888);
        System.out.println("Servidor activo");

        while (true) {
            /*
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

             */
            Hilo6 hilo = new Hilo6(recibido);
            hilo.start();
        }
    }
}
