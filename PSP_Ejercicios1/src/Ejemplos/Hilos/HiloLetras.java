package Ejemplos.Hilos;

public class HiloLetras extends Thread {
    @Override
    public void run(){
        for (char c = 'a'; c <'h'; c++) {
            System.out.println(c);
        }
    }
}
