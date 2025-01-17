package Tema3.String;

/* ALEJANDRO ASENCIO GURAU
* Crea una clase MyString con las siguientes funciones y procedimientos:
 a) Una función que reciba una cadena y devuelva esta cadena
 invertida y en mayúsculas.
 b) Una función que reciba una cadena y devuelva el número de
 vocales.
 c) Una función que reciba una cadena y devuelva la palabra de
 mayor longitud.
 d) Una función que reciba dos cadenas y devuelva el número de
 veces que la segunda cadena está incluida en la primera.
 e) Una función que reciba una cadena y devuelva el número de
 palabras que contiene.
 f) Una función que reciba un número de teléfono, por ejemplo
 “34555332211” y lo convierta al formato (+34)-555-332211.
 g) Un procedimiento que reciba una cadena y muestre por pantalla
 el histograma de frecuencias de las vocales (las veces que se
 repiten). Por ejemplo*/
public class MyString {
    public static String invertirString(String cadena) {
        //return new StringBuilder(cadena.toUpperCase()).reverse().toString();
        String res = "";
        for (int i = cadena.length() - 1; i >= 0; i--) {
            res += cadena.toUpperCase().charAt(i);
        }
        return res;
    }

    public static int numeroVocales(String cadena) {
        int res = 0;
        String vocales = "aeiouAEIOU";
        for (int i = 0; i < cadena.length(); i++) {
            char carcter = cadena.charAt(i);
            if (vocales.indexOf(carcter) != -1) {
                res++;
            }
        }
        return res;
    }

    public static String mayorLongitud(String cadena) {
        String palabraMayor = "", palabraActual = "";
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            //Compruba si el carcter es un espacio
            if (Character.isWhitespace(caracter)) {
                if (palabraActual.length() >= palabraMayor.length()) {
                    palabraMayor = palabraActual;
                }
                palabraActual = "";
            } else {
                palabraActual += caracter;
            }
        }

        //Despues de rcorrer la cadena comparamos si la ultima palabra es mas larga que palabraMayor
        if (palabraActual.length() >= palabraMayor.length()) {
            palabraMayor = palabraActual;
        }

        return palabraMayor;

    }

    public static int contarVecesCadena(String cadena1, String cadena2){
        int res=0;
        int longitudCadena=cadena1.length();
        int longitudSubcadena=cadena2.length();
        for (int i = 0; i <=longitudCadena-longitudSubcadena; i++) {
            if (cadena1.substring(i,i+longitudSubcadena).equals(cadena2)){
                res++;
            }
        }
        return res;
    }

    public static int numeroPlabarasContiene(String cadena){
        int res=0;
        boolean esPalabra=false;
        for (int i = 0; i < cadena.length(); i++) {
            char caracter=cadena.charAt(i);
            if (Character.isWhitespace(caracter)){
                esPalabra=false;
            }else if (!esPalabra){
                res++;
                esPalabra=true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String ejem = "hola que tal estas";
        System.out.println(numeroPlabarasContiene(ejem));
    }
}
