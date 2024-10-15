package Ejercicios.Unidad2.Sincronizacion.Monitor.Semaforo3_Monitores;

public class Cesto {
    int llena = 0;
    int unidades = 0;

    public Cesto(int unidades) {
        this.unidades = unidades;
    }

    public synchronized void crearMaterial() throws InterruptedException {
        while (llena >= 4) {
            wait();
        }
        llena = llena + unidades;
        System.out.println(Thread.currentThread().getName() + " count =" + llena);
    }

    public synchronized void cogerMaterial() throws InterruptedException {
        llena -= unidades;
        notifyAll();
    }
}
