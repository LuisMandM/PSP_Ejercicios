package Ejercicios.Unidad2.Sincronizacion.Monitor.Ejercicio_2;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class HiloProductor extends Thread {
    Productos productos;

    public HiloProductor(Productos productos) {
        this.productos = productos;
    }

    @Override
    public void run() {
        try {
            productos.producir();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
