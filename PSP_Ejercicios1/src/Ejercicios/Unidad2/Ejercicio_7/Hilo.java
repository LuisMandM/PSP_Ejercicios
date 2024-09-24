package Ejercicios.Unidad2.Ejercicio_7;


public class Hilo extends Thread {
    Candado candado;

    public Hilo(Candado candado) {
        this.candado = candado;
    }

    @Override
    public void run() {

        for (int i = 0; i < 500; i++) {
            candado.incrementar();
        }

        System.out.println(Candado.total);
    }
}
