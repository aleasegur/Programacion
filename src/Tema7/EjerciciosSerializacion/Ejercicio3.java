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
        String directorio1=MyMethodsAtributes.namePath;
        String directorio2=MyMethodsAtributes.newPath;
        String directorio3=MyMethodsAtributes.namePathBooks;
        String fileSearch= MyMethodsAtributes.introducirCadena(sc,"el archivo que buscas(ej: usuario.txt): ");

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
            System.out.println("Archivo encontrado en: " + filePath);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return -1;
        }

        return contador;
    }

}
