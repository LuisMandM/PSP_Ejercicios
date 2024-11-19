package Ejercicios.UDP.Ejercicio8_UDP;

import java.io.Serializable;

public class Operacion implements Serializable {
    int numero1;
    int numero2;
    int solucion;

    public Operacion(int numero1, int numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public int getSolucion() {
        return solucion;
    }

    public void setSolucion(int solucion) {
        this.solucion = solucion;
    }

    @Override
    public String toString() {
        return "Operacion{" +
                "numero1=" + numero1 +
                ", numero2=" + numero2 +
                '}';
    }
}
