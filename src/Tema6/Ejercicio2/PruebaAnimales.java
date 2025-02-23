package Tema6.Ejercicio2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaAnimales {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Animal> lista=new ArrayList<>();
        boolean buclePrincipal = true;
        char opcion;
        while (buclePrincipal) {
            try {
                showMenu();
                opcion = sc.next().toLowerCase().charAt(0);
                switch (opcion) {
                    case 'a':
                        addAnimales(sc, lista);
                        break;
                    case 'b':
                        mostrarLista(lista,sc);
                        break;
                    case 'c':
                        ejecutarAcciones(lista,sc);
                        break;
                    case 'd':
                        System.out.println("Saliendo...");
                        buclePrincipal = false;
                        break;
                    default:
                        System.err.println("Opcion incorrecta");
                }
            } catch (Exception e) {
                System.err.println("Error " + e.getMessage());
                e.printStackTrace();
                sc.nextLine();
            }
        }
        sc.close();
    }

    public static void showMenu() {
        System.out.println("a).Instanciar Animales");
        System.out.println("b).Mostrar Animales.");
        System.out.println("c).Acciones animales.");
        System.out.println("d).Salir.");
    }

    public static void addAnimales(Scanner sc, ArrayList<Animal> lista) {
        String name;
        int edad, opcion;
        double peso, altura;
        boolean bucle = true;
        while (bucle) {
            try {
                showSubmenu();
                opcion = sc.nextInt();
                name = introducirCadena(sc, "nombre");
                edad = introducirInt(sc, "edad");
                peso = introducirDouble(sc, "peso");
                altura = introducirDouble(sc, "altura");
                switch (opcion) {
                    case 1:
                        System.out.println("---CANARIO---");
                        boolean vuela = introducirBooleano(sc, "vuela el canario");
                        String color = introducirCadena(sc, "color del canario");
                        Canario canario = new Canario(name, edad, peso, altura, color, vuela);
                        lista.add(canario);
                        bucle = false;
                        break;
                    case 2:
                        System.out.println("---COCODRILO---");
                        int dientes = introducirInt(sc, "cuantos dientes tiene el cocodrilo");
                        boolean escamas = introducirBooleano(sc, "tien escamas el cocodrilo");
                        Cocodrilo cocodrilo = new Cocodrilo(name, edad, peso, altura, dientes, escamas);
                        lista.add(cocodrilo);
                        bucle = false;
                        break;
                    case 3:
                        System.out.println("---GATO---");
                        String colorPatron = introducirCadena(sc, "color y patron del gato");
                        String colorOjos = introducirCadena(sc, "color de los ojos del gato");
                        Gato gato = new Gato(name, edad, peso, altura, colorOjos, colorPatron);
                        lista.add(gato);
                        bucle = false;
                        break;
                    case 4:
                        System.out.println("--PERRO---");
                        String raza = introducirCadena(sc, "raza del perro");
                        boolean hocicoCorto = introducirBooleano(sc, "el perro tiene el hocico corto");
                        Perro perro = new Perro(name, edad, peso, altura, raza, hocicoCorto);
                        lista.add(perro);
                        bucle = false;
                        break;
                    case 5:
                        System.out.println("---TIBURON---");
                        int aletas = introducirInt(sc, "la cantidad de aletas del tiburon");
                        boolean pielRigida = introducirBooleano(sc, "tine la piel rigida");
                        Tiburon tiburon = new Tiburon(name, edad, peso, altura, aletas, pielRigida);
                        lista.add(tiburon);
                        bucle = false;
                        break;
                    default:
                        System.err.println("Opcion incorrecta");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error " + e.getMessage());
                e.printStackTrace();
                sc.nextLine();
            } catch (Exception e) {
                System.err.println("Error " + e.getMessage());
                e.printStackTrace();
                sc.nextLine();
            }
        }
    }

    public static void showSubmenu() {
        System.out.println("1).Canario");
        System.out.println("2).Cocodrilo");
        System.out.println("3).Gato");
        System.out.println("4).Perro");
        System.out.println("5).Tiburon");
        System.out.println("Elegir opcion");
    }

    public static void mostrarLista(ArrayList<Animal> lista, Scanner sc) {
        int num;
        try {
            do {
                showSubmenu();
                num = sc.nextInt();
                if (num <= 0 || num > 5) {
                    System.err.println("Valor introducido no correcto");
                }
            } while (num < 0 || num > 5);

            if (lista.isEmpty()) {
                System.out.println("La lista esta vacia");
            } else {
                //booleano que combruebo si el animalde ese tipo lo muestra,
                // antes no lo gastaba y me aparecia el animal de otro tipo con un texto de no encontrada
                /*Ejemplo de mi anterior codigo
                * if (num == 1 && animal instanceof Canario ||
                            num == 2 && animal instanceof Cocodrilo ||
                            num == 3 && animal instanceof Gato ||
                            num == 4 && animal instanceof Perro ||
                            num == 5 && animal instanceof Tiburon) {
                        System.out.println(animal);
                 else sout("animal no enocontrada")
                    }*/
                boolean encontrado=false;
                for (Animal animal : lista) {
                    if (num == 1 && animal instanceof Canario ||
                            num == 2 && animal instanceof Cocodrilo ||
                            num == 3 && animal instanceof Gato ||
                            num == 4 && animal instanceof Perro ||
                            num == 5 && animal instanceof Tiburon) {
                        System.out.println(animal);
                        encontrado=true;
                    }
                }
                if (!encontrado){
                    System.out.println("No hay animal de ese tipo en la lista");
                }
            }
        } catch (InputMismatchException | ArithmeticException e) {
            System.err.println("Error " + e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }
    }

    public static void ejecutarAcciones(ArrayList<Animal> lista,Scanner sc){
        //Muestra la lista completa de animales con su nombre
        System.out.println("Animales disponibles:");
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) instanceof Canario) {
                System.out.println((i + 1) + ",Canario: " + (lista.get(i)).getName());
            } else if (lista.get(i) instanceof Cocodrilo) {
                System.out.println((i + 1) + ",Cocodrilo: " + (lista.get(i)).getName());
            }else if (lista.get(i) instanceof Gato){
                System.out.println((i + 1) + ",Gato: " + (lista.get(i)).getName());
            }else if (lista.get(i) instanceof Perro) {
                System.out.println((i + 1) + ",Perro: " + (lista.get(i)).getName());
            }else if (lista.get(i) instanceof Tiburon) {
                System.out.println((i + 1) + ",Tiburon: " + (lista.get(i)).getName());
            }
        }
        try {
            int opcion;
            do {
                System.out.print("Elige un animal (1-" + lista.size() + "): ");
                opcion = sc.nextInt() - 1;
                if (opcion < 0 || opcion >= lista.size()) {
                    System.err.println("Posicion selecionada no existe");
                }
            } while (opcion < 0 || opcion >= lista.size());

            Animal animalSeleccionado = lista.get(opcion);

            // Llamar a metodos comunes verificando el tipo, tambien llamo al metodo unico de cada animal
            if (animalSeleccionado instanceof Canario) {
                Canario canario = (Canario) animalSeleccionado;
                System.out.println(canario.comer());
                System.out.println(canario.dormir());
                System.out.println(canario.hacerRuido());
                System.out.println(canario.estaVolando());
            } else if (animalSeleccionado instanceof Cocodrilo) {
                Cocodrilo cocodrilo = (Cocodrilo) animalSeleccionado;
                System.out.println(cocodrilo.comer());
                System.out.println(cocodrilo.dormir());
                System.out.println(cocodrilo.hacerRuido());
                System.out.println(cocodrilo.cazar());
            } else if (animalSeleccionado instanceof Gato) {
                Gato gato = (Gato) animalSeleccionado;
                System.out.println(gato.comer());
                System.out.println(gato.dormir());
                System.out.println(gato.hacerRuido());
                System.out.println(gato.saltando());
            } else if (animalSeleccionado instanceof Perro) {
                Perro perro = (Perro) animalSeleccionado;
                System.out.println(perro.comer());
                System.out.println(perro.dormir());
                System.out.println(perro.hacerRuido());
                System.out.println(perro.rastreando());
            } else if (animalSeleccionado instanceof Tiburon) {
                Tiburon tiburon = (Tiburon) animalSeleccionado;
                System.out.println(tiburon.comer());
                System.out.println(tiburon.dormir());
                System.out.println(tiburon.hacerRuido());
                System.out.println(tiburon.nadar());
            }

        }catch (InputMismatchException e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }catch (Exception e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }
    }

    public static String introducirCadena(Scanner sc, String atributo) {
        String cadena="";
        try {
            System.out.println("Introduce el " + atributo + ": ");
            cadena=sc.next();
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

    public static int introducirInt(Scanner sc, String atributo) throws Exception {
        int num=0;
        do {
            try {
                System.out.println("Introduce " + atributo + ": ");
                num = sc.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Error " + e.getMessage());
                e.printStackTrace();
                sc.nextLine();
            } catch (Exception e) {
                System.err.println("Error " + e.getMessage());
                e.printStackTrace();
                sc.nextLine();
            }
        }while (!Animal.numeroNoNegativo(num));
        return num;
    }

    public static double introducirDouble(Scanner sc, String atributo) throws Exception {
        double num=0;
        do {
            try {
                System.out.println("Introduce su " + atributo + " : ");
                num = sc.nextDouble();
            }catch (InputMismatchException e){
                System.err.println("Error "+e.getMessage());
                e.printStackTrace();
                sc.nextLine();
            }catch (Exception e){
                System.err.println("Error "+e.getMessage());
                e.printStackTrace();
                sc.nextLine();
            }
        } while (!Animal.numeroNoNegativo(num));
        return num;
    }

    public static boolean introducirBooleano(Scanner sc, String atributo) {
        boolean res = false;
        int opcion = 0;
        boolean entrar = true;
        while (entrar) {
            try {
                System.out.println("El animal " + atributo + "?:");
                System.out.println("1.True");
                System.out.println("2.False");
                System.out.println("Elegir opcion: ");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        res = true;
                        entrar = false;
                        break;
                    case 2:
                        res = false;
                        entrar = false;
                        break;
                    default:
                        System.err.println("Opcion incorrecta");
                }
            } catch (InputMismatchException e) {
                System.err.println("Errror " + e.getMessage());
                e.printStackTrace();
                sc.nextLine();
            } catch (Exception e) {
                System.err.println("Errror " + e.getMessage());
                e.printStackTrace();
                sc.nextLine();
            }
        }
        return res;
    }
}
