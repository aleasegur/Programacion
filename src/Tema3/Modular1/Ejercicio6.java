package Tema3.Modular1;
/*ALEJANDRO ASENCIO GURAU
* Escribe un programa que muestre las tablas de multiplicar del 1 al 10.*/
public class Ejercicio6 {
    public static void mostrarTablasMultiplicarUnoAlDiez(){
        int res=0;
        for (int i=1; i<=10;i++) {
            System.out.println("La tabla de mulriplicar de " + i + " :");
            for (int j = 1; j <= 10; j++) {
                res = j * i;
                System.out.println(i + " * " + j + " = " + res);
            }
        }
    }

    public static void main(String[] args) {
        mostrarTablasMultiplicarUnoAlDiez();
    }
}
