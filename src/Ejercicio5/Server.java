package Ejercicio5;

import javax.crypto.Cipher;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class Server {
    private static KeyPair keys = null;
    private static PublicKey publicKeyClient = null;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            GenerarLLaves();


            Socket cliente = serverSocket.accept();
            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream()); // Primero output, sino da error
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

            publicKeyClient = (PublicKey) entrada.readObject();
            System.out.println("Recibo clave publica");
            salida.writeObject(keys.getPublic());
            System.out.println("Envio Publica servidor");

            while (true) {
                byte[] mensaje = (byte[]) entrada.readObject();
                String mensajeDecoded = descifrarConClavePrivada(mensaje);
                System.out.println("Peticion recibida: " + mensajeDecoded);

                byte[] respuesta = cifrarConClavePublica(mensajeDecoded.toUpperCase());
                salida.writeObject(respuesta);
                System.out.println("Respuesta enviada");

            }


        } catch (IOException e) {
            System.out.println("Ocurrio un error al abrir el servidor " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Algo: " + e.getMessage());
        }

    }

    private static void GenerarLLaves() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048); // Tamaño de la clave de 2048 bits
            keys = keyPairGenerator.genKeyPair();
            System.out.println("LLaves generadas");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No se puede generar el AES");
        }
    }

    private static byte[] cifrarConClavePublica(String mensaje)
            throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKeyClient);
        return cipher.doFinal(mensaje.getBytes());  // Devuelve los bytes cifrados
    }

    private static String descifrarConClavePrivada(byte[] mensajeCifrado) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, keys.getPrivate());
        byte[] mensajeDescifrado = cipher.doFinal(mensajeCifrado);
        return new String(mensajeDescifrado);
    }
}
