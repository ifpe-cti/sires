package com.github.ssferraz.sires.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.github.ssferraz.sires.entity.Usuario;

public class UsuarioDAO {

	private static UsuarioDAO instance;
	protected EntityManager entityManager;
	private EntityManagerFactory emf = null;

	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}
		return instance;
	}

	public UsuarioDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		emf = Persistence.createEntityManagerFactory("siresPU");
		if (entityManager == null) {
			entityManager = emf.createEntityManager();
		}

		return entityManager;
	}

	public Usuario getById(int id) {
		return entityManager.find(Usuario.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		List<Usuario> listaRetorno = this.entityManager.createQuery("from " + Usuario.class.getName()).getResultList();
		this.entityManager.close();
		return listaRetorno;
	}

	public void persist(Usuario usuario) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void update(Usuario usuario) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Usuario usuario) {
		try {
			entityManager.getTransaction().begin();
			usuario = entityManager.find(Usuario.class, usuario.getId());
			entityManager.remove(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(int id) {
		try {
			Usuario usuario = getById(id);
			remove(usuario);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}