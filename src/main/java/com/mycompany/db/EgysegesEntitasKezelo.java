package com.mycompany.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Gégény István
 *
 */
public class EgysegesEntitasKezelo {



    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("egyseges");
    public static EntityManager em = emf.createEntityManager();
    
    public static EntityManager getEntityManeger()
    {
        return em;
    }
    
    public static void close(){
    
        em.close();
        emf.close();
    }



   

	
}
