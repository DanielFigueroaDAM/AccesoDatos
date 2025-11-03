
import model.Pokedex;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import services.PokedexServices;


public class App {
    public static void main(String[] args) {
        try {
            // Crea el SessionFactory a partir del archivo de configuración
            SessionFactory factory = new Configuration().configure("properties.xml").buildSessionFactory();
            // Abre una sesión
            Session session = factory.openSession();

//            PokedexServices.crearEnPokedex(new Pokedex("Pikachu", 6.0, "Eléctrico"));
//            PokedexServices.crearEnPokedex(new Pokedex("Charmander", 8.5, "Fuego"));
//            PokedexServices.crearEnPokedex(new Pokedex("Bulbasaur", 6.9, "Planta/Veneno"));
//            PokedexServices.crearEnPokedex(new Pokedex("Squirtle", 9.0, "Agua"));
//            PokedexServices.crearEnPokedex(new Pokedex("Jigglypuff", 5.5, "Normal/Hada"));
//            PokedexServices.crearEnPokedex(new Pokedex("Meowth", 4.2, "Normal"));
//            PokedexServices.crearEnPokedex(new Pokedex("Psyduck", 19.6, "Agua"));
//            PokedexServices.crearEnPokedex(new Pokedex("Machop", 19.5, "Lucha"));
//            PokedexServices.crearEnPokedex(new Pokedex("Geodude", 20.0, "Roca/Tierra"));
//            PokedexServices.crearEnPokedex(new Pokedex("Eevee", 6.5, "Normal"));



            PokedexServices.listarPokedex().forEach(System.out::println);


            session.close();
            factory.close();
        } catch (Exception e) {
            System.err.println("❌ Error al conectar con la base de datos:");
        }
    }
}
