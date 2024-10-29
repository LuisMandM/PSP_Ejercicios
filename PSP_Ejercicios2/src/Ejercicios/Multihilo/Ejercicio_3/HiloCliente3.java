package Ejercicios.Multihilo.Ejercicio_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloCliente3 extends Thread {
    private Socket socket;

    public HiloCliente3(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

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
                    socket.close();
                    break;
                default:
                    break;

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}