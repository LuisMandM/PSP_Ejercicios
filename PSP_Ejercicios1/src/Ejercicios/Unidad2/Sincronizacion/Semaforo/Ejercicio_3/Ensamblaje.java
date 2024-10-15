package Ejercicios.Unidad2.Sincronizacion.Semaforo.Ejercicio_3;

public class Ensamblaje extends Thread{
    Cesto mangas;
    Cesto cuerpos;

    public Ensamblaje(Cesto mangas, Cesto cuerpos) {
        this.mangas = mangas;
        this.cuerpos = cuerpos;
    }

    @Override
    public void run() {
        while (true){
            mangas.cogerMangas();
            cuerpos.cogerCuerpos();
            try {
                Thread.sleep(2000);
                System.out.println("Jersey creado, totalMangas = " + mangas.getMangasTotal() + " totalCuerpos= " + cuerpos.getCuerposTotal());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
