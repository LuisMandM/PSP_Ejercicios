package Ejercicios.Unidad1;

import java.io.File;
import java.io.IOException;

public class Ejercicio_3 {
    /* Ejercicio3:Podemos modificar el directorio de trabajo donde los procesos lanzados se ejecuten.
        Investiga sobre este punto (ayuda método directory()). Crea una aplicación en la que se
        lance la ejecución del comando dir. Queremos que el directorio de trabajo sea la carpeta
        temporal del sistema operativo. Muestra el valor devuelto por el método directory() antes
        y después del cambio. */
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        System.out.println("Directorio actual: " + pb.directory());
        if(pb.directory()==null){
            System.out.println("toma el del padre");
        }
        File tmpDir = new File("c:/tmp");
        if(!tmpDir.exists()){
            System.out.println("no existe el archivo");
        }
        System.out.println("El directorio a cambiado a: " + pb.directory());

        pb.command("cmd.exe","/c","dir");
        Process p = pb.start();

        // no terminado
    }
}
