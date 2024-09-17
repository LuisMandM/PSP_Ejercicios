package Ejercicios;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio1_4 {
    public static void main(String[] args) throws IOException, InterruptedException {
        /* Ejercicio1: Utilizando la clase Runtime lanza desde tu aplicación alguna aplicación almacenada en tu sistema.
        Prueba a obtener información del proceso lanzado. Investiga como podrías detener el proceso lanzado anteriormente.*/

        Process p = java.lang.Runtime.getRuntime().exec("\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\"");
        System.out.println(p.pid());
        System.out.println(p.isAlive());
        System.out.println(p.info().startInstant());
        System.out.println(p.info().user());
        System.out.println(p.info().totalCpuDuration().get().toNanos());

        int n = (int) p.pid();
        Thread.sleep(3000);

        p.destroy();
        System.out.println(p.isAlive());

        /* Ejercicio2: Desde tu aplicación java haz que directamente se ejecute el comando dir y se pueda ver el
        resultado de la ejecución de dicho comando en la salida de tu aplicación. Prueba hacerlo tanto con Runtime
        como con ProcessBuilder. Prueba a almacenar ese resultado en un fichero. */

        // SIN TERMINAR, MIRAR SOLUCION
        Process directorio = Runtime.getRuntime().exec("cmd /c dir C:\\Users\\");

        // Con ProcessBuilder
        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIR");
        pb.inheritIO();
        pb.start();


        /* Ejercicio3:Podemos modificar el directorio de trabajo donde los procesos lanzados se ejecuten.
        Investiga sobre este punto (ayuda método directory()). Crea una aplicación en la que se lance la ejecución
        del comando dir. Queremos que el directorio de trabajo sea la carpeta temporal del sistema operativo.
        Muestra el valor devuelto por el método directory() antes y después del cambio. */

        /* Ejercicio4: Vamos a redireccionar el resultado de la ejecución del comando tree de la aplicación Powershell.
        Queremos que la información se muestre en una ventana creada por nosotros para este fin. */
    }
}
