package com.github.ssferraz.sires.entity;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@ManagedBean(name = "solicitacao")
@Table(name = "solicitacao")

public class Solicitacao implements Serializable {

	private static final long serialVersionUID = 8318132024879333596L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(optional = false, cascade = CascadeType.REMOVE)
	private Sala sala;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date data;

	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Date horarioInicio;

	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Date horarioFim;

	@ManyToOne(optional = false, cascade = CascadeType.REMOVE)
	private Usuario requisitante;

	@Column(nullable = false)
	private String evento;

	@Column(nullable = false)
	private String status;

	public Solicitacao() {

	}

	public Solicitacao(int id, Sala sala,Date data, Date horarioInicio, Date horarioFim, Usuario requisitante, String evento, String status) {
		super();
		this.id = id;
		this.sala = sala;
		this.data = data;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.requisitante = requisitante;
		this.evento = evento;
		this.status = status;
	}
	
	public Solicitacao(Sala sala,Date data, Date horarioInicio, Date horarioFim, Usuario requisitante, String evento, String status) {
		super();
		
		this.sala = sala;
		this.data = data;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.requisitante = requisitante;
		this.evento = evento;
		this.status = status;
	}
	

	public int getId() {
		return id;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Date getHorarioInicio() {
		return horarioInicio;
	}
	
	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	
	public Date getHorarioFim() {
		return horarioFim;
	}
	
	public void setHorarioFim(Date horarioFim) {
		this.horarioFim = horarioFim;
	}

	public Usuario getRequisitante() {
		return requisitante;
	}

	public void setRequisitante(Usuario requisitante) {
		this.requisitante = requisitante;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
		result = prime * result + ((horarioFim == null) ? 0 : horarioFim.hashCode());
		result = prime * result + ((horarioInicio == null) ? 0 : horarioInicio.hashCode());
		result = prime * result + id;
		result = prime * result + ((requisitante == null) ? 0 : requisitante.hashCode());
		result = prime * result + ((sala == null) ? 0 : sala.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		if (horarioFim == null) {
			if (other.horarioFim != null)
				return false;
		} else if (!horarioFim.equals(other.horarioFim))
			return false;
		if (horarioInicio == null) {
			if (other.horarioInicio != null)
				return false;
		} else if (!horarioInicio.equals(other.horarioInicio))
			return false;
		if (id != other.id)
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Solicitacao [id=" + id + ", sala = " + sala + ", data=" + data + ", horarioInicio=" + horarioInicio + ", horarioFim=" + horarioFim + ", requisitante=" + requisitante + ", evento=" + evento
				+ ", status=" + status + "]";
	}

}
