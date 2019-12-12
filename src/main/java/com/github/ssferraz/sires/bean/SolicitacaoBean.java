package com.github.ssferraz.sires.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;

import com.github.ssferraz.sires.dao.ReservaDAO;
import com.github.ssferraz.sires.dao.SolicitacaoDAO;
import com.github.ssferraz.sires.dao.UsuarioDAO;
import com.github.ssferraz.sires.entity.Reserva;
import com.github.ssferraz.sires.entity.Solicitacao;
import com.github.ssferraz.sires.entity.Usuario;

@ManagedBean(name = "solicitacaoBean")
@ViewScoped
@SessionScoped
public class SolicitacaoBean implements Serializable {

	private static final long serialVersionUID = -7367875865580540503L;

	private SolicitacaoDAO daoS = new SolicitacaoDAO();
	ReservaBean rB = new ReservaBean();
	private Solicitacao solicitacao = new Solicitacao();

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public String cadastrarSolicitacao(Solicitacao solicitacao) {

		if (solicitacao.getData() == null || solicitacao.getHorarioInicio() == null
				|| solicitacao.getHorarioFim() == null || solicitacao.getSala() == null
				|| solicitacao.getRequisitante() == null || solicitacao.getEvento().equals("")) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Preencha todos os campos!"));
			return "";
		}
		
		if(solicitacao.getData().before(new Date())) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "A data não pode ser anterior a data de hoje!"));
			return "";
		}
		
		if(solicitacao.getHorarioInicio().after(solicitacao.getHorarioFim())) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "O horário de início não pode ser depois do horário de finalização.!"));
			return "";
		}

		solicitacao.setStatus("Pendente");
		daoS.save(solicitacao);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Solicitação feita com sucesso!"));
		return "solicitacoes.xhtml";
	}

	public String aprovarSolicitacao(Solicitacao solicitacao) {	
		
		solicitacao.setStatus("Aprovada");

		daoS.update(solicitacao);

		Reserva reserva = new Reserva();

		reserva.setSolicitacao(solicitacao);

		ReservaDAO rd = new ReservaDAO();
		rd.save(reserva);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitação aprovada!", "Agora ela é uma reserva!"));
		return "solicitacoes.xhtml";
	}

	public String reprovarSolicitacao(Solicitacao solicitacao) {
		solicitacao.setStatus("Reprovada");

		daoS.update(solicitacao);

		Reserva reserva = new Reserva();

		reserva.setSolicitacao(solicitacao);

		ReservaDAO rd = new ReservaDAO();
		rd.save(reserva);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Solicitação reprovada!", "O Requisitante deve efeturar uma nova solicitação"));
		return "solicitacoes.xhtml";
	}

	public List<Solicitacao> mostrarSolicitacoes() {
		List<Solicitacao> solicitacoes = daoS.findPendentes();
		return solicitacoes;
	}

	public List<Solicitacao> mostrarMinhasSolicitacoes(Usuario usuario) {
		List<Solicitacao> solicitacoes = daoS.findByRequisitante(usuario);
		return solicitacoes;
	}

	// Mostra usuários cadastrados somente se o usuário solicitante for
	// Administrador
	public List<Usuario> mostrarUsuariosAdmin(Usuario solicitante) {
		UsuarioDAO daoU = new UsuarioDAO();
		List<Usuario> usuarios = null;

		if (solicitante.getStatusAdmin() == true) {
			usuarios = daoU.findAll();
		}

		return usuarios;
	}
	
	public Date mostrarHoje() {
		return new Date();
	}
}
