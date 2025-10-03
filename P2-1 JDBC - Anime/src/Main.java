import java.sql.Connection;

public class Main {
    public static void main(String[] args) {


        Connection conn = Conexion.conexion();
        if (conn != null) {
            System.out.println("Conexión establecida correctamente.");
        }
        Anime fecha = new Anime();


        AnimeSql.insertarAnime(new Anime("Naruto", "Anime de ninjas", fecha.stringToDate("2002-02-02"), 9));

        AnimeSql.leerBaseDatos().forEach(System.out::println);
        System.out.println("--------------------------------");
        AnimeSql.leerBaseDatosFiltrada( "Naruto" ).forEach(System.out::println);

        AnimeSql.actualizarAnime(new Anime("Naruta", "Anime de ninjas", fecha.stringToDate("2002-02-02"), 9), "Naruto");

        AnimeSql.leerBaseDatos().forEach(System.out::println);

        AnimeSql.eliminarAnime("Naruta");

        AnimeSql.leerBaseDatos().forEach(System.out::println);

    }

}