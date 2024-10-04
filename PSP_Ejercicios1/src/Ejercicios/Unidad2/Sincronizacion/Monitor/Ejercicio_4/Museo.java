package Ejercicios.Unidad2.Sincronizacion.Monitor.Ejercicio_4;

public class Museo {
    int visitas = 35;
    int temperatura = 35;

    public synchronized void entrar(boolean jubilado) throws InterruptedException {
        if (temperatura >= 50) {
            while (visitas >= 35) {
                //El mensaje es erroneo
                System.out.println("Jubilado = " + jubilado + ". Hay " + visitas + " visitas y la temperatura es " + temperatura);
                wait();
            }
            visitas += 1;
        } else {
            while (visitas >= 50) {
                System.out.println("Jubilado = " + jubilado + ". Hay " + visitas + " visitas y la temperatura es " + temperatura);
                wait();
            }
            visitas += 1;
        }
    }

    public synchronized void salir() throws InterruptedException {
        visitas -= 1;
        System.out.println("Visitas = " + visitas);
        notifyAll();
    }

    public synchronized void setTemperatura(int Ntemperatura) {
        temperatura = Ntemperatura;
        notifyAll();
    }
}
