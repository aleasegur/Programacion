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
De 60.000 euros a 299.999 euros
A partir de 300.000 euros
45,0%
47,0%*/
public class Utils {
    public static double miles2kilometers(double miles){
        double res=0;
        double conversion= 1.609;
        res=miles*conversion;
        return res;
    }



}
