package Ejemplos.Hilos;

public class HiloNum extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 20; i++) {
            System.out.println(i);
        }
    }
}
