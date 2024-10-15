package Ejercicios.Unidad2.Sincronizacion.Semaforo.Ejercicio_3;

public class Costura extends Thread {
    Cesto cesto;
    int crear = 0;

    public Costura(Cesto cesto, int crear) {
        this.cesto = cesto;
        this.crear = crear;
    }

    @Override
    public void run() {
        while (true){
            if (crear == 1) {
                cesto.crearManga();
            } else if (crear == 2) {
                cesto.crearCuerpo();
            } else {
                System.out.println("Constructor de costura incorrecto");
            }
        }
    }
}
