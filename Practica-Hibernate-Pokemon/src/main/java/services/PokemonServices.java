package services;

import config.HibernateConfig;
import model.Pokemon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PokemonServices {

    public static void insertarPokemon(Pokemon pokemon){
        try(Session sesion = HibernateConfig.getSessionFactory().openSession()){
            Transaction transaccion = sesion.beginTransaction();
            sesion.save(pokemon);
            transaccion.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void actualizarPokemonNombrePorID(int id, String nuevoNombre){
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokemon pokemon = session.get(Pokemon.class, id);
            if (pokemon != null) {
                pokemon.setNome(nuevoNombre);
                session.update(pokemon);
            } else {
                System.out.println("Pokemon no encontrado para actualizar.");
            }
            transaction.commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void borrarPokemonPorID(int id){
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokemon pokemon = session.get(Pokemon.class, id);
            if (pokemon != null) {
                session.delete(pokemon);
            } else {
                System.out.println("Pokemon no encontrado para eliminar.");
            }
            transaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static List<Pokemon> listarPokemons(){
        try(Session session = HibernateConfig.getSessionFactory().openSession()){
            return session.createQuery("from Pokemon", Pokemon.class).getResultList();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }




}
