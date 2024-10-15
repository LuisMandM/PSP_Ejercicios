package Ejercicios.Unidad2.Sincronizacion.Semaforo.Monitor4_Semaforo;;

public class Visitante extends Thread {
    Museo museo;
    boolean jubilado = false;

    public Visitante(Museo museo) {
        this.museo = museo;
    }

    public Visitante(Museo museo, boolean jubilado) {
        this.museo = museo;
        this.jubilado = jubilado;
    }

    @Override
    public void run() {
        try {
            museo.entrar(jubilado);
            Thread.sleep(2000);
            museo.salir();
        } catch (InterruptedException e) {
            System.out.println("Error en sleep visitante");
        }
    }
}
