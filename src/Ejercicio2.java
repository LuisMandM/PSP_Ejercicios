import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.*;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException {

        // llevar un registro de la actividad del programa
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Introduce un usuario valido en formato email: ");
        String usuario = br.readLine();
        if (usuario.matches("[a-zA-Z0-9]+[@][a-zA-Z]+[.][a-z]{3}")){
            System.out.print("Introduce el nombre del fichero a visualizar: ");
            String fichero = br.readLine(); // máximo de 8 caracteres y tiene una extensión de 3 caracteres
            Pattern patternFile = Pattern.compile("\\S[a-z]{8}\\S[a-z]{3}");

        } else {
            System.out.println("Usuario no valido");
        }


    }
}
