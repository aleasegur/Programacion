package Tema2;

/*ALEJANDRO ASENCIO GURAU
* (OPCIONAL) Seguro que haces cálculos de más en el ejercicio 27…
Intenta optimizarlo. Pista: si el número que estoy viendo si es primo es
el 101, ¿tiene sentido probar a dividir entre 100? Es poco probable que
el número anterior lo pueda dividir… ¿Cuántos hay que seguro que no
podrán dividirlo?*/
public class Tema2Ejercicio31 {
    public static void main(String[] args) {
        boolean esPrimo;
        int num = 2, cantPrim = 0;
        while (cantPrim < 20) {
            esPrimo = true;
            //Si es par o mayor a 2 no es primo
            if (num > 2 && num % 2 == 0) {
                esPrimo = false;
            } else {
                //comprueba si es divisible con algun numero impar desde 3 hasta la raiz de num
                for (int i = 3; i <= Math.sqrt(num); i += 2) {
                    if (num % i == 0) {
                        esPrimo = false;
                    }
                }
            }
            if (esPrimo == true) {
                System.out.println(num + " ");
                cantPrim++;
            }
            num++;
        }
    }
}
