package Ejercicios.Unidad2.Sincronizacion.Synchronized.Ejercicio_2;

public class Jardin {
    static int total = 20;

    public synchronized void entrada(){ // Mientras un hilo hace estas lineas, ningun otro hilo podra hacerlo
        total += 1;
        System.out.println("Hay " + total + " visitantes");
    }
    public synchronized void salida(){ // Mientras un hilo hace estas lineas, ningun otro hilo podra hacerlo
        total -= 1;
        System.out.println("Hay " + total + " visitantes");
    }
}
