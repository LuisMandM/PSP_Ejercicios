import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoluEjer2 {
    static String login;
    static String fichero;

    static Logger logger = Logger.getLogger("SoluEjer2");

    public static void main(String[] args) {
        FileHandler fh;

        try {
            fh = new FileHandler("./log_ejer2.log", true);
            logger.addHandler(fh);
            logger.setLevel(Level.ALL);

            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            //Mensajes por consola
            Handler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.ALL);
            logger.setUseParentHandlers(true); //Quiero que se muestre por pantalla a true, false solo lo mando al log
            leer_login();

            System.out.println("\tSe ha conectado el usuario: " + login);
            logger.log(Level.INFO, "Se ha conectado el usuario: " + login);


            leer_fichero();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void leer_fichero() {
        fichero = new String();

        Pattern pat = null;
        Matcher mat = null;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            do {
                System.out.println("Ingrese el nombre del fichero: ");
                fichero = br.readLine();

                pat = Pattern.compile("\\S[a-z]{8}\\S[a-z]{3}");
                mat = pat.matcher(fichero);

            } while (!mat.matches());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void leer_login() {
        login = new String();

        Pattern pat = null;
        Matcher mat = null;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            do {
                System.out.println("Ingrese un usuario: ");
                login = br.readLine();

                pat = Pattern.compile("[a-zA-Z0-9]+[@][a-zA-Z]+[.][a-z]{3}");
                mat = pat.matcher(login);
                logger.log(Level.SEVERE, "Error al reer el login: " + login);
            } while (!mat.matches());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
