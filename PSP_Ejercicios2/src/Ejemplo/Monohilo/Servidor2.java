package Ejemplo.Monohilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor2 {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(3000); // Crear conexion
        Socket peticion = servidor.accept(); // recoge la peticion (el socket) del cliente, no avanza hasta que recibe una peticion
        DataInputStream entrada = new DataInputStream(peticion.getInputStream());
        DataOutputStream salida = new DataOutputStream(peticion.getOutputStream());

        System.out.println(entrada.readUTF());
        salida.writeUTF("Hola Cliente");

        entrada.close();
        salida.close();
        peticion.close();
        // servidor.close(); // Esto no se haria ya que el servidor siempr ese queda escuchando
    }
}
