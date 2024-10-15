package Ejercicios.Unidad2.Sincronizacion.Semaforo.Monitor4_Semaforo;

import java.util.concurrent.Semaphore;

public class Museo {
    Semaphore semaforo1;
    Semaphore semaforo2;
    Semaphore semtemperatura;
    int visitas = 0;
    int temperatura = 35;

    public Museo(Semaphore semaforo1, Semaphore semaforo2, Semaphore semtemperatura) {
        this.semaforo1 = semaforo1;
        this.semaforo2 = semaforo2;
        this.semtemperatura = semtemperatura;
    }

    public void entrar(boolean jubilado) throws InterruptedException {
        if (temperatura >= 50) {
            semaforo1.acquire(1);
        } else {
            semaforo2.acquire(1);
        }
        visitas += 1;
        System.out.println("Jubilado = " + jubilado + ". Hay " + visitas + " visitas y la temperatura es " + temperatura);
    }

    public void salir() throws InterruptedException {
        visitas -= 1;
        System.out.println("Visitas = " + visitas);
        semaforo1.release(1);
        semaforo2.release(1);
    }

    public void setTemperatura(int Ntemperatura) throws InterruptedException {
        semtemperatura.acquire();
        temperatura = Ntemperatura;
    }
}
