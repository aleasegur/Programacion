package Tema7.Ejercicios;

import java.io.*;
import java.util.*;

/*Implementa un programa que pida al usuario un nombrede archivo A para lectura y otro nombre
de archivo B para escritura.Leerá el contenido delarchivo A(por ejemplo‘usa_personas.txt’)ylo
escribirá ordenado alfabéticamente en B (por ejemplo ‘usa_personas_sorted.txt’).*/
public class EjercicioB3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //MyMethos es una clase que contiene metodos
        String fileInput=MyMethods.introducirCadena(sc,"entrada");
        String fileOutput=MyMethods.introducirCadena(sc,"salida");
        List<String> listaLines=new ArrayList<>();

        //Lee el archivo de entrada
        try(BufferedReader br=new BufferedReader(new FileReader("Documentos/"+fileInput))) {
            String lineas;
            while ((lineas=br.readLine())!=null){
                listaLines.add(lineas);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        //Ordena la listaLines alfabeticamente
        Collections.sort(listaLines);

        //Escribir archivo de salida
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(fileOutput))) {
            for (String linea :listaLines){
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Archivo ordenado y guardado en "+fileOutput);
        }catch (IOException e){
            e.printStackTrace();
        }
        sc.close();
    }

}
