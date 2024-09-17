package Ejercicios.Unidad1;

import java.io.IOException;

public class Ejercicio_1 {
     /* Ejercicio1: Utilizando la clase Runtime lanza desde tu aplicación alguna aplicación almacenada en tu sistema.
        Prueba a obtener información del proceso lanzado. Investiga como podrías detener el proceso lanzado anteriormente.*/

    public static void main(String[] args) throws InterruptedException, IOException {
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
    }
}
