package Ejercicios.Unidad2.Ejercicio_5;

public class Cajera extends Thread {
    double total = 0.0;
    Cliente cliente;

    public Cajera(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        for (int i = 0; i < cliente.productos; i++) {
            total += cliente.precio;
            System.out.println("Cajera"+getName() + " procesando el producto " + i + " del cliente " + cliente.nombre + ", precio = " + total);
        }
        System.out.println(getName() + " finaliza el cobro del cliente 1 y el total de la compra es: " + total + "€");

    }
}
