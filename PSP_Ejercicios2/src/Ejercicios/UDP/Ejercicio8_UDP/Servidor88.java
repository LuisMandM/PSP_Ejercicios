package Ejercicios.UDP.Ejercicio8_UDP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Random;

public class Servidor88 { // SIN TERMINAR
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket recibido = new DatagramSocket(8888);
        System.out.println("Esperando al cliente...");

        DatagramPacket lectura = new DatagramPacket(new byte[50], 50);
        Random random = new Random();
        Operacion multiplicacion = new Operacion(1 + random.nextInt(10), 1 + random.nextInt(10));

        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bs);
        out.writeObject(multiplicacion);

        byte[] bytes = bs.toByteArray();
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, lectura.getAddress() , lectura.getPort());

        DatagramSocket envio = new DatagramSocket();
        envio.send(dp);
        System.out.println("Envio: " + multiplicacion.toString());

        byte[] recibidos= new byte[1024];
        DatagramPacket paqRecibido= new DatagramPacket(recibidos, recibidos.length);
        recibido.receive(lectura);
        recibidos = lectura.getData();

        // Convertir de bytes a objeto
        ByteArrayInputStream bais= new ByteArrayInputStream (recibidos);
        ObjectInputStream in= new ObjectInputStream (bais);
        Operacion resultado=(Operacion) in.readObject();
        System.out.println("Recibo resultado: " + resultado.getSolucion());
    }
}
