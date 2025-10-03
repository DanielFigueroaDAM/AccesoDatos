import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnimeSql {

    public static boolean insertarAnime(Anime anime) {
        String sql = "INSERT INTO anime (nome, descripcion, data, puntuacion) VALUES (?, ?, ?, ?)";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexion()) {
            ps = conn.prepareStatement(sql);
            ps.setString(1, anime.getNombre());
            ps.setString(2, anime.getDescripcion());
            ps.setDate(3, anime.getFecha());
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
                String nombre = rs.getString("nome");
                String descripcion = rs.getString("descripcion");
                java.sql.Date fecha = rs.getDate("data");
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

    public static List<Anime> leerBaseDatosFiltrada(String filtro) {
        ArrayList<Anime> listaAnimes = new ArrayList<>();
        Anime anime;
        String sql = "SELECT * FROM anime WHERE nome LIKE ?";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexion()) {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + filtro + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nome");
                String descripcion = rs.getString("descripcion");
                java.sql.Date fecha = rs.getDate("data");
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

    public static boolean actualizarAnime(Anime anime, String nombreViejo) {
        String sql = "UPDATE anime SET nome = ?, descripcion = ?, data = ?, puntuacion = ? WHERE nome = ?";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexion()) {
            ps = conn.prepareStatement(sql);
            ps.setString(1, anime.getNombre());
            ps.setString(2, anime.getDescripcion());
            ps.setDate(3, anime.getFecha());
            ps.setInt(4, anime.getPuntuacion());
            ps.setString(5, nombreViejo);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            System.out.println("Error al actualizar anime: " + e.getMessage());
            return false;
        }
    }
    public static boolean eliminarAnime(String nombre){
        String sql = "DELETE FROM anime WHERE nome = ?";
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