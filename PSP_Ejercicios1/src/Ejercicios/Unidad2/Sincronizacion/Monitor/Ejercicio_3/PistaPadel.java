package Ejercicios.Unidad2.Sincronizacion.Monitor.Ejercicio_3;

public class PistaPadel {
    boolean ocupada = false;

    public synchronized void ocupar() throws InterruptedException {
        while (ocupada) {
            System.out.println("La pista está ocupada");
            wait();
        }
        ocupada = true;
    }
    public synchronized void desocupar() throws InterruptedException {
        System.out.println("la pista está disponible");
        ocupada = false;
        notifyAll();
    }
}
