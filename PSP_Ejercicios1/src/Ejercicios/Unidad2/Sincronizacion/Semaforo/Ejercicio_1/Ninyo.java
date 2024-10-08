package Ejercicios.Unidad2.Sincronizacion.Semaforo.Ejercicio_1;

public class Ninyo extends Thread {
    CajaJuguetes cajaJuguetes;

    public Ninyo(CajaJuguetes cajaJuguetes) {
        this.cajaJuguetes = cajaJuguetes;
    }

    @Override
    public void run() {
        try {
            cajaJuguetes.jugar();
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
