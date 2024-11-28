package Tema3;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Escribe un programa que lea por consola un día (1-31), un mes (1-12) y
un año y nos indique si la fecha es correcta o no.*/
public class Ejercicio8 {
    public static boolean comprobarFecha(int mes,int age,int dia){
        boolean res=false;
        if (comprobarAge(age)) {
            switch (mes) {
                case 1, 3, 5, 7, 8, 10, 12:
                    if (comprobarDias31(dia)) {
                        res = true;
                    }
                    break;
                case 4, 6, 9, 11:
                    if (comprobarDias30(dia)) {
                        res = true;
                    }
                    break;
                case 2:
                    if (comprobarDiaBisiesto(dia,age)){
                        res=true;
                    }
                    break;
                default:
                    res = false;
            }
        }else {
            res=false;
        }
        return res;
    }

    public static boolean comprobarDias31(int dia){
        boolean res=dia>=1&&dia<=31;
        return res;
    }

    public static boolean comprobarDias30(int dia){
        boolean res=dia>=1&&dia<=30;
        return res;
    }

    public static boolean comprobarDiaBisiesto(int dia,int age){
        boolean res=dia>=1&&dia<=28;
        if (comprobarAgeBisiesto(age)){
            res=dia>=1&&dia<=29;
        }
        return res;
    }

    public static boolean comprobarAge(int age){
        boolean res=age>0;
        return res;
    }

    //(age % 4 == 0 && (age % 100 != 0 || age % 400 == 0)) Calcular año bisisesto
    public static boolean comprobarAgeBisiesto(int age){
        boolean res=(age % 4 == 0 && (age % 100 != 0 || age % 400 == 0));
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int dia,mes,age;
        System.out.println("Introduce el numero de un dia: ");
        dia=sc.nextInt();
        System.out.println("Introduce el numero del mes: ");
        mes=sc.nextInt();
        System.out.println("Introduce un año: ");
        age=sc.nextInt();

        if (comprobarFecha(mes,age,dia)){
            System.out.println("La fecha introducida es correcta");
            System.out.println(dia+"/"+mes+"/"+age);
        }else {
            System.out.println("La fecha introducida es incorrecta");
            System.out.println(dia+"/"+mes+"/"+age);
        }
        sc.close();
    }
}
