package Ejercicios.Unidad2.Ejercicio_1;

public class HiloTexto extends Thread {
    public HiloTexto(String texto) {
        super(texto);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName());

            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
