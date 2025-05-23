package Tema8;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Scanner;

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

    public static String introducirCadena(Scanner sc, String tipo){
        String res=null;
        try {
            System.out.println("Introduce "+tipo);
            res=sc.next();
        }catch (StringIndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return res;
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
        String sql = "INSERT INTO estudiante (nombre, apellido, id_casa, anyo_curso, fecha_nacimiento) " +
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
        String sql = "DELETE FROM estudiante WHERE nombre = ? AND apellido = ?";
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

    public static void obtenerEstudiantesPorCasa(Connection con, String nombreCasa) {
        String sql = "SELECT e.nombre, e.apellido " +
                "FROM estudiante e " +
                "JOIN casa c ON e.id_casa = c.id_casa " +
                "WHERE c.nombre = ?";

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, nombreCasa);

            try (ResultSet res = pst.executeQuery()) {
                System.out.println("Estudiantes de la casa " + nombreCasa + ":");
                while (res.next()) {
                    String nombre=res.getString("nombre");
                    String apellido=res.getString("apellido");
                    System.out.println(nombre+" "+apellido);
                }
            }catch (SQLException e){
                System.err.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener estudiantes: " + e.getMessage());
        }
    }

    public static void obtenerMascotaEstudiante(Connection con, String nombre, String apellido) {
        String sql = "SELECT COALESCE(m.nombre, 'Sin mascota') AS mascota " +
                "FROM estudiante e " +
                "LEFT JOIN mascota m ON e.id_estudiante = m.id_estudiante " +
                "WHERE e.nombre = ? AND e.apellido = ?";

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, nombre);
            pst.setString(2, apellido);

            try (ResultSet res = pst.executeQuery()) {
                if (res.next()) {
                    String mascota=res.getString("mascota");
                    System.out.println("Mascota de " + nombre + " " + apellido + ": " +mascota);
                } else {
                    System.err.println("No se encontró un estudiante con ese nombre.");
                }
            }catch (SQLException e){
                System.err.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la mascota: " + e.getMessage());
        }
    }

    public static void obtenerNumeroEstudiantesPorCasa(Connection con) {
        String sql = "SELECT c.nombre AS casa, COUNT(e.id_estudiante) AS numero_estudiantes " +
                "FROM casa c " +
                "JOIN estudiante e ON c.id_casa = e.id_casa " +
                "GROUP BY c.nombre";

        try (PreparedStatement pst = con.prepareStatement(sql);
             ResultSet res = pst.executeQuery()) {

            System.out.println("Número de estudiantes por casa:");
            while (res.next()) {
                String nombreCasa=res.getString("casa");
                int numEstudiantes=res.getInt("numero_estudiantes");
                System.out.println(nombreCasa + ": " + numEstudiantes);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener el número de estudiantes por casa: " + e.getMessage());
        }
    }

    public static void insertarAsignatura(Connection con, String nombre,String aula,boolean obligatoria) {
        String sql = "INSERT INTO asignatura (nombre, aula ,obligatoria) VALUES (?,?,?)";

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, nombre);
            pst.setString(2, aula);
            pst.setBoolean(3,obligatoria);

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Asignatura insertada correctamente.");
            } else {
                System.err.println("Error al insertar la asignatura.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void modificarAulaAsignatura(Connection con, int idAsignatura, String nuevaAula) {
        String sql = "UPDATE asignatura SET aula = ? WHERE id_asignatura = ?";

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, nuevaAula);
            pst.setInt(2, idAsignatura);

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Aula modificada correctamente para la asignatura con ID: " + idAsignatura);
            } else {
                System.err.println("No se encontro la asignatura con ID: " + idAsignatura);
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar el aula: " + e.getMessage());
        }
    }

    public static void eliminarAsignaturaPorNombre(Connection con, String nombreAsignatura) {
        String sql = "DELETE FROM asignatura WHERE nombre = ?";

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, nombreAsignatura);

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Asignatura " + nombreAsignatura + " eliminada correctamente.");
            } else {
                System.err.println("No se encontró la asignatura con nombre: " + nombreAsignatura);
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar la asignatura: " + e.getMessage());
        }
    }


}
