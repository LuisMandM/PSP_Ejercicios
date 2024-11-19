package Ejercicios.UDP.Ejercicio_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Introduce IP del servidor: "); //localhost
        String servidor = bufer.readLine();

        System.out.print("Introduce un número para calcular su cuadrado: ");
        byte[] salida = bufer.readLine().getBytes();
        DatagramPacket envio = new DatagramPacket(salida, salida.length, InetAddress.getByName(servidor), 8888);

        DatagramSocket furgoneta = new DatagramSocket();
        furgoneta.send(envio);
        System.out.println("Paquete enviado al servidor");

        DatagramPacket lectura = new DatagramPacket(new byte[50], 50);
        furgoneta.receive(lectura);

        String mensaje = new String(lectura.getData());
        System.out.println("Respuesta del servidor: " + mensaje.trim());
    }
}
