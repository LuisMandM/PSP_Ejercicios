package Ejercicios.Unidad2.Sincronizacion.Monitor.Ejercicio_5;

public class Jugador extends Thread {
    PistaPadel pistaPadel;

    public Jugador(PistaPadel pistaPadel) {
        this.pistaPadel = pistaPadel;
    }

    @Override
    public void run() {
        try {
            pistaPadel.ocupar();
            Thread.sleep(1000);
            pistaPadel.desocupar();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
