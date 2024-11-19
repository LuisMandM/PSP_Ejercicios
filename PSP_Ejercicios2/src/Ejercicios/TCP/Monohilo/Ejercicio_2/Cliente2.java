package Ejercicios.TCP.Monohilo.Ejercicio_2;

import java.io.*;
import java.net.Socket;

public class Cliente2 {
    public static void main(String[] args) throws IOException {
        Socket peticion = new Socket("localhost",5000);
        DataInputStream entrada = new DataInputStream(peticion.getInputStream());
        DataOutputStream salida = new DataOutputStream(peticion.getOutputStream());
        String mensaje = "";

        while (!mensaje.toLowerCase().equals("exit")) {
            System.out.println("Escribe un mensaje: ");
            BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
            mensaje = bufer.readLine();
            salida.writeUTF(mensaje);
            System.out.println(entrada.readUTF());
        }
        entrada.close();
        salida.close();
        peticion.close();
    }
}
