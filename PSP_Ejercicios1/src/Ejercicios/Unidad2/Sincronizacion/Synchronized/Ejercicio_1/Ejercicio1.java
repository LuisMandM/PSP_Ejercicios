package Ejercicios.Unidad2.Sincronizacion.Synchronized.Ejercicio_1;


public class Ejercicio1 {
    public static void main(String[] args) throws InterruptedException {
        CandadoDoble candado = new CandadoDoble();
        HiloSyn hilo1 = new HiloSyn(candado);
        HiloSyn hilo2 = new HiloSyn(candado);
        HiloSyn hilo3 = new HiloSyn(candado);
        HiloSyn hilo4 = new HiloSyn(candado, "-");

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();

        System.out.println("Total: " + CandadoDoble.total);
    }
}
