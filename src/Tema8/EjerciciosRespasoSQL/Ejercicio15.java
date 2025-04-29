package Tema8.EjerciciosRespasoSQL;

import Tema8.MyDatos;

import java.sql.*;

/*15. Uso de JOIN para combinar tablas
Selecciona los nombres y apellidos de los estudiantes junto con el nombre de su casa.*/
public class Ejercicio15 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        String consulta="SELECT e.nombre AS nombre_estudiante, e.apellido AS apellido_estudiante, c.nombre AS casa " +
                "FROM estudiante e " +
                "JOIN casa c ON e.id_casa = c.id_casa ";
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD()); PreparedStatement pst=con.prepareStatement(consulta);
            ResultSet res=pst.executeQuery()) {
            while (res.next()){
                String nombre=res.getString("nombre_estudiante");
                String apellido=res.getString("apellido_estudiante");
                String casa=res.getString("casa");
                System.out.println("Estudiante: "+nombre+" "+apellido+" -Casa: "+casa);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
