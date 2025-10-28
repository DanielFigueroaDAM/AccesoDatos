
import model.EPokedex;
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

            EPokedex p = new EPokedex("Pikachu", 6.0, "Eléctrico");

            PokedexServices.crearEnPokedex(p);



            PokedexServices.listarPokedex().forEach(System.out::println);
            EPokedex recogido = PokedexServices.listarPokedex().get(0);
            PokedexServices.modificarPokedex(new EPokedex(4L, "Raichu", 30.0, "Eléctrico"));
            //PokedexServices.eliminarTodosDePokedex();

            // Cierra sesión y factory
            session.close();
            factory.close();
        } catch (Exception e) {
            System.err.println("❌ Error al conectar con la base de datos:");
            e.printStackTrace();
        }
    }
}
