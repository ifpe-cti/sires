package com.github.ssferraz.sires.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;

import org.junit.Test;

import com.github.ssferraz.sires.entity.Usuario;

public class UsuarioDAOTest {

	UsuarioDAO dao;
	Usuario usuario;

	@Before
	public void setUp() throws Exception {
		dao = new UsuarioDAO();
		usuario = new Usuario("1111111", "admin", "Maria da Silva", "maria@ifpe.edu.br", true);
	}

//	@Test
//	public void saveTest() {
//		dao.save(usuario);
//		Usuario usuario2 = dao.getById(usuario.getId());
//		assertEquals(true, usuario.equals(usuario2));
//	}
//	
//	@Test
//	public void updateTest() {
//		//Admitindo que há pelo menos um usuário registrado no BD e que possui ID == 1
//		Usuario usuario1 = dao.getById(1);
//		String nomeAntigo = usuario1.getNome();
//		usuario1.setNome("Maria da Silva Santos");
//		dao.update(usuario1);
//		
//		Usuario usuario2 = dao.getById(1);
//		
//		assertEquals(true, usuario1.equals(usuario2));
//		assertEquals(true, usuario1.getNome().equals(usuario2.getNome()));
//		assertEquals(false, usuario1.getNome().equals(nomeAntigo));
//
//	}

//	@Test
//	public void removeByIdTest() {
//		Usuario usuario1 = dao.getById(1);
//		dao.removeById(usuario1.getId());
//		
//		Usuario usuario2 = dao.getById(1);
//		
//		assertNull(usuario2);
//	}

	@Test
	public void findAllTest() {
		List<Usuario> usuarios = dao.findAll();

		// Admitindo que há usuários registrados no BD
		assertEquals(false, usuarios.isEmpty());

		// Supondo que não há usuários no banco:
		assertEquals(true, usuarios.isEmpty());

	}

}
