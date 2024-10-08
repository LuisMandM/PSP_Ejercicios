package Ejercicios.Unidad2.Sincronizacion.Semaforo.Ejercicio_2;

import java.util.concurrent.Semaphore;

public class Aula {
    private Semaphore semaforo;

    public Aula(Semaphore semaforo) {
        this.semaforo = semaforo;
    }

    public void usarOrdenador() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " intentado usar ordenador");
        semaforo.acquire();
        System.out.println(Thread.currentThread().getName() + " usando ordenador");
    }
    public void dejarOrdenador() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " se va");
        semaforo.release(1);
    }
}
