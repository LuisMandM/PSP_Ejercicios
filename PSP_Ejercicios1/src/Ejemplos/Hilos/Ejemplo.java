package Ejemplos.Hilos;

public class Ejemplo {
    public static void main(String[] args) throws InterruptedException { // El main es un hilo
        HiloThreadEjemplo hiloNumero = new HiloThreadEjemplo(); // Creamos el objeto (pero el hilo aun no está lanzado)
        hiloNumero.start();// Ejecutamos el hilo
        hiloNumero.run(); // Se ejecuta el metodo run, pero en forma secuencial, no como hilo
        hiloNumero.getPriority(); // Para saber la prioridad del hilo. Valor Default = 5
        System.out.println(hiloNumero.getState()); // Para saber el estado del hilo.

        HiloRunnableEjemplo hiloLetra = new HiloRunnableEjemplo(); // Creamos el objeto (aún no es un hilo, ni está lanzado)
        Thread hiloThread = new Thread(hiloLetra); // Hacemos que hiloLetra sea un hilo (se puede porque este objeto implementa Runnable)
        hiloThread.start(); // Ejecutamos el hilo

        System.out.println("Mensaje Main 1"); // Al ser el main otro hilo, este mensaje podría aparecer al principio del programa, al final, en medio...
        hiloNumero.join();
        System.out.println("Mensaje Main 1"); // Pero este mensaje no se ejecutara hasta que hiloNumero se ejecute por el join()

    }
}
