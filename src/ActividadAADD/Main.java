package ActividadAADD;

import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PilotsCRUD.loadProperties();
        Scanner sc=new Scanner(System.in);
        ArrayList<Piloto> lista=new ArrayList<>();
        int opcion;
        boolean bucle= true;
        try(Connection con=DriverManager.getConnection(PilotsCRUD.getURL(),PilotsCRUD.getUSER(),PilotsCRUD.getPASSWORD())) {
            while (bucle) {
                showMenu();
                try {
                    opcion = sc.nextInt();
                    switch (opcion) {
                        case 0:
                            System.out.println("Saliendo...");
                            bucle = false;
                            break;
                        case 1:
                            PilotsCRUD.createPilot(sc,lista,con);
                            break;
                        case 2:
                            int idBuscar=PilotsCRUD.introducirEntero(sc," el id del pilotoUpd: ");
                            Piloto pilotoVer=PilotsCRUD.readPilot(con,idBuscar);
                            if (pilotoVer!=null){
                                System.out.println(pilotoVer.getNombre()+" "+pilotoVer.getApellido()+", Nacionalidad: "+pilotoVer.getNacionalidad()+", Fecha: "+pilotoVer.getFecha());
                            }else{
                                System.err.println("Piloto no encontrado");
                            }
                            break;
                        case 3:
                            PilotsCRUD.readPilots(con,lista);
                            lista.forEach(System.out::println);
                            break;
                        case 4:
                            int idEncontrar=PilotsCRUD.introducirEntero(sc," el ID del piloto: ");
                            PilotsCRUD.updatePilot(sc,con,idEncontrar);
                            break;
                        case 5:
                            int idEliminar=PilotsCRUD.introducirEntero(sc," el ID del piloto: ");
                            PilotsCRUD.deletePilot(con,idEliminar);
                            break;
                        case 6:
                            PilotsCRUD.showPilotClassification(con);
                            PilotsCRUD.showBuildersClassification(con);
                            break;
                        default:
                            System.err.println("Error opcion no valida");
                    }
                } catch (InputMismatchException | ArithmeticException e) {
                    System.err.println(e.getMessage());
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        sc.close();
    }

    public static void showMenu(){
        System.out.println("1.Añadir piloto");
        System.out.println("2.Ver piloto");
        System.out.println("3.Ver lista de pilotos");
        System.out.println("4.Editar piloto");
        System.out.println("5.Borrar piloto");
        System.out.println("6.Ver clasificacion");
        System.out.println("0.Salir");
        System.out.println("Elige una opcion: ");
    }

}
