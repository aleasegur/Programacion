package Tema3.Modular3;
/*ALEJANDRO ASENCIO GURAU
*1. Crea una clase Utils que contendrá diferentes funciones y realiza las
siguientes funciones, no repitas código.
2. Añade a Utils una función miles2kilometers que convierta millas a
kilometros.
3. Añade a Utils una función getTaxes que dada una cantidad en euros y un
porcentaje devuelva el valor del impuesto a aplicar. El valor debe
devolver siempre dos decimales.
Por ejemplo, los impuestos si le paso 1 € y 21% es 0,21 €.
Para redondear un número a dos decimales puedes hacer lo siguiente
(intenta entender cómo funciona):
Math.round(numero * 100) / 100.0;
4. Añade a Utils una función getNetPrice que recibe una cantidad en euros
y un porcentaje de impuestos y devuelve esa cantidad más el impuesto.
Por ejemplo, el importe si le paso 1 € y 21% es 1,21 €.
5. Añade a Utils una función getCoins que le pases una cantidad en euros y
te devuelve las monedas con las que llegar a esa cantidad en un único
número entero.
Por ejemplo, 3,37 € serían:
1 de 2€
1 de 1€
0 de 50cts
2 de 20cts
0 de 10cts
1 de 5cts
1 de 2 cts
0 de 1ct.
Por tanto el valor devuelto será 11020110.
6. Añade a Utils una función llamada getNIF que te calcule el NIF (o la letra
del DNI). Para obtenerla se divide el número del entre 23 y el resto se
codifica con una letra. Siendo la correspondencia:
0 - T, 1 - R, 2 - W, 3 - A, 4 - G, 5 - M, 6 - Y, 7 - F, 8 - P, 9 - D,10 - X, 11 - B, 12 -
N, 13 - J, 14 - Z, 15 - S, 16 - Q, 17 - V, 18 - H, 19 - L, 20 - C, 21 - K, 22 - E
7. Añade a Utils una función que reciba el número del DNI y NIF y
compruebe si dicho par son correctos. Llama a la función isValidNIF.
8. (OPCIONAL) Haz una función que calcule el IRPF a partir de un salario
anual. Llama a la función calculateIRPF.
TRAMO TIPO
Hasta 12.450 euros 19,0%
De 12.450 euros a 20.199 euros 24,0%
De 20.200 euros a 35.199 euros 30,0%
De 35.200 euros a 59.999 euros 37,0%
De 60.000 euros a 299.999 euros 45,0%
A partir de 300.000 euros 47,0%*/
public class Utils {

    public static double miles2kilometers(double miles){
        double res=0;
        double conversion= 1.609;
        res=miles*conversion;
        return res;
    }

    public static double getTaxes(double precio,double porcentaje){
       double res=0;
       double impuesto=precio*(porcentaje/100);
       res=Math.round(impuesto*100)/100.0;
       return res;
    }

    public static double getNetPrice(double precio,double porcentaje){
        double res;
        double valorImpuesto=porcentaje/100;
        res=precio*(1+valorImpuesto);
        return res;
    }

    public static int getCoins(double cantEuros){
        int res=0;
        // Convertimos la cantidad a centimos para evitar problemas del tipo de variables
        int cantCent = (int) Math.round(cantEuros * 100);

        int monedasDe2Euros = 0, monedasDe1Euro = 0,monedasDe50Cent = 0,monedasDe20Cent = 0,
                monedasDe10Cent = 0,monedasDe5Cent = 0,monedasDe2Cent = 0, monedasDe1Cent = 0;

        monedasDe2Euros = cantCent / 200;
        cantCent %= 200;

        monedasDe1Euro = cantCent / 100;
        cantCent %= 100;

        monedasDe50Cent = cantCent / 50;
        cantCent %= 50;

        monedasDe20Cent = cantCent / 20;
        cantCent %= 20;

        monedasDe10Cent = cantCent / 10;
        cantCent %= 10;

        monedasDe5Cent = cantCent / 5;
        cantCent %= 5;

        monedasDe2Cent = cantCent / 2;
        cantCent %= 2;

        monedasDe1Cent = cantCent;

        res= Integer.parseInt(String.format("%d%d%d%d%d%d%d%d", monedasDe2Euros,monedasDe1Euro,monedasDe50Cent, monedasDe20Cent,monedasDe10Cent, monedasDe5Cent,monedasDe2Cent,monedasDe1Cent));
        return res;
    }

    public static char getNIF(String dni){
        String letrasDni="TRWAGMYFPDXBNJZSQVHLCKE";
        char res=0;
        int dniNumerico=Integer.parseInt(dni);
        int indice=dniNumerico%23;
        res=letrasDni.charAt(indice);
        return res;
    }

    public static boolean isValidNIF(String dni){
        boolean res=false;
            String letrasDni = "TRWAGMYFPDXBNJZSQVHLCKE";
            //Extraer los primeros 9 caracteres
            String numDni = dni.substring(0, 8);
            //Extraer los primeros 8 caracteres
            char letraIntroducida = dni.charAt(8);

            //Convertir los primeros 8 caracteres en numeros entero
            int valDni = Integer.parseInt(numDni);
            //calcular la letra correspondiente
            char letraVal = letrasDni.charAt(valDni % 23);

            res = letraVal == letraIntroducida;
        return res;
    }

    public static double calculateIRPF(double salario){
        double res = 0;

        if (salario <= 12450) {
            res = salario * 0.19;
        } else {
            res = 12450 * 0.19;
            salario -= 12450;
        }

        if (salario <= 7750) {
            res += salario * 0.24;
        } else {
            res += 7750 * 0.24;
            salario -= 7750;
        }

        if (salario <= 15000) {
            res += salario * 0.30;
        } else {
            res += 15000 * 0.30;
            salario -= 15000;
        }

        if (salario <= 14800) {
            res += salario * 0.37;
        } else {
            res += 14800 * 0.37;
            salario -= 14800;
        }

        if (salario > 0) {
            res += salario * 0.45;
        }

        return res;
    }
}
