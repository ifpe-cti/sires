package com.github.ssferraz.sires.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;

import org.junit.Test;

import com.github.ssferraz.sires.entity.Reserva;
import com.github.ssferraz.sires.entity.Solicitacao;

public class ReservaDAOTest {

	ReservaDAO daoReserva;
	SolicitacaoDAO daoSolicitacao;
	Reserva reserva;

	@Before
	public void setUp() throws Exception {
		daoReserva = new ReservaDAO();
		daoSolicitacao = new SolicitacaoDAO();
		Solicitacao s = daoSolicitacao.getById(1);
		s.setStatus("Aprovada");
		reserva = new Reserva(s);
	}

//	@Test
//	public void saveTest() {
//		daoReserva.save(reserva);
//		Reserva reserva2 = daoReserva.getById(reserva.getId());
//		assertEquals(true, reserva.equals(reserva2));
//	}
//	
//	@Test
//	public void updateTest() {

//		//Admitindo que há pelo menos uma reserva registrada no BD e que possui ID == 1
//		Reserva reserva1 = daoReserva.getById(1);
//		String eventoAntigo = reserva1.getEvento();
//		reserva1.setEvento("Minicurso IA");
//		daoReserva.update(reserva1);
//		
//		Reserva reserva2 = daoReserva.getById(1);
//		
//		assertEquals(true, reserva1.equals(reserva2));
//		assertEquals(true, reserva1.geEvento().equals(reserva2.getEvento()));
//		assertEquals(false, reserva1.getEvento().equals(eventoAntigo));
//
//	}

//	@Test
//	public void removeByIdTest() {
//		Reserva reserva1 = daoReserva.getById(1);
//		daoReserva.removeById(reserva1.getId());
//		
//		Reserva reserva2 = daoReserva.getById(1);
//		
//		assertNull(reserva2);
//	}

	@Test
	public void findAllTest() {
		List<Reserva> reservas = daoReserva.findAll();

		// Admitindo que há reservas registradas no BD
		// assertEquals(false,reservas.isEmpty());

		// Supondo que não há solicitações no banco:
		assertEquals(true, reservas.isEmpty());
	}

}
