package Ejercicios.Unidad2.Sincronizacion.Monitor.Semaforo3_Monitores;

public class Costura extends Thread {
    Cesto cesto;

    public Costura(Cesto cesto) {
        this.cesto = cesto;
    }

    @Override
    public void run() {
        while (true) {
            try {
                cesto.crearMaterial();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
