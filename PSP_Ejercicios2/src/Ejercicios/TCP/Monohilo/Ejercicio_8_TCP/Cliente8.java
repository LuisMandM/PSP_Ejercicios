package Ejercicios.TCP.Monohilo.Ejercicio_8_TCP;

import java.io.*;
import java.net.Socket;

public class Cliente8 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket peticion = new Socket("localhost", 5000);
        ObjectInputStream entrada = new ObjectInputStream(peticion.getInputStream());
        ObjectOutputStream salida = new ObjectOutputStream(peticion.getOutputStream());

        System.out.print("Programa Cliente Iniciado");

        Multiplicacion multiplicacion = (Multiplicacion) entrada.readObject();
        System.out.println("Recibo: " + multiplicacion.getNumero1() + ", " + multiplicacion.getNumero2());
        multiplicacion.setSolucion(multiplicacion.getNumero1() * multiplicacion.getNumero2());
        salida.writeObject(multiplicacion);
        System.out.println("Envio: " + multiplicacion.getSolucion());

        entrada.close();
        salida.close();
        peticion.close();
    }
}
