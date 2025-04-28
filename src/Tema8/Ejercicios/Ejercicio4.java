package Tema8.Ejercicios;

import Tema8.MyDatos;

import java.sql.*;
/*4. Agrupación de resultados con GROUP BY
Muestra cuántos estudiantes hay en cada casa, mostrando el nombre de la casa y el número de
estudiantes. */
public class Ejercicio4 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        String consulta="SELECT c.nombre ,COUNT(e.id_estudiante) AS numero_estudiantes " +
                "FROM Casa c " +
                "JOIN estudiante e ON c.id_casa = e.id_casa " +
                "GROUP BY c.nombre";
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD());
            PreparedStatement pstate=con.prepareStatement(consulta);ResultSet res=pstate.executeQuery()){
            while (res.next()){
                String nombreCasa=res.getString("nombre");
                int numEstudiantes=res.getInt("numero_estudiantes");
                System.out.println(nombreCasa+": "+numEstudiantes+" estudiantes");
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
