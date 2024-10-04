package Ejercicios.Unidad2.Sincronizacion.Monitor.Ejercicio_4;


public class Ejercicio4 {
    public static void main(String[] args) throws InterruptedException {
        Museo museo = new Museo();
        Temperatura h_temp = new Temperatura(museo);
        Visitante visitante = null;
        Visitante jubilado = null;

        h_temp.start();

        for (int i = 0; i < 50; i++) {
            visitante = new Visitante(museo);
            visitante.start();
        }
        for (int i = 0; i < 10; i++) {
            jubilado = new Visitante(museo, true);
            jubilado.setPriority(10);
            jubilado.start();
        }
    }
}