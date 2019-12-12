package com.github.ssferraz.sires.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("siresPU");

	public EntityManager getConnection() {
		return emf.createEntityManager();
	}
}
