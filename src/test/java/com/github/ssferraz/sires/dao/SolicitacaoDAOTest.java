package com.github.ssferraz.sires.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;

import org.junit.Test;

import com.github.ssferraz.sires.entity.Solicitacao;

public class SolicitacaoDAOTest {
	
	SolicitacaoDAO daoSolicitacao;
	SalaDAO daoSala;
	UsuarioDAO daoUsuario;
	Solicitacao solicitacao;

	@Before
	public void setUp() throws Exception {
		daoSolicitacao = new SolicitacaoDAO();
		daoSala = new SalaDAO();
		daoUsuario = new UsuarioDAO();
		solicitacao = new Solicitacao(daoSala.getById(1), new Date(), new Date(), new Date(),daoUsuario.getById(1), "Palestra 5", "Pendente");	
	}

//	@Test
//	public void saveTest() {
//		daoSolicitacao.save(solicitacao);
//		Solicitacao solicitacao2 = daoSolicitacao.getById(solicitacao.getId());
//		assertEquals(true, solicitacao.equals(solicitacao2));
//	}
//	
//	@Test
//	public void updateTest() {
	
//		//Admitindo que há pelo menos uma solicitacao registrada no BD e que possui ID == 1
//		Solicitacao solicitacao1 = daoSolicitacao.getById(1);
//		String eventoAntigo = solicitacao1.getEvento();
//		solicitacao1.setEvento("Minicurso IA");
//		daoSolicitacao.update(solicitacao1);
//		
//		Solicitacao solicitacao2 = daoSolicitacao.getById(1);
//		
//		assertEquals(true, solicitacao1.equals(solicitacao2));
//		assertEquals(true, solicitacao1.geEvento().equals(solicitacao2.getEvento()));
//		assertEquals(false, solicitacao1.getEvento().equals(eventoAntigo));
//
//	}
	
//	@Test
//	public void removeByIdTest() {
//		Solicitacao solicitacao1 = daoSolicitacao.getById(1);
//		daoSolicitacao.removeById(solicitacao1.getId());
//		
//		Solicitacao solicitacao2 = daoSolicitacao.getById(1);
//		
//		assertNull(solicitacao2);
//	}
	
	@Test
	public void findAllTest() {
		List<Solicitacao> solicitacoes = daoSolicitacao.findAll();
		
		//Admitindo que há solicitacoes registradas no BD
		//assertEquals(false,solicitacoes.isEmpty());
		
		//Supondo que não há solicitações no banco:
		assertEquals(true,solicitacoes.isEmpty());
	}

}
