package Ejercicios.Unidad2.Sincronizacion.Semaforo.Ejercicio_1;

import java.util.concurrent.Semaphore;

public class CajaJuguetes {
    private Semaphore semaforo;
    private Profesora profesora;

    public CajaJuguetes(Semaphore semaforo, Profesora profesora) {
        this.semaforo = semaforo;
        this.profesora = profesora;
    }

    public void jugar() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " intentado coger juguete");
        semaforo.acquire();
        if (semaforo.availablePermits() == 0) {
            System.out.println(Thread.currentThread().getName() + " avisa de que no hay juguetes");
            Thread.sleep(1000);
            Profesora profesora1 = new Profesora(semaforo);
            profesora1.start();
        }
        System.out.println(Thread.currentThread().getName() + " jugando con juguete");
    }
}
