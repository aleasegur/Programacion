package Tema5.Excepciones;

import javax.xml.transform.sax.SAXSource;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Implementa un programa que cree un vector de enteros de tamaño N
(número aleatorio entre 1 y 100) con valores aleatorios entre 1 y 10. Luego se le
preguntará al usuario qué posición del vector quiere mostrar por pantalla,
repitiéndose una y otra vez hasta que se introduzca un valor negativo. Maneja
todas las posibles excepciones.*/
public class Ejercicio4 {

    public static int[] rellenarVectorAleatorio(Random rand){
        int numsAle,lenghtN;
        lenghtN=rand.nextInt(100);
        int[] vector = new int[lenghtN];
        try {
            for (int i = 0; i < vector.length; i++) {
                numsAle=rand.nextInt(10)+1;
                vector[i]=numsAle;
            }
        }catch (ArrayIndexOutOfBoundsException | InputMismatchException e){
            System.err.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return vector;
    }

    public static void mostrarUnaPosicionVector(Scanner sc,int[] vector){
        int numUser;
        try {
            do {
                System.out.println("Introduce una psocion del vector a mostrar(1-100,para salir introduce un numero negativo): ");
                numUser = sc.nextInt()-1;
                System.out.println(vector[numUser]);
            }while (numUser>=0);
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random rand=new Random();
        int[] vectorInte=rellenarVectorAleatorio(rand);
        //System.out.println(Arrays.toString(vectorInte));
        mostrarUnaPosicionVector(sc,vectorInte);

    }
}
