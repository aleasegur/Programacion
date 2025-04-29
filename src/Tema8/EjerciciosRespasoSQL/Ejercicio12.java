package Tema8.EjerciciosRespasoSQL;

import Tema8.MyDatos;

import java.sql.*;
import java.time.LocalDate;

/*12.Inserción de datos con INSERT INTO
Inserta un nuevo estudiante llamado "Nymphadora Tonks" en la casa Slytherin (id_casa = 4),
en el 7º año, con fecha de nacimiento '1973-11-25'.*/
public class Ejercicio12 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        String nombre = "Nymphadora";
        String apellido = "Tonks";
        int idCasa = 4;
        int curso = 7;
        LocalDate fecha = LocalDate.of(1973, 11, 25);
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD())){
            int idEstudiante=MyDatos.insertarEstudiante(con,nombre,apellido,idCasa,curso,fecha);
            if (idEstudiante != -1){
                System.out.println("Estudiante insertado");
            }else{
                System.err.println("Error al insertar el estudiante");
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

}
