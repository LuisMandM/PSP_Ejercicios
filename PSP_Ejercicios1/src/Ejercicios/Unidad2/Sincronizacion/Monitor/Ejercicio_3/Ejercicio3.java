package Ejercicios.Unidad2.Sincronizacion.Monitor.Ejercicio_3;

public class Ejercicio3 {
    public static void main(String[] args) {
        PistaPadel pistaPadel= new PistaPadel();
        Jugador jugador;

        for (int i = 0; i < 5; i++) {
            jugador = new Jugador(pistaPadel);
            jugador.start();
        }
    }
}
