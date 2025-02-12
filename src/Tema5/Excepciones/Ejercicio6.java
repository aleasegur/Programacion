package Tema5.Excepciones;

import java.util.Scanner;

public class Ejercicio6 {
    public static String arrayMostrar(Gato[] gatos) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < gatos.length; i++) {
            if (gatos[i] == null) {
                sb.append(".");//Posicion vacia
            } else {
                sb.append("X");//Posicion ocupada
            }
            if (i < gatos.length - 1) {
                sb.append(", ");//en cada espacio de la posicion pongo coma(,)
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void instanciarGato(Scanner sc,Gato[] gatos,int numGatos) throws Exception {
        String name;
        int edad;
        System.out.println("Introduce el nombre del gato: ");
        name=sc.next();
        System.out.println("Introduce la edad del gato: ");
        edad= sc.nextInt();
        if (numGatos<gatos.length){
            gatos[numGatos]=new Gato(name,edad);
        }
        System.out.println(arrayMostrar(gatos));
    }

    public static void mostrarGatos(Gato[] gatos){
        for (Gato gato : gatos){
            if (gato!=null){
                gato.imprimir();
            }
        }
    }

    public static void cambiarValoresGato(Gato[] gatos,Scanner sc)throws Exception{
        String name;
        int edad,numModulo;
        System.out.println(arrayMostrar(gatos));
        try {
            System.out.println("Elige que gato quieres cambiar los valores(1-10,selecciona las casillas marcadas en X): ");
            numModulo = sc.nextInt() - 1;
            System.out.println("Introduce el nombre del gato: ");
            name = sc.next();
            System.out.println("Introduce la edad del gato: ");
            edad = sc.nextInt();
            gatos[numModulo].setName(name);
            gatos[numModulo].setEdad(edad);
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
        }
    }

    public static void showMenu(){
        System.out.println("a).Instanciar Gatos");
        System.out.println("b).Cambiar valores de un gato");
        System.out.println("c).Mostrar gatos");
        System.out.println("d).Salir");
        System.out.println("Elegir opcion: ");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int numGatos=0;
        char opcion;
        Gato[] gatos=new Gato[10];
        boolean bucle=true;
        while (bucle){
            showMenu();
            opcion=sc.next().toLowerCase().charAt(0);
            switch (opcion){
                case 'a':
                    if (numGatos<gatos.length){
                        instanciarGato(sc,gatos,numGatos);
                        numGatos++;
                    }else {
                        System.err.println("No se puede crear mas gatos");
                    }
                    break;
                case 'b':
                    cambiarValoresGato(gatos,sc);
                    break;
                case 'c':
                    mostrarGatos(gatos);
                    break;
                case 'd':
                    System.out.println("Saliendo...");
                    bucle=false;
                    break;
                default:
                    System.err.println("Opcion incorrecta, vuelva a introducirlo");
            }
        }
    }
}
