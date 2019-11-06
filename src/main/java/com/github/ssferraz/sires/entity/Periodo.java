package com.github.ssferraz.sires.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "periodo")
public class Periodo implements Serializable {

	private static final long serialVersionUID = 85953247237846591L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date date;
	@Temporal(TemporalType.TIME)
	private Date horarioInicio;
	@Temporal(TemporalType.TIME)
	private Date horarioFim;

	public Periodo() {
	}

	public Periodo(int id, Date date, Date horarioinicio, Date horarioFim) {
		super();
		this.id = id;
		this.date = date;
		this.horarioInicio = horarioinicio;
		this.horarioFim = horarioFim;

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((horarioFim == null) ? 0 : horarioFim.hashCode());
		result = prime * result + ((horarioInicio == null) ? 0 : horarioInicio.hashCode());
		result = prime * result + id;
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
		Periodo other = (Periodo) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
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
		return true;
	}

	@Override
	public String toString() {
		return "Periodo [id=" + id + ", date=" + date + ", horarioInicio=" + horarioInicio + ", horarioFim="
				+ horarioFim + "]";
	}

}
