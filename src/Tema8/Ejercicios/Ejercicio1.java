package Tema8.Ejercicios;

import java.sql.*;

/*1. Consulta básica con SELECT
Selecciona los nombres y apellidos de todos los profesores */
public class Ejercicio1 {
    // URL de la base de datos, user y contraseña
    private static final String URL = "jdbc:postgresql://ad-postgres.cpsk8il53gbl.us-east-1.rds.amazonaws.com:5432/hogwarts";
    private static final String USER = "postgres";
    private static final String PASS = "12345678";
    public static void main(String[] args) {
        // Consulta SQL
        String consultaSql = "SELECT nombre, apellido FROM profesor";

        // Conectar y ejecutar la consulta
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement sentencia = con.prepareStatement(consultaSql)){
             ResultSet rs = sentencia.executeQuery();

                // Procesar el resultado de la consulta
                while (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");

                    // Mostrar los nombres y apellidos de los profesores
                    System.out.println("Nombre: " + nombre + ", Apellido: " + apellido);
                }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
