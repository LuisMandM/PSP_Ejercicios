package Ejercicios.UDP.Ejercicio_7;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Cliente7 {
    public static void main(String[] args) throws IOException {


        MulticastSocket multi = new MulticastSocket(12345);
        InetAddress grupo = InetAddress.getByName("230.0.0.1");
        multi.joinGroup(grupo);

        DatagramPacket recibido = new DatagramPacket(new byte[1024], 1024);
        multi.receive(recibido);
        System.out.println(new String(recibido.getData()).trim());
        System.out.println(recibido.getAddress());
        System.out.println(recibido.getPort());

        multi.leaveGroup(grupo);
        multi.close();
    }
}
