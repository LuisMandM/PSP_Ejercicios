package Ejemplo.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {
    public static void main(String[] args) throws IOException {
        // Pare recibir el paquete del cliente, ponemos el mismo puerto
        DatagramSocket recibido = new DatagramSocket(8888);

        while (true){
            // Ver lo que me escriben y almacenar en el paquete
            DatagramPacket lectura = new DatagramPacket(new byte[24], 24); // lo metemos en el buble porque sino se solapa el string

            // Esperar a recibir el paquete y almacenarlo en el DatagramPacket para poder leerlo
            recibido.receive(lectura);

            String mensaje = new String(lectura.getData()); // Si no se pasa a String es ilegible

            System.out.println(mensaje);
            mensaje = "";
        }

    }
}