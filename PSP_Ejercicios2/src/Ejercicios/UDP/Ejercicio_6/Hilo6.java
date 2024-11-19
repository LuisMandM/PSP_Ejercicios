package Ejercicios.UDP.Ejercicio_6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Hilo6 extends Thread {
    private DatagramSocket recibido;

    public Hilo6(DatagramSocket recibido) {
        this.recibido = recibido;
    }

    @Override
    public void run() {
        DatagramPacket lectura = new DatagramPacket(new byte[50], 50);
        try {
            recibido.receive(lectura);
            String snumero = new String(lectura.getData());
            snumero = snumero.trim();

            int numero = 0;

            numero = Integer.parseInt(snumero);

            if (numero != 0) {
                String resultado = "El cuadrado de " + numero + " es " + String.valueOf(numero * numero);
                byte[] salida = resultado.getBytes();

                DatagramPacket envio = new DatagramPacket(salida, salida.length, lectura.getAddress(), lectura.getPort());
                DatagramSocket furgoneta = new DatagramSocket();
                furgoneta.send(envio);
            } else {
                String respuesta = "Numero 0 no es posible";
                byte[] salida = respuesta.getBytes();

                DatagramPacket envio = new DatagramPacket(salida, salida.length, lectura.getAddress(), lectura.getPort());
                DatagramSocket furgoneta = new DatagramSocket();
                furgoneta.send(envio);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
