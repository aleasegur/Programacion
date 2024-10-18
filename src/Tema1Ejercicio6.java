import java.util.Scanner;
/*Realiza una nueva clase en Java en el proyecto Programacion llamada
Tema1Ejercicio6 que calcule el área de un círculo. Debe seguir el
esquema del siguiente ordinograma.*/
public class Tema1Ejercicio6 {
    public static void main(String[] args) {
        double radio, area;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el valor del radio: ");
        radio = sc.nextDouble();
        area = Math.PI * radio * radio;
        System.out.println("El area del circulo es " + area);
    }
}
