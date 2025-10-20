
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {
        try {
            // Crea el SessionFactory a partir del archivo de configuración
            SessionFactory factory = new Configuration().configure("properties.xml").buildSessionFactory();

            // Abre una sesión
            Session session = factory.openSession();



            // Cierra sesión y factory
            session.close();
            factory.close();
        } catch (Exception e) {
            System.err.println("❌ Error al conectar con la base de datos:");
            e.printStackTrace();
        }
    }
}
