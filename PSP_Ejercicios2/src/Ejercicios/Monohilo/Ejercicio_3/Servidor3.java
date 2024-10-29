package Ejercicios.Monohilo.Ejercicio_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor3 {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(5000);
        Socket cliente = servidor.accept();
        System.out.println("Servidor conectado");
        DataInputStream entrada = new DataInputStream(cliente.getInputStream());
        DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());

        double solucion = 0.0;
        switch (entrada.readInt()) {
            case 1: // suma
                solucion = entrada.readDouble() + entrada.readDouble();
                salida.writeDouble(solucion);
                break;
            case 2: // resta
                solucion = entrada.readDouble() - entrada.readDouble();
                salida.writeDouble(solucion);
                break;
            case 3: // multiplicacion
                solucion = entrada.readDouble() * entrada.readDouble();
                salida.writeDouble(solucion);
                break;
            case 4: // division
                solucion = entrada.readDouble() / entrada.readDouble();
                salida.writeDouble(solucion);
                break;
            case 5:
                entrada.close();
                salida.close();
                cliente.close();
                servidor.close();
                break;
            default:
                break;
        } // o.O
    }
}
