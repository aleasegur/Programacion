package Tema3;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Escribe un programa que pida números enteros positivos hasta que se
introduzca el 0, para cada número nos dirá si es primo o no.
*/
public class Ejercicio7 {
    public static boolean comprobarNumerosPrimos(int num){
        boolean res=true;
            if (num>1){
                for (int i = 2; i <=Math.sqrt(num) ; i++) {
                    if (num%i==0){
                        res=false;
                    }
                }
            }else {
                res=false;
            }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=0;
        do {
            System.out.println("Introduce un numero mayor a 1(Para salir introduzca 0)");
            num=sc.nextInt();
            if (num==0){
                System.out.println("Saliendo...");
            }else if (comprobarNumerosPrimos(num)){
                System.out.println(num+" es primo");
            }else {
                System.out.println(num+" no es primo");
            }
        }while (num!=0);
    }
}
