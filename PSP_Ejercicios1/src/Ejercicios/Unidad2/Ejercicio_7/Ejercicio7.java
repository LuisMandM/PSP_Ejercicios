package Ejercicios.Unidad2.Ejercicio_7;

public class Ejercicio7 {
    public static void main(String[] args) throws InterruptedException {
        Candado candado = new Candado();
        Hilo hilo1 = new Hilo(candado);
        Hilo hilo2 = new Hilo(candado);
        Hilo hilo3 = new Hilo(candado);
        Hilo hilo4 = new Hilo(candado);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();

        System.out.println("Total: " + Candado.total);

    }
}
