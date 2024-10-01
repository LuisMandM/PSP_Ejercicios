package Ejercicios.Unidad2.Sincronizacion.Monitor.Ejercicio_1;


public class Ejercicio1 { // no se si esta del todo bien porque siempre me sale el mismo resultado
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta();
        HiloAhorrador ahorrador;
        HiloGastador gastador;

        for (int i = 0; i < 20; i++) {
            ahorrador = new HiloAhorrador(cuenta);
            ahorrador.start();
        }

        for (int i = 0; i < 20; i++) {
            gastador = new HiloGastador(cuenta);
            gastador.start();
        }
    }
}
