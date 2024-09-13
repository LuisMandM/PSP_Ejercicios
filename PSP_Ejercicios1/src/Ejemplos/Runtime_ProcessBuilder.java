package Ejemplos;

import java.io.IOException;

public class Runtime_ProcessBuilder {
    public static void main(String[] args) throws InterruptedException, IOException {
        Process p = java.lang.Runtime.getRuntime().exec("Notepad.exe");
        System.out.print(p.pid());
        Thread.sleep(2000);
        p.destroy();
        System.out.println(p.pid());
        System.out.println(p.isAlive());

        ProcessBuilder pw = new ProcessBuilder("notepad.exe", "prueba.txt");
        Process nuevo = pw.start();
        System.out.println(nuevo.pid());
        System.out.println(nuevo.isAlive());
    }
}