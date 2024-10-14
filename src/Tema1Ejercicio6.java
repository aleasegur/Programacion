import java.util.Scanner;

public class Tema1Ejercicio6 {
    public static void main(String[] args) {
        double radio,area;

        Scanner sc=new Scanner(System.in);

        System.out.println("Introduce el valor del radio: ");
        radio=sc.nextDouble();
        area=Math.PI*radio*radio;
        System.out.println("El area del circulo es "+area);
    }
}
