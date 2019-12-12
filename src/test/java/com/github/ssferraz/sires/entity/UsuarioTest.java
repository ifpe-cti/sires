package com.github.ssferraz.sires.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.ssferraz.sires.entity.Usuario;

public class UsuarioTest {

	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;


	@Before
	public void setUp(){
		
		usuario1 = new Usuario(1, "1234567","admin","Maria da Silva","maria@ifpe.edu.br",true);
		usuario2 = new Usuario(1, "1234567","admin","Maria da Silva","maria@ifpe.edu.br",true);
		usuario3 = new Usuario(3, "1234567","admin","Maria da Silva","maria@ifpe.edu.br",true);
	}


	@Test
	public void testHashCode() {
		assertEquals(true, usuario1.hashCode() == usuario2.hashCode());
		assertEquals(false, usuario2.hashCode() == usuario3.hashCode());
		assertEquals(false, usuario1.hashCode() == usuario3.hashCode());
		
	}

	@Test
	public void testEqualsObject() {
		assertEquals(true, usuario1.equals(usuario2));
		assertEquals(false, usuario2.equals(usuario3));
		assertEquals(false, usuario1.equals(usuario3));
	}

	@Test
	public void testToString() {
		assertTrue(usuario1.toString().equals(usuario2.toString()));
		assertFalse(usuario2.toString().equals(usuario3.toString()));
		assertFalse(usuario1.toString().equals(usuario3.toString()));
	}

}
