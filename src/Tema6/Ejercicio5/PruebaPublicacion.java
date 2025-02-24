package Tema6.Ejercicio5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaPublicacion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<PublicacionTexto> listaTexto=new ArrayList<>();
        ArrayList<PublicacionFoto> listaFoto=new ArrayList<>();
        ArrayList<PublicacionVideo> listaVideo=new ArrayList<>();
        boolean buclePrincipal=true;
        char opcion;
        while (buclePrincipal){
            try {
                showMenu();
                opcion=sc.next().toLowerCase().charAt(0);
                switch (opcion){
                    case 'a':
                        addPublicaciones(sc,listaTexto,listaFoto,listaVideo);
                        break;
                    case 'b':
                        mostrarPublicacion(sc,listaTexto,listaFoto,listaVideo);
                        break;
                    case 'c':
                        System.out.println("Saliendo...");
                        buclePrincipal=false;
                        break;
                    default:
                        System.err.println("Opcion invalida");
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }

    public static void addPublicaciones(Scanner sc,ArrayList<PublicacionTexto> listaTexto,ArrayList<PublicacionFoto> listaFoto,ArrayList<PublicacionVideo> listaVideo){
        boolean entrar=true;
        int opcion;
        while (entrar){
            try {
                subMenu();
                opcion=sc.nextInt();
                sc.nextLine();
                switch (opcion){
                    case 1:
                        String contenido=introducirStr(sc,"contenido");
                        PublicacionTexto pubTxt=new PublicacionTexto(contenido);
                        listaTexto.add(pubTxt);
                        entrar=false;
                        break;
                    case 2:
                        String urlFoto=introducirStr(sc,"url de la foto");
                        String descripcion=introducirStr(sc,"descripcion de la foto");
                        PublicacionFoto pubFoto=new PublicacionFoto(urlFoto,descripcion);
                        listaFoto.add(pubFoto);
                        entrar=false;
                        break;
                    case 3:
                        String urlVideo=introducirStr(sc,"la url del video");
                        String titulo=introducirStr(sc,"el titulo del video");
                        PublicacionVideo pubVid=new PublicacionVideo(urlVideo,titulo);
                        listaVideo.add(pubVid);
                        entrar=false;
                        break;
                    default:
                        System.err.println("Opcion no valida");
                }
            }catch (InputMismatchException | ArithmeticException e){
                System.err.println("Error "+e.getMessage());
            }catch (Exception e){
                System.err.println("Error "+e.getMessage());
            }
        }
    }

    public static void mostrarPublicacion(Scanner sc,ArrayList<PublicacionTexto> listaTexto,ArrayList<PublicacionFoto> listaFoto,ArrayList<PublicacionVideo> listaVideo){
        int num;
        boolean listado=true;
        while (listado) {
            try {
                System.out.println("---MOSTRAR Y COMPARTIR PUBLICACION---");
                subMenu();
                sc.nextLine();
                num = sc.nextInt();
                sc.nextLine();
                switch (num) {
                    case 1:
                        if (listaTexto.isEmpty()){
                            System.out.println("No hay ninguna publicacion");
                        }else {
                            for (PublicacionTexto pT : listaTexto){
                                pT.iPublicar();
                                pT.iCompartir();
                                String comentario1=introducirStr(sc,"comentario");
                                pT.iComentar(comentario1);
                            }
                        }
                        listado=false;
                        break;
                    case 2:
                        if (listaFoto.isEmpty()){
                            System.out.println("No hay ninguna publicacion");
                        }else {
                            for (PublicacionFoto pF : listaFoto){
                                pF.iPublicar();
                                pF.iCompartir();
                                pF.iAbrirPublicacion();
                                String comentario2=introducirStr(sc,"comentario");
                                pF.iComentar(comentario2);
                            }
                        }
                        listado=false;
                        break;
                    case 3:
                        if (listaVideo.isEmpty()){
                            System.out.println("No hay ninguna publicacion");
                        }else {
                            for (PublicacionVideo pV : listaVideo){
                                pV.iPublicar();
                                pV.iCompartir();
                                pV.iAbrirPublicacion();
                                String comentario3=introducirStr(sc,"comentario");
                                pV.iComentar(comentario3);
                            }
                        }
                        listado=false;
                        break;
                    default:
                        System.err.println("Valor introducido incorrecto");
                }

            } catch (InputMismatchException | ArithmeticException e) {
                System.err.println("Error " + e.getMessage());
                sc.nextLine();
            }
        }
    }

    public static String introducirStr(Scanner sc,String publi){
        String cad="";
        try {
            System.out.println("Introduce "+publi+" :");
            cad=sc.nextLine().trim();
        }catch (StringIndexOutOfBoundsException e){
            System.err.println("Error "+e.getMessage());
        }catch (Exception e){
            System.err.println("Error "+e.getMessage());
        }
        return cad;
    }

    public static void subMenu(){
        System.out.println("1.Publicacion Texto");
        System.out.println("2.Publicacion Foto");
        System.out.println("3.Publicacion Video");
        System.out.print("Elegir opcion:");
    }

    public static void showMenu(){
        System.out.println("a).Crear Publicacion");
        System.out.println("b).Mostrar Publicacion");
        System.out.println("c).Salir");
        System.out.print("Elegir opcion:");
    }

}
