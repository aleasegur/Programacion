package Tema8.EjerciciosRespasoSQL;

import Tema8.MyDatos;

import java.sql.*;

/*9. Uso de operadores lógicos (AND, OR)
Selecciona los nombres y apellidos de los estudiantes que están en el 5º año y pertenecen a las
casas Gryffindor o Slytherin.*/
public class Ejercicio9 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        String consulta="SELECT nombre, apellido " +
                "FROM estudiante " +
                "WHERE anyo_curso = 5 " +
                "AND id_casa IN (SELECT id_casa FROM casa WHERE nombre IN ('Gryffindor', 'Slytherin'))";
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD()); PreparedStatement sta=con.prepareStatement(consulta);
            ResultSet res=sta.executeQuery()) {
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
