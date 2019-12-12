package com.github.ssferraz.sires.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import com.github.ssferraz.sires.dao.UsuarioDAO;
import com.github.ssferraz.sires.entity.Usuario;

@ManagedBean(name = "usuarioBean")
@ViewScoped
@SessionScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = -7531619888376921099L;

	private UsuarioDAO dao = new UsuarioDAO();
	private Usuario usuario= new Usuario();

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String cadastrarUsuario(Usuario usuario) {

		if (usuario.getSiape().equals("") || usuario.getSenha().equals("") || usuario.getEmail().equals("")
				|| usuario.getNome().equals("")) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Preencha todos os campos!"));
			return "";
		}

		else {

			if (!usuario.getSiape().matches("[0-9]{7}")) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"SIAPE Inválido!", "Um SIAPE é composto apenas números e possui 7 dígitos."));
				return "";
			}

			if (siapeExiste(usuario) == true) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro!", "Já existe algum usuário cadastrado com esse SIAPE."));
				return "";
			}

			if (!usuario.getEmail().matches("[^@,\\s]+" + "@{1}" + "[^\\s,@]+")) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail inválido!", "Informe um e-mail válido."));
				return "";
			}
		}

		dao.save(usuario);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Usuário cadastrado!"));
		return "usuarios.xhtml";
	}
	
	public String cadastrarNovoUsuario(Usuario usuario) {

		if (usuario.getSiape().equals("") || usuario.getSenha().equals("") || usuario.getEmail().equals("")
				|| usuario.getNome().equals("")) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Preencha todos os campos!"));
			return "";
		}

		else {

			if (!usuario.getSiape().matches("[0-9]{7}")) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"SIAPE Inválido!", "Um SIAPE é composto apenas números e possui 7 dígitos."));
				return "";
			}

			if (siapeExiste(usuario) == true) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro!", "Já existe algum usuário cadastrado com esse SIAPE."));
				return "";
			}

			if (!usuario.getEmail().matches("[^@,\\s]+" + "@{1}" + "[^\\s,@]+")) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail inválido!", "Informe um e-mail válido."));
				return "";
			}
		}

		dao.save(usuario);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Usuário cadastrado!"));
		return "login.xhtml";
	}
	
	public String atualizarUsuario(Usuario usuario) {

		if (usuario.getSiape().equals("") || usuario.getSenha().equals("") || usuario.getEmail().equals("")
				|| usuario.getNome().equals("")) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Preencha todos os campos!"));
			return "";
		}

		else {

			if (!usuario.getSiape().matches("[0-9]{7}")) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"SIAPE Inválido!", "Um SIAPE é composto apenas números e possui 7 dígitos."));
				return "";
			}

			if (!usuario.getEmail().matches("[^@,\\s]+" + "@{1}" + "[^\\s,@]+")) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail inválido!", "Informe um e-mail válido."));
				return "";
			}

		}
		dao.update(usuario);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Usuário atualizado!"));
		return "usuarios.xhtml";
	}

	public String atualizarMeusDados(Usuario usuario) {
		dao.update(usuario);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Usuário atualizado!"));
		return "index.xhtml";
	}

	public String removerUsuario(Usuario usuario) {
		System.out.println(usuario.getId());
		dao.removeById(usuario.getId());
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Usuário removido!"));
		return "usuarios.xhtml";
	}

	public List<Usuario> mostrarUsuarios() {
		List<Usuario> usuarios = dao.findAll();
		return usuarios;
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

	public String eAdmin(Usuario usuario) {
		if (usuario.getStatusAdmin() == true) {
			return "Sim";
		} else {
			return "Não";
		}
	}
	
	public boolean siapeExiste(Usuario usuario) {
		List<Usuario> consultado = dao.getBySiape(usuario.getSiape());
		if (consultado.isEmpty()==true) {
			return false;
		}else {
			return true;
		}
	}
}
