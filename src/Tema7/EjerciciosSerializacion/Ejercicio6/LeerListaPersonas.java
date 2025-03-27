package Tema7.EjerciciosSerializacion.Ejercicio6;

import Tema7.EjerciciosSerializacion.Persona;
import Tema7.MyMethodsAtributes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LeerListaPersonas {
    public static void main(String[] args) {
        ArrayList<Persona> listaPersonas;
        String dir= MyMethodsAtributes.newPathData;
        String fileOut="personas.dat";
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(dir+fileOut))) {
            listaPersonas = (ArrayList<Persona>) oi.readObject();
            System.out.println("Lista de personas de personas.dat:");
            for (Persona p : listaPersonas) {
                System.out.println(p);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer: " + e.getMessage());
        }
    }
}
