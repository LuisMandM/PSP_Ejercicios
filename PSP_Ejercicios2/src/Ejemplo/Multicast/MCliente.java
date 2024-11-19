package Ejemplo.Multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Arrays;

public class MCliente {
    public static void main(String[] args) throws IOException {
        MulticastSocket escucha = new MulticastSocket(55557);
        InetAddress grupo = InetAddress.getByName("230.0.0.1");
        escucha.joinGroup(grupo); // Nos unimos al grupo multicast

        byte[] datoRecogido = new byte[1024]; // Recogeríamos el mensaje:

        DatagramPacket dgp = new DatagramPacket(datoRecogido, datoRecogido.length);
        escucha.receive(dgp); // Recibimos la petición del servidor multicast

        byte[] datoRelleno = dgp.getData(); // Obtención del dato ya relleno
        System.out.println("Mensaje: " + Arrays.toString(datoRelleno));

        escucha.leaveGroup(grupo); // Dejamos el grupo multicast
        escucha.close(); // Cerramos:
    }
}
