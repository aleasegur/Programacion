package Tema3.Modular2;
/*ALEJANDRO ASENCIO GURAU
* 1. Crea una clase MyMath que tendrá funciones para calcular el perímetro y
el área de un círculo, cuadrado y rectángulo. Los nombres de las
funciones serán:
squarePerimeter
squareArea
rectanglePerimeter
rectangleArea
circlePerimeter
circleArea
2. Añade una función a MyMath que nos diga si un número es primo. Añade
otra función que nos diga si un número NO es primo (reutiliza código).
3. Añade a MyMath una función que nos indique el número de dígitos de un
número entero.
4. Añade a MyMath una función que devuelve el número de dígitos pares de
un número entero.
5. Añade a MyMath una función que devuelve el número de dígitos impares
de un número entero.
6. Añade a MyMath una función que nos calcule el factorial de un número.
7. Añade a MyMath una función que nos calcule el factorial de un número
(de manera recursiva).
8. Añade una función a MyMath que recibirá 3 coeficientes de una ecuación
de segundo grado y devolverá cuántas soluciones tiene la ecuación (2, 1
o 0).
Por ejemplo,
x ^ 2 + 2 x - 3 = 0 tiene dos soluciones (-3 y 1).
x ^ 2 + 3 x + 5 = 0 no tiene solución.
Recordemos que unaecuación de segundo grado: ax2 + bx + c = 0, puede tener una, dos o
ninguna solución. Depende del valor del Discriminante: D = b2 - 4ac.
D>0 Dos soluciones reales distintas.
D=0 Una solución.
D<0 No hay solución real.
9. Añade una función a MyMath que sume los dígitos de un número entero.
10.Crea un programa principal llamado Ejercicio10 donde utilices todas las
funciones creadas anteriormente dentro de MyMath.*/
public class MyMath {
    public static double circlePerimeter(double radio){
        double res=0;
        res=2*Math.PI*radio;
        return res;
    }

    public static double circleArea(double radio){
        double res=0;
        res=Math.PI*radio*radio;
        return res;
    }

    public static double squarePerimeter(double lado){
        double res=0;
        res=4*lado;
        return res;
    }

    public static double squareArea(double lado){
        double res=0;
        res=lado*lado;
        return res;
    }

    public static double rectanglePerimeter(double base,double altura){
        double res=0;
        res=2*(base+altura);
        return res;
    }

    public static double rectangleArea(double base,double altura){
        double res=0;
        res=base*altura;
        return res;
    }

    public static boolean esPrimo(int num){
        boolean res=true;
        if (num>1){
            for (int i = 2; i <=Math.sqrt(num) ; i++) {
                if (num%i==0){
                    res=false;
                }
            }
        }else {
            res=false;
        }
        return res;
    }

    public static boolean noEsPrimo(int num){
        boolean res=!esPrimo(num);
        return res;
    }

    public static int numeroDeDigitos(int num){
        int res=0;
        for (int i = num; i!=0; i/=10) {
            res++;
        }
        return res;
    }

    public static int contarDigitosPares(int num){
        int res=0;
        num=Math.abs(num);
        while (num > 0) {
            int digito = num % 10;
            if (digito % 2 == 0) {
                res++;
            }
            num /= 10;
        }
        return res;
    }


    public static int contarDigitosImpares(int num){
        int res=0;
        num=Math.abs(num);
        while (num > 0) {
            int digito = num % 10;
            if (digito % 2 != 0) {
                res++;
            }
            num /= 10;
        }
        return res;
    }

    public static int factorialNumero(int num){
        int res=1;
        for (int i = 1; i <=num ; i++) {
            res*=i;

        }
        return res;
    }

    public static int factorialNumeroRecursivo(int num){
        int res=0;
        if (num==0){
            res=1;
        }else {
            res=num*factorialNumeroRecursivo(num-1);
        }
        return res;
    }

    public static int ecuacionDeSegundoGrado(int num1,int num2,int num3){
        int res=0;
        int discriminante=num2*num2-4*num1*num3;
        if (discriminante>0){
            res=2;
            System.out.println("Numero de soluciones es "+res+" :");
            System.out.println("Primera solucion es "+(-num2 - Math.sqrt(discriminante)) / (2.0 * num1));
            System.out.println("Segunda solucion es "+(-num2 + Math.sqrt(discriminante)) / (2.0 * num1));
        }else if (discriminante==0){
            res=1;
            System.out.println("Numero de soluciones es "+res+" :");
            System.out.println("La solucion es "+-num2/(2.0*num1));
        }else {
            System.out.println("No hay solucion");
        }
        return res;
    }

    public static int sumarrNumeroDeDigitos(int num){
        int res = 0;
        num = Math.abs(num);
        while (num > 0) {
            // Extraigo el último dígito
            res += num % 10;
            // Elimino último dígito
            num /= 10;
        }
        return res;
    }

}
