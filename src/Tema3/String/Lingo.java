package Tema3.String;

import java.io.FileWriter;
import java.util.Scanner;

public class Lingo {

    public static boolean comprobarLongitudCadenas(String cadenaUsuario,String cadenaPalabra){
        boolean res=true;
        if (cadenaUsuario.length()!=cadenaPalabra.length()){
            System.out.println("La palabra debe tener "+cadenaUsuario.length()+". Inttroduzca de nuevo");
            res=false;
        }
        return res;
    }

    public static String reemplazarCaracter(String cadena, int posicion, char nuevoCaracter) {
        String res="";
        String inicio = cadena.substring(0, posicion);
        String fin = cadena.substring(posicion + 1);
        res+=inicio+nuevoCaracter+fin;
        return res;
    }

    public static String evaluarIntentosPalabra(String palabraSecreta,String palabraUsuario){
        String res = "";
        for (int i = 0; i < palabraSecreta.length(); i++) {
            res+="_";
        }

        // Verificar letras en la posicion correcta
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraUsuario.charAt(i) == palabraSecreta.charAt(i)) {
                res = reemplazarCaracter(res, i, palabraUsuario.charAt(i)); // Marca como correcta
            }
        }

        // Verificar letras contenidas pero en posición incorrecta
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (res.charAt(i) == '_') { // Si no esta ya correcta
                for (int j = 0; j < palabraSecreta.length(); j++) {
                    if (res.charAt(j) == '_' && palabraUsuario.charAt(i) == palabraSecreta.charAt(j)) {
                        res = reemplazarCaracter(res, i, '*'); // Marca como incorrecta pero contenida
                    }
                }
            }
        }

        return res;
    }

    public static void iniciarLingo(Scanner sc,String palabra){
        int intento=1;
        String palabraRevelar="";
        boolean condicionBucle=true;

        for (int i = 0; i < palabra.length(); i++) {
            palabraRevelar += "_";
        }

        while (condicionBucle){
            String palabraUser="";
            System.out.println("Hint: "+palabraRevelar);
            do {
                System.out.print("Try: ");
                palabraUser=sc.nextLine().toLowerCase();
            }while (HangmanGame.palabraNoEspacio(palabraUser)|| !comprobarLongitudCadenas(palabra,palabraUser));

            palabraRevelar=evaluarIntentosPalabra(palabra,palabraUser);

            System.out.println("Try: "+palabraUser);

            if (palabraUser.equals(palabra)){
                System.out.println("¡Congratulations!");
                condicionBucle=false;
            }

            if (intento==5){
                System.out.println("Lo siento has superado los 5 intentos. La palabra secreta era "+palabra);
                condicionBucle=false;
            }
            intento++;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String palabra;
        System.out.println("Juego del LINGO");
        do {
            System.out.println("Escribr una palabra secreta: ");
            palabra = sc.nextLine().toLowerCase();
        }while (HangmanGame.palabraNoEspacio(palabra));
        HangmanGame.borrarConsola();
        iniciarLingo(sc,palabra);
        sc.close();
    }
}
