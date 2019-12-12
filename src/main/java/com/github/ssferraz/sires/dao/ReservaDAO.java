package com.github.ssferraz.sires.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.github.ssferraz.sires.connection.ConnectionFactory;
import com.github.ssferraz.sires.entity.Reserva;

public class ReservaDAO {

	// Salvar no banco
	public void save(Reserva reserva) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			em.persist(reserva);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	// Atualizar no banco
	public void update(Reserva reserva) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			em.merge(reserva);
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

			Reserva reserva = em.find(Reserva.class, id);

			em.getTransaction().begin();
			em.remove(reserva);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	// Recuperar por ID
	public Reserva getById(Integer id) {

		EntityManager em = new ConnectionFactory().getConnection();

		Reserva reserva = null;

		try {
			reserva = em.find(Reserva.class, id);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}

		return reserva;
	}

	// Recuperar Todos os Registros
	@SuppressWarnings("unchecked")
	public List<Reserva> findAll() {

		EntityManager em = new ConnectionFactory().getConnection();

		List<Reserva> lista = null;

		try {
			lista = em.createQuery("from Reserva order by id asc").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}

		return lista;
	}
}