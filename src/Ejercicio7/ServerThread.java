package Ejercicio7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;

public class ServerThread extends Thread {
    Socket cliente;
    KeyPair keys;

    public ServerThread(Socket socket, KeyPair privKey) {
        this.cliente = socket;
        this.keys = privKey;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream()); // Primero output, sino da error
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

            salida.writeObject(keys.getPublic());
            System.out.println("Envio Publica servidor");

            while (true) {
                int opcion = (int)entrada.readObject();

                switch (opcion) {
                    case 1:
                        Signature dsa = Signature.getInstance("SHA1withRSA");
                        dsa.initSign(keys.getPrivate());
                        String mensaje = "Este mensaje va a ser firmado correctamente";
                        dsa.update(mensaje.getBytes());
                        byte[] signature = dsa.sign();

                        salida.writeObject(signature);
                        salida.writeObject(mensaje);

                        break;
                    case 2:
                        Signature dsaE = Signature.getInstance("SHA1withRSA");
                        dsaE.initSign(keys.getPrivate());
                        String mensajeE = "Este mensaje va a ser firmado Incorrectamente";
                        dsaE.update(mensajeE.getBytes());
                        byte[] signatureE = dsaE.sign();

                        mensajeE = "Falsificado";
                        salida.writeObject(signatureE);
                        salida.writeObject(mensajeE);
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }

            }


        } catch (IOException e) {
            System.out.println("Ocurrio un error al abrir el servidor " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Algo: " + e.getMessage());
        }
    }

}
