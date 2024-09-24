package Ejercicios.Unidad2.Sincronizacion.Synchronized.Ejercicio_1;

public class CandadoDoble {
    static int total = 0;

    public synchronized void incrementar(){ // Mientras un hilo hace estas lineas, ningun otro hilo podra hacerlo
        total += 1;
    }
    public synchronized void disminuir(){ // Mientras un hilo hace estas lineas, ningun otro hilo podra hacerlo
        total -= 1;
    }
}
