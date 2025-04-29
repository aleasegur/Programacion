package Tema8.EjerciciosConexionBBDDHogwarts;

import Tema8.MyDatos;

import java.sql.*;
import java.util.Scanner;

/*1. Consulta de estudiantes por casa
Crea un método que consulte los nombres y apellidos de todos los estudiantes de una casa
cuyo nombre pasarás por parámetro. Haz la prueba con Gryffindor. */
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        MyDatos.loadProperties();
        String nombreCasa=MyDatos.introducirCadena(sc," el nombre de la casa de hogwarts a consultar(Ej:Slytherin): ");
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD())){
            MyDatos.obtenerEstudiantesPorCasa(con,nombreCasa);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        sc.close();
    }
}
