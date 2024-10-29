package Ejercicios.Multihilo.Ejercicio_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloCliente2 extends Thread{
    private Socket socket;

    public HiloCliente2(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            String mensaje = "";
            do {
                mensaje = entrada.readUTF();
                if (!mensaje.equalsIgnoreCase("exit")) {
                    salida.writeUTF(mensaje.toUpperCase());
                } else {
                    salida.writeUTF("Adios cliente");
                    entrada.close();
                    salida.close();
                    socket.close();
                }
            } while (!mensaje.equalsIgnoreCase("exit"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
