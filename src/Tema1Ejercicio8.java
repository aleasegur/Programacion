import java.util.Scanner;

//ALEJANDRO ASENCIO GURAU
/*Implementa en Java una clase llamada Tema1Ejercicio8 que pida por
teclado 2 números enteros y te indica el mayor de ellos o si son iguales.*/
public class Tema1Ejercicio8 {
    public static void main(String[] args) {
        int num1,num2;

        Scanner sc=new Scanner(System.in);

        System.out.println("Dime el primer numero: ");
        num1=sc.nextInt();
        System.out.println("Dime el segundo numero: ");
        num2=sc.nextInt();

        if (num1==num2){
            System.out.println("Son iguales");
        }else if (num1>num2){
            System.out.println("El numero mayor es "+num1);
        }else {
            System.out.println("El numero mayor es "+num2);
        }
    }
}
