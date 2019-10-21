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
import com.github.ssferraz.sires.dao.ReservaDAO;
import com.github.ssferraz.sires.dao.SalaDAO;
import com.github.ssferraz.sires.entity.Reserva;
import com.github.ssferraz.sires.entity.Sala;

	@ManagedBean
	@RequestScoped
	public class ReservaBean {

		EntityManager em;
		EntityManagerFactory emf;
		ReservaDAO reservaDAO;
		
		public ReservaBean() {
			emf = Persistence.createEntityManagerFactory("sires");
			em = emf.createEntityManager();
		}
		
		public void insert(Reserva reserva) {
			em.getTransaction().begin();
			em.merge(reserva);
			em.getTransaction().commit();
			emf.close();
		}
		
		public void delete(Reserva reserva) {
			em.getTransaction().begin();
			Query q = em.createNativeQuery("delete sala from sires where nome ="+reserva.getId());
			q.executeUpdate();
			em.getTransaction().commit();
			emf.close();
		}
		public void update(Reserva reserva) {
				this.reservaDAO.update(reserva);
		        FacesContext.getCurrentInstance().addMessage(null, 
		                new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso!","A reserva foi atualizada com sucesso!"));
		    
		}
		
		public Reserva select(Reserva reserva) {
			   try{
		           return (Reserva)PersistenceDAO.getInstance().read("select * from reserva where codigo="+reserva.getId()).get(0);
		       }catch(IndexOutOfBoundsException index){
		           return null;
		       }
		}
		
	}


