package Ejemplos.Hilos;

public class HiloMayus implements Runnable { // en java solo podemos heredar de una clase, usamos runnable porque thread ya usa el extends

    @Override
    public void run() {
        for (char c = 'A'; c <'L'; c++) {
            System.out.println(c);
        }
    }
}
