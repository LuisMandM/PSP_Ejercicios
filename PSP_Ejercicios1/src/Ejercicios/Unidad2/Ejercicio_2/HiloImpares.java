package Ejercicios.Unidad2.Ejercicio_2;

public class HiloImpares extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println("Hilo impar: " + i);
            i++;
        }
    }
}
