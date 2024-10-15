package Ejercicios.Unidad2.Sincronizacion.Monitor.Semaforo3_Monitores;

public class Semaforo3_ConMonitor {
    public static void main(String[] args) {
        Cesto cestoMangas = new Cesto(2);
        Cesto cestoCuerpos = new Cesto(1);

        Costura costuraMangas = new Costura(cestoMangas);
        Costura costuraCuerpos = new Costura(cestoCuerpos);
        Ensamblaje ensamblaje = new Ensamblaje(cestoMangas,cestoCuerpos);

        costuraMangas.start();
        costuraCuerpos.start();
        ensamblaje.start();
    }
}
