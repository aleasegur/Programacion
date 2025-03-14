package Tema7.Ejercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/*
* Implementa un programa que genere aleatoriamente nombres de persona (combinando nombres
y apellidos de ‘usa_nombres.txt’ y ‘usa_apellidos.txt’). Se le pedirá al usuario cuántos nombres de
persona desea generar y a qué archivo añadirlos (por ejemplo ‘usa_personas.txt’).*/
public class EjercicioB4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random randdom=new Random();

        String fileNames= MyMethodsAtributes.introducirCadena(sc,"el archivo de nombres(ej: usa_nombres.txt): ");
        String fileLastName= MyMethodsAtributes.introducirCadena(sc,"el archivo de apellidos(ej: usa_apellidos.txt): ");
        int cantidad= MyMethodsAtributes.introducirEntero(sc,"la cantidad de nombres y apellidos a generar: ");
        String fileOut= MyMethodsAtributes.introducirCadena(sc,"el archivo de salida(ej: personas_nuevas.txt): ");

        List<String> listNames=readFile(fileNames);
        List<String> listLastNames=readFile(fileLastName);

        if (listNames.isEmpty() && listLastNames.isEmpty()){
            System.err.println("ERROR: No se puede leer listNames o listLastNames");
        }

        try(BufferedWriter bw=new BufferedWriter(new FileWriter(fileOut,true))) {
            for (int i = 0; i < cantidad; i++) {
                //coge un nombre y apellido aleatorios accediendo a las listas.
                String nombreAlea=listNames.get(randdom.nextInt(listNames.size()))+" "+listLastNames.get(randdom.nextInt(listLastNames.size()));
                bw.write(nombreAlea);
                bw.newLine();
            }
            System.out.println("Se han generado "+cantidad+" nombres y apellidos en "+fileOut);
        }catch (IOException e){
            e.printStackTrace();
        }
        sc.close();
    }

    //Metodo para leer nombres y apellidos desde un archivo
    public static List<String> readFile(String nameFile){
        List<String> lista=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new FileReader(MyMethodsAtributes.namePath+nameFile))) {
            String linea;
            while ((linea=br.readLine())!=null){
                lista.add(linea.trim());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return lista;
    }
}
