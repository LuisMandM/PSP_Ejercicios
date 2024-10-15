package Ejercicios.Unidad2.Sincronizacion.Monitor.Semaforo3_Monitores;

public class Ensamblaje extends Thread{
    Cesto cestoMangas;
    Cesto cestoCuerpos;

    public Ensamblaje(Cesto cestoMangas, Cesto cestoCuerpos) {
        this.cestoMangas = cestoMangas;
        this.cestoCuerpos = cestoCuerpos;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(2000);
                cestoMangas.cogerMaterial();
                cestoCuerpos.cogerMaterial();
                System.out.println("Jersey creado");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
