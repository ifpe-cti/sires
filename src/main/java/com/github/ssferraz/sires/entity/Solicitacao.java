package com.github.ssferraz.sires.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "solicitacao")
@SecondaryTable(name = "periodo")
public class Solicitacao implements Serializable {
	private static final long serialVersionUID = 8318132024879333596L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private Sala sala;
	@Column
	private Usuario requisitante;
	@OneToOne(optional = false)
	private Periodo periodo;
	@Column
	private String evento;
	@Column
	private boolean autorizado;

	public Solicitacao() {

	}

	public Solicitacao(int id, Sala sala, Usuario requisitante, Periodo periodo, String evento, boolean autorizado) {
		super();
		this.id = id;
		this.sala = sala;
		this.requisitante = requisitante;
		this.periodo = periodo;
		this.evento = evento;
		this.autorizado = autorizado;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Usuario getRequisitante() {
		return requisitante;
	}

	public void setRequisitante(Usuario requisitante) {
		this.requisitante = requisitante;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public boolean isAutorizado() {
		return autorizado;
	}

	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (autorizado ? 1231 : 1237);
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
		result = prime * result + id;
		result = prime * result + ((periodo == null) ? 0 : periodo.hashCode());
		result = prime * result + ((requisitante == null) ? 0 : requisitante.hashCode());
		result = prime * result + ((sala == null) ? 0 : sala.hashCode());
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
		Solicitacao other = (Solicitacao) obj;
		if (autorizado != other.autorizado)
			return false;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		if (id != other.id)
			return false;
		if (periodo == null) {
			if (other.periodo != null)
				return false;
		} else if (!periodo.equals(other.periodo))
			return false;
		if (requisitante == null) {
			if (other.requisitante != null)
				return false;
		} else if (!requisitante.equals(other.requisitante))
			return false;
		if (sala == null) {
			if (other.sala != null)
				return false;
		} else if (!sala.equals(other.sala))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Solicitacao [id=" + id + ", sala=" + sala + ", requisitante=" + requisitante + ", periodo=" + periodo
				+ ", evento=" + evento + ", autorizado=" + autorizado + "]";
	}

}
