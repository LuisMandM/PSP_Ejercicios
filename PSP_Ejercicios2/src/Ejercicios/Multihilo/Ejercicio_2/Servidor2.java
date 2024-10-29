package Ejercicios.Multihilo.Ejercicio_2;

import Ejercicios.Multihilo.Ejercicio_1.HiloCliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor2 {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(5000);

        while (true) {
            Socket cliente = servidor.accept();

            HiloCliente2 hiloCliente = new HiloCliente2(cliente);
            hiloCliente.start();
        }
    }
}