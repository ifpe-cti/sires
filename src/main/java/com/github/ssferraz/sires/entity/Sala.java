package com.github.ssferraz.sires.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sala")
public class Sala {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private char bloco;
	@Column
	private String nome;
	@Column
	private String tipo;
	
	public Sala() {
		
	}
	
	public Sala(int id, char bloco, String nome, String tipo) {
		super();
		this.id = id;
		this.bloco = bloco;
		this.nome = nome;
		this.tipo = tipo;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getBloco() {
		return bloco;
	}
	public void setBloco(char bloco) {
		this.bloco = bloco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
