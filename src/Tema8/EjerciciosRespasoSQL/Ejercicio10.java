package Tema8.EjerciciosRespasoSQL;

import Tema8.MyDatos;

import java.sql.*;
import java.time.LocalDate;

/*10.Limitar resultados con LIMIT
Muestra los primeros 5 estudiantes ordenados por su fecha de nacimiento*/
public class Ejercicio10 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        String consulta="SELECT nombre, apellido, fecha_nacimiento " +
                "FROM estudiante " +
                "ORDER BY fecha_nacimiento ASC " +
                "LIMIT 5";
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD()); PreparedStatement sta=con.prepareStatement(consulta);
            ResultSet res=sta.executeQuery()) {
            while (res.next()){
                String nombre=res.getString("nombre");
                String apellido=res.getString("apellido");
                LocalDate date=res.getObject("fecha_nacimiento",LocalDate.class);
                System.out.println(nombre+" "+apellido+", Fecha: "+date);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
