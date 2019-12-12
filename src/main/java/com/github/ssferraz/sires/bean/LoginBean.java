package com.github.ssferraz.sires.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import com.github.ssferraz.sires.dao.UsuarioDAO;
import com.github.ssferraz.sires.entity.Usuario;

@ManagedBean(name = "loginBean")
@SessionScoped
@ViewScoped

public class LoginBean implements Serializable {

	private static final long serialVersionUID = -8508626733331893608L;

	private UsuarioDAO dao = new UsuarioDAO();
	private Usuario usuario;
	private boolean usuarioLogado = false;

	public LoginBean() {
		usuario = new Usuario();
	}

	public Usuario selectBySiape(Usuario usuario) {

		List<Usuario> lista = dao.findAll();

		Usuario usuarioConsulta = null;

		for (Usuario u : lista) {
			if (usuario.getSiape().equals(u.getSiape())) {
				usuarioConsulta = u;
			}
		}

		return usuarioConsulta;
	}

	public String statusAdminString(Usuario usuario) {
		if (usuario.getStatusAdmin() == true) {
			return "Sim";
		} else {
			return "Não";
		}
	}

	public String logar() {

		if (usuario.getSiape().equals("") || usuario.getSenha().equals("")) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "É preciso informar SIAPE e senha"));
			return "";
		}

		else{
			
			if(!usuario.getSiape().matches("[0-9]{7}")) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"SIAPE Inválido!", "Um SIAPE é composto apenas números e possui 7 dígitos."));
				return "";
			}

			Usuario consultado = selectBySiape(usuario);

			if (consultado == null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Usuário não encontrado!", "Verifique SIAPE e senha"));
				return "";

			} else if (usuario.getSiape().equals(consultado.getSiape())
					&& usuario.getSenha().equals(consultado.getSenha())) {

				this.usuario = consultado;
				usuarioLogado = true;

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Sucesso!", "Bem-vindo(a) ao SIRES, " + consultado.getNome() + "!"));

				return "index.xhtml";

			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha incorreta!", "Tente novamente"));
				return "";
			}
		}
	}

	public String mostrarStatus(Usuario usuario) {
		if (usuario.getStatusAdmin() == true) {
			return "Administrador";
		} else {
			return "Servidor";
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(boolean usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String sair() {
		usuarioLogado = false;
		return "login.xhtml?faces-redirect=true";
	}
}
