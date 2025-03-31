package Tema7.EjercicioCSV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serial;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String direc=MyMetodosCSV.PATH_CSV;
        String fichero=MyMetodosCSV.FILE_CSV;
        ArrayList<Funko> lista=new ArrayList<>();
        int opcion;
        boolean menuFunko=true;
        loadFunko(direc,fichero,lista);
        while (menuFunko){
            try {
                showMenu();
                opcion=sc.nextInt();
                switch (opcion){
                    case 1:
                        addFunko(sc,lista);
                        break;
                    case 2:
                        eliminarFunko(sc,lista);
                        break;
                    case 3:
                        mostrarFunkos(lista);
                        break;
                    case 4:
                        mostrarFunkoCaro(lista);
                        break;
                    case 5:
                        mostrarFunkoPrecioMedio(lista);
                        break;
                    case 6:
                        mostrarFunkoPorModelo(lista);
                        break;
                    case 7:
                        mostrarFunkoLanzado2023(lista);
                        break;
                    case 8:
                        saveFunkos(direc,fichero,lista);
                        menuFunko=false;
                        System.out.println("Saliendo..");
                        break;
                    default:
                        System.err.println("Opcion invalida");
                }
            }catch (InputMismatchException | ArithmeticException e){
                System.err.println(e.getMessage());
            }
        }
        sc.close();
    }

    public static void showMenu(){
        System.out.println("1.Añadir funko");
        System.out.println("2.Borrar funko");
        System.out.println("3.Mostrar funkos");
        System.out.println("4.Mostrar funko mas caro");
        System.out.println("5.Mostrar media de precio de los funkos");
        System.out.println("6.Mostrar funko por colecciones");
        System.out.println("7.Mostrar funkos del 2023");
        System.out.println("8.Guardar y salir");
        System.out.println("Elegir opcion: ");
    }

    public static void loadFunko(String direc, String fichero,ArrayList<Funko> lista){
        Path ruta= Paths.get(direc);
        if (!Files.exists(ruta)){
            System.err.println("Archivo no encontrado");
        }
        try(BufferedReader br= Files.newBufferedReader(Path.of(ruta + fichero))) {
            String linea;
            //br.readLine(); //Salto la cabecera
            while ((linea=br.readLine())!=null){
                lista.add(Funko.fromCSV(linea));
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void mostrarFunkos(ArrayList<Funko> lista){
        for (Funko funko : lista){
            System.out.println(funko);
        }
    }

    public static void addFunko(Scanner sc,ArrayList<Funko> lista){
        String codigo,nombre,modelo;
        LocalDate fecha;
        double precio;
        try {
            codigo=MyMetodosCSV.introducirString(sc,"el codigo del funko: ");
            nombre=MyMetodosCSV.introducirString(sc,"el nombre del funko(nombre_completo): ");
            modelo=MyMetodosCSV.introducirString(sc,"el modelo del funko: ");
            fecha=MyMetodosCSV.introducirFecha(sc,"la fecha del funko(YYYY-MM-DD): ");
            precio=MyMetodosCSV.introducirNumeroReal(sc,"el precio del funko: ");
            Funko funko=new Funko(codigo,nombre,modelo,precio,fecha);
            lista.add(funko);
        }catch (ArithmeticException | InputMismatchException | StringIndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static void modFunko(Scanner sc,ArrayList<Funko> lista) throws Exception {
        String cod=MyMetodosCSV.introducirString(sc,"el codigo del funko a modificar: ");
        String nombre;
        double precio;
        for (Funko funk : lista){
            if (funk.getCodigo().equalsIgnoreCase(cod)){
                try {
                    nombre = MyMetodosCSV.introducirString(sc, "el nuevo nombre para el funko(nombre_completo): ");
                    precio = MyMetodosCSV.introducirNumeroReal(sc, "el nuevo precio del funko");
                    funk.setNombre(nombre);
                    funk.setPrecio(precio);
                }catch (InputMismatchException | ArithmeticException | StringIndexOutOfBoundsException e){
                    System.err.println(e.getMessage());
                }catch (Exception e){
                    System.err.println(e.getMessage());
                }
            }else{
                System.err.println("Funko no encontrado");
            }
        }
    }

    public static void eliminarFunko(Scanner sc,ArrayList<Funko> lista){
        String codigo=MyMetodosCSV.introducirString(sc,"el codigo del funko a eliminar: ");
        lista.removeIf(f->f.getCodigo().equalsIgnoreCase(codigo));
    }

    public static void mostrarFunkoCaro(ArrayList<Funko> lista){
        Optional<Funko> funkoCaro=lista.stream().max(Comparator.comparing(Funko::getPrecio));
        System.out.println("Funko mas caro: "+funkoCaro.orElse(null));
    }

    public static void mostrarFunkoPrecioMedio(ArrayList<Funko> lista){
        double precioMedio=lista.stream().mapToDouble(Funko::getPrecio).average().orElse(0);
        System.out.println("Precio medio: "+precioMedio);
    }

    public static void mostrarFunkoLanzado2023(ArrayList<Funko> lista){
        List<Funko> funko2023=lista.stream().filter(f->f.getFecha().getYear()==2023).toList();
        System.out.println("Funkos lanzados en 2023: "+funko2023);
    }

    public static void mostrarFunkoPorModelo(ArrayList<Funko> lista){
        Set<String> modelos= new HashSet<>();
        Map<String,List<Funko>> funkosPorModelo=new HashMap<>();

        //Agrupar funkos por modelos
        for (Funko f : lista){
            modelos.add(f.getModelo());
            funkosPorModelo.computeIfAbsent(f.getModelo(),k->new ArrayList<>()).add(f);
        }

        //Mostrar funkos por modelo
        for (String modelo : modelos){
            System.out.println("Modelo: "+modelo);
            funkosPorModelo.get(modelo).forEach(System.out::println);
        }
    }

    public static void saveFunkos(String direc, String fichero,ArrayList<Funko> lista){
        try(BufferedWriter bw= Files.newBufferedWriter(Paths.get(direc+fichero))) {
            bw.write("COD,NOMBRE,MODELO,PRECIO,FECHA_LANZAMIENTO\n");
            for (Funko funko : lista){
                bw.write(funko.toCSV()+ "\n");
                System.out.println("Datos guardados");
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

}
