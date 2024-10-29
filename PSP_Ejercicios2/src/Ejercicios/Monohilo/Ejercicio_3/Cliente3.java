package Ejercicios.Monohilo.Ejercicio_3;

import java.io.*;
import java.net.Socket;

public class Cliente3 {
    public static void main(String[] args) throws IOException {
        Socket peticion = new Socket("localhost", 5000);
        DataInputStream entrada = new DataInputStream(peticion.getInputStream());
        DataOutputStream salida = new DataOutputStream(peticion.getOutputStream());
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

        int operacion;
        double num1;
        double num2;

        System.out.print("1.Suma 2.Resta 3.Multiplicacion 4.Division 5.Salir \n" +
                "Operacion: ");
        operacion = Integer.parseInt(bufer.readLine());
        salida.writeInt(operacion);

        if (operacion != 5) {
            System.out.println("Introduce el primer numero: ");
            num1 = Double.parseDouble(bufer.readLine());
            salida.writeDouble(num1);
            System.out.println("Introduce el segundo numero: ");
            num2 = Double.parseDouble(bufer.readLine());
            salida.writeDouble(num2);

            System.out.println(entrada.readDouble());
        }

        entrada.close();
        salida.close();
        peticion.close();
    }
}