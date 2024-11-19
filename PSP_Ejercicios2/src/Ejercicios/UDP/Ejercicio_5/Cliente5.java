package Ejercicios.UDP.Ejercicio_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introduce mensaje:");
        byte[] salida = bufer.readLine().getBytes();
        DatagramPacket envio = new DatagramPacket(salida, salida.length, InetAddress.getLocalHost(), 8888);

        DatagramSocket furgoneta = new DatagramSocket();
        furgoneta.send(envio);

        DatagramPacket lectura = new DatagramPacket(new byte[50], 50);
        furgoneta.receive(lectura);

        String mensaje = new String(lectura.getData());
        System.out.println(mensaje.trim()); // .trim() para quitar espacios
    }
}
