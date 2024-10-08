package Ejercicios.Unidad2.Sincronizacion.Semaforo.Ejercicio_2;


import java.util.concurrent.Semaphore;

public class Ejercicio2 {
    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(3);
        Aula aula = new Aula(semaforo);

        Alumno alumno1 = new Alumno(aula,7000);
        Alumno alumno2 = new Alumno(aula,4000);
        Alumno alumno3 = new Alumno(aula,3000);
        Alumno alumno4 = new Alumno(aula,1000);
        Alumno alumno5 = new Alumno(aula,1000);

        alumno1.start();
        alumno2.start();
        alumno3.start();
        alumno4.start();
        alumno5.start();
    }
}
