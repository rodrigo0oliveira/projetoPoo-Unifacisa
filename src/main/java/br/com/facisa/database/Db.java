package br.com.facisa.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Db {

    public static  EntityManagerFactory emf;
    public static EntityManager em;

    public static EntityManager openConnection(){
        emf = Persistence.createEntityManagerFactory("projetoPoo");
        em  = emf.createEntityManager();

        return em;
    }

    public static void closeConnection(){
        emf.close();
        em.close();
    }
}
