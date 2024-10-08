package Ejercicios.Unidad2.Sincronizacion.Semaforo.Ejemplo;

public class Jugador extends Thread {
    private Pista pista;

    public Jugador(Pista pista) {
        this.pista = pista;
    }

    @Override
    public void run() {
        try {
            pista.jugar();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
