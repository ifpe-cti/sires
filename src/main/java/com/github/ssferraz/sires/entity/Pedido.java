package com.github.ssferraz.sires.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
@SecondaryTable(name="periodo")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private Sala sala;
	@Column
	private Usuario requisitante;
	@Column(table="periodo")
	private Periodo periodo;
	@Column
	private String evento;
	@Column
	private boolean autorizado;
	
	public Pedido() {
		
	}
	
	public Pedido(int id, Sala sala, Usuario requisitante, Periodo periodo, String evento, boolean autorizado) {
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

}
