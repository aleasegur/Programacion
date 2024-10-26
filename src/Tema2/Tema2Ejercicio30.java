package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Haz una calculadora. La calculadora permitirá hacer varias operaciones.
Pedirá un número real, pedirá una operación (+, -, *, / o %), pedirá otro
número real y mostrará el resultado por consola. A continuación pedirá
los datos para una nueva operación. Piensa en un modo para que se
pueda salir de la calculadora en cualquier momento.*/
public class Tema2Ejercicio30 {
    public static void main(String[] args) {
        boolean salir=true;
        int op;
        double num1,num2,suma,resta,prod,div,resto;
        Scanner sc=new Scanner(System.in);
        while (salir){
            System.out.println("Introduce el primer numero real: ");
            num1=sc.nextDouble();
            System.out.println("Introduce el segundo numero real: ");
            num2=sc.nextDouble();
            System.out.println("---CALCULADORA---"+"\n"+
                    "0.SALIR"+"\n1.SUMA"+"\n2.RESTA"+"\n3.PRODUCTO"+"\n4.DIVISION"+"\n5.RESIDUO");
            op=sc.nextInt();
            switch (op){
                case 0:
                    salir=false;
                    break;
                case 1:
                    suma=num1+num2;
                    System.out.println(num1+" + "+num2+" = "+suma);
                    break;
                case 2:
                    resta=num1-num2;
                    System.out.println(num1+" - "+num2+" = "+resta);
                    break;
                case 3:
                    prod=num1*num2;
                    System.out.println(num1+" * "+num2+" = "+prod);
                    break;
                case 4:
                    if (num2!=0) {
                        div = num1 / num2;
                        System.out.println(num1+" / "+num2+" = "+div);
                    }else {
                        System.err.println("ERROR: NO SE PUEDE DIVIDIR ENTRE CERO");
                    }
                    break;
                case 5:
                    if (num2!=0) {
                        resto = num1 % num2;
                        System.out.println(num1+" / "+num2+" = "+resto);
                    }else {
                        System.err.println("ERROR: NO SE PUEDE DIVIDIR ENTRE CERO");
                    }
                    break;
                default:
                    System.err.println("ERROR: DATO INTRODUCIDO NO VALIDO");
            }
            System.out.println("SALIENDO DE LA CALCULADORA");
            sc.close();
        }
    }
}
