package Ejercicios.Unidad2.Sincronizacion.Monitor.Ejercicio_2;

public class Ejercicio2 { //CORREGIR
    public static void main(String[] args) {
        Productos productos = new Productos();
        HiloProductor productor;
        HiloConsumidor consumidor;

        for (int i = 0; i < 5; i++) {
            productor = new HiloProductor(productos);
            productor.start();
        }

        for (int i = 0; i < 10; i++) {
            consumidor = new HiloConsumidor(productos);
            consumidor.start();
        }
    }
}
