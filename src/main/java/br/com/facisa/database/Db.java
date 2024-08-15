package br.com.facisa.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Db {

    static  EntityManagerFactory emf;
    static EntityManager em;

    public static void openConnection(){
        emf = Persistence.createEntityManagerFactory("projetoPoo");
        em  = emf.createEntityManager();
    }

    public static void closeConnection(){
        emf.close();
        em.close();
    }
}
