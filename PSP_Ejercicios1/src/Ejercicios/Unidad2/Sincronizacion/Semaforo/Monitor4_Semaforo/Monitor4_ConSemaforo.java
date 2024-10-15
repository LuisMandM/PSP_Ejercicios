package Ejercicios.Unidad2.Sincronizacion.Semaforo.Monitor4_Semaforo;

import java.util.concurrent.Semaphore;

public class Monitor4_ConSemaforo { //CORREGIR
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaforo1 = new Semaphore(50);
        Semaphore semaforo2 = new Semaphore(35);
        Semaphore semtemperatura = new Semaphore(1);

        Museo museo = new Museo(semaforo1,semaforo2,semtemperatura);
        Temperatura h_temp = new Temperatura(museo);
        Visitante visitante = null;
        Visitante jubilado = null;

        h_temp.start();

        for (int i = 0; i < 50; i++) {
            visitante = new Visitante(museo);
            visitante.setPriority(1);
            visitante.start();
        }
        for (int i = 0; i < 10; i++) {
            jubilado = new Visitante(museo, true);
            jubilado.setPriority(10);
            jubilado.start();
        }
    }
}
