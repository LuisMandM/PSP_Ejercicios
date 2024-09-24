package Ejercicios.Unidad2.Sincronizacion.Synchronized.Ejercicio_1;

public class HiloSyn extends Thread {
    CandadoDoble candado;
    String accion = "+";

    public HiloSyn(CandadoDoble candado) {
        this.candado = candado;
    }

    public HiloSyn(CandadoDoble candado, String accion) {
        this.candado = candado;
        this.accion = accion;
    }

    @Override
    public void run() {
        if (accion.equals("+")) {
            for (int i = 0; i < 10; i++) {
                candado.incrementar();
            }
        } else if (accion.equals("-")) {
            for (int i = 0; i < 10; i++) {
                candado.disminuir();
            }
        }


        System.out.println(CandadoDoble.total);
    }
}
