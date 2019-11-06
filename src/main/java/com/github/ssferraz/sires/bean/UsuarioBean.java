package com.github.ssferraz.sires.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.github.ssferraz.sires.dao.PersistenceDAO;
import com.github.ssferraz.sires.entity.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioBean {

	private String siape;
	private String senha;

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario select(Usuario usuario) {
		try {
			return (Usuario) PersistenceDAO.getInstance()
					.read("select * from usuario where siape=" + usuario.getSiape()).get(0); // ALTERAR PARA ADD SENHA
		} catch (IndexOutOfBoundsException index) {
			return null;
		}
	}

}
