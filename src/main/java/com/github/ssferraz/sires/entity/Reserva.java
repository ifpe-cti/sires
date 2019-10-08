package com.github.ssferraz.sires.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private Pedido pedido;
	
	public Reserva() {
		
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reserva(int id, Pedido pedido) {
		super();
		this.id = id;
		this.pedido = pedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getId() {
		return id;
	}


}
