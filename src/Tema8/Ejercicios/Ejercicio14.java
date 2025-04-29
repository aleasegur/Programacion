package Tema8.Ejercicios;

import Tema8.MyDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*14. Eliminación de datos con DELETE
Elimina al estudiante con nombre "Tom Riddle". */
public class Ejercicio14 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        String nombre="Tom";
        String apellido="Riddle";
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD())) {
            MyDatos.borrarEstudiante(con,nombre,apellido);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
