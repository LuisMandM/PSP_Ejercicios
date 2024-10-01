package Ejercicios.Unidad2.Sincronizacion.Monitor.Ejercicio_2;

public class HiloConsumidor extends Thread {
    Productos productos;

    public HiloConsumidor(Productos productos) {
        this.productos = productos;
    }

    @Override
    public void run() {
        try {
            productos.consumir();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
