package Tema8.Ejercicios;

import Tema8.MyDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*13. Modificación de datos con UPDATE
Cambia el jefe de la casa Hufflepuff a Pomona Sprout.*/
public class Ejercicio13 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        String nombre="Pomona";
        String apellido="Sprout";
        String nombreCasa="Hufflepuff";
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD())) {
            MyDatos.modJefeCasa(con,nombre,apellido,nombreCasa);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
