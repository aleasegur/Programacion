package Tema4.GestionPersonasCuentas;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Crear una clase Cuenta la cual se caracteriza por tener asociado un número de cuenta y un
saldo disponible. Además, se debe poder consultar el saldo disponible en cualquier
momento, recibir abonos y pagar recibos.*/
public class Cuenta {
    private String iban;
    private double saldo;

    //Constructor por defecto
    public Cuenta(){
        iban="ES0000";
        saldo=0;
    }

    //Constructor por parametros
    public Cuenta(String iban, double saldo) {
        if (validarIban(iban)) {
            this.iban = iban;
        }else{
            System.err.println("Iban incorrecto");
        }
        //En saldo se tendria que comprobar que el saldo no sea negativo, pero para comporbar las personas morosas se tendria que dejar
        this.saldo=saldo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        if (validarIban(iban)) {
            this.iban = iban;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    //Metodo para pagar un reciboutilizo String
    //Comprubo si el saldo es mayor a la cantidad a pagar y si es asi lo resto por esa cantidad y muestro un mensaje
    //SUGERENCIA (tendre que utilizar String.format PARA EL MENSAJE)
    public String pagarRecibo(String idRecibo,double cantidad){
        String res="";
        if (this.saldo>=cantidad){
            this.saldo-=cantidad;
            res="Retiro realizado: "+cantidad+" de la cuenta "+idRecibo;
        }else{
            System.err.println("Fondos insuficientes");
        }
        return res;
    }


    public double depositarAbono(double cantidad){
        double res;
        this.saldo+=cantidad;
        res=this.saldo;
        return res;
    }

    public String mostrarSaldo(){
        return "Saldo disponible en la cuenta "+getIban()+" es de "+getSaldo();
    }

    public static boolean validarIban(String iban){
        boolean res=true;
        //se que un iban son 24 carcteres, es para no hacerlo largo
        if (iban.length()!=6){
            System.out.println("EL IBAN DEBE TENER 6 caracteres");
            res=false;
        }

        if (!Character.isLetter(iban.charAt(0)) || !Character.isLetter(iban.charAt(1))) {
            System.err.println("Los dos primeros caracteres del IBAN deben ser letras.");
            res= false;
        }

        //utilizo .matches para comprobar la cadena si coincide con el patron
        //\\d representa carcter numerico, y {4} el patron anterior \\d se debe currir 4 veces(se que un iban son 24 de caracteres)
        String restoIban = iban.substring(2);
        if (!restoIban.matches("\\d{4}")) {
            System.err.println("Los ultimos 6 caracteres del IBAN deben ser numeros.");
            res= false;
        }

        return res;
    }

    public static String intoducirIban(Scanner sc){
        String iban;
        do {
            System.out.println("Introduce el iban: ");
            iban=sc.next().toUpperCase();
        }while (!Cuenta.validarIban(iban));
        return iban;
    }

    public static double introducirSaldo(Scanner sc){
        double res;
        /*Coemntado para hacer pruebas
        do {
            System.out.println("Introduce la cantidad de dinero: ");
            res=sc.nextDouble();
            if (res<=0){
                System.err.println("El dinero a ingresar no debe ser menor o igual a 0");
            }
        }while (res<=0);*/
        System.out.println("Introduce la cantidad de dinero: ");
        res=sc.nextDouble();
        return res;
    }

    public static boolean comprobarIbanRepetido(String iban,Cuenta[] cuenta){
        boolean res=false;
        for (Cuenta cuentas : cuenta){
            if (cuentas!=null && cuentas.getIban().equals(iban)){
                System.err.println("El IBAN introducido ya existe. Vuelva a introducir otro");
                res=true;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "iban='" + iban + '\'' +
                ", saldo=" + saldo +
                '}';
    }

}
