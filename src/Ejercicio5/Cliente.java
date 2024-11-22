package Ejercicio5;

import javax.crypto.Cipher;
import java.io.*;
import java.net.Socket;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class Cliente {
    private static KeyPair keys = null;
    private static PublicKey publicKeyClient = null;


    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Socket peticion = new Socket("localhost", 8888);
            GenerarLLaves();

            ObjectOutputStream salida = new ObjectOutputStream(peticion.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(peticion.getInputStream());

            salida.writeObject(keys.getPublic());
            System.out.println("Envio mi publica");
            publicKeyClient = (PublicKey) entrada.readObject();
            System.out.println("Recibo publica del server");

            while (true){
                System.out.println("Escriba un texto: ");
                String texto = br.readLine();

                salida.writeObject(cifrarConClavePublica(texto));
                System.out.println("Envio la peticion");

                byte[] mensaje = (byte[]) entrada.readObject();
                String mensajeDecoded = descifrarConClavePrivada(mensaje);
                System.out.println("Peticion respuesta: " + mensajeDecoded);
            }


        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: "   + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: "   + e.getMessage());
        }
    }

    private static void GenerarLLaves() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048); // Tamaño de la clave de 2048 bits
            keys = keyPairGenerator.genKeyPair();
            System.out.println("LLaves generadas");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No se puede generar el RSA");
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
