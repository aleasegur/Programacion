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
        char op;
        double num1,num2,suma,resta,prod,div,resto;
        Scanner sc=new Scanner(System.in);
        while (salir){
            System.out.println("Introduce el primer numero real: ");
            num1=sc.nextDouble();
            System.out.println("Introduce el segundo numero real: ");
            num2=sc.nextDouble();
            System.out.println("---CALCULADORA---"+"\n"+
                    "S.SALIR"+"\n+.SUMA"+"\n-.RESTA"+"\n*.PRODUCTO"+"\n/.DIVISION"+"\n%.RESIDUO");
            op=sc.next().toUpperCase().charAt(0);
            switch (op){
                case 'S':
                    salir=false;
                    break;
                case '+':
                    suma=num1+num2;
                    System.out.println(num1+" + "+num2+" = "+suma);
                    break;
                case '-':
                    resta=num1-num2;
                    System.out.println(num1+" - "+num2+" = "+resta);
                    break;
                case '*':
                    prod=num1*num2;
                    System.out.println(num1+" * "+num2+" = "+prod);
                    break;
                case '/':
                    if (num2!=0) {
                        div = num1 / num2;
                        System.out.println(num1+" / "+num2+" = "+div);
                    }else {
                        System.err.println("ERROR: NO SE PUEDE DIVIDIR ENTRE CERO");
                    }
                    break;
                case '%':
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
        }
        System.out.println("SALIENDO DE LA CALCULADORA");
        sc.close();
    }
}
