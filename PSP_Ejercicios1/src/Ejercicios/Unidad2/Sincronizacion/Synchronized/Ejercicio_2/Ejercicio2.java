package Ejercicios.Unidad2.Sincronizacion.Synchronized.Ejercicio_2;

public class Ejercicio2 {
    public static void main(String[] args) {
        Jardin candadoJardin = new Jardin();
        Visitante visitante;

        for (int i = 0; i < 10; i++) {
            visitante = new Visitante(candadoJardin);
            visitante.start();
        }

        for (int i = 0; i < 15; i++) {
            visitante = new Visitante(candadoJardin,"-");
            visitante.start();
        }
    }
}
