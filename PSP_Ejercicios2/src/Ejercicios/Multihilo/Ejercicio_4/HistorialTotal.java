package Ejercicios.Multihilo.Ejercicio_4;

public class HistorialTotal {
    private String historialTotal = "Historial: ";

    public synchronized void anadir(String historial) throws InterruptedException {
        historialTotal += historial;
    }

    public String getHistorialTotal() throws InterruptedException {
        return historialTotal;
    }
}
