package Ejercicios.UDP.Ejercicio_5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.LocalDateTime;

public class ServidorUDP5 {
    public static void main(String[] args) throws IOException {
        DatagramSocket recibido = new DatagramSocket(8888);
        System.out.println("Servidor activo");

        while (true) {
            DatagramPacket lectura = new DatagramPacket(new byte[50], 50);
            recibido.receive(lectura);
            String mensaje = new String(lectura.getData());

            System.out.println("Ha llegado una peticion: " + mensaje.trim());
            System.out.println("Procedente de: " + lectura.getAddress().getHostAddress());
            System.out.println("En el puerto: " + lectura.getPort());

            System.out.println("Sirviendo la peticion");
            String respuesta = "Hora del servidor " + LocalDateTime.now();
            byte[] salida = respuesta.getBytes();

            DatagramPacket envio = new DatagramPacket(salida, salida.length, lectura.getAddress(), lectura.getPort());
            DatagramSocket furgoneta = new DatagramSocket();
            furgoneta.send(envio);
        }
    }
}
