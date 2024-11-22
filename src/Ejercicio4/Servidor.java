package Ejercicio4;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Servidor {
    static SecretKey key = null;


    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        GenerarLLave();

        DatagramPacket initlectura = new DatagramPacket(new byte[256], 256);
        socket.receive(initlectura);
        DatagramPacket SendKey = new DatagramPacket(key.getEncoded(), key.getEncoded().length, initlectura.getAddress(), initlectura.getPort());
        DatagramSocket envio = new DatagramSocket();
        envio.send(SendKey);
        System.out.println("LLave enviada");

        while (true) {
            try {

                DatagramSocket furgoneta = new DatagramSocket(8889);
                DatagramPacket lectura = new DatagramPacket(new byte[256], 256);
                furgoneta.receive(lectura);

                System.out.println("Ha llegado una peticion cifrada, descifrando....");
                System.out.println("Procedente de: " + lectura.getAddress().getHostAddress());
                String mensaje = descifrarTexto(lectura.getData());
                System.out.println("Peticion recibida: "+ mensaje);

                System.out.println("Respondiendo.....");
                String respuesta = "Respuesta: " + mensaje.toUpperCase();
                byte[] salida = cifrarTexto(respuesta);
                DatagramPacket peticionRespuesta = new DatagramPacket(salida, salida.length, lectura.getAddress(), lectura.getPort());
                furgoneta.send(peticionRespuesta);
                System.out.println("Peticion enviada");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }


    private static void GenerarLLave() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);  // 128 bits de longitud
            key = keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No se puede generar el AES");
        }
    }

    private static byte[] cifrarTexto(String textoOriginal) throws
            Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] textoCifrado = cipher.doFinal(textoOriginal.getBytes());
        //String mensajecifrado = new String(textoCifrado);
        return textoCifrado;
    }

    private static String descifrarTexto(byte[] textoCifrado) throws
            Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] textoDecifrado = cipher.doFinal(textoCifrado);
        return new String(textoDecifrado);
    }
}
