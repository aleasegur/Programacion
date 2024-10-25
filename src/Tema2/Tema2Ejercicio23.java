package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Lee por teclado varios números enteros positivos hasta recibir un
número negativo. El programa mostrará la media de los números (sin
tener en cuenta el negativo).*/
public class Tema2Ejercicio23 {
    public static void main(String[] args) {
        int num,media=0,cant=0,suma=0;
        Scanner sc=new Scanner(System.in);
        do {
            System.out.println("Introduce varios numeros positivos(Para salir utiliza un numero negativo): ");
            num=sc.nextInt();
            if (num>=0){
                suma+=num;
                cant++;
            }
        }while (num>0);
        media=suma/cant;
        System.out.println("La media de los numeros introducidos es "+media);
        sc.close();
    }
}
