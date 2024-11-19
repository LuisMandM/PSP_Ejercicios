package Ejercicios.UDP.Ejercicio_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ServidorM7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

        MulticastSocket servidor = new MulticastSocket();

        while (true) {
            System.out.print("Introduce el mensaje a mandar: ");
            String mensaje = bufer.readLine();

            byte[] dato = mensaje.getBytes();

            // Usamos la direccion Multicast 230.0.0.1, por poner alguna dentro del rango y el puerto 55557, uno cualquiera que esté libre.
            DatagramPacket dgp = new DatagramPacket(dato, dato.length, InetAddress.getByName("230.0.0.1"), 12345);

            // Envío
            servidor.send(dgp);
        }
    }
}
