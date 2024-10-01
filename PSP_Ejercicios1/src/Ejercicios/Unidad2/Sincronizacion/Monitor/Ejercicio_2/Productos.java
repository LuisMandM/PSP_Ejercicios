package Ejercicios.Unidad2.Sincronizacion.Monitor.Ejercicio_2;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Productos {
    ArrayList<Integer> total = new ArrayList<>();

    public synchronized void producir() throws InterruptedException {
        while (total != null) {
            System.out.println("Estoy bloqueado porque aun hay productos");
            wait();
        }

        for (int i = 0; i < 5; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            total.add(randomNum);
        }
        System.out.println("Los productos han sido repuestos: " + total);
    }

    public synchronized void consumir() throws InterruptedException {
        while (total == null) {
            System.out.println("Estoy bloqueado porque no hay productos");
            wait();
        }
        total.remove(total.get(total.indexOf(total.getFirst())));
        System.out.println("Productos restantes: " + total);
        notifyAll();
    }
}
