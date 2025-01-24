package Tema4.Ejercicio2;

import java.util.Scanner;

public class Mainejer2 {
    public static Persona crearPersona(Scanner sc){
        int edad;
        String dni,nombre,apellidos;

        System.out.println("Introduce tu nombre: ");
        nombre=sc.next();
        System.out.println("Introduce tus apellidos: ");
        apellidos=sc.next();

        do {
            System.out.println("Introduce tu edad: ");
            edad = sc.nextInt();
        }while (!edadNoNegativo(edad));

        do {
            System.out.println("Introduce tu dni: ");
            dni = sc.next().toUpperCase();
            if (!Persona.checkDNI(dni)){
                System.err.println("DNI introducido no correcto. Vuelva a introducirlo");
            }
        }while (!Persona.checkDNI(dni));

        return new Persona(nombre,apellidos,dni,edad);
    }

    public static boolean edadNoNegativo(int edad){
        boolean res=true;
        if (edad<=0){
            System.err.println("La edad no puede ser menor o igual a 0");
            res=false;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Persona persona1=crearPersona(sc);
        Persona persona2=crearPersona(sc);

        int diferenciaEdad;

        System.out.println("---DATOS//PRIMERA PERSONA---");
        persona1.print();
        System.out.println("Es mayor de edad "+persona1.isAdult());
        System.out.println("Esta jubilado "+persona1.isRetired());

        System.out.println("---DATOS//SEGUNDA PERSONA");
        persona2.print();
        System.out.println("Es mayor de edad "+persona2.isAdult());
        System.out.println("Esta jubilado "+persona2.isAdult());

        diferenciaEdad= persona1.ageDifference(persona2);
        System.out.println("La edad de diferencia entre las dos persoanas es de "+diferenciaEdad);

    }
}
