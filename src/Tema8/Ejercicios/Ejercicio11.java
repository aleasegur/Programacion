package Tema8.Ejercicios;

import Tema8.MyDatos;

import java.sql.*;
import java.time.LocalDate;

/*11.Uso de operadores de comparación
Muestra los nombres de los estudiantes cuya calificación en la asignatura de "Vuelo" es mayor
o igual a 8.*/
public class Ejercicio11 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        String consulta="SELECT e.nombre, e.apellido " +
                "FROM estudiante e " +
                "JOIN Estudiante_Asignatura ea ON e.id_estudiante = ea.id_estudiante " +
                "JOIN asignatura a ON ea.id_asignatura = a.id_asignatura " +
                "WHERE a.nombre = 'Vuelo' AND ea.calificacion >= 8";
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD()); PreparedStatement sta=con.prepareStatement(consulta);
            ResultSet res=sta.executeQuery()) {
            System.out.println("---ALUMNOS CON CALIFICACION MAYOR O IGUAL A 8---");
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
