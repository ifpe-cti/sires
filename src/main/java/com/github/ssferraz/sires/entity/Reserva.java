package com.github.ssferraz.sires.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

	private static final long serialVersionUID = 225395015811535450L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(optional = false)
	private Solicitacao solicitacao;

	public Reserva() {

	}

	public void setId(int id) {
		this.id = id;
	}

	public Reserva(int id, Solicitacao solicitacao) {
		super();
		this.id = id;
		this.solicitacao = solicitacao;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((solicitacao == null) ? 0 : solicitacao.hashCode());
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
		Reserva other = (Reserva) obj;
		if (id != other.id)
			return false;
		if (solicitacao == null) {
			if (other.solicitacao != null)
				return false;
		} else if (!solicitacao.equals(other.solicitacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", solicitacao=" + solicitacao + "]";
	}

}
