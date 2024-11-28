package Tema3;
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
        res=2*lado;
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
        }
        return res;
    }

    public static boolean noEsPrimo(int num){
        boolean res=false;
        if (num>1){
            for (int i = 2; i <=Math.sqrt(num) ; i++) {
                if (num%i==0){

                }else {
                    res=true;
                }
            }
        }
        return res;
    }



}
