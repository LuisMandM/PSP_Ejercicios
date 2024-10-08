package Ejercicios.Unidad2.Sincronizacion.Semaforo.Ejemplo;

import java.util.concurrent.Semaphore;

public class Pista {
    private Semaphore semaforo;

    public Pista(Semaphore semaforo) {
        this.semaforo = semaforo;
    }

    public void jugar() throws InterruptedException {
        System.out.println("Intentando jugar");
        semaforo.acquire();
        System.out.println("Alguilado con exito");
        Thread.sleep(1000);
        semaforo.release();
    }
}
