package Services;

import Config.HibernateConfig;
import Model.Autor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AutorServices {
    public static void insertarAutor(Autor autor){
        try(Session sesion = HibernateConfig.getSessionFactory().openSession()){
            Transaction transaccion = sesion.beginTransaction();
            sesion.save(autor);
            transaccion.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void borrarAutor(Autor autor){
        try(Session sesion = HibernateConfig.getSessionFactory().openSession()){
            Transaction transaccion = sesion.beginTransaction();
            sesion.delete(autor);
            transaccion.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static List<Autor> listarAutores(){
        try(Session sesion = HibernateConfig.getSessionFactory().openSession()){
            List<Autor> autores = sesion.createQuery("from Autor", Autor.class).getResultList();
            return autores;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
