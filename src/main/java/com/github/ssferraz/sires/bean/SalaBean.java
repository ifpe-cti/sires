package com.github.ssferraz.sires.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.github.ssferraz.sires.dao.SalaDAO;
import com.github.ssferraz.sires.entity.Sala;

@ManagedBean(name = "salaBean")
@ViewScoped
@SessionScoped
public class SalaBean implements Serializable {


	private static final long serialVersionUID = -1311043629143741585L;

	private SalaDAO dao = new SalaDAO();
	private Sala sala = new Sala();

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public String cadastrarSala(Sala sala) {

		if (sala.getNome().equals("") || sala.getTipo().contentEquals("")) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Preencha todos os campos!"));
			return "";
			
		} else {
			dao.save(sala);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Sala cadastrada!"));
			return "salas.xhtml";
		}

	}

	public String atualizarSala(Sala sala) {
		if (sala.getNome().equals("") || sala.getTipo().contentEquals("")) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Preencha todos os campos!"));
			return "";
			
		} else {
			dao.update(sala);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Sala atualizada!"));
			return "salas.xhtml";
		}
	}

	public String removerSala(Sala sala) {
		System.out.println(sala.getId());
		dao.remove(sala.getId());
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Sala removida!"));
		return "salas.xhtml";
	}

	public List<Sala> mostrarSalas() {
		List<Sala> salas = dao.findAll();
		return salas;
	}

}
