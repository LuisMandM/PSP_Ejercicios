package Ejemplo.Monohilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket cliente = new Socket("localhost", 5000);

        DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
        DataInputStream lectura = new DataInputStream(cliente.getInputStream());

        salida.writeUTF("Hula!");
        System.out.println(lectura.readUTF());
        salida.close();
        lectura.close();
        cliente.close();
    }
}
