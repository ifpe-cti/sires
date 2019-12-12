package com.github.ssferraz.sires.entity;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.github.ssferraz.sires.entity.Sala;
import com.github.ssferraz.sires.entity.Solicitacao;
import com.github.ssferraz.sires.entity.Usuario;

public class SolicitacaoTest {
	
	private Usuario usuario1;
	private Sala sala1;
	
	private Solicitacao solicitacao1;
	private Solicitacao solicitacao2;
	private Solicitacao solicitacao3;


	@Before
	public void setUp(){
		
		usuario1 = new Usuario(1, "1234567","admin","Maria da Silva","maria@ifpe.edu.br",true);
		sala1 = new Sala(1, 'A',"Auditório I","Auditório");
		
		solicitacao1 = new Solicitacao(1, sala1, new Date(), new Date(),new Date(), usuario1, "Palestra 1", "Pendente");
		solicitacao2 = new Solicitacao(1, sala1, new Date(), new Date(),new Date(), usuario1, "Palestra 1", "Pendente");
		solicitacao3 = new Solicitacao(2, sala1, new Date(), new Date(),new Date(), usuario1, "Palestra 1", "Pendente");
	}


	@Test
	public void testHashCode() {
		assertEquals(true, solicitacao1.hashCode() == solicitacao2.hashCode());
		assertEquals(false, solicitacao2.hashCode() == solicitacao3.hashCode());
		assertEquals(false, solicitacao1.hashCode() == solicitacao3.hashCode());
		
	}

	@Test
	public void testEqualsObject() {
		assertEquals(true, solicitacao1.equals(solicitacao2));
		assertEquals(false, solicitacao2.equals(solicitacao3));
		assertEquals(false, solicitacao1.equals(solicitacao3));
	}

	@Test
	public void testToString() {
		assertTrue(solicitacao1.toString().equals(solicitacao2.toString()));
		assertFalse(solicitacao2.toString().equals(solicitacao3.toString()));
		assertFalse(solicitacao1.toString().equals(solicitacao3.toString()));
	}

}
