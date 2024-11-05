package Ejemplo.UDP.Ejemplo;

import java.io.IOException;
import java.net.*;

public class ClienteUDP {
    public static void main(String[] args) throws IOException {
        String mensaje = "hola lui";
        byte[] salida = mensaje.getBytes();

        // Preparar el paquete que vamos a enviar, no se puede poner "localhost" en el tercer parametro, por eso lo ponemos asi
        DatagramPacket envio = new DatagramPacket(salida, salida.length, InetAddress.getLocalHost(),8888);

        // Enviamos el paquete
        DatagramSocket furgoneta = new DatagramSocket();
        furgoneta.send(envio);

        salida = "adios".getBytes();
        envio = new DatagramPacket(salida, salida.length, InetAddress.getLocalHost(),8888);
        furgoneta.send(envio);
    }
}
