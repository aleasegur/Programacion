package Tema3.String;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
*  Realiza el juego del ahorcado en una clase llamada HangmanGame. Pedirá
una palabra a un primer usuario, se borrará de consola. Y al segundo usuario
se le preguntan letras hasta que decida resolver. Tendrá 6 intentos que irán
dibujando al “ahorcado”.
*o
/|\
/ \
*/
public class HangmanGame {

    public static void borrarConsola(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    // Verificar si la letra ya ha sido introducida
    public static boolean comprobarLetraIngresada(String cadena, char letra){
        boolean res=true;
        if (cadena.indexOf(letra) != -1) {
            System.err.println("¡Ya ingresaste esa letra! Intenta con otra.");
            res=false;
        }
        return res;
    }

    public static void palabraHangman(Scanner sc,String palabra){
        String palabraRevelar = "";
        boolean condicionBucle=true;
        for (int i = 0; i < palabra.length(); i++) {
            //Inicializo la palabra oculta con guiones
            palabraRevelar += "_";
        }
        int intentos = 0;
        String letrasIncorrectas = "";
        String letrasIntroducidas="";

        while (condicionBucle) {
            System.out.println("Palabra: " + palabraRevelar);
            System.out.println("Letras incorrectas: " + letrasIncorrectas);
            System.out.println("Intentos restantes: " + (6 - intentos));
            char letra=0;
            do {
                System.out.print("Introduce un caracter: ");
                letra = sc.next().toLowerCase().charAt(0);
            }while (!comprobarLetraIngresada(letrasIntroducidas,letra));

            letrasIntroducidas+=letra;

            boolean acierto = false;
            String palabraProgreso = "";
            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) == letra) {
                    palabraProgreso += letra;
                    acierto = true;
                } else {
                    palabraProgreso += palabraRevelar.charAt(i);
                }
            }

            palabraRevelar = palabraProgreso;

            if (!acierto) {
                letrasIncorrectas += letra + " ";
                intentos++;
                intentoHangMan(intentos);
            }

            if (palabraRevelar.equals(palabra)) {
                System.out.println("¡Has adivinado la palabra! " + palabra);
                condicionBucle=false;
            }

            if (intentos == 6) {
                System.out.println("¡Has perdido! La palabra era: " + palabra);
                condicionBucle=false;
            }
        }
    }

    public static void intentoHangMan(int intentos){
        switch (intentos) {
            case 1:
                System.out.println(" o");
                break;
            case 2:
                System.out.println(" o");
                System.out.println("/ ");
                break;
            case 3:
                System.out.println(" o");
                System.out.println("/| ");
                break;
            case 4:
                System.out.println(" o");
                System.out.println("/|\\");
                break;
            case 5:
                System.out.println(" o");
                System.out.println("/|\\");
                System.out.println("/ ");
                break;
            case 6:
                System.out.println(" o");
                System.out.println("/|\\");
                System.out.println("/ \\");
                break;
        }
    }

    public static boolean palabraNoEspacio(String cadena){
        boolean res=false;
        if (cadena.contains(" ")){
            System.err.println("La palabra no debe tener un espacio");
            res=true;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String palabraAdivinar;
        System.out.println("¿VAMOS A JUGAR AL AHORCADO!");
        do {
            System.out.println("Introduce una palabra para adivinar: ");
            palabraAdivinar = sc.nextLine().toLowerCase();
        }while (palabraNoEspacio(palabraAdivinar));
        borrarConsola();
        palabraHangman(sc,palabraAdivinar);
        sc.close();
    }
}
