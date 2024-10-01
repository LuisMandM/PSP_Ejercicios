package Ejercicios.Unidad2.Sincronizacion.Monitor.Ejercicio_1;


public class HiloAhorrador extends Thread {
    Cuenta cuenta;

    public HiloAhorrador(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        try {
            cuenta.ahorro();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
