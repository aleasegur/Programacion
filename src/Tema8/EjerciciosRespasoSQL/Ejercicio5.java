package Tema8.EjerciciosRespasoSQL;

import Tema8.MyDatos;

import java.sql.*;
/*5. Uso de funciones de agregación
Calcula la calificación media y la calificación máxima en la asignatura "Pociones".
*/
public class Ejercicio5 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        String consulta = "SELECT AVG(ea.calificacion) AS calificacion_media, " +
                "MAX(ea.calificacion) AS calificacion_maxima " +
                "FROM Estudiante_Asignatura ea " +
                "JOIN Asignatura a ON ea.id_asignatura = a.id_asignatura " +
                "WHERE a.nombre = 'Pociones'";
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD()); PreparedStatement state=con.prepareStatement(consulta);
        ResultSet res=state.executeQuery()){
            while (res.next()){
                int notaMedia=res.getInt("calificacion_media");
                int notaMaxima=res.getInt("calificacion_maxima");
                System.out.println("Calificacion media="+notaMedia);
                System.out.println("Calificacion maxima="+notaMaxima);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
