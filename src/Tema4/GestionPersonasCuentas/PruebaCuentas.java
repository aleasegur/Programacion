package Tema4.GestionPersonasCuentas;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
*  Crear una clase PruebaCuentas con un menú que nos permita
 1. Instanciar objetos de tipo Persona
2. Instanciar objetos de tipo Cuenta y asociarlo a una persona.
 3. Mostrar datos de una persona (por su dni).
 4. Recibir la nómina mensual de una persona (por dni y núm de cuenta).
 5. Recibir un pago (por dni y núm de cuenta).
 6. Realizar transferencia entre cuentas.
 7. Imprimir las personas morosas*/

public class PruebaCuentas {

    public static void showMenu() {
        System.out.println(" 1. Instanciar objetos de tipo Persona \n" +
                " 2. Instanciar objetos de tipo Cuenta y asociarlo a una persona.\n" +
                " 3. Mostrar datos de una persona (por su dni).\n" +
                " 4. Recibir la nómina mensual de una persona (por dni y núm de cuenta).\n" +
                " 5. Recibir un pago (por dni y núm de cuenta).\n" +
                " 6. Realizar transferencia entre cuentas.\n" +
                " 7. Imprimir las personas morosas.\n" +
                " 8. Salir.\n" +
                " Eleger opcion: ");
    }

    public static String introducirDni(Scanner sc){
        String dni;
        do {
            System.out.println("Introduce el DNI:");
            dni=sc.next().toUpperCase();
        }while (!Persona.validarDni(dni));
        return dni;
    }

    public static String intoducirIban(Scanner sc){
        String iban;
        do {
            System.out.println("Introduce el iban: ");
            iban=sc.next().toUpperCase();
        }while (!Cuenta.validarIban(iban));
        return iban;
    }


    public static void instanciarPersona(Scanner sc,Persona[] personas){
        for (int i = 0; i < personas.length; i++) {
            String dni = introducirDni(sc);
            personas[i] = new Persona(dni);
            System.out.println("Persona añadida correctamente con DNI " + dni);
        }
    }

    public static void instanciarAsociarCuenta(Scanner sc, Persona[] personas){
        String dni=introducirDni(sc);
        Persona persona=buscarPersona(dni,personas);
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

    public static void reacibirNomina(Persona[] personas, Scanner sc) {
        String dni = introducirDni(sc);
        Persona persona = buscarPersona(dni, personas);
        if (persona != null) {
            String iban = intoducirIban(sc);
            Cuenta cuenta = persona.buscarCuenta(iban);
            if (cuenta != null) {
                System.out.println("Introduce la cantidad de dinero: ");
                double dinero = sc.nextDouble();
                cuenta.depositarAbono(dinero);
                System.out.println("Nomina recibida.Nuevo saldo " + cuenta.getSaldo());
            } else {
                System.err.println("Cuenta no encontrada");
            }
        } else {
            System.err.println("Persona no encontrada");
        }
    }

    public static void realizarPago(Scanner sc, Persona[] personas) {
        String dni = introducirDni(sc);
        Persona persona = buscarPersona(dni, personas);
        if (persona != null) {
            String iban = intoducirIban(sc);
            Cuenta cuenta = persona.buscarCuenta(iban);
            if (cuenta != null) {
                System.out.println("Introduce la cantidad de dinero: ");
                double dinero = sc.nextDouble();
                if (cuenta.getSaldo() >= dinero) {
                    cuenta.pagarRecibo("Pago", dinero);
                    System.out.println("Pago realizado con exito. Nuevo saldo: " + cuenta.getSaldo());
                } else {
                    System.out.println("Saldo insuficiente.");
                }
            } else {
                System.err.println("Cuenta no encontrada");
            }
        } else {
            System.err.println("Persona no encontrada");
        }
    }

    public static void realizarTransferencia(Persona[] personas,Scanner sc){
        System.out.println("DNI Persona de origen");
        String dniOrigen=introducirDni(sc);
        Persona personaOrigen=buscarPersona(dniOrigen,personas);
        if (personaOrigen!=null){
            System.out.println("Iban cuenta de origen");
            String ibanOrigen=intoducirIban(sc);
            Cuenta cuentaOrigen=personaOrigen.buscarCuenta(ibanOrigen);
            if (cuentaOrigen!=null){
                System.out.println("Dni persona destinatario");
                String dniDestino=introducirDni(sc);
                Persona personaDestino=buscarPersona(dniDestino,personas);
                if (personaDestino!=null){
                    System.out.println("Iban cuenta destinatario");
                    String ibanDestino=intoducirIban(sc);
                    Cuenta cuentaDestino=personaDestino.buscarCuenta(ibanDestino);
                    if (cuentaDestino!=null){
                        System.out.println("Introduce el dinero a transferir: ");
                        double dinero=sc.nextDouble();
                        if (cuentaOrigen.getSaldo()>=dinero){
                            cuentaOrigen.pagarRecibo("Transferencia a"+ibanDestino,dinero);
                            cuentaDestino.depositarAbono(dinero);
                            System.out.println("Transferencia relaizada");
                            System.out.println("Nuevo saldo en la cuenta de origen " + cuentaOrigen.getSaldo());
                            System.out.println("Nuevo saldo de la cuenta de destino " + cuentaDestino.getSaldo());
                        } else {
                            System.err.println("Saldo insuficieente de " + cuentaOrigen.getIban() + " perteneciente de " + personaOrigen.getDni());
                        }
                    }else{
                        System.err.println("El iban de la persona de destino asociada no existe.");
                    }
                }else{
                    System.err.println("El dni de la persona de destino asociada no existe.");
                }
            }else{
                System.err.println("El iban de la cuenta origen asociada no existe.");
            }
        }else{
            System.err.println("El dni de la persona de origen asociada no existe.");
        }
    }

    public static Persona buscarPersona(String dni,Persona[] personas){
        for (int i = 0; i < personas.length; i++) {
            if (personas[i].getDni().equals(dni) && personas[i]!=null){
                return personas[i];
            }
        }
        System.err.println("No se encontro a ninguna persona con el DNI: "+dni);
        return null;
    }

    public static void mostrarDatosPersona(Scanner sc,Persona[] personas){
        String dni=introducirDni(sc);
        Persona persona=buscarPersona(dni,personas);
        if (persona!=null) {
            persona.mostrarCuenta();
        }else{
            System.err.println("Persona no encontrada");
        }
    }

    public static boolean imprimirMorosos(Persona[] personas){
        boolean res=false;
        System.out.println("Personas morosas: ");
        for (int i = 0; i < personas.length; i++) {
            if (personas[i].esMoroso() && personas[i]!=null){
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
        int opcion;
        boolean condiconBucle = true;
        while (condiconBucle) {
            showMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    instanciarPersona(sc, personas);
                    break;
                case 2:
                    //ES912100041845020005133_(ultimo numero el que quieras del 0-9)
                    //ES91210004184502000513__(ultimos numeros el que quieras del 0-9)
                    //Comprobar al introducir sin repetir 24 numeros
                    instanciarAsociarCuenta(sc, personas);
                    break;
                case 3:
                    mostrarDatosPersona(sc, personas);
                    break;
                case 4:
                    reacibirNomina(personas, sc);
                    break;
                case 5:
                    realizarPago(sc, personas);
                    break;
                case 6:
                    realizarTransferencia(personas, sc);
                    break;
                case 7:
                    boolean moroso=imprimirMorosos(personas);
                    System.out.println(moroso);
                    break;
                case 8:
                    System.out.println("Saliendo del progrma...");
                    condiconBucle = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        sc.close();
    }
}
