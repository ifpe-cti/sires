package com.github.ssferraz.sires.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.github.ssferraz.sires.entity.Solicitacao;

public class SolicitacaoDAO {

	private static SolicitacaoDAO instance;
	protected EntityManager entityManager;
	private EntityManagerFactory emf = null;

	public static SolicitacaoDAO getInstance() {
		if (instance == null) {
			instance = new SolicitacaoDAO();
		}
		return instance;
	}

	public SolicitacaoDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		emf = Persistence.createEntityManagerFactory("siresPU");
		if (entityManager == null) {
			entityManager = emf.createEntityManager();
		}
		return entityManager;
	}

	public Solicitacao getById(int id) {
		return entityManager.find(Solicitacao.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Solicitacao> findAll() {
		List<Solicitacao> listaRetorno = this.entityManager.createQuery("from " + Solicitacao.class.getName())
				.getResultList();
		this.entityManager.close();
		return listaRetorno;
	}

	public void persist(Solicitacao solicitacao) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(solicitacao);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void update(Solicitacao solicitacao) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(solicitacao);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Solicitacao solicitacao) {
		try {
			entityManager.getTransaction().begin();
			solicitacao = entityManager.find(Solicitacao.class, solicitacao.getId());
			entityManager.remove(solicitacao);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(int id) {
		try {
			Solicitacao solicitacao = getById(id);
			remove(solicitacao);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
