package Ejercicios.Unidad2.Ejercicio_4;

import static Ejercicios.Unidad2.Ejercicio_4.Ejercicio4.array;

public class CrearArray extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            array.add(i);
        }
    }
}
