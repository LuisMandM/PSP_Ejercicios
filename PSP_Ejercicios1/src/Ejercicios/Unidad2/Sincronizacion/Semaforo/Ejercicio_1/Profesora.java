package Ejercicios.Unidad2.Sincronizacion.Semaforo.Ejercicio_1;

import java.util.concurrent.Semaphore;

public class Profesora extends Thread {
    private Semaphore semaforo;

    public Profesora(Semaphore semaforo) {
        this.semaforo = semaforo;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " repone los juguetes");
        semaforo.release(2);
    }
}
