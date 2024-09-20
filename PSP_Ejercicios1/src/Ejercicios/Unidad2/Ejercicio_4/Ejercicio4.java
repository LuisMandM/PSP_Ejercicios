package Ejercicios.Unidad2.Ejercicio_4;

import java.util.ArrayList;

public class Ejercicio4 {
    static ArrayList array = new ArrayList();

    public static void main(String[] args) throws InterruptedException {

        CrearArray crearArray = new CrearArray();
        crearArray.start();
        crearArray.join();

        Calculo1 calculo1 = new Calculo1();
        calculo1.start();
    }

    public static class Calculo1 extends Thread {
        public void run() {
            int suma = 0;
            for (int i = 0; i < 1000; i++) {
                suma = suma + array.get(i);
            }
        }
    }

    public static class Calculo2 extends Thread {
        public void run() {
            int suma = 0;
            for (int i = 1000; i < 1000; i++) {
                suma = suma + array.get(i);
            }
        }
    }
}
