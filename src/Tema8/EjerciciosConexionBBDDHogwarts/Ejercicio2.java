package Tema8.EjerciciosConexionBBDDHogwarts;

import Tema8.MyDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
/*2. Obtener la mascota de un estudiante específico
Crea un método que consulte y muestre la mascota de un estudiante cuyo nombre y apellido
pases como parámetros. Haz la prueba con Hermione Granger. */
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String nombre= MyDatos.introducirCadena(sc," el nombre del estudiante(Ej:Hermione): ");
        String apellido= MyDatos.introducirCadena(sc," el apellido del estudiante(Ej:Granger): ");
        MyDatos.loadProperties();
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD())){
            MyDatos.obtenerMascotaEstudiante(con,nombre,apellido);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        sc.close();
    }
}
