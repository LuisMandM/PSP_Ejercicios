package Ejercicio7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.*;

public class Server {
    private static KeyPair keys = null;
    private static PublicKey publicKeyClient = null;


    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            GenerarLLaves();

            while (true) {
                Socket socket = serverSocket.accept();
                ServerThread Hilo = new ServerThread(socket, keys);
                Hilo.start();
            }

//            Socket cliente = serverSocket.accept();
//            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream()); // Primero output, sino da error
//            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
//
//            salida.writeObject(keys.getPublic());
//            System.out.println("Envio Publica servidor");
//
//            while (true) {
//                int opcion = (int)entrada.readObject();
//
//                switch (opcion) {
//                    case 1:
//                        Signature dsa = Signature.getInstance("SHA1withRSA");
//                        dsa.initSign(keys.getPrivate());
//                        String mensaje = "Este mensaje va a ser firmado correctamente";
//                        dsa.update(mensaje.getBytes());
//                        byte[] signature = dsa.sign();
//
//                        salida.writeObject(signature);
//                        salida.writeObject(mensaje);
//
//                        break;
//                    case 2:
//                        Signature dsaE = Signature.getInstance("SHA1withRSA");
//                        dsaE.initSign(keys.getPrivate());
//                        String mensajeE = "Este mensaje va a ser firmado Incorrectamente";
//                        dsaE.update(mensajeE.getBytes());
//                        byte[] signatureE = dsaE.sign();
//
//                        mensajeE = "Falsificado";
//                        salida.writeObject(signatureE);
//                        salida.writeObject(mensajeE);
//                        break;
//                    default:
//                        System.out.println("Opcion no valida");
//                        break;
//                }
//
//            }


        } catch (IOException e) {
            System.out.println("Ocurrio un error al abrir el servidor " + e.getMessage());
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
}
