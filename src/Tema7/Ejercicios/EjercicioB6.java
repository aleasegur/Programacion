package Tema7.Ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
* Implementa un programa que pida al usuario un número de cualquier longitud,como por ejemplo
“1234”, y lediga al usuario si dicho número aparece en el primer millón de decimales del nºpi
(están en el archivo‘pi-million.txt’).No está permitido utilizar ninguna librería ni clase ni método
que realice la búsqueda. Debes implementar el algoritmo de búsqueda tú. */
public class EjercicioB6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String nameFile="pi-million.txt";
        String numSearch=MyMethodsAtributes.introducirCadena(sc,"el numero a buscado en los decimales de pi: ");
        String piDecimales=leerArchivo(nameFile);

        if (piDecimales.isEmpty()){
            System.err.println("No se puede leer el archivo de pi");
        }

        //Algoritmo de busqueda manual
        boolean buscado=false;
        //Recooro hasta piDecimales-numSearch para que la comparacion no exceda la longitud del string
        for (int i = 0; i < piDecimales.length()-numSearch.length(); i++) {
            boolean coincide=true;
            for (int j = 0; j < numSearch.length(); j++) {
                //Comparo cada caracter de numSearch con la parte correspondiente de piDecimales
                //Lo uso para obtener cada caracter en la subcadena de piDecimales comparando a numSearch
                if (piDecimales.charAt(i+j)!=numSearch.charAt(j)){
                    coincide=false;
                }
            }
            if (coincide){
                buscado=true;
            }
        }

        if (buscado){
            System.out.println("El nmero "+numSearch+" aparece en los primeros millones decimales de pi");
        }else{
            System.out.println("El nmero "+numSearch+" no aparece en los primeros millones decimales de pi");
        }

    }

    public static String leerArchivo(String file){
        StringBuilder piDeci=new StringBuilder();
        try(BufferedReader br=new BufferedReader(new FileReader(MyMethodsAtributes.namePath+file))){
            String linea;
            while ((linea=br.readLine())!=null){
                piDeci.append(linea.trim());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return piDeci.toString();
    }
}
