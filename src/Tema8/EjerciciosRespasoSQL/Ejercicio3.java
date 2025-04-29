package Tema8.EjerciciosRespasoSQL;

import Tema8.MyDatos;
import java.sql.*;
import java.time.LocalDate;
/*3. Ordenación de resultados con ORDER BY
Muestra los nombres y apellidos de los estudiantes, ordenados por su fecha de nacimiento de
forma ascendente.*/
public class Ejercicio3 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        String consulta="SELECT nombre, apellido,fecha_nacimiento FROM estudiante ORDER BY fecha_nacimiento ASC";
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD()); PreparedStatement st=con.prepareStatement(consulta);
            ResultSet res=st.executeQuery()){

            while (res.next()){
                String nombre=res.getString("nombre");
                String apellido=res.getString("apellido");
                LocalDate date=res.getObject("fecha_nacimiento",LocalDate.class);
                System.out.println("Nombre: "+nombre+", Apellido: "+apellido+", Fecha nacimiento: "+date);
            }

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
