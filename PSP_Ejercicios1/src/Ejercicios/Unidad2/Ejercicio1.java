package Ejercicios.Unidad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException {
        System.out.println("Creamos el hilo 1");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HiloTexto hilo1 = new HiloTexto(br.readLine());
        System.out.println("Creamos el hilo 2");
        br = new BufferedReader(new InputStreamReader(System.in));
        HiloTexto hilo2 = new HiloTexto(br.readLine());
        System.out.println("Creamos el hilo 3");
        br = new BufferedReader(new InputStreamReader(System.in));
        HiloTexto hilo3 = new HiloTexto(br.readLine());

        System.out.println("Lanzamos ejecución de los hilos");
        hilo1.start();
        hilo2.start();
        hilo3.start();

        try{
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Termina programa principal");
    }
}
