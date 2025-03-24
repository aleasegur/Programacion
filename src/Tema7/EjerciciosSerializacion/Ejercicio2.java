package Tema7.EjerciciosSerializacion;

import Tema7.MyMethodsAtributes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String fileSearch= MyMethodsAtributes.introducirCadena(sc,"el nombre del fichero(ej:usuario.txt.txt): ");
        String directorio1=MyMethodsAtributes.namePath;
        String directorio2=MyMethodsAtributes.newPath;
        String directorio3=MyMethodsAtributes.namePathBooks;
        if (!fileRead(directorio1+fileSearch)){
            if (!fileRead(directorio2+fileSearch)){
                fileRead(directorio3+fileSearch);
            }
        }
        sc.close();
    }
    public static boolean fileRead(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Archivo no encontrado en: " + filePath);
            return false;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            return true;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
