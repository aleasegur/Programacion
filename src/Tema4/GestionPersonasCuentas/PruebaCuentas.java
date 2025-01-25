package Tema4.GestionPersonasCuentas;

import java.util.Scanner;



public class PruebaCuentas {

    public static String introducirDni(Scanner sc){
        String dni;
        do {
            System.out.println("Introduce el DNI:");
            dni=sc.next().toUpperCase();
        }while (Persona.validarDni(dni));
        return dni;
    }

    public static String intoducirIban(Scanner sc){
        String iban;
        do {
            System.out.println("Introduce el iban: ");
            iban=sc.next().toUpperCase();
        }while (Cuenta.validarIban(iban));
        return iban;
    }

    public static int instanciarPersona(Scanner sc,Persona[] personas,int numPersonas){
        int res=numPersonas;
        String dni=introducirDni(sc);
        Persona persona=new Persona(dni);
        personas[res]=persona;
        res++;
        return res;
    }

    public static void instanciarAsociarCueenta(Scanner sc,Persona[] personas,int numPersonas){
        String dni=introducirDni(sc);
        Persona persona=buscarPersona(dni,personas,numPersonas);
        if (persona!=null){
            String iban=intoducirIban(sc);
            System.out.println("Introduce el saldo de la cuenta: ");
            double saldo=sc.nextDouble();
            Cuenta cuenta=new Cuenta(iban,saldo);
            persona.agregarCuenta(cuenta);
            System.out.println("Cuenta asociada correctamente a la persona con DNI " + dni);
        } else {
            System.err.println("Persona no encontrada.");
        }
    }

    public static Persona buscarPersona(String dni,Persona[] personas,int numPersona){
        for (int i = 0; i < numPersona; i++) {
            if (personas[i].getDni().equals(dni)){
                return personas[i];
            }
        }
        return null;
    }

    public static void mostrarDatosPersona(Scanner sc,Persona[] personas,int numPersona){
        String dni=introducirDni(sc);
        Persona persona=buscarPersona(dni,personas,numPersona);
        if (persona!=null) {
            persona.mostrarCuenta();
        }else{
            System.err.println("Persona no encontrada");
        }
    }

    public static boolean imprimirMorosos(Persona[] personas,int numPersona){
        boolean res=false;
        System.out.println("Personas morosas: ");
        for (int i = 0; i < numPersona; i++) {
            if (personas[i].esMoroso()){
                System.out.println("DNI: "+personas[i].getDni());
                res=true;
            }
        }
        if (!res){
            System.out.println("No hay morosos");
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Persona[] personas=new Persona[3];
        int numPersonas=0;
    }
}
