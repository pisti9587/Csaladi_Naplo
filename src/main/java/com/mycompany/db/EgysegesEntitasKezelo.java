package com.mycompany.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Gégény István
 *
 */
public class EgysegesEntitasKezelo {

	public EntityManager em;
	EntityManagerFactory emf;

	/**
	 * 
	 */
	public EgysegesEntitasKezelo() {
		emf = Persistence.createEntityManagerFactory("egyseges");
		em = emf.createEntityManager();

		em.getTransaction().begin();
		
		
	}

}
