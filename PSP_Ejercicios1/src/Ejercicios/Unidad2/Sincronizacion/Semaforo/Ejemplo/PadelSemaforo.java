package Ejercicios.Unidad2.Sincronizacion.Semaforo.Ejemplo;

import java.util.concurrent.Semaphore;

public class PadelSemaforo {
    public static void main(String[] args) {

        Semaphore semaforo = new Semaphore(2);
        Pista pista = new Pista(semaforo);

        Jugador j1 = new Jugador(pista);
        Jugador j2 = new Jugador(pista);
        Jugador j3 = new Jugador(pista);
        Jugador j4 = new Jugador(pista);
        Jugador j5 = new Jugador(pista);

        j1.start();
        j2.start();
        j3.start();
        j4.start();
        j5.start();
    }
}
