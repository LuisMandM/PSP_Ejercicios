package Ejercicios.Unidad2.Ejercicio_4;

import java.util.ArrayList;

public class Ejercicio4 {
    static ArrayList array = new ArrayList();

    public static void main(String[] args) throws InterruptedException {

        double resultado = 0;

        for (int i = 0; i < 2000; i++) {
            array.add(i);
        }

        Calculo1 calculo1 = new Calculo1(array);
        calculo1.start();
        Calculo2 calculo2 = new Calculo2(array);
        calculo2.start();

        calculo1.join();
        calculo2.join();

        resultado += calculo1.getSuma();
        resultado += calculo2.getSuma();
        resultado = resultado / array.size();
        System.out.println(calculo1.getSuma());
        System.out.println(calculo2.getSuma());
        System.out.println(resultado);
    }

    public static class Calculo1 extends Thread {
        ArrayList<Integer> array_T = new ArrayList();
        int suma = 0;

        public Calculo1(ArrayList<Integer> array_T) {
            this.array_T = array_T;
        }

        public int getSuma() {
            return suma;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                this.suma += array_T.get(i);
            }
        }
    }

    public static class Calculo2 extends Thread {
        ArrayList<Integer> array_T = new ArrayList();
        int suma = 0;

        public Calculo2(ArrayList<Integer> array_T) {
            this.array_T = array_T;
        }

        public int getSuma() {
            return suma;
        }
        @Override
        public void run() {

            for (int i = 1000; i < 2000; i++) {
                this.suma += array_T.get(i);
            }
        }
    }
}
