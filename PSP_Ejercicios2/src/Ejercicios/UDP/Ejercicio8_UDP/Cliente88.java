package Ejercicios.UDP.Ejercicio8_UDP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente88 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket peticion = new Socket("localhost", 5000);
        ObjectInputStream entrada = new ObjectInputStream(peticion.getInputStream());
        ObjectOutputStream salida = new ObjectOutputStream(peticion.getOutputStream());

        System.out.print("Programa Cliente Iniciado");

        Operacion multiplicacion = (Operacion) entrada.readObject();
        System.out.println("Recibo: " + multiplicacion.getNumero1() + ", " + multiplicacion.getNumero2());
        multiplicacion.setSolucion(multiplicacion.getNumero1() * multiplicacion.getNumero2());
        salida.writeObject(multiplicacion);
        System.out.println("Envio: " + multiplicacion.getSolucion());

        entrada.close();
        salida.close();
        peticion.close();
    }
}
