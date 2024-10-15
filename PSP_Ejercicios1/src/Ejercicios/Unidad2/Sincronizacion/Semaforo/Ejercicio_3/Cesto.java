package Ejercicios.Unidad2.Sincronizacion.Semaforo.Ejercicio_3;

import java.util.concurrent.Semaphore;

public class Cesto {
    private  Semaphore semaforoMangas = new Semaphore(6);
    private  Semaphore semaforoCuerpos = new Semaphore(3);
    private  Semaphore semaforoEnsamblaje = new Semaphore(1);
    private int mangasTotal = 0;
    private int cuerposTotal = 0;

    public Cesto(Semaphore semaforoMangas, Semaphore semaforoCuerpos, Semaphore semaforoEnsamblaje) {
        this.semaforoMangas = semaforoMangas;
        this.semaforoCuerpos = semaforoCuerpos;
        this.semaforoEnsamblaje = semaforoEnsamblaje;
    }

    public void crearManga() {
        try {
            semaforoMangas.acquire();
            mangasTotal += 1;
            System.out.println("Manga creada, total = " + mangasTotal);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearCuerpo() {
        try {
            semaforoCuerpos.acquire();
            cuerposTotal += 1;
            System.out.println("Cuerpo creado, total = " + cuerposTotal);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void cogerMangas() {
        if (mangasTotal >= 2) {
            semaforoMangas.release(2);
            mangasTotal -= 2;
        }
    }

    public void cogerCuerpos() {
        if (cuerposTotal >= 1) {
            semaforoCuerpos.release(1);
            cuerposTotal -= 1;
        }
    }

    public int getMangasTotal() {
        return mangasTotal;
    }

    public int getCuerposTotal() {
        return cuerposTotal;
    }
}
