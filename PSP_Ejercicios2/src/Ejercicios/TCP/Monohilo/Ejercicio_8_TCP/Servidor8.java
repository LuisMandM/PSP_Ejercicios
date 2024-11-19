package Ejercicios.TCP.Monohilo.Ejercicio_8_TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor8 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket servidor = new ServerSocket(5000);
        System.out.println("Esperando al cliente...");
        Socket cliente = servidor.accept();
        System.out.println("Cliente encontrado");

        ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream()); // Primero output, sino da error
        ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
        Random random = new Random();

        Multiplicacion multiplicacion = new Multiplicacion(1 + random.nextInt(10), 1 + random.nextInt(10));
        salida.writeObject(multiplicacion);
        System.out.println("Envio: " + multiplicacion.toString());

        Multiplicacion resultado = (Multiplicacion) entrada.readObject();
        System.out.println("Recibo resultado: " + resultado.getSolucion());
    }
}
