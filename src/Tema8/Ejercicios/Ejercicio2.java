package Tema8.Ejercicios;

import Tema8.MetodosAtributos;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;
import Tema8.MetodosAtributos;

/*2. Filtrado de datos con WHERE
Selecciona los nombres y apellidos de los estudiantes nacidos después del 1 de enero de 1980.  */
public class Ejercicio2 {
    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private final static String rutaDb=MetodosAtributos.dirProperties;
    public static void main(String[] args) {
        loadProperties();

        String consulta="SELECT nombre,apellido FROM estudiante WHERE fecha_nacimiento>'1980-01-01'";

        try(Connection con= DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement state=con.prepareStatement(consulta)){
            ResultSet res=state.executeQuery();

            System.out.println("---Estudiantes nacidos despues del 1 de enero de 1980---");
            while (res.next()){
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                System.out.println("Nombre: " + nombre + ", Apellido: " + apellido);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }

    }

    public static void loadProperties(){
        Properties properties=new Properties();
        try(InputStream iS= Files.newInputStream(Paths.get(rutaDb))) {
            properties.load(iS);
            URL=properties.getProperty("db.url");
            USER=properties.getProperty("db.user");
            PASSWORD=properties.getProperty("db.password");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
