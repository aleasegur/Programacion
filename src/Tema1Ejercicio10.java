//ALEJANDRO ASENCIO GURAU
/*Implementa en Java una clase llamada Tema1Ejercicio10 que pida por
teclado 2 números reales y muestre por pantalla el resultado de su
suma, producto, resto y división.
*/
import java.util.Scanner;
public class Tema1Ejercicio10 {
    public static void main(String[] args) {
        double num1,num2,suma,resta,producto,div=0,resto=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el valor del primer numero: ");
        num1=sc.nextDouble();
        System.out.println("Introduce el valor del segundo numero: ");
        num2=sc.nextDouble();

        suma=num1+num2;
        resta=num1-num2;
        producto=num1*num2;
        if (num2==0){
            System.err.println("ERROR: NO SE PUEDE DIVIDIR POR CERO");
        }else if (num1>num2){
            div=num1/num2;
            resto=num1%num2;
        }else {
            System.err.println("ERROR: EL DIVISOR NO PUEDE SER MAYOR AL DIVIDENDO");
        }

        System.out.println("Suma: "+suma+
                "\nResta: "+resta+
                "\nProducto: "+producto+
                "\nDivision: "+div+
                "\nResiduo: "+resto);

    }
}
