package Ejercicio4;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Arrays;

public class Cliente {
    private static SecretKey secretKey;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            byte[] salida = new String("Hola Server").getBytes();
            DatagramPacket envio = new DatagramPacket(salida, salida.length, InetAddress.getLocalHost(), 8888);
            DatagramSocket furgoneta = new DatagramSocket();
            furgoneta.send(envio);

            byte[] datosEntrada = new byte[256];
            DatagramPacket paquete = new DatagramPacket(new byte[16], 16);
            ;
            furgoneta.receive(paquete);
            //secretKey = (SecretKey) paquete.getData();

            System.out.println("LLave recibida");

            do {
                try {
                    System.out.println("Introduzca el mensaje: ");
                    String mensajeOriginal = br.readLine();
                    byte[] mensaje = cifrarTexto(mensajeOriginal);

                    DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, InetAddress.getLocalHost(), 8889);
                    DatagramSocket sobre = new DatagramSocket();
                    sobre.send(peticion);
                    System.out.println("Envio Cifrado: " + mensajeOriginal);


                    DatagramPacket respuesta = new DatagramPacket(new byte[256], 256);
                    sobre.receive(respuesta);
                    System.out.println("Respuesta cifrada recibida:  " + respuesta.getAddress());
                    System.out.println("Respuesta descifrada: " + descifrarTexto(respuesta.getData()));
                    System.out.println();
                } catch (Exception e) {
                    System.out.println("Error al entrar el mensaje: " + e.getMessage());
                }


            } while (true);


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static byte[] cifrarTexto(String textoOriginal) throws
            Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] textoCifrado = cipher.doFinal(textoOriginal.getBytes());
        //String mensajecifrado = new String(textoCifrado);
        return textoCifrado;
    }

    private static String descifrarTexto(byte[] textoCifrado) throws
            Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] textoDecifrado = cipher.doFinal(textoCifrado);
        return new String(textoDecifrado);
    }
}
