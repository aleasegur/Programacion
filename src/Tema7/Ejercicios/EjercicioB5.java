package Tema7.Ejercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Implementa un programa que cree la carpeta ‘Diccionario’ con tantos archivos como letras del
abecedario(A.txt,B.txt…Z.txt). Introducirá en cada archivo las palabras de‘diccionario.txt’que
comiencen por dicha letra.*/
public class EjercicioB5 {
    public static void main(String[] args) {
        String carpeta="Diccionario";
        String fileDiccionario="diccionario.txt";
        //Map que almacena lista de palabras por cada letra
        Map<Character, List<String>> mapPalabras=new HashMap<>();

        File directorio=new File(carpeta);
        if (!directorio.exists()){
            directorio.mkdir();
        }

        for (char letra='A';letra<='Z';letra++){
            mapPalabras.put(letra,new ArrayList<>());
        }

        try(BufferedReader br=new BufferedReader(new FileReader(MyMethodsAtributes.namePath+fileDiccionario))) {
            String palabra;
            while ((palabra=br.readLine())!=null){
                palabra=palabra.trim();
                if (!palabra.isEmpty()){
                    char primeraLetra=Character.toUpperCase(palabra.charAt(0));
                    if (mapPalabras.containsKey(primeraLetra)){
                        mapPalabras.get(primeraLetra).add(palabra);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        //Escribir cada lista de palabras con su archivo
        for (char letra='A';letra<='Z';letra++){
            File fileLetra=new File(carpeta+"/"+letra+".txt");
            try(BufferedWriter bw=new BufferedWriter(new FileWriter(fileLetra))) {
                for (String palabra : mapPalabras.get(letra)){
                    bw.write(palabra);
                    bw.newLine();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        System.out.println("Archivos generados en la carpeta 'Diccionario'");
    }
}
