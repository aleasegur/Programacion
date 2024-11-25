package Tema3;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Escribe un programa que muestre un menú con 9 opciones (si tus
ejercicios son modulares no debería costarte demasiado):
a) Muestra el signo de un número introducido por el usuario.
b) Indica si el usuario es mayor de edad o no.
c) Calcula el área y perímetro de un círculo.
d) Conversor de euros a dólares y de dólares a euros.
e) Mostrar tabla de multiplicar de un número.
f) Mostrar tablas de multiplicar del 1 al 10.
g) Comprobador de números primos.
h) Comprobador de fechas.
i) Dibujar triángulos.
*/
public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char opcion;
        boolean condicionMenu = true;
        while (condicionMenu) {
            System.out.println("---MENU INTERACTIVO---");
            System.out.println("a) Muestra el signo de un número introducido por el usuario.\n" +
                    "b) Indica si el usuario es mayor de edad o no.\n" +
                    "c) Calcula el área y perímetro de un círculo.\n" +
                    "d) Conversor de euros a dólares y de dólares a euros.\n" +
                    "e) Mostrar tabla de multiplicar de un número.\n" +
                    "f) Mostrar tablas de multiplicar del 1 al 10.\n" +
                    "g) Comprobador de números primos.\n" +
                    "h) Comprobador de fechas.\n" +
                    "i) Dibujar triángulos. \n" +
                    "s) Salir. ");
            System.out.println("---------------");
            System.out.println("Elige una opcion: ");
            opcion = sc.next().toLowerCase().charAt(0);
            switch (opcion) {
                case 'a':
                    int num;
                    System.out.println("---COMPROBACION DE NUMERO POSITIVO,NEGATIVO O 0---");
                    System.out.println("Introduce un numero: ");
                    num = sc.nextInt();
                    if (Ejercicio1.numberSign(num)==0){
                        System.out.println("El numero es 0.");
                    }else if (Ejercicio1.numberSign(num)>=1){
                        System.out.println("El numero es positivo. ");
                    }else {
                        System.out.println("El numero negativo.");
                    }
                    break;
                case 'b':
                    int edad;
                    System.out.println("Introduce tu edad: ");
                    edad=sc.nextInt();
                    if(Ejercicio2.isAdult(edad)){
                        System.out.println("Es mayor de edad");
                    }else {
                        System.out.println("Es menor edad");
                    }
                    System.out.println("Numero asignado es "+Ejercicio1.numberSign(edad));
                    break;
                case 'c':
                    double radius;
                    double resultArea=0,resultPerim=0;
                    System.out.println("Ingrese el radio del circulo: ");
                    radius=sc.nextDouble();
                    if (Ejercicio3.validRadius(radius)){
                        resultArea=Ejercicio3.calculateCircleArea(radius);
                        resultPerim=Ejercicio3.calculateCirclePerimeter(radius);
                        System.out.println("Perimetro: "+resultPerim);
                        System.out.println("Area: "+resultArea);
                    }else {
                        System.err.println("El radio es negativo.Debe ser positivo");
                    }
                    break;
                case 'd':
                    double dinero = 0;
                    char opcionD, opcionConversion;
                    boolean condConversion = true, condAccionConversor;
                    double dolarAeuro = 0, euroAdolar = 0;
                    while (condConversion) {
                        System.out.println("---CONVERSOR DE DINERO(€/$)---");
                        System.out.println("u.Utilizar");
                        System.out.println("s.Salir");
                        System.out.println("--------------------------------");
                        System.out.println("Elige una opcion: ");
                        opcion = sc.next().toLowerCase().charAt(0);
                        switch (opcion) {
                            case 'u':
                                do {
                                    System.out.println("Introduce la cantidad de dinero que quieres conversar: ");
                                    dinero = sc.nextDouble();
                                    if (dinero <= 0) {
                                        System.out.println("Error el saldo no debe ser negativo o 0");
                                    } else {
                                        dolarAeuro = Ejercicio4.dollar2euro(dinero);
                                        euroAdolar = Ejercicio4.euro2dollar(dinero);
                                    }
                                } while (dinero <= 0);
                                condAccionConversor=true;
                                while (condAccionConversor) {
                                    System.out.println("d.Dolar");
                                    System.out.println("e.Euro");
                                    System.out.println("--------");
                                    System.out.println("Elige una opcion: ");
                                    opcionConversion = sc.next().toLowerCase().charAt(0);
                                    switch (opcionConversion) {
                                        case 'd':
                                            System.out.println("Tu dinero en euros: " + dinero + " €" + " a dolares es " + dolarAeuro + " $");
                                            condAccionConversor = false;
                                            break;
                                        case 'e':
                                            System.out.println("Tu dinero en dolares: " + dinero + " $" + " a euros es " + euroAdolar + " €");
                                            condAccionConversor = false;
                                            break;
                                        default:
                                            System.out.println("ERROR: VUELVA A INTRODUCIR LA ACCION");
                                    }
                                }
                                break;
                            case 's':
                                System.out.println("Saliendo del programa...");
                                condConversion = false;
                                break;
                            default:
                                System.err.println("Eleccion no reconocida.Vuelva a introducir la opcion correcta");
                        }
                    }
                    break;
                case 'e':
                    int numE;
                    char opcionE;
                    boolean condicion=true;
                    while (condicion) {
                        do {
                            System.out.println("Introduce un numero para mostrar su tabla de multiplicacion: ");
                            numE = sc.nextInt();
                            if (Ejercicio5.comprobarNumeroMultiplicacion(numE)) {
                                Ejercicio5.tablaMultiplicar(numE);
                            } else {
                                System.out.println("Error: debe introducir un numero entre 1 y 10");
                            }
                        }while (!Ejercicio5.comprobarNumeroMultiplicacion(numE));
                        do {
                            System.out.println("Desea volver a realizar una tabla de multiplicacion(s/n)");
                            opcion=sc.next().toLowerCase().charAt(0);
                            switch (opcion){
                                case 's':
                                    break;
                                case 'n':
                                    System.out.println("Saliendo...");
                                    condicion=false;
                                    break;
                                default:
                                    System.out.println("ERROR: CARACTER NO RECONOCIDO.VUELVA A INTRODUCIR");
                            }
                        }while (opcion!='s' && opcion!='n');
                    }
                    break;
                case 'f':
                    Ejercicio6.mostrarTablasMultiplicarUnoAlDiez();
                    break;
                case 'g':
                    int numG=0;
                    do {
                        System.out.println("Introduce un numero mayor a 1(Para salir introduzca 0)");
                        numG=sc.nextInt();
                        if (numG==0){
                            System.out.println("Saliendo...");
                        }else if (Ejercicio7.comprobarNumerosPrimos(numG)){
                            System.out.println(numG+" es primo");
                        }else {
                            System.out.println(numG+" no es primo");
                        }
                    }while (numG!=0);
                    break;
                case 'h':
                    int dia,mes,age;
                    System.out.println("Introduce el numero de un dia: ");
                    dia=sc.nextInt();
                    System.out.println("Introduce el numero del mes: ");
                    mes=sc.nextInt();
                    System.out.println("Introduce un año: ");
                    age=sc.nextInt();

                    if (Ejercicio8.comprobarFecha(mes,age,dia)){
                        System.out.println("La fecha introducida es correcta");
                        System.out.println(dia+"/"+mes+"/"+age);
                    }else {
                        System.out.println("La fecha introducida es incorrecta");
                        System.out.println(dia+"/"+mes+"/"+age);
                    }
                    break;
                case 'i':
                    int numI;
                    char car;
                    System.out.println("Introduce las lineas que quieres: ");
                    num = sc.nextInt();
                    System.out.println("Introduce el caracter que deseas: ");
                    car = sc.next().charAt(0);
                    Ejercicio9.imprimirPiramide(num, car);
                    break;
                case 's':
                    System.out.println("Saliendo...");
                    condicionMenu = false;
                    break;
                default:
                    System.err.println("CARACTER NO RECONOCIDO. VUELVE A INTRODUCIR");
            }
        }
        sc.close();
    }
}
