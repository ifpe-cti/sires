package com.github.ssferraz.sires.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 

import com.github.ssferraz.sires.entity.Usuario;
	 
	public class UsuarioDAO {
	 
	       private static UsuarioDAO instance;
	       protected EntityManager entityManager;
	        
	       public static UsuarioDAO getInstance(){
	         if (instance == null){
	            instance = new UsuarioDAO();
	         }
	          
	         return instance;
	       }
	 
	       private UsuarioDAO() {
	         entityManager = getEntityManager();
	       }
	 
	       private EntityManager getEntityManager() {
	        EntityManagerFactory factory = 
	        Persistence.createEntityManagerFactory("crudHibernateUsu");
	        if (entityManager == null) {
	          entityManager = factory.createEntityManager();
	        }
	 
	        return entityManager;
	       }
	 
	       public Usuario getById(final int id) {
	         return entityManager.find(Usuario.class, id);
	       }
	 
	       @SuppressWarnings("unchecked")
	       public List<Usuario> findAll() {
	         return entityManager.createQuery("Para " + 
	         Usuario.class.getName()).getResultList();
	       }
	}