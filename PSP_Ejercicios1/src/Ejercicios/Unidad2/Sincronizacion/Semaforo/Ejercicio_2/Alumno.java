package Ejercicios.Unidad2.Sincronizacion.Semaforo.Ejercicio_2;

public class Alumno extends Thread{
    Aula aula;
    int tiempo;

    public Alumno(Aula aula, int tiempo) {
        this.aula = aula;
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        try {
            aula.usarOrdenador();
            Thread.sleep(tiempo);
            aula.dejarOrdenador();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
