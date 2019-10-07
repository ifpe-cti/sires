package com.github.ssferraz.sires.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String siape;
	@Column
	private String senha;
	@Column
	private String nome;
	@Column
	private String email;
	@Column
	private Categoria categoria;
	
	public Usuario() {
		
	}
	
	public Usuario(int id, String siape, String senha, String nome, String email, Categoria categoria) {
		super();
		this.id = id;
		this.siape = siape;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
		this.senha = senha;
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
}
