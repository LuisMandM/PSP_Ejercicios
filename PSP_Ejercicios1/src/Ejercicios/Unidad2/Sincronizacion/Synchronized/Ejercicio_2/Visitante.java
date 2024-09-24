package Ejercicios.Unidad2.Sincronizacion.Synchronized.Ejercicio_2;


public class Visitante extends Thread {
    Jardin candadoJardin;
    String accion = "+";

    public Visitante(Jardin candado) {
        this.candadoJardin = candado;
    }

    public Visitante(Jardin candado, String accion) {
        this.candadoJardin = candado;
        this.accion = accion;
    }

    @Override
    public void run() {
        if (accion.equals("+")) {
            candadoJardin.entrada();
        } else if (accion.equals("-")) {
            candadoJardin.salida();
        }
    }
}
