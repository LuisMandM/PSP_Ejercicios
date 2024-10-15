package Ejercicios.Unidad2.Sincronizacion.Semaforo.Ejercicio_3;

import java.util.concurrent.Semaphore;

public class Ejercicio3 {
    public static void main(String[] args) {
        Semaphore semaforoMangas = new Semaphore(6);
        Semaphore semaforoCuerpos = new Semaphore(3);
        Semaphore semaforoEnsamblaje = new Semaphore(1);
        Cesto cestoMangas = new Cesto(semaforoMangas, semaforoCuerpos, semaforoEnsamblaje);
        Cesto cestoCuerpos = new Cesto(semaforoMangas, semaforoCuerpos, semaforoEnsamblaje);

        // 1--> mangas 2--> cuerpos
        Costura manga = new Costura(cestoMangas, 1);
        manga.start();
        Costura cuerpo = new Costura(cestoCuerpos, 2);
        cuerpo.start();

        Ensamblaje ensamblaje = new Ensamblaje(cestoMangas, cestoCuerpos);
        ensamblaje.start();
    }
}
