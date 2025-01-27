package Tema4.GestionPersonasCuentas;
/*ALEJANDRO ASENCIO GURAU
* Crear una clase Persona, que se caracteriza por un DNI y un array de cuentas bancarias. La
 Persona puede tener asociada hasta 3 cuentas bancarias, y debe tener un método que permita
 añadir cuentas (hasta 3 que es el máximo). También debe contener un método que devuelva
si la persona es morosa (si tienen alguna cuenta con saldo negativo).*/
public class Persona {
    private String dni;
    private Cuenta[] cuentas;

    public Persona(){
        dni="12345678J";
        cuentas=new Cuenta[3];
    }

    public Persona(String dni) {
        this.dni = dni.toUpperCase();
        this.cuentas=new Cuenta[3];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = new Cuenta(); // Objeto vacío
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

    public boolean agregarCuenta(Cuenta cuenta){
        boolean res=false;
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] =new Cuenta(cuenta.getIban(),cuenta.getSaldo());
            res= true;
        }
        return res;
    }

    public void mostrarCuenta(){
        System.out.println("DNI "+getDni());
        for (int i = 0; i < cuentas.length; i++) {
            System.out.println("Cuenta "+(i+1)+": \nIBAN= "+getCuentas()[i].getIban()+"\nSaldo= "+getCuentas()[i].getSaldo());
        }
    }

    public boolean esMoroso(){
        boolean res=false;
        for (int i = 0; i < cuentas.length; i++) {
            if (getCuentas()[i].getSaldo()<0){
                res=true;
            }
        }
        return res;
    }

    public static boolean validarDni(String dni) {
        boolean res=true;
        if (dni.length() != 9) {
            System.err.println("El DNI debe tener 9 caracteres");
            res = false;
        }
        String numero = dni.substring(0, 8);
        char letra = dni.charAt(8);

        if (!numero.matches("\\d{8}") && !Character.isLetter(letra)){
            System.out.println("El DNI debe tener 8 digitosd y una letra");
            res=false;
        }

        return res;
    }

    public Cuenta buscarCuenta(String iban){
        for (Cuenta cuenta : cuentas){
            if (cuenta!=null && cuenta.getIban().equals(iban)){
                return cuenta;
            }
        }
        return null;
    }


}
