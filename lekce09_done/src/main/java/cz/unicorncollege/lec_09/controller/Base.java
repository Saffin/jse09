package cz.unicorncollege.lec_09.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Base {
	protected static EntityManager em;
	
	public Base() {
		setEntityManager();
	}
	
	protected static void setEntityManager() {

		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("LEC09");
		em = emf.createEntityManager();
	}
}
