import java.sql.Connection;

public class Main {
    public static void main(String[] args) {


        Connection conn = Conexion.conexion();
        if (conn != null) {
            System.out.println("Conexión establecida correctamente.");
        }
        Anime fecha = new Anime();

//        System.out.println("--------------------------------");
//        AnimeSql.insertarAnime(new Anime("Naruto", "Anime de ninjas", fecha.stringToDate("2002-02-02"), 9));
//        System.out.println("--------------------------------");
//        AnimeSql.leerBaseDatos().forEach(System.out::println);
//        System.out.println("--------------------------------");
//        AnimeSql.leerBaseDatosFiltrada( "Naruto" ).forEach(System.out::println);
//        System.out.println("--------------------------------");
//        AnimeSql.actualizarAnime(new Anime("Naruta", "Anime de ninjas", fecha.stringToDate("2002-02-02"), 9), "Naruto");
//        System.out.println("--------------------------------");
//        AnimeSql.leerBaseDatos().forEach(System.out::println);
        System.out.println("--------------------------------");
        AnimeSql.eliminarAnime("Naruta");
        System.out.println("--------------------------------");
        AnimeSql.leerBaseDatos().forEach(System.out::println);

    }

}