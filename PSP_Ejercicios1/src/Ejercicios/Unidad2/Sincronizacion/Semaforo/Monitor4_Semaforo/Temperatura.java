package Ejercicios.Unidad2.Sincronizacion.Semaforo.Monitor4_Semaforo;

import java.util.Random;

public class Temperatura extends Thread {
    int temperatura = 0;
    Museo museo;

    public Temperatura(Museo museo) {
        this.museo = museo;
    }

    @Override
    public void run() {
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            temperatura += r.nextInt(50);
            try {
                museo.setTemperatura(temperatura);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
