package Tema8.Ejercicios;

import Tema8.MyDatos;

import java.sql.*;

/*18. Uso de HAVING
Muestra los nombres de las casas que tienen un número promedio de calificaciones superior a
7 en las asignaturas de los estudiantes de esa casa. */
public class Ejercicio18 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        String consulta="SELECT c.nombre AS casa " +
                "FROM casa c " +
                "JOIN estudiante e ON c.id_casa = e.id_casa " +
                "JOIN estudiante_asignatura ea ON e.id_estudiante = ea.id_estudiante " +
                "GROUP BY c.nombre " +
                "HAVING AVG(ea.calificacion) > 7";
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD()); PreparedStatement pst=con.prepareStatement(consulta);
            ResultSet res=pst.executeQuery()) {
            System.out.println("---CASAS QUE TIENEN UN PROMEDIO DE CALIFICACIONES SUPERIOR A 7---");
            while (res.next()){
                String nombre=res.getString("casa");
                System.out.println(nombre);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
