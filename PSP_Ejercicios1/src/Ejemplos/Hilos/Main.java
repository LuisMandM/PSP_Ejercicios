package Ejemplos.Hilos;

public class Main {
    public static void main(String[] args) { //el main es un hilo
        HiloNum hn = new HiloNum();
        HiloLetras hl = new HiloLetras();

        HiloMayus hm = new HiloMayus();
        Thread hmHilo = new Thread(hm); //para convertirlo en hilo, porque runnable no crea hilos en si, necesita de thread


        // resultados desordenados
        hn.start();
        hl.start();
        hmHilo.start();

        // resultados como si estuvieran en secuencia
        /*
        hn.run();
        hl.run();
        hmHilo.run();
         */

        try{ // con los join() esperamos a que terminen los hilos antes de ejecutar las lineas fuera del trycatch
            hn.join();
            hl.join();
            hmHilo.join();
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("estado de proceso hl en main: " + hl.getState());
        System.out.println("prioridad de hl:"+ hl.getPriority());
    }
}