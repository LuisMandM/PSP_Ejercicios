package Ejercicios.Unidad2.Sincronizacion.Monitor.Ejercicio_5;

public class Ejercicio5 {
    public static void main(String[] args) {
        PistaPadel pistaPadel= new PistaPadel();
        Jugador jugador;

        for (int i = 0; i < 15; i++) {
            jugador = new Jugador(pistaPadel);
            jugador.start();
        }
    }
}
