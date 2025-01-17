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

    public static void palabraHangman(Scanner sc,String palabra){
        String progreso = "";
        for (int i = 0; i < palabra.length(); i++) {
            progreso += "_"; // Se inicializa la palabra oculta con guiones bajos
        }
        int intentos = 0;
        String letrasIncorrectas = "";

        while (intentos < 6) {
            System.out.println("Palabra: " + progreso);
            System.out.println("Letras incorrectas: " + letrasIncorrectas);
            System.out.println("Intentos restantes: " + (6 - intentos));
            System.out.print("Introduce un caracter: ");
            char letra = sc.next().charAt(0);

            // Verificar si la letra está en la palabra
            boolean acierto = false;
            StringBuilder nuevaPalabra = new StringBuilder(progreso);
            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) == letra) {
                    nuevaPalabra.setCharAt(i, letra); // Reemplazamos el guion bajo por la letra correcta
                    acierto = true;
                }
            }
            progreso = nuevaPalabra.toString(); // Actualizamos el progreso

            if (!acierto) {
                letrasIncorrectas += letra + " "; // Agregamos la letra incorrecta a la lista
                intentos++;
                intentoHangMan(intentos);
            }

            // Verificar si el jugador ha adivinado la palabra
            if (progreso.equals(palabra)) {
                System.out.println("¡Has adivinado la palabra! " + palabra);
                break;
            }
        }

        if (intentos == 6) {
            System.out.println("¡Has perdido! La palabra era: " + palabra);
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

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String texto="hola";
        borrarConsola();
        palabraHangman(sc,texto);
    }
}
