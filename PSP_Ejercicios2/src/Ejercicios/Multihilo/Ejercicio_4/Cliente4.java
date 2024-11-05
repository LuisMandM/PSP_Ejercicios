package Ejercicios.Multihilo.Ejercicio_4;

import java.io.*;
import java.net.Socket;

public class Cliente4 {
    public static void main(String[] args) throws IOException {
        Socket peticion = new Socket("localhost", 5000);
        DataInputStream entrada = new DataInputStream(peticion.getInputStream());
        DataOutputStream salida = new DataOutputStream(peticion.getOutputStream());
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

        int operacion = 0;
        double num1;
        double num2;

        while (operacion != 7) {
            System.out.print("1.Suma 2.Resta 3.Multiplicacion 4.Division 5.Historial Propio 6.Historial Total 7.Salir \n" +
                    "Operacion: ");
            operacion = Integer.parseInt(bufer.readLine());
            salida.writeInt(operacion);
            if (operacion < 5) {
                System.out.println("Introduce el primer numero: ");
                num1 = Double.parseDouble(bufer.readLine());
                salida.writeDouble(num1);

                System.out.println("Introduce el segundo numero: ");
                num2 = Double.parseDouble(bufer.readLine());
                salida.writeDouble(num2);

                System.out.println(entrada.readDouble());
            } else if (operacion == 5 || operacion == 6) {
                System.out.println(entrada.readUTF());
            }
        }
        entrada.close();
        salida.close();
        peticion.close();
    }
}