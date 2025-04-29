package Tema8;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;

public class MyDatos {
    public static final String dirProperties="resources/db.properties";
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    public static String getURL() {
        return URL;
    }

    public static String getUSER() {
        return USER;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void loadProperties(){
        Properties properties=new Properties();
        try(InputStream iS= Files.newInputStream(Paths.get(dirProperties))) {
            properties.load(iS);
            URL=properties.getProperty("db.url");
            USER=properties.getProperty("db.user");
            PASSWORD=properties.getProperty("db.password");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int insertarEstudiante(Connection con, String nombre, String apellido, int idCasa, int curso, LocalDate fecha) {
        int idGenerado = -1;  // Para almacenar el ID generado
        String sql = "INSERT INTO Estudiante (nombre, apellido, id_casa, anyo_curso, fecha_nacimiento) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // Asignar valores a los parámetros
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setInt(3, idCasa);
            pst.setInt(4, curso);
            pst.setDate(5, java.sql.Date.valueOf(fecha));

            // Ejecutar la insercion
            int filasAfectadas = pst.executeUpdate();
            System.out.println("Filas afectadas al insertar: " + filasAfectadas);

            // Obtener el ID generado después de ejecutar la consulta
            try (ResultSet res = pst.getGeneratedKeys()) {
                if (res.next()) {
                    idGenerado = res.getInt(1);
                }
                System.out.println("Estudiante insertado con ID: " + idGenerado);
            }catch (SQLException e){
                System.err.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return -1;
        }
        return idGenerado;
    }

    public static void modJefeCasa(Connection con, String nombre, String apellido, String nombreCasa){
        String sql="UPDATE Casa " +
                "SET id_jefe = (SELECT id_profesor FROM Profesor WHERE nombre = ? AND apellido = ?) " +
                "WHERE nombre = ?";
        try(PreparedStatement pst=con.prepareStatement(sql)) {
            pst.setString(1,nombre);
            pst.setString(2,apellido);
            pst.setString(3,nombreCasa);
            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Jefe de la casa actualizado correctamente.");
            } else {
                System.err.println("No se encontro la casa o el profesor.");
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public static void borrarEstudiante(Connection con,String nombre,String apellido){
        String sql = "DELETE FROM Estudiante WHERE nombre = ? AND apellido = ?";
        try(PreparedStatement pst=con.prepareStatement(sql)) {
            pst.setString(1,nombre);
            pst.setString(2,apellido);
            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Estudiante eliminado correctamente.");
            } else {
                System.err.println("No se encontro el estudiante con nombre: " + nombre + " " + apellido);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

}
