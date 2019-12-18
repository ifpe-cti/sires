package com.github.ssferraz.sires.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.github.ssferraz.sires.dao.ReservaDAO;
import com.github.ssferraz.sires.entity.Reserva;

@ManagedBean(name = "reservaBean")
@RequestScoped

public class ReservaBean implements Serializable {

	private static final long serialVersionUID = 935142932270799615L;
	private ReservaDAO daoR = new ReservaDAO();
	private Reserva reserva = new Reserva();

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public String cadastrarReserva(Reserva reserva) {

		reserva.getSolicitacao().setStatus("Aprovada");

		daoR.save(reserva);

		FacesContext.getCurrentInstance().addMessage(null,

				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Reserva feita com sucesso!"));

		return "reservas.xhtml";

	}

	public String removerReserva(Reserva reserva) {

		System.out.println(reserva.toString());
		
		daoR.remove(reserva);
		

		FacesContext.getCurrentInstance().addMessage(null,

				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Reserva excluída com sucesso!"));

		return "reservas.xhtml";

	}

	public List<Reserva> mostrarReservas() {
		List<Reserva> reservas = daoR.findAll();
		return reservas;
	}

	/*public List<Reserva> mostrarReservasFuturas() {
		List<Reserva> reservasFuturas = new ArrayList<Reserva>();
		List<Reserva> todasReservas = mostrarReservas();

		Date d = new Date();
		for (Reserva rf : todasReservas) {
			if (rf.getSolicitacao().getData().getDate()>d.getDate() || rf.getSolicitacao().getData().getDate()==d.getDate()) {
				reservasFuturas.add(rf);
			}
		}
		return reservasFuturas;
	}*/
}