package services;

import config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GatosServices {
    public void meterPokemonEnPokedex(String nome, double peso, String misc){
        try(Session sesion = HibernateConfig.getSessionFactory().openSession()){
            Transaction transaction = sesion.beginTransaction();


        }
    }
}
