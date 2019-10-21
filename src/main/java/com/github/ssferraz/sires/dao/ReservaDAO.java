package com.github.ssferraz.sires.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.github.ssferraz.sires.entity.Reserva;

public class ReservaDAO {

	private static ReservaDAO instance;
	protected EntityManager entityManager;
	private EntityManagerFactory emf = null;

	public static ReservaDAO getInstance() {
		if (instance == null) {
			instance = new ReservaDAO();
		}

		return instance;
	}

	private ReservaDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernateRe");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Reserva getById(final int id) {
		return entityManager.find(Reserva.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Reserva> findAll() {
		return entityManager.createQuery("Para " + Reserva.class.getName()).getResultList();
	}

	public void persist(Reserva reserva) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(reserva);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Reserva reserva) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(reserva);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Reserva reserva) {
		try {
			entityManager.getTransaction().begin();
			reserva = entityManager.find(Reserva.class, reserva.getId());
			entityManager.remove(reserva);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			Reserva reserva = getById(id);
			remove(reserva);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void update(Reserva reserva) {

		 EntityManager em = emf.createEntityManager();
	        em.getTransaction().begin();
	        em.merge(reserva);
	        em.getTransaction().commit();
	        em.close();
	
		
	}

}
