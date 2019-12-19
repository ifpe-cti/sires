package com.github.ssferraz.sires.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.github.ssferraz.sires.connection.ConnectionFactory;
import com.github.ssferraz.sires.entity.Solicitacao;
import com.github.ssferraz.sires.entity.Usuario;

public class SolicitacaoDAO {

	// Salvar no banco
	public void save(Solicitacao solicitacao) {
		EntityManager em = new ConnectionFactory().getConnection();
		System.out.println(solicitacao.getHorarioInicio());
		try {
			em.getTransaction().begin();
			em.persist(solicitacao);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	// Atualizar no banco
	public void update(Solicitacao solicitacao) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			em.merge(solicitacao);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void remove(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {

			Solicitacao solicitacao = em.find(Solicitacao.class, id);

			em.getTransaction().begin();
			em.remove(solicitacao);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	// Recuperar por ID
	public Solicitacao getById(Integer id) {

		EntityManager em = new ConnectionFactory().getConnection();

		Solicitacao solicitacao = null;

		try {
			solicitacao = em.find(Solicitacao.class, id);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}

		return solicitacao;
	}

	// Recuperar Todos os Registros
	@SuppressWarnings("unchecked")
	public List<Solicitacao> findAll() {

		EntityManager em = new ConnectionFactory().getConnection();

		List<Solicitacao> lista = null;

		try {
			lista = em.createQuery("from Solicitacao order by id asc").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}

		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Solicitacao> findAutorizadas() {

		EntityManager em = new ConnectionFactory().getConnection();

		List<Solicitacao> lista = null;

		try {
			lista = em.createQuery("from Solicitacao where autorizado = true order by id asc").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}

		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Solicitacao> findReprovadas() {

		EntityManager em = new ConnectionFactory().getConnection();

		List<Solicitacao> lista = null;

		try {
			lista = em.createQuery("from Solicitacao where autorizado = false order by id asc").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}

		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Solicitacao> findPendentes() {

		EntityManager em = new ConnectionFactory().getConnection();

		List<Solicitacao> lista = null;

		try {
			lista = em.createQuery("from Solicitacao where status = 'Pendente' order by id asc").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}

		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Solicitacao> findByRequisitante(Usuario usuario) {

		EntityManager em = new ConnectionFactory().getConnection();

		List<Solicitacao> lista = null;

		try {
			lista = em.createQuery("from Solicitacao where requisitante_id = " + usuario.getId() + " order by id asc")
					.getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}

		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public boolean verificaDisponibilidade(Solicitacao solicitacao) {
		EntityManager em = new ConnectionFactory().getConnection();
		List<Solicitacao> lista = null;		
		
		String sql = "from Reserva r "
				+ "inner join r.solicitacao as s "
				+ "inner join s.sala as sl "
				+ "where s.data = :data "
				+ "and sl.id = :idSala "
				+ "and ((s.horarioInicio >= :horarioInicio and s.horarioInicio <= :horarioFim) "
				+ "or (s.horarioFim >= :horarioInicio and s.horarioFim <= :horarioFim))";
		
		System.out.println(sql);
		try {
			Query query = em.createQuery(sql);
			query.setParameter("data", solicitacao.getData());
			query.setParameter("idSala", solicitacao.getSala().getId());
			query.setParameter("horarioInicio", solicitacao.getHorarioInicio());
			query.setParameter("horarioFim", solicitacao.getHorarioFim());
			lista = query.getResultList();
			
			
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}

		return lista.isEmpty();
	}

}