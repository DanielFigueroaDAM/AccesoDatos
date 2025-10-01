import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnimeSql {
    // insertar datos en la tabla

    public static boolean insertarAnime(Anime anime){
        String sql = "INSERT INTO anime (nombre, descripcion, fecha, puntuacion) VALUES (?, ?, ?, ?)";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexion()) {
            ps = conn.prepareStatement(sql); // Preparamos la sentencia SQL, sql es la variable que contiene la consulta
            ps.setString(1, anime.getNombre());
            ps.setString(2, anime.getDescripcion());
            ps.setString(3, anime.getFecha());
            ps.setInt(4, anime.getPuntuacion());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            System.out.println("Error al insertar anime: " + e.getMessage());
            return false;
        }
    }
    public static List<Anime> leerBaseDatos() {
        ArrayList<Anime> listaAnimes = new ArrayList<>();
        Anime anime;
        String sql = "SELECT * FROM anime";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexion()) {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String fecha = rs.getString("fecha");
                int puntuacion = rs.getInt("puntuacion");
                anime = new Anime(nombre, descripcion, fecha, puntuacion);
                listaAnimes.add(anime);
            }
            return listaAnimes;
        } catch (Exception e) {
            System.out.println("Error al leer animes: " + e.getMessage());
            return null;
        }
    }
    public static List<Anime> leerBaseDatosFiltrada(String filtro){
        ArrayList<Anime> listaAnimes = new ArrayList<>();
        Anime anime;
        String sql = "SELECT * FROM anime WHERE nombre LIKE ?";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexion()) {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + filtro + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String fecha = rs.getString("fecha");
                int puntuacion = rs.getInt("puntuacion");
                anime = new Anime(nombre, descripcion, fecha, puntuacion);
                listaAnimes.add(anime);
            }
            return listaAnimes;
        } catch (Exception e) {
            System.out.println("Error al leer animes: " + e.getMessage());
            return null;
        }

    }
    // Acutalizar una entrada de la base de datos
    public static boolean actualizarAnime(Anime anime, String nombreViejo){
        String sql = "UPDATE anime SET nombre = ?, descripcion = ?, fecha = ?, puntuacion = ? WHERE nombre = ?";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexion()) {
            ps = conn.prepareStatement(sql);
            ps.setString(1, anime.getNombre());
            ps.setString(2, anime.getDescripcion());
            ps.setString(3, anime.getFecha());
            ps.setInt(4, anime.getPuntuacion());
            ps.setString(5, nombreViejo);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            System.out.println("Error al actualizar anime: " + e.getMessage());
            return false;
        }
    }
    // Eliminar una entrada de la base de datos
    public static boolean eliminarAnime(String nombre){
        String sql = "DELETE FROM anime WHERE nombre = ?";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexion()) {
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            System.out.println("Error al eliminar anime: " + e.getMessage());
            return false;
        }
    }

}
