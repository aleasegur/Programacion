package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Realiza un programa que calcule el precio de la estancia en un camping.
 Leerá por consola el número de personas y días. La tarifa estándar es
 de 15 €/noche, pero si son más de 5 personas y se quedan al menos una
 semana el precio se reduce un 25%.*/
public class Tema2Ejercicio14 {
    public static void main(String[] args) {
        int numPers,dias;
        double tarifa=15.0,descuento=25.0,precioTotal,calculoDescuento;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el numero de personas: ");
        numPers=sc.nextInt();
        System.out.println("Introduce el numero de dias: ");
        dias=sc.nextInt();
        precioTotal=dias*tarifa;
        calculoDescuento=tarifa*descuento/100;
        if (numPers>5 && dias>=7){
            precioTotal-=calculoDescuento;
            System.out.println("El descuento aplicado es "+descuento+"%");
        }
        System.out.println("El precio total de la estancia es "+precioTotal);
        sc.close();
    }
}
