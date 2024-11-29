package Tema3.Modular2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Crea un programa principal llamado Ejercicio10(Lo he cambiado por Ejercicio10MyMath) donde utilices todas las
funciones creadas anteriormente dentro de MyMath.*/
public class Ejercicio10 {
    public static void showMenu(){
        System.out.println("---MENU INTERACTIVO---");
        System.out.println("Menú de opciones:");
        System.out.println("a) Calcular el perímetro y área de un círculo, cuadrado o rectángulo.");
        System.out.println("b) Comprobar si un número es primo o no primo.");
        System.out.println("c) Determinar el número de dígitos de un número entero.");
        System.out.println("d) Contar el número de dígitos pares de un número entero.");
        System.out.println("e) Contar el número de dígitos impares de un número entero.");
        System.out.println("f) Calcular el factorial de un número (iterativo o recursivo).");
        System.out.println("g) Determinar cuántas soluciones tiene una ecuación cuadrática.");
        System.out.println("h) Sumar los dígitos de un número entero.");
        System.out.println("s) Salir.");
        System.out.println("---------------");
        System.out.println("Elige una opcion: ");
    }

    //Metodo que en caso que la opcion selecciona es s o n. Sale o no sale del bucle de cada caso
    public static boolean pedirOtraVez(Scanner sc) {
        char opcion;
        boolean res = false;
        do {
            System.out.println("¿Desea volver a introducir un número (s/n)? ");
            opcion = sc.next().toLowerCase().charAt(0);
            switch (opcion) {
                case 's':
                    res = true;
                    break;
                case 'n':
                    res = false;
                    break;
                default:
                    System.err.println("CARACTER NO RECONOCIDO. VUELVA A INTRODUCIR");
            }
        } while (opcion != 's' && opcion != 'n');
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char opcion;
        boolean condicionBuclePrincipal=true;
        while (condicionBuclePrincipal){
            showMenu();
            opcion=sc.next().toLowerCase().charAt(0);
            switch (opcion){
                case 'a':
                    double radio,lado,base,altura;
                    char opcionA;
                    boolean condicionCaseA=true;
                    while (condicionCaseA) {
                        System.out.println("---CALCULOR PERIMETRO Y AREA---");
                        System.out.println("a)Circulo. "+"\nb)Cuadrado"+"\nc)Rectangulo"+"\ns)Salir");
                        opcionA=sc.next().toLowerCase().charAt(0);
                        switch (opcionA) {
                            case 'a':
                                do {
                                    System.out.println("Introduce el valor del radio: ");
                                    radio=sc.nextDouble();
                                    if (radio<=0){
                                        System.err.println("El radio no puede ser menor o igual a 0.VUELVA A INTRODUCIRLO");
                                    }
                                }while (radio<=0);
                                System.out.println("El area del circulo es "+MyMath.circleArea(radio));
                                System.out.println("El perimetro del circulo es "+MyMath.circlePerimeter(radio));
                                break;
                            case 'b':
                                do {
                                    System.out.println("Introduce el valor del lado del cuadrado: ");
                                    lado=sc.nextDouble();
                                    if (lado<=0){
                                        System.err.println("El lado no puede ser menor o igual a 0. VUELVA A INTRODUCIRLO");
                                    }
                                }while (lado<=0);
                                System.out.println("El area del cuadrado es "+MyMath.squareArea(lado));
                                System.out.println("El perimetro del cuadrado es "+MyMath.squarePerimeter(lado));
                                break;
                            case 'c':
                                do {
                                    System.out.println("Introduce el valor de la base del rectangulo: ");
                                    base=sc.nextDouble();
                                    System.out.println("Introduce el valor de la altura del rectangulo: ");
                                    altura=sc.nextDouble();
                                    if (altura<=0 && base<=0){
                                        System.err.println("Error la base o altura no debe ser menor o igual a 0");
                                    }
                                }while (altura<=0 && base<=0);
                                System.out.println("El area del rectangulo es "+MyMath.rectangleArea(base,altura));
                                System.out.println("El perimetro del rectangulo es "+MyMath.rectanglePerimeter(base,altura));
                                break;
                            case 's':
                                System.out.println("Saliendo de la opcion A...");
                                condicionCaseA=false;
                                break;
                            default:
                                System.err.println("Error valor no reconocido. VUELVA A INTRODUCIRLO");
                        }
                    }
                    break;
                case 'b':
                    int numB;
                    boolean condicionCaseB=true;
                    while (condicionCaseB) {
                        do {
                            System.out.println("Introduce el valor de un numero: ");
                            numB = sc.nextInt();
                            if (numB <= 1) {
                                System.out.println("Si el numero es menor o igual a 1 no es primo. Vuelva a introducir");
                            }
                        } while (numB <= 1);
                        boolean result1B = MyMath.esPrimo(numB);
                        boolean result2B = MyMath.noEsPrimo(numB);
                        if (result1B) {
                            System.out.println("El numero " + numB + " es primo");
                        } else if (result2B) {
                            System.out.println("El numero " + numB + " no es primo");
                        }
                        if (!pedirOtraVez(sc)) {
                            System.out.println("Saliendo del caso B...");
                            condicionCaseB = false;
                        }
                    }
                    break;
                case 'c':
                    int numC,resultC;
                    boolean condicionCaseC=true;
                    while (condicionCaseC){
                            System.out.println("Introduce un numero: ");
                            numC=sc.nextInt();
                            resultC=MyMath.numeroDeDigitos(numC);
                        System.out.println("El numero de digitos de "+numC+" es "+resultC);
                        if (!pedirOtraVez(sc)) {
                            System.out.println("Saliendo del caso C...");
                            condicionCaseC = false;
                        }
                    }
                    break;
                case 'd':
                    int numD, resultD;
                    boolean condicionCaseD = true;
                    while (condicionCaseD) {
                        System.out.println("Introduce un numero: ");
                        numD = sc.nextInt();
                        resultD = MyMath.contarDigitosPares(numD);
                        System.out.println("Los digitos pares que hay en el numero " + numD + " son " + resultD);
                        if (!pedirOtraVez(sc)) {
                            System.out.println("Saliendo del caso D...");
                            condicionCaseD = false;
                        }
                    }
                    break;
                case 'e':
                    int numE, resultE;
                    boolean condicionCaseE = true;
                    while (condicionCaseE) {
                        System.out.println("Introduce un numero: ");
                        numE = sc.nextInt();
                        resultE = MyMath.contarDigitosImpares(numE);
                        System.out.println("Los digitos impares que hay en el numero " + numE + " son " + resultE);
                        if (!pedirOtraVez(sc)) {
                            System.out.println("Saliendo del caso D...");
                            condicionCaseE = false;
                        }
                    }
                    break;
                case 'f':
                    int numF = 0, resultF;
                    boolean condicionCaseF = true;
                    char opcionF;
                    while (condicionCaseF) {
                        System.out.println("--TIPOS DE FACTORIAL(SEGUN EL METODO EMPLEADO)--");
                        System.out.println("a)Iterativo. " + "\nb)Recursivo." + "\nc)Salir.");
                        opcionF = sc.next().toLowerCase().charAt(0);
                        if (opcionF != 'c') {
                            System.out.println("Introduce un numero: ");
                            numF = sc.nextInt();
                        }
                        switch (opcionF) {
                            case 'a':
                                resultF = MyMath.factorialNumero(numF);
                                System.out.println("El factorial iterativo de " + numF + " es " + resultF);
                                break;
                            case 'b':
                                resultF = MyMath.factorialNumeroRecursivo(numF);
                                System.out.println("El factorial iterativo de " + numF + " es " + resultF);
                                break;
                            case 'c':
                                System.out.println("Saliendo del caso F...");
                                condicionCaseF = false;
                                break;
                            default:
                                System.err.println("Carcter no reconocido. Vuelva a introducirlo");
                        }
                    }
                    break;
                case 'g':
                    //Para comprobar 2 soluciones(1,2,-3) y para una solucion(1,2,1)
                    int num1G,num2G,num3G,resultG;
                    boolean condicionCaseG=true;
                    while (condicionCaseG) {
                        System.out.println("Introduce un valor al primer numero: ");
                        num1G = sc.nextInt();
                        System.out.println("Introduce un valor al segundo numero: ");
                        num2G = sc.nextInt();
                        System.out.println("Introduce un valor al tercer numero: ");
                        num3G = sc.nextInt();
                        resultG = MyMath.ecuacionDeSegundoGrado(num1G, num2G, num3G);
                        System.out.println(resultG);
                        if (!pedirOtraVez(sc)){
                            System.out.println("Saliendo del caso G...");
                            condicionCaseG=false;
                        }
                    }
                    break;
                case 'h':
                    int numH,resultH;
                    boolean condicionCaseH=true;
                    while (condicionCaseH) {
                        do {
                            System.out.println("Introduce un numero: ");
                            numH = sc.nextInt();
                            if (numH <= 0) {
                                System.err.println("Error el numero introducido es menor o igual a 0. VUELVAS A INTRODUCIR");
                            }
                        } while (numH <= 0);
                        resultH = MyMath.sumarrNumeroDeDigitos(numH);
                        System.out.println("La suma de los digitos de " + numH + " es " + resultH);
                        if (!pedirOtraVez(sc)){
                            System.out.println("Saliendo del caso H...");
                            condicionCaseH=false;
                        }
                    }
                    break;
                case 's':
                    System.out.println("Saliendo del programa...");
                    condicionBuclePrincipal=false;
                    break;
                default:
                    System.err.println("VALOR INTRODUCIDO NO VALIDO. VUELVELO A INTRODUCIR");
            }
        }
        sc.close();
    }
}
