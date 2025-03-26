package Tema7.EjerciciosSerializacion;

import Tema7.MyMethodsAtributes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String dir1=MyMethodsAtributes.namePath;
        String dir2=MyMethodsAtributes.newPath;
        String dir3=MyMethodsAtributes.namePathBooks;
        String fileSearch= MyMethodsAtributes.introducirCadena(sc,"el archivo que buscas(ej: usuario.txt): ");
        int totalPalabras=contarPalabras(dir1+fileSearch);

        if (totalPalabras == -1) {
            totalPalabras = contarPalabras(dir2 + fileSearch);
            if (totalPalabras==-1){
                totalPalabras=contarPalabras(dir3+fileSearch);
            }
        }

        if (totalPalabras >= 0) {
            System.out.println("El archivo contiene " + totalPalabras + " palabras.");
        } else {
            System.out.println("No se pudo encontrar el archivo en ninguno de los directorios.");
        }


    }

    public static int contarPalabras(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Archivo no encontrado en: " + filePath);
            return -1;
        }

        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                // Dividir la linea en palabras usando espacios como separadores
                String[] palabras = linea.trim().split("\\s+");

                // Evitar contar una linea vacia como una palabra
                if (!linea.trim().isEmpty()) {
                    contador += palabras.length;
                }
            }
            //System.out.println("Archivo encontrado en: " + filePath);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return -1;
        }

        return contador;
    }

}
