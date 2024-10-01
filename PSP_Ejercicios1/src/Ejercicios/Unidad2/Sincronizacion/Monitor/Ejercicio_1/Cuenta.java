package Ejercicios.Unidad2.Sincronizacion.Monitor.Ejercicio_1;

public class Cuenta {
    static int total = 0;

    public synchronized void ahorro() throws InterruptedException {
        while (total >= 250) { // no deja pasar a los hilos si total es >=250
            System.out.println("Estoy bloqueado por limite de saldo ahorrado");
            wait();
        }
        total += 10;
        notifyAll(); // para avisar a los hilos de que han subido los ahorros y igual ya pueden gastar
        System.out.println("Hay " + total + "€ de saldo");
    }

    public synchronized void gasto() throws InterruptedException {
        while (total <= 0) { // no deja pasar a los hilos si total es <= 0
            System.out.println("Estoy bloqueado por limite de saldo gastado");
            wait();
        }
        total -= 10;
        notifyAll(); // para avisar a los hilos de que han bajado los ahorros y igual ya pueden ahorrar
        System.out.println("Hay " + total + "€ de saldo");
    }
}
