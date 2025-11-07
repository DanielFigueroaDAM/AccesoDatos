
import XmlUtils.XML_Adestrador;
import XmlUtils.XML_Pokedex;
import model.Adestrador;
import model.Pokedex;
import model.Pokemon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import services.AdestradorServices;
import services.PokedexServices;
import services.PokemonServices;

import java.text.SimpleDateFormat;


public class App {
    public static void main(String[] args) {
        try {
            // Crea el SessionFactory a partir del archivo de configuración
            SessionFactory factory = new Configuration().configure("properties.xml").buildSessionFactory();
            // Abre una sesión
            Session session = factory.openSession();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Pokedex p =new Pokedex("Pikachu", 6.0, "Eléctrico");
            PokedexServices.crearEnPokedex(p);
            PokedexServices.crearEnPokedex(new Pokedex("Charmander", 8.5, "Fuego"));
            PokedexServices.crearEnPokedex(new Pokedex("Bulbasaur", 6.9, "Planta/Veneno"));
            PokedexServices.crearEnPokedex(new Pokedex("Squirtle", 9.0, "Agua"));
            PokedexServices.crearEnPokedex(new Pokedex("Jigglypuff", 5.5, "Normal/Hada"));
            PokedexServices.crearEnPokedex(new Pokedex("Meowth", 4.2, "Normal"));
            PokedexServices.crearEnPokedex(new Pokedex("Psyduck", 19.6, "Agua"));
            PokedexServices.crearEnPokedex(new Pokedex("Machop", 19.5, "Lucha"));
            PokedexServices.crearEnPokedex(new Pokedex("Geodude", 20.0, "Roca/Tierra"));
            PokedexServices.crearEnPokedex(new Pokedex("Eevee", 6.5, "Normal"));

            Adestrador a=new Adestrador( "Ash Ketchum", sdf.parse("22/02/1990"));
            AdestradorServices.crearAdestrador(a);
            AdestradorServices.crearAdestrador(new Adestrador( "Misty", sdf.parse("09/07/1992")));

            PokemonServices.insertarPokemon(new Pokemon("PikachuAB", sdf.parse("15/08/2020"),p,a));

            PokemonServices.listarPokemons().forEach(System.out::println);
            PokedexServices.listarPokedex().forEach(System.out::println);
            AdestradorServices.listarAdestradores().forEach(System.out::println);

//            XML_Pokedex.pokedexToXML(PokedexServices.listarPokedex());
//            XML_Adestrador.adestradoresToXML(AdestradorServices.listarAdestradores());
//
//            AdestradorServices.eliminarTodosDeAdestrador();
//            PokedexServices.eliminarTodosDePokedex();





            session.close();
            factory.close();
        } catch (Exception e) {
            System.err.println("❌ Error al conectar con la base de datos:"+ e.getMessage());
        }
    }
}
