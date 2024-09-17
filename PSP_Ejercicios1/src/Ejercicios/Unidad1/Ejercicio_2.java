package Ejercicios.Unidad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio_2 {
    /* Ejercicio2: Desde tu aplicación java haz que directamente se ejecute el comando dir y se pueda ver el
        resultado de la ejecución de dicho comando en la salida de tu aplicación. Prueba hacerlo tanto con Runtime
        como con ProcessBuilder. Prueba a almacenar ese resultado en un fichero. */

    public static void main(String[] args) throws IOException {
        // SIN TERMINAR, MIRAR SOLUCION
        Process directorio = Runtime.getRuntime().exec("cmd /c dir C:\\Users\\");
        BufferedReader lectura = new BufferedReader(new InputStreamReader(directorio.getInputStream()));

        String linea = null;
        while ((linea = lectura.readLine())!=null){
            System.out.println(linea);
        }


        // Con ProcessBuilder
        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIR");
        pb.inheritIO();
        pb.start();
    }
}
