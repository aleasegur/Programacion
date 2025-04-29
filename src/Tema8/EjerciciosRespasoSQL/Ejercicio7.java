package Tema8.EjerciciosRespasoSQL;

import Tema8.MyDatos;

import java.sql.*;
/*7. Filtrado de patrones con LIKE
Selecciona los nombres de los estudiantes cuyo apellido empieza con la letra "P"*/
public class Ejercicio7 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        String consulta="Select nombre FROM estudiante WHERE apellido LIKE 'P%'";
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD()); PreparedStatement sta=con.prepareStatement(consulta);
            ResultSet res=sta.executeQuery()) {
            System.out.println("---ESTUDIANTES QUE SU APELLIDO EMPIEZA POR LA P---");
            while (res.next()){
                String nombre=res.getString("nombre");
                System.out.println(nombre);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
