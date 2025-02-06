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
        System.out.println("""
                 1. Instanciar objetos de tipo Persona\s
                 2. Instanciar objetos de tipo Cuenta y asociarlo a una persona.
                 3. Mostrar datos de una persona (por su dni).
                 4. Recibir la nómina mensual de una persona (por dni y núm de cuenta).
                 5. Recibir un pago (por dni y núm de cuenta).
                 6. Realizar transferencia entre cuentas.
                 7. Imprimir las personas morosas.
                 8. Salir.
                 Eleger opcion: \
                """);
    }

    public static String arrayMostrar(Persona[] personas) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                sb.append(".");//Posicion vacia
            } else {
                sb.append("X");//Posicion ocupada
            }
            if (i < personas.length - 1) {
                sb.append(", ");//en cada espacio de la posicion pongo coma(,)
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //Metodo para instanciar y crear el objeto persona
    public static void instanciarPersona(Scanner sc,Persona[] personas,int numPersonas){
        String dni;
        do {
            dni = Persona.introducirDni(sc);
        } while (Persona.comprobarDniRepetido(dni, personas));
        if (numPersonas < personas.length) {
            personas[numPersonas] = new Persona(dni);
        }
        System.out.println(arrayMostrar(personas));
    }

    //Utilizo null para verificar si existe esa persona, lo gasto tambien para verificar si una cuenta existe en los metodos de mas abajo
    //Instanciar objetos de tipo Cuenta y asociarlo a una persona
    public static void instanciarAsociarCuenta(Scanner sc, Persona[] personas){
        String dni = Persona.introducirDni(sc);
        Persona persona=buscarPersona(dni,personas);
        if (persona!=null){
            persona.agregarCuenta(sc);
            System.out.println("Cuenta asociada correctamente a la persona con DNI " + dni);
        } else {
            System.err.println("Persona no encontrada.");
        }
    }

    //Recibir la nómina mensual de una persona (por dni y núm de cuenta).
    public static void recibirNomina(Persona[] personas, Scanner sc) {
        String dni = Persona.introducirDni(sc);
        Persona persona = buscarPersona(dni, personas);
        if (persona != null) {
            String iban = Cuenta.intoducirIban(sc);
            Cuenta cuenta = persona.buscarCuenta(iban);
            if (cuenta != null) {
                double dinero = Persona.introducirSaldo(sc);
                cuenta.depositarAbono(dinero);
                System.out.println("Nomina recibida.Nuevo saldo " + cuenta.getSaldo());
            } else {
                System.err.println("Cuenta no encontrada");
            }
        } else {
            System.err.println("Persona no encontrada");
        }
    }

    //Recibir un pago (por dni y núm de cuenta).
    public static void realizarPago(Scanner sc, Persona[] personas) {
        String dni = Persona.introducirDni(sc);
        Persona persona = buscarPersona(dni, personas);
        if (persona != null) {
            String iban = Cuenta.intoducirIban(sc);
            Cuenta cuenta = persona.buscarCuenta(iban);
            if (cuenta != null) {
                double dinero = Persona.introducirSaldo(sc);
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

    //Realizar transferencia entre cuentas
    public static void realizarTransferencia(Persona[] personas,Scanner sc){
        System.out.println("DNI Persona de origen");
        String dniOrigen = Persona.introducirDni(sc);
        Persona personaOrigen=buscarPersona(dniOrigen,personas);
        if (personaOrigen!=null){
            System.out.println("Iban cuenta de origen");
            String ibanOrigen = Cuenta.intoducirIban(sc);
            Cuenta cuentaOrigen=personaOrigen.buscarCuenta(ibanOrigen);
            if (cuentaOrigen!=null){
                System.out.println("Dni persona destinatario");
                String dniDestino = Persona.introducirDni(sc);
                Persona personaDestino=buscarPersona(dniDestino,personas);
                if (personaDestino!=null){
                    System.out.println("Iban cuenta destinatario");
                    String ibanDestino = Cuenta.intoducirIban(sc);
                    //Metodo que busco dentro del array de cuentas asociado a una persona si existe o no
                    //Creado para verificar si existe o no la cuenta o distintas cuentas
                    Cuenta cuentaDestino=personaDestino.buscarCuenta(ibanDestino);
                    if (cuentaDestino!=null){
                        System.out.println("---dinero a transferir---");
                        double dinero = Persona.introducirSaldo(sc);
                        //Utilizo el metodo pagar recibo para mostrar la transferencia en forma de recibo de banco
                        cuentaOrigen.pagarRecibo("Transferencia a"+ibanDestino,dinero);
                        cuentaDestino.depositarAbono(dinero);
                        System.out.println("Transferencia relaizada");
                        System.out.println("Nuevo saldo en la cuenta de origen " + cuentaOrigen.mostrarSaldo());
                        System.out.println("Nuevo saldo de la cuenta de destino " + cuentaDestino.mostrarSaldo());
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

    //Este metodo busca si la persona introducida por dni existe o no, si no existe salto un mensaje de error y devuele null
    public static Persona buscarPersona(String dni,Persona[] personas){
        for (Persona persona : personas) {
            if (persona!= null && persona.getDni().equals(dni)) {
                return persona;
            }
        }
        System.err.println("No se encontro a ninguna persona con el DNI: "+dni);
        return null;
    }

    //Mostrar datos de una persona (por su dni).
    public static void mostrarDatosPersona(Scanner sc,Persona[] personas){
        String dni = Persona.introducirDni(sc);
        Persona persona=buscarPersona(dni,personas);
        if (persona!=null) {
            persona.mostrarCuenta();
        }else{
            System.err.println("Persona no encontrada");
        }
    }

    //Imprimir las personas morosas
    public static boolean imprimirMorosos(Persona[] personas){
        boolean res=false;
        System.out.println("Personas morosas: ");
        for (Persona persona : personas) {
            if (persona!=null && persona.esMoroso()) {
                System.out.println("DNI: " + persona.getDni());
                res = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona[] personas = new Persona[Persona.NUMERO_DE_PERSONAS];
        int numPersonas = 0;
        int opcion;
        boolean condiconBucle = true;
        while (condiconBucle) {
            PruebaCuentas.showMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    if (numPersonas < personas.length) {
                        instanciarPersona(sc, personas, numPersonas);
                        numPersonas++;
                    } else {
                        System.err.println("No se puede crear mas personas");
                    }
                    break;
                case 2:
                    //__12(las dos primeras letras las que quieras)
                    //ES__(ultimos numeros el que quieras del 0-9)
                    //Verificar como comprubo el numero de cuenta
                    instanciarAsociarCuenta(sc, personas);
                    break;
                case 3:
                    mostrarDatosPersona(sc, personas);
                    break;
                case 4:
                    recibirNomina(personas, sc);
                    break;
                case 5:
                    realizarPago(sc, personas);
                    break;
                case 6:
                    realizarTransferencia(personas, sc);
                    break;
                case 7:
                    boolean moroso=imprimirMorosos(personas);
                    System.out.println("Hay morosos? "+moroso);
                    break;
                case 8:
                    System.out.println("Saliendo del progrma...");
                    condiconBucle = false;
                    break;
                default:
                    System.err.println("Opcion no valida. Intente de nuevo.");
            }
        }
        sc.close();
    }
}
