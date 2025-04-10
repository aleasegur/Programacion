package RankingVideojuegos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
//Fichero que contiene los errores
public class Logger {
    public static void log(String mensaje) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(MetodosRanking.DIR_LOG_ERRORS, true))) {
            pw.println(LocalDateTime.now() + " - " + mensaje);
        } catch (IOException e) {
            System.err.println("No se pudo escribir en el log.");
        }
    }
}
