package com.github.ssferraz.sires.entity;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.github.ssferraz.sires.entity.Sala;
import com.github.ssferraz.sires.entity.Solicitacao;
import com.github.ssferraz.sires.entity.Reserva;
import com.github.ssferraz.sires.entity.Usuario;

public class ReservaTest {
	
	private Usuario usuario1;
	private Sala sala1;
	private Solicitacao solicitacao;

	
	private Reserva reserva1;
	private Reserva reserva2;
	private Reserva reserva3;


	@Before
	public void setUp(){
		
		usuario1 = new Usuario(1, "1234567","admin","Maria da Silva","maria@ifpe.edu.br",true);
		sala1 = new Sala(1, 'A',"Auditório I","Auditório");
		
		solicitacao = new Solicitacao(1, sala1, new Date(), new Date(),new Date(), usuario1, "Palestra 1", "Pendente");
		
		reserva1 = new Reserva(1,solicitacao);
		reserva2 = new Reserva(1, solicitacao);
		reserva3 = new Reserva(2, solicitacao);
	}


	@Test
	public void testHashCode() {
		assertEquals(true, reserva1.hashCode() == reserva2.hashCode());
		assertEquals(false, reserva2.hashCode() == reserva3.hashCode());
		assertEquals(false, reserva1.hashCode() == reserva3.hashCode());
		
	}

	@Test
	public void testEqualsObject() {
		assertEquals(true, reserva1.equals(reserva2));
		assertEquals(false, reserva2.equals(reserva3));
		assertEquals(false, reserva1.equals(reserva3));
	}

	@Test
	public void testToString() {
		assertTrue(reserva1.toString().equals(reserva2.toString()));
		assertFalse(reserva2.toString().equals(reserva3.toString()));
		assertFalse(reserva1.toString().equals(reserva3.toString()));
	}

}
