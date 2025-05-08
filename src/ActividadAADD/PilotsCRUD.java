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
    public static final String dir ="resources/con.properties";
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

    public static void createPilot(Scanner sc, ArrayList<Piloto> lista,Connection con){
        String code,nombre,apellido,nacionalidad;
        int id= 0;
        LocalDate fecha;
        String sql="INSERT INTO drivers (code,forename,surname,dob,nationality) VALUES (?,?,?,?,?)";
        try {
            code=introducirString(sc," el codigo del piloto: ");
            nombre=introducirString(sc," el nombre del piloto: ");
            apellido=introducirString(sc," el apellido del piloto: ");
            nacionalidad=introducirString(sc," la nacionalidad del piloto: ");
            fecha=introducirFecha(sc," la fecha del piloto: ");
            Piloto piloto=new Piloto(code,nombre,nacionalidad,apellido,fecha,id);
            try(PreparedStatement pst=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
                pst.setString(1,piloto.getNombre());
            }catch (SQLException e){
                System.err.println(e.getMessage());
            }
        }catch (InputMismatchException | ArithmeticException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

}
