package com.github.ssferraz.sires.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.github.ssferraz.sires.entity.Perfil;

public class PerfilDAO {

	private static PerfilDAO instance;
	protected EntityManager entityManager;
	private EntityManagerFactory emf = null;

	public static PerfilDAO getInstance() {
		if (instance == null) {
			instance = new PerfilDAO();
		}
		return instance;
	}

	public PerfilDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		emf = Persistence.createEntityManagerFactory("siresPU");
		if (entityManager == null) {
			entityManager = emf.createEntityManager();
		}
		return entityManager;
	}

	public Perfil getById(int id) {
		return entityManager.find(Perfil.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Perfil> findAll() {
		List<Perfil> listaRetorno = this.entityManager.createQuery("from " + Perfil.class.getName()).getResultList();
		this.entityManager.close();
		return listaRetorno;
	}

	public void persist(Perfil perfil) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(perfil);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void update(Perfil perfil) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(perfil);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Perfil perfil) {
		try {
			entityManager.getTransaction().begin();
			perfil = entityManager.find(Perfil.class, perfil.getId());
			entityManager.remove(perfil);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(int id) {
		try {
			Perfil perfil = getById(id);
			remove(perfil);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}