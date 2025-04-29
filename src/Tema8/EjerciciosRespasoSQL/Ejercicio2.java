package Tema8.EjerciciosRespasoSQL;

import Tema8.MyDatos;
import java.sql.*;


/*2. Filtrado de datos con WHERE
Selecciona los nombres y apellidos de los estudiantes nacidos después del 1 de enero de 1980.  */
public class Ejercicio2 {

    public static void main(String[] args) {
        MyDatos.loadProperties();
        String consulta="SELECT nombre,apellido FROM estudiante WHERE fecha_nacimiento>'1980-01-01'";
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD());
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
}
