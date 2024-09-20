package Ejemplos.Hilos;

public class HiloRunnableEjemplo implements Runnable { // En java solo podemos heredar de una clase, implementamos Runnable para poder crear el hilo sin heredar de Thread
    @Override
    public void run() { // Este metodo debe estar SIEMPRE
        for (char i = 'A'; i < 'M'; i++) {
            System.out.println(i);
        }
    }
}
