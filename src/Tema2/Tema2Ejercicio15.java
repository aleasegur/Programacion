package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Realiza un programa que lee el número de un mes y el año e indica por
 consola el número de días del mes (piensa en que el año puede ser
 bisiesto).*/
public class  Tema2Ejercicio15 {
    public static void main(String[] args) {
        int dia=0,mes,year;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el mes: ");
        mes=sc.nextInt();
        System.out.println("Introduce el año: ");
        year=sc.nextInt();
        //30=4,6,9,11
        //31=1,3,5,7,8,10,12
        switch (mes){
            case 1,3,5,7,8,10,12:
                dia=31;
                break;
            case 4,6,9,11:
                dia=30;
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
                    dia=29;
                }else {
                    dia=28;
                }
                break;

            default:
                System.err.println("ERROR: VALOR INTRODUCIDO NO VALIDO");
        }
        System.out.println(mes+"/"+year+" tiene "+dia+" dias");
        sc.close();
    }
}
