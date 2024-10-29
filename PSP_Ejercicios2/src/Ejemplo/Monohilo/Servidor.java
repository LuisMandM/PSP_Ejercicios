package Ejemplo.Monohilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        System.out.println("Ejemplo.Monohilo.Servidor preparado");
        ServerSocket servidor = new ServerSocket(5000);
        Socket peticion = servidor.accept(); // ".accept" devuelve un socket. Es decir, estamos creando la conexion y ya podemos leer y escribir

        DataOutputStream salida = new DataOutputStream(peticion.getOutputStream());
        DataInputStream lectura = new DataInputStream(peticion.getInputStream());

        System.out.println(lectura.readUTF());
        salida.writeUTF("Adius!");
        salida.close();
        lectura.close();
        servidor.close();
    }
}