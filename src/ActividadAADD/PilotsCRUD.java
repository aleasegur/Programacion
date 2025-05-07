package ActividadAADD;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PilotsCRUD {
    public static final String dir ="resources/db.propers";
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
        try(InputStream iS= Files.newInputStream(Paths.get(dir))) {
            properties.load(iS);
            URL=properties.getProperty("db.url");
            USER=properties.getProperty("db.user");
            PASSWORD=properties.getProperty("db.password");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
