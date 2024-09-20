package Ejercicios.Unidad2.Ejercicio_2;

public class HiloPares extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hilo par: " + i);
            i++;
        }
    }
}
