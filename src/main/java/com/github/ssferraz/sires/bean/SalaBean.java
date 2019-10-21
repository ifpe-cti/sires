package com.github.ssferraz.sires.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.github.ssferraz.sires.dao.PersistenceDAO;
import com.github.ssferraz.sires.dao.SalaDAO;
import com.github.ssferraz.sires.entity.Sala;

@ManagedBean
@RequestScoped
public class SalaBean {

	EntityManager em;
	EntityManagerFactory emf;
	SalaDAO salaDAO;
	
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
	public void update(Sala sala) {
			this.salaDAO.update(sala);
	        FacesContext.getCurrentInstance().addMessage(null, 
	                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!","A sala foi atualizada com sucesso!"));
	    
	}
	
	public Sala select(Sala sala) {
		   try{
	           return (Sala)PersistenceDAO.getInstance().read("select * from Sala where codigo="+sala.getId()).get(0);
	       }catch(IndexOutOfBoundsException index){
	           return null;
	       }
	}
	
}
