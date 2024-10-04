package Ejercicios.Unidad2.Sincronizacion.Monitor.Ejercicio_4;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
            museo.setTemperatura(temperatura);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
