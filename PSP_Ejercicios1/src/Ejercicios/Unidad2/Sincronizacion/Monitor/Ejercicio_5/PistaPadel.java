package Ejercicios.Unidad2.Sincronizacion.Monitor.Ejercicio_5;

public class PistaPadel {
    int llena = 0;

    public synchronized void ocupar() throws InterruptedException {
        while (llena >= 2) {
            System.out.println("La pista está ocupada");
            wait();
        }
        llena = llena + 1;
    }

    public synchronized void desocupar() throws InterruptedException {
        llena -= 1;
        System.out.println("La pista está disponible (" + llena + ")");
        notifyAll();
    }
}
