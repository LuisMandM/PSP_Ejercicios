package Ejercicios.Unidad2.Ejercicio_5;

public class Ejercicio5 {
    public static void main(String[] args) throws InterruptedException {
        Cliente cliente1 = new Cliente("Cliente1",3, 2.5);
        Cliente cliente2 = new Cliente("Cliente2",4, 0.5);

        Cajera cajera1 = new Cajera(cliente1);
        Cajera cajera2 = new Cajera(cliente2);

        cajera1.start();
        cajera2.start();

        cajera1.join();
        cajera2.join();
        System.out.println("Termino la jornada de trabajo");
    }
}
