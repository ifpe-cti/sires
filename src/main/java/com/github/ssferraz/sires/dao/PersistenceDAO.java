package com.github.ssferraz.sires.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceDAO {

	private static PersistenceDAO instance = null;
	private EntityManagerFactory emf = null;

	private PersistenceDAO() {
		this.emf = Persistence.createEntityManagerFactory("pmgusPU");
	}

	public static PersistenceDAO getInstance() {
		if (instance == null)
			instance = new PersistenceDAO();
		return instance;
	}

	public void persist(Object o) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}

	public void update(Object o) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
		em.close();
	}

	public List<?> read(String sql) {
		EntityManager em = emf.createEntityManager();
		List<?> result = em.createQuery(sql).getResultList();
		em.close();
		return result;
	}

	public void delete(Object o) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		if (!em.contains(o)) {
			o = em.merge(o);
		}
		em.remove(o);
		em.getTransaction().commit();
		em.close();
	}
}
