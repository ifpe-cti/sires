package com.github.ssferraz.sires.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.github.ssferraz.sires.entity.Sala;

public class SalaDAO {

	private static SalaDAO instance;
	protected EntityManager entityManager;
	 private EntityManagerFactory emf = null;

	public static SalaDAO getInstance() {
		if (instance == null) {
			instance = new SalaDAO();
		}

		return instance;
	}

	private SalaDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernateSa");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Sala getById(final int id) {
		return entityManager.find(Sala.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Sala> findAll() {
		return entityManager.createQuery("Para " + Sala.class.getName()).getResultList();
	}

	public void persist(Sala sala) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(sala);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Sala sala) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(sala);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Sala sala) {
		try {
			entityManager.getTransaction().begin();
			sala = entityManager.find(Sala.class, sala.getId());
			entityManager.remove(sala);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			Sala sala = getById(id);
			remove(sala);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void update(Sala sala) {

		 EntityManager em = emf.createEntityManager();
	        em.getTransaction().begin();
	        em.merge(sala);
	        em.getTransaction().commit();
	        em.close();
	}
	
	

}
