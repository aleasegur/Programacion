package Tema3.Arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Realiza el juego “Atrapa a la mosca”. Hay un array de 15 elementos (no
 visible por el jugador). El jugador selecciona una posición (entre 1 y 15) si la
 mosca se encuentra en dicha posición, el jugador ha ganado. Si la mosca se
 encuentra en una posición adyacente, aleatoriamente cambia de posición. Si
 lo mosca no se encuentra en una posición adyacente, no se mueve.
*/
public class Ejercicio3AtrapaLaMosca {
    public static void initVector(int []vector){
        for (int i = 0; i < vector.length; i++) {
            vector[i]=0;
        }
    }

    public static boolean comprobarUserInput(int userInput){
        return userInput < 0 || userInput >= 15;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random random=new Random();
        int posicionMosca,userInput;
        int[] vectorMosca=new int[15];
        boolean buclePrincipal=true;
        System.out.println("Bienvenido a Atrapar La Mosca!");
        posicionMosca=random.nextInt(15);
        while (buclePrincipal){
            //Pongo que todas los posiciones son 0
            initVector(vectorMosca);
            //Marco la posicion de la moosca con un 1
            vectorMosca[posicionMosca]=1;
            //Para comprobar si se muestra el vector de la mosca, para depurar
            //System.out.println("Vector Mosca: " + Arrays.toString(vectorMosca));
            do {
                System.out.println("Selecciona una posicion entre 1-15: ");
                userInput = sc.nextInt() - 1;// Cuando el usuario ingresa 1 para la primera fila, se refiere al índice 0 del array.
                if (comprobarUserInput(userInput)) {
                    System.err.println("Selecciona un numero valido entre 1 y 15");
                }
            }while (comprobarUserInput(userInput));

            if (posicionMosca==userInput){
                System.out.println("Felicidades has atrapado la mosca en la poscion "+(userInput+1)+" !");
                buclePrincipal=false;
                //verifico si la diferencia de posicion escogida por el usuario esta cerca o lejos(o adyacente) de la posicionMosca
            }else if (Math.abs(userInput-posicionMosca)==1){
                System.out.println("La mosca estaba cerca, pero se ha movido a una nueva posicion");
                //Evita que la nueva posicion sea adyacente
                do {
                    posicionMosca=random.nextInt(15);
                }while (Math.abs(posicionMosca-userInput)<=1);
                //Actualiza la nueva posicion de la mosca
                initVector(vectorMosca);
                vectorMosca[posicionMosca]=1;
            }else {
                System.out.println("La mosca no esta aqui sigue intentandolo");
            }
        }
        sc.close();
    }
}
