import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Ejer_3 {

    static List<Map<String, byte[]>> registros = new ArrayList();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean running = true;
        String user;
        String pass;


        do {
            System.out.print("Sistema de Gestion de Contraseñas:\n1.Registrarse\n2.Login\n3.Salir\nOpcion: ");
            try {
                int opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1:
                        System.out.print("Indique el usuario: ");
                        user = br.readLine();
                        System.out.print("Indique el password: ");
                        pass = br.readLine();

                        if (addRegistro(user, pass)) System.out.println("Usuario registrado, correctamente\n");
                        else System.out.println("Algo ha salido mal en el registro\n");

                        break;
                    case 2:
                        if (!registros.isEmpty()) {
                            System.out.print("Indique el usuario: ");
                            user = br.readLine();
                            System.out.print("Indique el password: ");
                            pass = br.readLine();

                            if (validarSesion(user, pass)) System.out.println("Bienvenido " + user + "\n");
                            else System.out.println("Credenciales invalidas\n");
                        } else System.out.println("Debe haber al menos un usuario registrado\n");

                        break;
                    case 3:
                        System.out.println("Adios...");
                        running = false;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;

                }

            } catch (IOException e) {
                System.out.println("Error en el inicio de sesión");
            }


        } while (running);

    }


    private static boolean addRegistro(String user, String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            byte[] hashed = messageDigest.digest();
            Map<String, byte[]> map = new HashMap();
            map.put(user, hashed);
            registros.add(map);
            return true;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error en la codificacion de la contraseña: " + e.getMessage());
            return false;
        }
    }

    private static boolean validarSesion(String user, String password) {
        boolean res = false;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            byte[] hashed = messageDigest.digest();

            for (Map<String, byte[]> map : registros) {
                if (Arrays.equals(map.get(user), hashed)) res = true;
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error en la codificacion de la contraseña: " + e.getMessage());
            res = false;
        }
        return res;
    }

}
