package Tema5.Excepciones;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Implementa un programa con tres funciones:
• void imprimePositivo(int p): Imprime el valor p. Lanza una ‘Exception’ si
p < 0
• void imprimeNegativo(int n): Imprime el valor n. Lanza una ‘Exception’ si
p >= 0
La función main para realizar pruebas. Puedes llamar a ambas funciones varias
veces con distintos valores, hacer un bucle para pedir valores por teclado y
pasarlos a las funciones, etc. Maneja las posibles excepciones.*/
public class Ejercicio5 {

    public static void imprimePositivo(int p)throws Exception{
        if (p>=0){
            System.out.println(p);
        }else{
            throw new Exception("ERROR: NUMERO NEGATIVO");
        }
    }

    public static void imprimeNegativo(int p)throws Exception{
        if (p<0){
            System.out.println(p);
        }else{
            throw new Exception("ERROR: NUMERO POSITIVO");
        }
    }



    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int num;
        boolean bucle=true;
        while (bucle){
            System.out.println("Introduce un numero: ");
            num=sc.nextInt();
            imprimePositivo(num);
            imprimeNegativo(num);
        }
        sc.close();
    }
}
