package Tema7.Ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/*
* Implementa un programa que lea un documento de texto y muestre por pantalla algunos datos
estadísticos: nº de líneas, nº de palabras, nº de caracteres y cuáles son las 10 palabras más
comunes (y cuántas veces aparecen). Prueba el programa con los archivos de la carpeta ‘Libros’*/
public class EjercicioB7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numLineas=0,numPalabras=0,numChars=0;
        String fileName=MyMethodsAtributes.introducirCadena(sc,"el nombre del archivo a analizar(ej: coplas_manrique.txt): ");
        Map<String,Integer> mapEstadistica=new Hashtable<>();

        try(BufferedReader br=new BufferedReader(new FileReader(MyMethodsAtributes.namePathBooks+fileName))) {
            String linea;
            while ((linea=br.readLine())!=null){
                numLineas++;
                numChars+=linea.length();
                String[] palabras=linea.replaceAll("[^a-zA-Záéíóúüñ]]","").split("\\s+");
                numPalabras+=palabras.length;

                for (String palabra : palabras){
                    if (!palabra.isEmpty()){
                        mapEstadistica.put(palabra,mapEstadistica.getOrDefault(palabra,0)+1);
                    }
                }
            }

            List<Map.Entry<String,Integer>> listPalabras=new ArrayList<>(mapEstadistica.entrySet());
            listPalabras.sort((a,b)-> b.getValue().compareTo(a.getValue()));
            System.out.println("Numero de lineas "+numLineas);
            System.out.println("Numero de palabras "+numPalabras);
            System.out.println("Numero de caracteres "+numChars);

            int cont=0;
            for (Map.Entry<String,Integer>entry : listPalabras){
                if (cont<10){
                    System.out.println(entry.getKey()+" : "+entry.getValue());
                }
                cont++;
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
