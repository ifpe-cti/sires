package com.github.ssferraz.sires.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.github.ssferraz.sires.entity.Sala;

@ManagedBean
@RequestScoped
public class SalaBean {

	EntityManager em;
	EntityManagerFactory emf;
	
	public SalaBean() {
		emf = Persistence.createEntityManagerFactory("sires");
		em = emf.createEntityManager();
	}
	
	public void insert(Sala sala) {
		em.getTransaction().begin();
		em.merge(sala);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void delete(Sala sala) {
		em.getTransaction().begin();
		Query q = em.createNativeQuery("delete sala from sires where nome ="+sala.getNome());
		q.executeUpdate();
		em.getTransaction().commit();
		emf.close();
	}
	
}
