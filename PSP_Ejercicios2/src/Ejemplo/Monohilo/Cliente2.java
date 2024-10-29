package Ejemplo.Monohilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente2 {
    public static void main(String[] args) throws IOException {
        Socket cliente = new Socket("localhost", 3000); // Crea una peticion a la conexion
        DataInputStream entrada = new DataInputStream(cliente.getInputStream());
        DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());

        salida.writeUTF("Hola Servidor");
        System.out.println(entrada.readUTF());

        entrada.close();
        salida.close();
        cliente.close();
    }
}
