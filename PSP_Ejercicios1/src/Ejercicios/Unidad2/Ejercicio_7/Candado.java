package Ejercicios.Unidad2.Ejercicio_7;

public class Candado {
    public static int total = 0;

    public synchronized void incrementar(){ // Mientras un hilo hace estas lineas, ningun otro hilo podra hacerlo
        total += 1;
    }
}
