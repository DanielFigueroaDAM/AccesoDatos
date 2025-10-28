package services;

import config.HibernateConfig;
import model.EPokedex;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PokedexServices {
    public static void crearEnPokedex(EPokedex pokedex){
        try(Session session = HibernateConfig.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(pokedex);
            transaction.commit();
        }catch (Exception e) {
            System.out.println("Erro ao crea la pokedex: " + e.getMessage());
        }
    }

    public static List<EPokedex> listarPokedex(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from EPokedex", EPokedex.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error al leer la lista de pokedex: " + e.getMessage());
            return null;
        }
    }

    public static void eliminarTodosDePokedex() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("DELETE FROM EPokedex").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar todos de la pokedex: " + e.getMessage());
        }
    }
    public static void modificarPokedex(EPokedex pokedex) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(pokedex);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al modificar la pokedex: " + e.getMessage());
        }
    }
}
