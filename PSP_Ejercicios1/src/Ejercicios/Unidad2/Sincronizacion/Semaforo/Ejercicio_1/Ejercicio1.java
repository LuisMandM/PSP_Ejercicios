package Ejercicios.Unidad2.Sincronizacion.Semaforo.Ejercicio_1;


import java.util.concurrent.Semaphore;

public class Ejercicio1 {
    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(3); // dos juguetes
        Profesora profesora = new Profesora(semaforo);
        CajaJuguetes cajaJuguetes = new CajaJuguetes(semaforo,profesora);

        Ninyo n1 = new Ninyo(cajaJuguetes);
        Ninyo n2 = new Ninyo(cajaJuguetes);
        Ninyo n3 = new Ninyo(cajaJuguetes);
        Ninyo n4 = new Ninyo(cajaJuguetes);
        Ninyo n5 = new Ninyo(cajaJuguetes);

        n1.start();
        n2.start();
        n3.start();
        n4.start();
        n5.start();
    }
}
