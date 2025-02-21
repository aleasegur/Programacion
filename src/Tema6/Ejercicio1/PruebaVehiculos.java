package Tema6.Ejercicio1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaVehiculos {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Vehiculo> lista = new ArrayList<>();
        boolean buclePrincipal=true;
        char opcion;
        while (buclePrincipal){
            showMenu();
            opcion=sc.next().toLowerCase().charAt(0);
            switch (opcion){
                case 'a':
                    instanciarVehiculo(sc,lista);
                    break;
                case 'b':
                    mostrarLista(lista,sc);
                    break;
                case 'c':
                    removeVehiculo(sc,lista);
                    break;
                case 'd':
                    System.out.println("Saliendo...");
                    buclePrincipal=false;
                    break;
                default:
                    System.err.println("Valor introducido incorrecto");
            }
        }
        sc.close();
    }

    //un sub menu en el que instanciar subclases de Vehiculo
    public static void subMenu(){
        System.out.println("a).Turismo");
        System.out.println("b).Camion");
        System.out.println("c).Ciclomotor");
        System.out.println("Elegir opcion: ");
    }

    //Metodo que introduzco la matricula
    public static String introducirMatricula(Scanner sc){
        String cadena="";
        try {
            do {
                System.out.println("Introduce la matricula(7 caracteres,los primeros 4 son numero, los ultimos 3 letras): ");
                cadena = sc.next();
            }while (!Vehiculo.checkMatricula(cadena));
        }catch (StringIndexOutOfBoundsException e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }catch (Exception e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }
        return cadena;
    }

    //Metodo String que devuelve un string de combustible
    public static String introducirCombustible(Scanner sc){
        String cadena="";
        int num;
        boolean entrar=true;
        //"gasolina","diesel","electrico","hidrogeno"
        while (entrar) {
            try {
                System.out.println("1.Gasolina");
                System.out.println("2.Diesel");
                System.out.println("3.Electrico");
                System.out.println("4.Hidrogeno");
                System.out.println("Elegir la opcion");
                num = sc.nextInt();
                switch (num) {
                    case 1:
                        cadena = "gasolina";
                        entrar=false;
                        break;
                    case 2:
                        cadena = "diesel";
                        entrar=false;
                        break;
                    case 3:
                        cadena = "electrico";
                        entrar=false;
                        break;
                    case 4:
                        cadena = "hidrogeno";
                        entrar=false;
                        break;
                    default:
                        System.err.println("Error con la eleccon elegida");
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.err.println("Error " + e.getMessage());
                e.printStackTrace();
                sc.nextLine();
            } catch (Exception e) {
                System.err.println("Error " + e.getMessage());
                e.printStackTrace();
                sc.nextLine();
            }
        }
        return cadena;
    }

    //Metodo que devuelve un int de ruedas
    public static int introducirRuedas(Scanner sc){
        int ruedas=0;
        try {
            do {
                System.out.println("Introduce el numero de ruedas: ");
                ruedas=sc.nextInt();
            }while (!Vehiculo.checkRuedas(ruedas));
        }catch (InputMismatchException e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }catch (Exception e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }
        return ruedas;
    }

    //Metodo que devuelve un int de plazas
    public static int introducirPlazas(Scanner sc){
        int num=0;
        try {
            do{
                System.out.println("Introducir el numero de plazas: ");
                num=sc.nextInt();
            }while (!Turismos.checkPlazas(num));
        }catch (InputMismatchException | ArithmeticException e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }catch (Exception e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }
        return num;
    }

    //Metodo que devuelve un tipouso
    public static TipoUso introducirTipoUso(Scanner sc){
        int num;
        TipoUso tipo=null;
        boolean entrar=true;
        //"profesional","particular"
        while (entrar){
            try {
                System.out.println("Introduce el tipo de uso del turismo: ");
                System.out.println("1.Profesional");
                System.out.println("2.Particular");
                System.out.println("Elegir la opcion");
                num = sc.nextInt();
                switch (num) {
                    case 1:
                        tipo=TipoUso.PROFESIONAL;
                        entrar=false;
                        break;
                    case 2:
                        tipo=TipoUso.PARTICULAR;
                        entrar=false;
                        break;
                    default:
                        System.err.println("Error con la eleccon elegida");
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.err.println("Error " + e.getMessage());
                e.printStackTrace();
                sc.nextLine();
            } catch (Exception e) {
                System.err.println("Error " + e.getMessage());
                e.printStackTrace();
                sc.nextLine();
            }
        }
        return tipo;
    }

    //Metodo que devuelve un int de peso
    public static int introducirPeso(Scanner sc){
        int num=0;
        try {
            do {
                System.out.println("Introduce el peso del camion: ");
                num = sc.nextInt();
            }while (!Camiones.checkPeso(num));
        }catch (InputMismatchException | ArithmeticException e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }catch (Exception e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }
        return num;
    }

    //devuelve un booleano
    public static boolean introducirEspeligroso(Scanner sc){
        boolean res=true,entrar=true;
        int num;
        while (entrar) {
            try {
                System.out.println("Introduce si es peligro o no la mercancia del camion: ");
                System.out.println("1.True");
                System.out.println("2.False");
                System.out.println("Elegir opcion: ");
                num = sc.nextInt();
                switch (num) {
                    case 1:
                        res = true;
                        entrar=false;
                        break;
                    case 2:
                        res=false;
                        entrar=false;
                        break;
                    default:
                        System.err.println("Ellecion elegido no correcta");
                }
            } catch (Exception e) {
                System.err.println("Error " + e.getMessage());
                e.printStackTrace();
                sc.nextLine();
            }
        }
        return res;
    }

    //devuelve un int
    public static int introducirCilindrada(Scanner sc){
        int num=0;
        try {
            do {
                System.out.println("Introduce la cilindrana del ciclomotor: ");
                num = sc.nextInt();
            }while (!Ciclomotor.checkCilindrana(num));
        }catch (InputMismatchException | ArithmeticException e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }catch (Exception e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }
        return num;
    }

    public static void instanciarVehiculo(Scanner sc,ArrayList<Vehiculo> lista){
        char opcion;
        String matricula="",combustible="";
        int ruedas=0;
        boolean entrar=true;
        while (entrar){
            try {
                subMenu();
                opcion=sc.next().toLowerCase().charAt(0);
                if (opcion=='a' || opcion=='b' || opcion=='c'){
                matricula=introducirMatricula(sc);
                combustible=introducirCombustible(sc);
                ruedas=introducirRuedas(sc);
                }
                switch (opcion){
                    case 'a':
                        int numPlazas=introducirPlazas(sc);
                        TipoUso tipoUso=introducirTipoUso(sc);
                        Turismos turismo=new Turismos(matricula,combustible,ruedas,numPlazas,tipoUso);
                        lista.add(turismo);
                        entrar=false;
                        break;
                    case 'b':
                        int peso=introducirPeso(sc);
                        boolean mercanciaPeligrosa=introducirEspeligroso(sc);
                        Camiones camion=new Camiones(matricula,combustible,ruedas,peso,mercanciaPeligrosa);
                        lista.add(camion);
                        entrar=false;
                        break;
                    case 'c':
                        int cilindrana= introducirCilindrada(sc);
                        Ciclomotor ciclomotor=new Ciclomotor(matricula,combustible,ruedas,cilindrana);
                        lista.add(ciclomotor);
                        entrar=false;
                        break;
                    default:
                        System.err.println("Error con la eleccion introducida");
                }
            }catch (InputMismatchException | ArithmeticException e){
                System.err.println("Error "+e.getMessage());
                e.printStackTrace();
                sc.nextLine();
            }catch (Exception e){
                System.err.println("Error "+e.getMessage());
                e.printStackTrace();
                sc.nextLine();
            }
        }
    }

    public static void mostrarLista(ArrayList<Vehiculo> lista,Scanner sc){
        int num;
        try {
            do {
                System.out.println("1.Turismo");
                System.out.println("2.Camion");
                System.out.println("3.Ciclomotor");
                System.out.println("Elegir opcion: ");
                num = sc.nextInt();
                if (num < 0 || num > 3) {
                    System.err.println("Valor introducido no correcto");
                }
            } while (num < 0 || num > 3);

            if (lista.isEmpty()){
                System.out.println("La lista esta vacia");
            }else {
                for (Vehiculo vehiculo : lista) {
                    if (num==1 && vehiculo instanceof Turismos ||
                            num==2 && vehiculo instanceof Camiones ||
                            num==3 && vehiculo instanceof Ciclomotor) {
                        System.out.println(vehiculo);
                    }else{
                        System.out.println("No hay vehiculos de ese tipo en la lista");
                    }
                }
            }
        }catch (InputMismatchException | ArithmeticException e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }
    }

    public static void removeVehiculo(Scanner sc,ArrayList<Vehiculo> lista){
        String matricula;
        try {
            matricula=introducirMatricula(sc);
            for (Vehiculo vehiculo : lista){
                if (vehiculo.getMatricula().equalsIgnoreCase(matricula)){
                    lista.remove(vehiculo);
                    System.out.println("Vehiculo eliminado");
                }else{
                    System.out.println("La matricula introducida no existe");
                }
            }
        }catch (StringIndexOutOfBoundsException e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }catch (Exception e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }
    }

    public static void showMenu(){
        System.out.println("a).Instanciar vehiculo");
        System.out.println("b).Mostrar vehiculo");
        System.out.println("c).Eliminar un vehiculo");
        System.out.println("d).Salir");
    }
}
