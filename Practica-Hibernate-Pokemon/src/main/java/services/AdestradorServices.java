package services;

import config.HibernateConfig;
import model.Adestrador;
import model.Pokedex;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AdestradorServices {
    public static void crearAdestrador(Adestrador adestrador){
        try(Session session = HibernateConfig.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(adestrador);
            transaction.commit();
        }catch (Exception e) {
            System.out.println("Erro ao crea la adestrador: " + e.getMessage());
        }

    }
    public static List<Adestrador> listarAdestradores(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Adestrador", Adestrador.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error al leer la lista de pokedex: " + e.getMessage());
            return null;
        }
    }

    public static void modificarAdestrador(Adestrador adestrador) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(adestrador);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al modificar la adestrador: " + e.getMessage());
        }
    }
    public static void eliminarTodosDeAdestrador() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Adestrador").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar todos de la adestrador: " + e.getMessage());
        }
    }
}
