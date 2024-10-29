package Ejercicios.Monohilo.Ejercicio_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor2 {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(5000);
        Socket cliente = servidor.accept();
        System.out.println("Servidor conectado");
        DataInputStream entrada = new DataInputStream(cliente.getInputStream());
        DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());

        String mensaje = "";
        while (!mensaje.toLowerCase().equals("exit")) {
            mensaje = entrada.readUTF();
            salida.writeUTF(mensaje.toUpperCase());
        }
        entrada.close();
        salida.close();
        cliente.close();
        servidor.close();
    }
}
