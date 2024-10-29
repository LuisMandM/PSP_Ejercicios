package Ejercicios.Multihilo.Ejercicio_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket skCliente = new Socket("localhost", 4999);
        DataInputStream entrada = new DataInputStream(skCliente.getInputStream());
        DataOutputStream salida = new DataOutputStream(skCliente.getOutputStream());

        System.out.println(entrada.readUTF());
        salida.writeUTF("Gracias por atenderme Servidor");

        entrada.close();
        salida.close();
        skCliente.close();
    }
}
