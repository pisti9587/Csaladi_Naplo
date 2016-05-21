package com.mycompany.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Gégény István
 *
 */
public class NaploEntitasKezelo {

	public EntityManager em;
	EntityManagerFactory emf;

	/**
	 * 
	 */
	public NaploEntitasKezelo() {
		emf = Persistence.createEntityManagerFactory("naplok");
		em = emf.createEntityManager();

		em.getTransaction().begin();
	}

}
