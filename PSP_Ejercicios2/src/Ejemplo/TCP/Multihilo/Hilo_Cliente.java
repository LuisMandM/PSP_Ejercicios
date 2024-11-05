package Ejemplo.TCP.Multihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Hilo_Cliente extends Thread {
    private Socket socket;

    public Hilo_Cliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            for (int i = 0; i < 10; i++) {
                System.out.println("El cliente dice: " + entrada.readUTF());
            }

            salida.writeUTF("Adios cliente");

            entrada.close();
            salida.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}