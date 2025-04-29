package Tema8.EjerciciosConexionBBDDHogwarts;

import Tema8.MyDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/*6. Eliminar una asignatura
Crea un método que permita eliminar una asignatura de la tabla. Ejecuta este método con la
asignatura creada anteriormente. */
public class Ejercicio6 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        Scanner sc=new Scanner(System.in);
        String nombreAsig=MyDatos.introducirCadena(sc," el nombre de la asignatura:(Ej:Programacion): ");
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD())){
            MyDatos.eliminarAsignaturaPorNombre(con,nombreAsig);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        sc.close();
    }
}
