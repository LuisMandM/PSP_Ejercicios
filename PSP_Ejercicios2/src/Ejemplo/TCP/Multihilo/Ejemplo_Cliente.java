package Ejemplo.TCP.Multihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Ejemplo_Cliente {
    // Para poder lanzar "Ejemplo_Cliente" en paralelo: Ventana al lado dle run > Edit configurations > Modify Options > Allow multiple instances
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 5555);
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

        for (int i = 0; i < 10; i++) {
            salida.writeUTF("Hola");
            Thread.sleep(1000);
        }
        System.out.println(entrada.readUTF());

        entrada.close();
        salida.close();
        socket.close();
    }
}
