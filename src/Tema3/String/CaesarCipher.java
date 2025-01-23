package Tema3.String;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Crea una clase CaesarCipher para implementar el cifrado de Julio César con
tres funciones: encrypt (cifrar), decrypt (descifrar) y main. Julio César inventó
un cifrado para evitar que los mensajes pudieran ser leídos por cualquier
persona. El cifrado tiene las siguientes normas:
- Todo mensaje debe tener sus letras en mayúsculas.
- Se reemplaza cada letra por la siguiente del abecedario, excepto la Z
que se reemplaza por la A.
- Se reemplaza cada dígito por el siguiente dígito, excepto el 9 que se
reemplaza por 0.
- El resto de caracteres no se reemplazan.*/
public class CaesarCipher {

    public static String cifrarCaesar(String cadena){
        String res="";
        cadena=cadena.toUpperCase();
        for (int i = 0; i < cadena.length(); i++) {
            char caracter=cadena.charAt(i);
            if (Character.isLetter(caracter)){
                //Ciframos la letra con desplazamiento 1
                int posicion=(caracter-'A'+1)%26;
                res+=(char)('A'+posicion);
            }else if(Character.isDigit(caracter)){
                //ciframos el digito con desplazamiento 1
                int digito=(caracter-'0'+1)%10;
                res+=('0'+digito);
            }else {
                res+=caracter;
            }
        }
        return res;
    }

    public static String descifrarCaesar(String cadena){
        String res = "";
        cadena = cadena.toUpperCase();
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (Character.isLetter(caracter)) {
                // desciframos la letra con desplazamiento 1
                int posicion = (caracter - 'A' - 1 + 26) % 26;
                res += (char) ('A' + posicion);
            } else if (Character.isDigit(caracter)) {
                // desciframos el digito con desplazamiento 1
                int digito = (caracter - '0' - 1 + 10) % 10;
                res += (char) ('0' + digito);
            } else {
                res += caracter;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce un mensaje: ");
        String texto=sc.nextLine().toUpperCase();
        System.out.println("Texto original: "+texto);
        String textoCodificado=cifrarCaesar(texto);
        System.out.println("Texto codificado: "+textoCodificado);
        String textoDescod=descifrarCaesar(textoCodificado);
        System.out.println("Texto descodificado: "+textoDescod);
        sc.close();
    }
}
