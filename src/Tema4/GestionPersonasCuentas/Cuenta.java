package Tema4.GestionPersonasCuentas;

import javax.swing.plaf.PanelUI;

public class Cuenta {
    private String iban;
    private double saldo;

    public Cuenta(String iban, double saldo) {
        setIban(iban);
        setSaldo(saldo);
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
        if (iban.length()!=24){
            System.out.println("EL IBAN DEBE TENER 24 caracteres");
            res=false;
        }

        if (!Character.isLetter(iban.charAt(0)) || !Character.isLetter(iban.charAt(1))) {
            System.err.println("Los dos primeros caracteres del IBAN deben ser letras.");
            res= false;
        }

        //utilizo .matches para comprobar la cadena si coincide con el patron
        //\\d representa carcter numerico, y {22} el patron anterior \\d se debe currir 22 veces
        String restoIban = iban.substring(2);
        if (!restoIban.matches("\\d{22}")) {
            System.err.println("Los ultimos 22 caracteres del IBAN deben ser numeros.");
            res= false;
        }

        return res;
    }

}
