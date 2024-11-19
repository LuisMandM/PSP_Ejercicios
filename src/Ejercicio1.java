import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.*;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Pattern pat = null;
        Matcher mat = null;
        int numero = 0;

        while (numero != 3) {
            System.out.println("1. Validar matricula  2.Validar DNI  3.Salir");
            numero = Integer.parseInt(br.readLine());

            switch (numero) {
                case 1: // Matricula
                    pat = Pattern.compile("[0-9]{4}-[a-zA-Z]{3}");
                    System.out.println("Introduce una matricula: ");
                    String matricula = br.readLine();

                    // matricula.matches("[0-9]{4}-[a-zA-Z]{3}"); --> tambien se puede asi
                    mat = pat.matcher(matricula);
                    if (mat.find()) {
                        System.out.println("La matricula es valida");
                    } else {
                        System.out.println("La matricula no es valida");
                    }
                    break;
                case 2: // DNI
                    pat = Pattern.compile("[0-9]{8}[a-zA-Z]");
                    System.out.println("Introduce un DNI: ");
                    String dni = br.readLine();

                    mat = pat.matcher(dni);
                    if (mat.find()) {
                        System.out.println("El DNI es valido");
                    } else {
                        System.out.println("El DNI no es valido");
                    }
                    break;
                case 3: // Salir
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Numero no valido");
                    break;
            }
        }
    }
}