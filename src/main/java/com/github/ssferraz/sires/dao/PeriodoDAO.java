package com.github.ssferraz.sires.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.github.ssferraz.sires.entity.Periodo;

public class PeriodoDAO {

	private static PeriodoDAO instance;
	protected EntityManager entityManager;
	private EntityManagerFactory emf = null;

	public static PeriodoDAO getInstance() {
		if (instance == null) {
			instance = new PeriodoDAO();
		}
		return instance;
	}

	public PeriodoDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		emf = Persistence.createEntityManagerFactory("siresPU");
		if (entityManager == null) {
			entityManager = emf.createEntityManager();
		}
		return entityManager;
	}

	public Periodo getById(int id) {
		return entityManager.find(Periodo.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Periodo> findAll() {
		List<Periodo> listaRetorno = this.entityManager.createQuery("from " + Periodo.class.getName()).getResultList();
		this.entityManager.close();
		return listaRetorno;
	}

	public void persist(Periodo periodo) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(periodo);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void update(Periodo periodo) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(periodo);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Periodo periodo) {
		try {
			entityManager.getTransaction().begin();
			periodo = entityManager.find(Periodo.class, periodo.getId());
			entityManager.remove(periodo);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(int id) {
		try {
			Periodo periodo = getById(id);
			remove(periodo);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
