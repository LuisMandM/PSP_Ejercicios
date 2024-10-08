package Ejercicios.Unidad2.Sincronizacion.Monitor.Ejercicio_5;

import java.util.Random;

public class Jugador extends Thread {
    PistaPadel pistaPadel;

    public Jugador(PistaPadel pistaPadel) {
        this.pistaPadel = pistaPadel;
    }

    @Override
    public void run() {
        try {
            Random r = new Random();
            pistaPadel.ocupar();
            Thread.sleep(1000);
            pistaPadel.desocupar();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
