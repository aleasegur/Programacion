package Tema4.GestionPersonasCuentas;

public class Persona {
    private String dni;
    private Cuenta[] cuentas;
    private int numCuentas;

    public Persona(String dni) {
        this.dni = dni;
        this.cuentas = new Cuenta[3];
        this.numCuentas=0;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (validarDni(dni)) {
            this.dni = dni;
        }else{
            System.err.println("El DNI introducido no es correcto");
        }
    }

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public boolean agregarCuenta(Cuenta cuenta){
        boolean res=false;
        if (numCuentas<3){
            cuentas[numCuentas]=cuenta;
            numCuentas++;
            res=true;
        }else{
            System.err.println("No se puede tener mas de 3 cuentas por persona");
        }
        return res;
    }

    public void mostrarCuenta(){
        System.out.println("DNI "+getDni());
        for (int i = 0; i < getCuentas().length; i++) {
            System.out.println("Cuenta "+(i+1)+": \nIBAN= "+getCuentas()[i].getIban()+"\nSaldo= "+getCuentas()[i].getSaldo());
        }
    }

    public boolean esMoroso(){
        boolean res=false;
        for (int i = 0; i < getCuentas().length; i++) {
            if (getCuentas()[i].getSaldo()<0){
                res=true;
            }
        }
        return res;
    }

    public static boolean validarDni(String dni) {
        boolean res=true;
        if (dni.length() != 9) {
            res = false;
        }
        String numero = dni.substring(0, 8);
        char letra = dni.charAt(8);

        if (!numero.matches("\\d{8}") && !Character.isLetter(letra)){
            res=false;
        }

        return res;
    }


}
