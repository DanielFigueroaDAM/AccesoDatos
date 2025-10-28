package paqueteConexion;

import objeto.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CRUD {
    public static void insertarPelicula(Pelicula pelicula){
        String sql = "insert into pelicula (Titulo,Director,AnoEstreo,Xenero) values (?,?,?,?)";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexion()){
            ps = conn.prepareStatement(sql);
            ps.setString(1,pelicula.getTitulo());
            ps.setString(2,pelicula.getDirector());
            ps.setInt(3,pelicula.getAnoEstreo());
            ps.setString(4,pelicula.getXenero());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("insercion fallida: "+e.getMessage());
        }
    }
    public static ArrayList<Pelicula> leerPeliculas(){
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
        Pelicula p;
        String sql = "Select * from pelicula";
        PreparedStatement ps;
        try(Connection conn = Conexion.conexion()){
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("Id");
                String titulo = rs.getString("Titulo");
                String director = rs.getString("Director");
                int anoEstro = rs.getInt("AnoEstreo");
                String xenero = rs.getString("Xenero");
                p = new Pelicula(id,titulo,director,anoEstro,xenero);
                listaPeliculas.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error al leer la base de datos"+e.getMessage());
        }
        return listaPeliculas;
    }

}
