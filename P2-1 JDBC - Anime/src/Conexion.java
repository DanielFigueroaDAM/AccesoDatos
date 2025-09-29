import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection conexion() {
        String url = "jdbc:postgresql://localhost:5432/animedb";
        String usuario = "postgres";
        String contrasinal = "admin";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, usuario, contrasinal);
            System.out.println("✅ Conexión establecida correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a la bd: " + e.getMessage());
        }

        return conn;
    }
}
