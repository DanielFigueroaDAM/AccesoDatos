package AccessBD;

import Objetos.Vehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AccesoABaseDeDatos {

    public static ArrayList<Vehiculo> setVehiculosTable(){
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        Vehiculo vehiculo;
        String sql = "SELECT * FROM vehiculo";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexion()) {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String modelo = rs.getString("Modelo");
                String marca = rs.getString("Marca");
                int ano = rs.getInt("Ano");
                String descripcion = rs.getString("Descripcion");
                listaVehiculos.add(new Vehiculo(id,modelo,marca,ano,descripcion));
            }
            return listaVehiculos;
        } catch (Exception e) {
            System.out.println("Error al leer animes: " + e.getMessage());
            return null;
        }
    }
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

    public static boolean actualizarVehiculo(Vehiculo vehiculo, int id) {
        String sql = "UPDATE anime SET modelo = ?, marca = ?, ano = ? ,descripcion = ? WHERE id = ?";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexion()) {
            ps = conn.prepareStatement(sql);
            ps.setString(2, vehiculo.getDescripcion());
            ps.setString(3, vehiculo.getModelo());
            ps.setInt(4, vehiculo.getAno());
            ps.setInt(4, vehiculo.getId()); // me quede aqui
            ps.setString(1, vehiculo.getMarca());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            System.out.println("Error al actualizar anime: " + e.getMessage());
            return false;
        }
    }
    public static boolean eliminarVehiculo(int id){
        String sql = "DELETE FROM Vehiculo WHERE nome = ?";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexion()) {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            System.out.println("Error al eliminar anime: " + e.getMessage());
            return false;
        }
    }








}
