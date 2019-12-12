package com.github.ssferraz.sires.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.github.ssferraz.sires.connection.ConnectionFactory;
import com.github.ssferraz.sires.entity.Usuario;

public class UsuarioDAO{


	// Salvar no banco
	public void save(Usuario usuario) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	// Atualizar no banco
	public void update(Usuario usuario) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			em.merge(usuario);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void remove(Usuario usuario) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public void removeById(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {

			Usuario usuario = em.find(Usuario.class, id);

			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	// Recuperar por ID
	public Usuario getById(Integer id) {

		EntityManager em = new ConnectionFactory().getConnection();

		Usuario usuario = null;

		try {
			usuario = em.find(Usuario.class, id);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}

		return usuario;
	}
	
	// Recuperar por Siape
	@SuppressWarnings("unchecked")
		public List<Usuario> getBySiape(String siape) {

			EntityManager em = new ConnectionFactory().getConnection();

			List<Usuario> usuarios = null;

			try {
				usuarios = em.createQuery("from Usuario where siape = " + siape).getResultList();
			} catch (Exception e) {
				System.err.println(e);
			} finally {
				em.close();
			}

			return usuarios;
		}
		
		
	// Recuperar Todos os Registros
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {

		EntityManager em = new ConnectionFactory().getConnection();

		List<Usuario> lista = null;

		try {
			lista = em.createQuery("from Usuario order by id asc").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}

		return lista;
	}
}