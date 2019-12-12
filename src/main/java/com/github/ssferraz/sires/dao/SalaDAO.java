package com.github.ssferraz.sires.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.github.ssferraz.sires.connection.ConnectionFactory;
import com.github.ssferraz.sires.entity.Sala;

public class SalaDAO {

	// Salvar no banco
	public void save(Sala sala) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			em.persist(sala);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	// Atualizar no banco
	public void update(Sala sala) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			em.merge(sala);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	//Remover
	public void remove(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {

			Sala sala = em.find(Sala.class, id);

			em.getTransaction().begin();
			em.remove(sala);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	// Recuperar por ID
	public Sala getById(Integer id) {

		EntityManager em = new ConnectionFactory().getConnection();

		Sala sala = null;

		try {
			sala = em.find(Sala.class, id);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}

		return sala;
	}

	// Recuperar Todos os Registros
	@SuppressWarnings("unchecked")
	public List<Sala> findAll() {

		EntityManager em = new ConnectionFactory().getConnection();

		List<Sala> lista = null;

		try {
			lista = em.createQuery("from Sala order by id asc").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}

		return lista;
	}
}