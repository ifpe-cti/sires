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

import com.github.ssferraz.sires.utils.SampleEntity;

@Entity
@ManagedBean(name = "sala")
@Table(name = "sala")
public class Sala implements Serializable, SampleEntity {

	private static final long serialVersionUID = -5487064625857522349L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private char bloco;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String tipo;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "sala")
	private List<Solicitacao> solicitacoes;
	
	public Sala() {

	}

	public Sala(Integer id, char bloco, String nome, String tipo) {
		super();
		this.id = id;
		this.bloco = bloco;
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public Sala(char bloco, String nome, String tipo) {
		super();
		this.bloco = bloco;
		this.nome = nome;
		this.tipo = tipo;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	

	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bloco;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Sala other = (Sala) obj;
		if (bloco != other.bloco)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", bloco=" + bloco + ", nome=" + nome + ", tipo=" + tipo + "]";
	}


}
