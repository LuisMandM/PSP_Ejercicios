package Ejercicio7;

import java.io.*;
import java.net.Socket;
import java.security.*;

public class Cliente {
    private static PublicKey publicKeyClient = null;

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Socket peticion = new Socket("localhost", 8888);

            ObjectOutputStream salida = new ObjectOutputStream(peticion.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(peticion.getInputStream());

            publicKeyClient = (PublicKey) entrada.readObject();
            System.out.println("Recibo publica del server");

            while (true) {
                System.out.println("Escriba un texto: ");
                int texto = Integer.parseInt(br.readLine());

                salida.writeObject(texto);
                System.out.println("Envio la peticion");

                Signature verify = Signature.getInstance("SHA1withRSA");
                verify.initVerify(publicKeyClient);


                byte[] firma = (byte[]) entrada.readObject();
                String mensajeDecoded = (String) entrada.readObject();

                verify.update(mensajeDecoded.getBytes());
                boolean check = verify.verify(firma);
                if (check) {
                    System.out.println("Firmado correctamente");
                    System.out.println("Mensaje: " + mensajeDecoded);
                } else {
                    System.out.println("Firmado incorrectamente");
                }

            }


        } catch (IOException | ClassNotFoundException | NoSuchAlgorithmException | InvalidKeyException e) {
            System.out.println("Error al conectar con el servidor: " + e.getMessage());
        } catch (SignatureException e) {
            System.out.println("Erro en firma: " + e.getMessage());
        }

    }
}
