package Ejercicios.Unidad2.Ejercicio_2;

public class Ejercicio2 {
    public static void main(String[] args) {
        HiloImpares hiloimpar = new HiloImpares();
        System.out.println("Prioridad hilo impar: " + hiloimpar.getPriority());
        hiloimpar.setPriority(4);
        System.out.println("Nueva prioridad hilo impar: " + hiloimpar.getPriority());
        hiloimpar.start();

        HiloPares hilopar = new HiloPares();
        System.out.println("Prioridad hilo par: " + hilopar.getPriority());
        hilopar.setPriority(Thread.MAX_PRIORITY); // pone la prioridad maxima que haya en juego??
        System.out.println("Nueva prioridad hilo impar: " + hilopar.getPriority());
        hilopar.start();


    }
}
