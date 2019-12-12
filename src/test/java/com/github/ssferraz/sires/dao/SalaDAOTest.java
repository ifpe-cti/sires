package com.github.ssferraz.sires.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;

import org.junit.Test;

import com.github.ssferraz.sires.entity.Sala;

public class SalaDAOTest {
	
	SalaDAO dao;
	Sala sala;

	@Before
	public void setUp() throws Exception {
		dao = new SalaDAO();
		sala = new Sala('C',"Laboratório de Informática I","Laboratório de Informática");	
	}

//	@Test
//	public void saveTest() {
//		dao.save(sala);
//		Sala sala2 = dao.getById(sala.getId());
//		assertEquals(true, sala.equals(sala2));
//	}
//	
//	@Test
//	public void updateTest() {
//		//Admitindo que há pelo menos uma sala registrada no BD e que possui ID == 1
//		Sala sala1 = dao.getById(1);
//		String nomeAntigo = sala1.getNome();
//		sala1.setNome("Laboratório de Informática II");
//		dao.update(sala1);
//		
//		Sala sala2 = dao.getById(1);
//		
//		assertEquals(true, sala1.equals(sala2));
//		assertEquals(true, sala1.getNome().equals(sala2.getNome()));
//		assertEquals(false, sala1.getNome().equals(nomeAntigo));
//
//	}
	
//	@Test
//	public void removeByIdTest() {
//		Sala sala1 = dao.getById(1);
//		dao.removeById(sala1.getId());
//		
//		Sala sala2 = dao.getById(1);
//		
//		assertNull(sala2);
//	}
	
	@Test
	public void findAllTest() {
		List<Sala> salas = dao.findAll();
		
		//Admitindo que há salas registradas no BD
		//assertEquals(false,salas.isEmpty());
		
		//Supondo que não há salas no banco:
		assertEquals(true,salas.isEmpty());
	}

}
