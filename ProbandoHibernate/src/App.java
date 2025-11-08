import Config.HibernateConfig;
import Model.Autor;
import Services.AutorServices;
import org.hibernate.SessionFactory;

import javax.security.auth.login.Configuration;

public class App {
    public static void main(String[] args) {

        //Autor a  =new Autor("Cervantes", "Española");
//        AutorServices.insertarAutor(a);

        Autor a = AutorServices.listarAutores().get(0);
        AutorServices.borrarAutor(a);
    }
}
