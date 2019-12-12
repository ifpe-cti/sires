package com.github.ssferraz.sires.entity;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.github.ssferraz.sires.utils.Md5;
import com.github.ssferraz.sires.utils.SampleEntity;

@Entity
@ManagedBean(name = "usuario")
@Table(name = "usuario")
public class Usuario implements Serializable, SampleEntity {

	private static final long serialVersionUID = 7969049553075273232L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, unique = true)
	private String siape;
	
	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private boolean statusAdmin;

	//@OneToMany(mappedBy="solicitacao", cascade=CascadeType.REMOVE)
	//private List<Solicitacao> solicitacoes;
	
	public Usuario() {

	}
	
	public Usuario(Integer id, String siape, String senha, String nome, String email, boolean statusAdmin) {
		super();
		this.id = id;
		this.siape = siape;
		this.senha = Md5.criptografar(senha);
		this.nome = nome;
		this.email = email;
		this.statusAdmin = statusAdmin;
	}
	
	public Usuario(String siape, String senha, String nome, String email, boolean statusAdmin) {
		super();
		this.siape = siape;
		this.senha = Md5.criptografar(senha);
		this.nome = nome;
		this.email = email;
		this.statusAdmin = statusAdmin;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
		this.senha = Md5.criptografar(senha);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean getStatusAdmin() {
		return statusAdmin;
	}
	
	public void setStatusAdmin(boolean statusAdmin) {
		this.statusAdmin = statusAdmin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((siape == null) ? 0 : siape.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (siape == null) {
			if (other.siape != null)
				return false;
		} else if (!siape.equals(other.siape))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", siape=" + siape + ", senha=" + senha + ", nome=" + nome + ", email=" + email
				+ ", statusAdmin=" + statusAdmin + "]";
	}
}
