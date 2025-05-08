package ActividadAADD;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;
import java.sql.*;

public class PilotsCRUD {
    public static final String dir ="resources/conexion.properties";
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    public static String getURL() {
        return URL;
    }

    public static String getUSER() {
        return USER;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void loadProperties(){
        Properties properties=new Properties();
        try(InputStream iS= Files.newInputStream(Paths.get(dir))) {
            properties.load(iS);
            URL=properties.getProperty("db.url");
            USER=properties.getProperty("db.user");
            PASSWORD=properties.getProperty("db.password");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static LocalDate introducirFecha(Scanner sc, String tipo){
        LocalDate res = null;
        try {
            System.out.println("Introduce "+tipo);
            res=LocalDate.parse(sc.next());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return res;
    }

    public static String introducirString(Scanner sc, String tipo){
        String res="";
        try{
            System.out.println("Introduce "+tipo);
            res=sc.next();
        }catch (StringIndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return res;
    }

    public static int introducirEntero(Scanner sc, String tipo){
        int res=0;
        try {
            System.out.println("Introduce "+tipo);
            res=sc.nextInt();
        }catch (InputMismatchException | ArithmeticException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return res;
    }

    public static Piloto crearObjetoPiloto(Scanner sc){
        String code,nombre,apellido,nacionalidad;
        LocalDate fecha;
        try {
            code = introducirString(sc, " el codigo del piloto: ");
            nombre = introducirString(sc, " el nombre del piloto: ");
            apellido = introducirString(sc, " el apellido del piloto: ");
            nacionalidad = introducirString(sc, " la nacionalidad del piloto: ");
            fecha = introducirFecha(sc, " la fecha del piloto(YYYY-MM-DD): ");
            Piloto piloto = new Piloto(code,nombre,nacionalidad,apellido,fecha);
            return piloto;
        }catch (InputMismatchException | ArithmeticException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static void createPilot(Scanner sc, ArrayList<Piloto> lista,Connection con){
        String code,nombre,apellido,nacionalidad;
        LocalDate fecha;
        String sql="INSERT INTO drivers (code,forename,surname,dob,nationality) VALUES (?,?,?,?,?)";
            Piloto piloto=crearObjetoPiloto(sc);
            try(PreparedStatement pst=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
                pst.setString(1,piloto.getCode());
                pst.setString(2,piloto.getNombre());
                pst.setString(3,piloto.getApellido());
                pst.setDate(4,Date.valueOf(piloto.getFecha()));
                pst.setString(5,piloto.getNacionalidad());

                int filas=pst.executeUpdate();

                if (filas>0){
                    try(ResultSet res=pst.executeQuery()) {
                        if (res.next()){
                            int idGenerado=res.getInt(1);
                            piloto.setId(idGenerado);
                            System.out.println("Piloto insertado con ID: "+idGenerado);
                        }
                    }catch (SQLException e){
                        System.err.println(e.getMessage());
                    }
                }
                lista.add(piloto);
            }catch (SQLException e){
                System.err.println(e.getMessage());
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
    }

    public static Piloto readPilot(Connection con,int idBuscar){
        String sql = "SELECT driverid, code, forename, surname, dob, nationality FROM drivers WHERE driverid = ?";

        try(PreparedStatement pst=con.prepareStatement(sql)) {
            pst.setInt(1,idBuscar);
            try(ResultSet res=pst.executeQuery()) {
                if (res.next()){
                    int id=res.getInt("driverid");
                    String code=res.getString("code");
                    String nombre = res.getString("forename");
                    String apellido = res.getString("surname");
                    LocalDate fecha = res.getDate("dob").toLocalDate();
                    String nacionalidad = res.getString("nationality");

                    Piloto piloto = new Piloto(code, nombre,nacionalidad,apellido,fecha);
                    piloto.setId(id);
                    return piloto;
                }
            }catch (SQLException e){
                System.err.println(e.getMessage());
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static void readPilots(Connection con,ArrayList<Piloto> lista){
        String sql = "SELECT driverid, code, forename, surname, dob, nationality FROM drivers";

        try(PreparedStatement pst=con.prepareStatement(sql); ResultSet res= pst.executeQuery()) {

            while (res.next()){
                int id = res.getInt("driverid");
                String code = res.getString("code");
                String nombre = res.getString("forename");
                String apellido = res.getString("surname");
                LocalDate fechaNacimiento = res.getDate("dob").toLocalDate();
                String nacionalidad = res.getString("nationality");
                Piloto piloto = new Piloto(code, nombre, nacionalidad,apellido,fechaNacimiento);
                piloto.setId(id);
                lista.add(piloto);
            }

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

    public static void updatePilot(Connection con,Piloto piloto) {
        String sql = "UPDATE drivers SET code = ?, forename = ?, surname = ?, dob = ?, nationality = ? WHERE driverid = ?";

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, piloto.getCode());
            pst.setString(2, piloto.getNombre());
            pst.setString(3, piloto.getApellido());
            pst.setDate(4, Date.valueOf(piloto.getFecha()));
            pst.setString(5, piloto.getNacionalidad());
            pst.setInt(6, piloto.getId());

            int filasActualizadas = pst.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Piloto actualizado correctamente.");
            } else {
                System.err.println("No se encontro un piloto con ese ID.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void deletePilot(Connection con,Piloto piloto){
        String sql = "DELETE drivers SET code = ?, forename = ?, surname = ?, dob = ?, nationality = ? WHERE driverid = ?";

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, piloto.getCode());
            pst.setString(2, piloto.getNombre());
            pst.setString(3, piloto.getApellido());
            pst.setDate(4, Date.valueOf(piloto.getFecha()));
            pst.setString(5, piloto.getNacionalidad());
            pst.setInt(6, piloto.getId());

            int filasActualizadas = pst.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Piloto eliminado correctamente.");
            } else {
                System.err.println("No se encontro un piloto con ese ID.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
