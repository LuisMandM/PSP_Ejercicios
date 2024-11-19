package Ejercicios.TCP.Multihilo.Ejercicio_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloCliente4 extends Thread {
    private Socket socket;
    private String historial = "";
    HistorialTotal historialTotal;

    public HiloCliente4(Socket socket, HistorialTotal historialTotal) {
        this.socket = socket;
        this.historialTotal = historialTotal;
    }

    @Override
    public void run() {
        try {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            double num1;
            double num2;
            int operacion = 0;
            String hilo = Thread.currentThread().getName();

            double solucion = 0.0;
            while (operacion != 7) {
                switch (entrada.readInt()) {
                    case 1: // suma
                        num1 = entrada.readDouble();
                        num2 = entrada.readDouble();
                        solucion = num1 + num2;
                        salida.writeDouble(solucion);
                        historial += hilo + ": " + "suma " + num1 + " " + num2 + " = " + solucion + ", ";
                        historialTotal.anadir("suma " + num1 + " " + num2 + " = " + solucion + ", ");
                        break;
                    case 2: // resta
                        num1 = entrada.readDouble();
                        num2 = entrada.readDouble();
                        solucion = num1 - num2;
                        salida.writeDouble(solucion);
                        historial += hilo + ": " + "resta " + num1 + " " + num2 + " = " + solucion + ", ";
                        historialTotal.anadir("resta " + num1 + " " + num2 + " = " + solucion + ", ");
                        break;
                    case 3: // multiplicacion
                        num1 = entrada.readDouble();
                        num2 = entrada.readDouble();
                        solucion = num1 * num2;
                        salida.writeDouble(solucion);
                        historial += hilo + ": " + "multiplicacion " + num1 + " " + num2 + " = " + solucion + ", ";
                        historialTotal.anadir("multiplicacion " + num1 + " " + num2 + " = " + solucion + ", ");
                        break;
                    case 4: // division
                        num1 = entrada.readDouble();
                        num2 = entrada.readDouble();
                        solucion = num1 / num2;
                        salida.writeDouble(solucion);
                        historial += hilo + ": " + "division " + num1 + " " + num2 + " = " + solucion + ", ";
                        historialTotal.anadir("division " + num1 + " " + num2 + " = " + solucion + ", ");
                        break;
                    case 5: // historial
                        if (historial == null) {
                            salida.writeUTF("Aun no hay historial que mostrar");
                        } else {
                            salida.writeUTF(historial);
                        }
                        break;
                    case 6: // historial total
                        salida.writeUTF(historialTotal.getHistorialTotal());
                        break;
                    case 7: // salir
                        operacion = 7;
                        break;
                    default:
                        break;
                }
            }
            entrada.close();
            salida.close();
            socket.close();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
