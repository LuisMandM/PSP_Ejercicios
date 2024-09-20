package Ejemplos.Hilos;

public class HiloThreadEjemplo extends Thread { // Creamos hilo al heredar de esta clase

    @Override
    public void run() { // Este metodo debe estar SIEMPRE
        for (int i = 0; i < 20; i++) {
            System.out.println(i + " del hilo " + this.getName());
        }
    }
}
