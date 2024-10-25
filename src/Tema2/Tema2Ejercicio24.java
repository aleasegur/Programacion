package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* 24.Realiza un programa que permite a un profesor introducir la nota de un
número indefinido de alumnos y le indica cuántos suspendidos o
aprobados hay.
*/
public class Tema2Ejercicio24 {
    public static void main(String[] args) {
        double numNota;
        int apro=0,susp=0;
        boolean entrar=true;
        Scanner sc=new Scanner(System.in);
        while (entrar){
            System.out.println("Introduce la nota del alumno(Para salir introduce un numero menor a 0 o mayor a 10): ");
            numNota=sc.nextDouble();
            if (numNota<0 || numNota>10){
                entrar=false;
            }else if (numNota>=5 && numNota<=10){
                apro++;
            }else {
                susp++;
            }
        }
        System.out.println("Han aprobado "+apro+"\nHan suspendido "+susp);
        sc.close();
    }
}
