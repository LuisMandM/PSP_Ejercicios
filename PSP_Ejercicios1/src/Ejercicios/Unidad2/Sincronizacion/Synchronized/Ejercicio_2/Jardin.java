package Ejercicios.Unidad2.Sincronizacion.Synchronized.Ejercicio_2;

public class Jardin {
    static int total = 20;

    public synchronized void entrada() throws InterruptedException { // Mientras un hilo hace estas lineas, ningun otro hilo podra hacerlo
        while(total >=25){ // no deja pasar a los hilos si total es >=25, esto no seria synchronized sino monitor
            System.out.println("Estoy bloqueado por limite de visitantes alcanzado");
            wait();
        }
        total += 1;
        System.out.println("Hay " + total + " visitantes");
    }
    public synchronized void salida(){ // Mientras un hilo hace estas lineas, ningun otro hilo podra hacerlo
        total -= 1;
        System.out.println("Hay " + total + " visitantes");
        notifyAll(); // para avisar a los hilos de que hay un visitante menos
    }
}
