import objeto.Pelicula;
import paqueteConexion.CRUD;
import paqueteConexion.Conexion;

import java.sql.Connection;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Connection conn = Conexion.conexion();
        Pelicula p1 = new Pelicula("El resplandor", "Stanlee kubrick", 2002, "Terror");
        Pelicula p2 = new Pelicula("chuky","Leonardo Dicoprio", 1992, "Terror");
//        CRUD.insertarPelicula(p1);
//        CRUD.insertarPelicula(p2);
        ArrayList<Pelicula> listaRecogida = CRUD.leerPeliculas();
        for (Pelicula p : listaRecogida){
            System.out.println(p);
        }
    }
}
