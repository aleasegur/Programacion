package Tema8.EjerciciosRespasoSQL;

import Tema8.MyDatos;

import java.sql.*;

/*8. Uso de IN para búsqueda múltiple
Muestra los nombres y apellidos de los estudiantes que están en su 4º o 5º año.*/
public class Ejercicio8 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        String consulta="SELECT nombre,apellido,anyo_curso FROM estudiante WHERE anyo_curso IN (4,5)";
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD()); PreparedStatement sta=con.prepareStatement(consulta);
            ResultSet res=sta.executeQuery()) {
            while (res.next()){
                String nombre=res.getString("nombre");
                String apellido=res.getString("apellido");
                int anyo=res.getInt("anyo_curso");
                System.out.println(nombre + " " + apellido+", Curso: "+anyo);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
