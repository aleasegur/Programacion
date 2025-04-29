package Tema8.EjerciciosRespasoSQL;

import Tema8.MyDatos;

import java.sql.*;

/*17. Uso de subconsultas
Muestra los nombres de los estudiantes que tienen una calificación superior al promedio en la
asignatura "Encantamientos". */
public class Ejercicio17 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        String consulta="SELECT e.nombre, e.apellido " +
                "FROM estudiante e " +
                "JOIN estudiante_asignatura ea ON e.id_estudiante = ea.id_estudiante " +
                "JOIN asignatura a ON ea.id_asignatura = a.id_asignatura " +
                "WHERE a.nombre = 'Encantamientos' " +
                "AND ea.calificacion > (SELECT AVG(calificacion) FROM estudiante_asignatura WHERE id_asignatura = a.id_asignatura)";
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD()); PreparedStatement pst=con.prepareStatement(consulta);
            ResultSet res=pst.executeQuery()) {
            System.out.println("---ESTUDIANTES CON CALIFICACION SUPERIOR AL PROMEDIA EN ENCANTAMIENTOS---");
            while (res.next()){
                String nombre=res.getString("nombre");
                String apellido=res.getString("apellido");
                System.out.println(nombre+" "+apellido);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
