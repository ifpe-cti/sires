package com.github.ssferraz.sires.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.ssferraz.sires.entity.Sala;

public class SalaTest {

	private Sala sala1;
	private Sala sala2;
	private Sala sala3;


	@Before
	public void setUp(){
		
		sala1 = new Sala(1, 'A',"Auditório I","Auditório");
		sala2 = new Sala(1, 'A',"Auditório I","Auditório");
		sala3 = new Sala(2, 'C',"Laboratório de Informática III","Laboratório de Informática");
		
	}


	@Test
	public void testHashCode() {
		assertEquals(true, sala1.hashCode() == sala2.hashCode());
		assertEquals(false, sala2.hashCode() == sala3.hashCode());
		assertEquals(false, sala1.hashCode() == sala3.hashCode());
		
	}

	@Test
	public void testEqualsObject() {
		assertEquals(true, sala1.equals(sala2));
		assertEquals(false, sala2.equals(sala3));
		assertEquals(false, sala1.equals(sala3));
	}

	@Test
	public void testToString() {
		assertTrue(sala1.toString().equals(sala2.toString()));
		assertFalse(sala2.toString().equals(sala3.toString()));
		assertFalse(sala1.toString().equals(sala3.toString()));
	}

}
