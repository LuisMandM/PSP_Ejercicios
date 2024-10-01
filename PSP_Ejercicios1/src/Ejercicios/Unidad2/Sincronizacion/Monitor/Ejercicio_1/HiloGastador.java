package Ejercicios.Unidad2.Sincronizacion.Monitor.Ejercicio_1;

public class HiloGastador extends Thread {
    Cuenta cuenta;

    public HiloGastador(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        try {
            cuenta.gasto();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
