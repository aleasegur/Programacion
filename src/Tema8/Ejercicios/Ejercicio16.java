package Tema8.Ejercicios;

import Tema8.MyDatos;

import java.sql.*;

/*16. Uso de LEFT JOIN para combinar tablas
Muestra los nombres de los estudiantes junto con los nombres de las mascotas y las asignatu
ras que cursan. Incluye a los estudiantes que no tienen mascota. */
public class Ejercicio16 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        String consulta="SELECT e.nombre AS nombre_estudiante, e.apellido AS apellido_estudiante, " +
                "COALESCE(m.nombre, 'Sin mascota') AS mascota, a.nombre AS asignatura " +
                "FROM estudiante e " +
                "LEFT JOIN mascota m ON e.id_estudiante = m.id_estudiante " +
                "JOIN estudiante_asignatura ea ON e.id_estudiante = ea.id_estudiante " +
                "JOIN asignatura a ON ea.id_asignatura = a.id_asignatura";
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD()); PreparedStatement pst=con.prepareStatement(consulta);
            ResultSet res=pst.executeQuery()) {
            while (res.next()){
                String nombre=res.getString("nombre_estudiante");
                String apellido=res.getString("apellido_estudiante");
                String mascotaNombre=res.getString("mascota");
                String asignaturaNombre=res.getString("asignatura");
                System.out.println("Estudiante: "+nombre+" "+apellido+" -Mascota: "+mascotaNombre+" -Asignatura: "+asignaturaNombre);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
