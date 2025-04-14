package RankingVideojuegos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Videojuegos> lista=new ArrayList<>();
        String dir=MetodosRanking.DIRECTORIO;
        String fileTxt=MetodosRanking.DIR_FILE_TXT;
        String fileDat=MetodosRanking.DIR_FILE_DAT;
        boolean menu=true;
        int opcion;
        char opcionOrdenar;

        File file=new File(dir);
        if (!file.exists()){
            file.mkdir();
        }

        while (menu){
            menuPrincipal();
            try {
                opcion=sc.nextInt();
                switch (opcion){
                    case 0:
                        System.out.println("Saliendo del programa");
                        menu=false;
                        break;
                    case 1:
                        addVideojuego(sc,lista);
                        break;
                    case 2:
                        do {
                            System.out.println("Mostrar el ranking ordenado por nota?(s/n)");
                            opcionOrdenar=sc.next().toLowerCase().charAt(0);
                            if (opcionOrdenar == 's') {
                                mostrarRankingOrdenado(lista);
                            } else if (opcionOrdenar == 'n') {
                                mostrarRanking(lista);
                            } else {
                                System.err.println("Opcion incorrecta");
                            }
                        }while (opcionOrdenar!='s' && opcionOrdenar!='n');
                        break;
                    case 3:
                        guardarRanking(lista,dir,fileDat);
                        break;
                    case 4:
                        cargarRanking(lista,dir,fileDat);
                        break;
                    case 5:
                        eliminarVideojuego(sc,lista);
                        break;
                    case 6:
                        exportTxt(lista,dir,fileTxt);
                        break;
                    default:
                        System.err.println("Opcion elegida incorrecta");
                }
            }catch (InputMismatchException | ArithmeticException e){
                System.err.println(e.getMessage());
                Logger.log(e.getMessage());
            }catch (Exception e){
                System.err.println(e.getMessage());
                Logger.log(e.getMessage());
            }
        }
        sc.close();
    }

    public static void menuPrincipal(){
        System.out.println("---Ranking de Videojuegos---");
        System.out.println("1.Añadir videojuego");
        System.out.println("2.Mostrar ranking");
        System.out.println("3.Guardar ranking");
        System.out.println("4.Cargar ranking");
        System.out.println("5.Eliminar videojuego");
        System.out.println("6.Exportar a texto");
        System.out.println("7.Jugar demo");
        System.out.println("0.Salir");
        System.out.println("Elegir opcion: ");
    }

    public static void menuSecundario(){
        System.out.println("---Videojuego a registrar---");
        System.out.println("1.Fisico");
        System.out.println("2.Digital");
        System.out.println("Elegir opcion");
    }

    public static void addVideojuego(Scanner sc, ArrayList<Videojuegos> lista){
        String titulo = "",plataforma="",tiendaOnline,estado,tiendaCompra;
        double tamGB;
        int nota=0,opcion;
        boolean bucleAdd=true;
        while (bucleAdd){
            menuSecundario();
            try {
                opcion = sc.nextInt();
                if (opcion==2 || opcion==1){
                    titulo=MetodosRanking.introducirString(sc,"el titulo del videojuego(ejem: devil_may_cry): ");
                    plataforma=MetodosRanking.introducirString(sc,"la plataforma que pertenece el videojuego "+titulo+"(ejem: nintendo_switch2): ");
                    nota=MetodosRanking.introdcirNota(sc,"la nota de "+titulo+"(1-10): ");
                }
                switch (opcion) {
                    case 1:
                        estado=MetodosRanking.introducirEstado(sc,titulo);
                        tiendaCompra=MetodosRanking.introducirString(sc,"la tienda donde se compro "+titulo+"(ejemp:media_mark): ");
                        VideojuegoFisico videojuegoFisico=new VideojuegoFisico(titulo,plataforma,nota,estado,tiendaCompra);
                        lista.add(videojuegoFisico);
                        bucleAdd=false;
                        break;
                    case 2:
                        tiendaOnline=MetodosRanking.introducirString(sc,"la tienda donde se compro "+titulo+"(ejemp:epic_games): ");
                        tamGB=MetodosRanking.introducirTamGb(sc,"cuanto pesa en GB el "+titulo+":");
                        VideojuegoDigital videojuegoDigital=new VideojuegoDigital(titulo,plataforma,nota,tiendaOnline,tamGB);
                        lista.add(videojuegoDigital);
                        bucleAdd=false;
                        break;
                    default:
                        System.err.println("Opcion elegido incorrecta");
                }
            }catch (InputMismatchException | ArithmeticException e){
                System.err.println(e.getMessage());
                Logger.log(e.getMessage());
            }catch (Exception e){
                System.err.println(e.getMessage());
                Logger.log(e.getMessage());
            }
        }
    }

    public static void mostrarRanking(ArrayList<Videojuegos> lista){
        lista.stream().forEach(v -> {
            System.out.println(v);
            v.iJugarDemo();});
    }

    public static void mostrarRankingOrdenado(ArrayList<Videojuegos> lista){
        lista.sort(Comparator.comparingInt(Videojuegos::getNota).reversed());
        lista.stream().forEach(v->{
            System.out.println(v);
            v.iJugarDemo();
        });
    }

    public static void guardarRanking(ArrayList<Videojuegos> lista,String dir,String fileDat){
        try(ObjectOutputStream o =new ObjectOutputStream(new FileOutputStream(dir+fileDat))) {
            o.writeObject(lista);
            System.out.println("Lista guardado en el fichero " + fileDat + " en el directorio " + dir);
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
            Logger.log(e.getMessage());
        } catch (IOException e){
            System.err.println(e.getMessage());
            Logger.log(e.getMessage());
        }
    }

    public static void cargarRanking(ArrayList<Videojuegos> lista,String dir,String fileDat){
        Path ruta= Paths.get(dir);
        if (!Files.exists(ruta)){
            System.err.println("ruta no encontrado "+ruta);
            Logger.log("ruta no encontrado "+ruta);
        }
        try(ObjectInputStream oi=new ObjectInputStream(new FileInputStream(dir+fileDat))) {
            ArrayList<Videojuegos> listaCarga = (ArrayList<Videojuegos>) oi.readObject();
            // Elimino los elementos anteriores para evitar duplicados
            lista.clear();
            //Utilizo adAll para añadir los elemntos de una lista(listaCarga) a la otra lista
            lista.addAll(listaCarga);
            System.out.println("Ranking cargado desde archivo: " + dir + fileDat);
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
            Logger.log(e.getMessage());
        }catch (IOException | ClassNotFoundException e){
            System.err.println(e.getMessage());
            Logger.log(e.getMessage());
        }
    }

    public static void eliminarVideojuego(Scanner sc,ArrayList<Videojuegos> lista) throws JuegoNoEncontradoException {
        String titulo=MetodosRanking.introducirString(sc,"el titulo del videojuego a eliminar(ejem: devil_may_cry): ");
        boolean encontrado=lista.removeIf(v->v.getTitulo().equalsIgnoreCase(titulo));
        if (encontrado){
            System.out.println("El videojuego: "+titulo+" ha sido eliminado");
        }else{
            throw new JuegoNoEncontradoException("No se ha encontrado ese juego con ese titulo");
        }
    }

    public static void exportTxt(ArrayList<Videojuegos> lista,String dir,String fileTxt){
        Path ruta=Paths.get(dir);
        if (!Files.exists(ruta)){
            System.err.println("ruta no encontrado "+ruta);
            Logger.log("ruta no encontrado "+ruta);
        }

        try(BufferedWriter bw=new BufferedWriter(new FileWriter(dir+fileTxt,true))) {
            for (Videojuegos videojuegos : lista){
                bw.write(videojuegos.toString());
                bw.newLine();
            }
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
            Logger.log(e.getMessage());
        }catch (IOException e){
            System.err.println(e.getMessage());
            Logger.log(e.getMessage());
        }

    }
}
