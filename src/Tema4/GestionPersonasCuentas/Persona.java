package Tema4.GestionPersonasCuentas;

import java.util.Arrays;
import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Crear una clase Persona, que se caracteriza por un DNI y un array de cuentas bancarias. La
 Persona puede tener asociada hasta 3 cuentas bancarias, y debe tener un método que permita
 añadir cuentas (hasta 3 que es el máximo). También debe contener un método que devuelva
si la persona es morosa (si tienen alguna cuenta con saldo negativo).*/
public class Persona {
    private String dni;
    //Pienso que el array de Cuentas su incializacion no se puede modificar, ya que el enunciado deja claro que solo 3 cuentas
    private final Cuenta[] cuentas;
    //Atributo que asegura que la cantidad de personas a instanciar en PruebaCuentas sea la solicitado o como quieras
    public static final int NUMERO_DE_PERSONAS=10;
    //Atributo final para que sean 3 cuentas bancarias sin opcion a modificar durante la ejecuion del programa
    public static final int NUMERO_DE_CUENTAS_BANCARIAS=3;

    //Constructor por defecto
    public Persona(){
        dni="12345678J";
        cuentas=new Cuenta[NUMERO_DE_CUENTAS_BANCARIAS];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i]=new Cuenta();
        }
    }

    //Constructor por parametros
    public Persona(String dni) {
        if (validarDni(dni)) {
            this.dni = dni.toUpperCase();
        }else{
            System.err.println("El DNI introducido no es correcto");
        }
        //Aqui instancio cuentas con la longtitud del array
        this.cuentas=new Cuenta[NUMERO_DE_CUENTAS_BANCARIAS];
        //en caso de que no se asocio e instancia la cuenta con Persona,
        // utilizaremos el constructor por defecto creado en Cuenta
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i]=new Cuenta();
        }
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (validarDni(dni)) {
            this.dni = dni.toUpperCase();
        }else{
            System.err.println("El DNI introducido no es correcto");
        }
    }

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    //Lo he ehcho con un procedimiento no se si es mejor cambiarlo a un metodo de tipo cuenta o booleano
    public void agregarCuenta(Scanner sc){
        for (int i = 0; i < cuentas.length; i++) {
            System.out.println("---IBAN CUENTA "+(i+1)+"---");
            String iban;
            do {
                iban = Cuenta.intoducirIban(sc);
            }while (Cuenta.comprobarIbanRepetido(iban,cuentas));
            double dinero=Cuenta.introducirSaldo(sc);
            cuentas[i] = new Cuenta(iban, dinero);
        }
    }

    public void mostrarCuenta(){
        System.out.println("DNI "+getDni());
        for (int i = 0; i < cuentas.length; i++) {
            System.out.println("Cuenta "+(i+1)+": \nIBAN= "+getCuentas()[i].getIban()+"\nSaldo= "+getCuentas()[i].getSaldo());
        }
    }

    public boolean esMoroso(){
        for (Cuenta cuenta : getCuentas()) {
            if (cuenta.getSaldo() < 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean validarDni(String dni) {
        boolean res=true;
        if (dni==null || dni.length()!=9) {
            System.err.println("El DNI debe tener 9 caracteres");
            res = false;
        }else {
            String numero = dni.substring(0, 8);
            char letra = dni.charAt(8);

            if (!numero.matches("\\d{8}")) {
                System.err.println("El DNI debe tener 8 digitosd y una letra");
                res = false;
            }

            if (!Character.isLetter(letra)) {
                System.err.println("El DNI debe tener una letra al final");
                res = false;
            }
        }

        return res;
    }

    //Metodo que buscar dentro del array de cuentas asociado a una persona si existe o no
    public Cuenta buscarCuenta(String iban){
        for (Cuenta cuenta : cuentas){
            if (cuenta!=null && cuenta.getIban().equals(iban)){
                return cuenta;
            }
        }
        return null;
    }

    public static String introducirDni(Scanner sc){
        String dni;
        do {
            System.out.println("Introduce el DNI:");
            dni=sc.next().toUpperCase();
        }while (!Persona.validarDni(dni));
        return dni;
    }

    public static boolean comprobarDniRepetido(String dbi,Persona[] personas){
        boolean res=false;
        for (Persona persona : personas){
            if (persona!=null && persona.getDni().equals(dbi)){
                System.err.println("El DNI introducido ya existe. Vuelva a introducir otro");
                res=true;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", cuentas=" + Arrays.toString(cuentas) +
                '}';
    }
}
