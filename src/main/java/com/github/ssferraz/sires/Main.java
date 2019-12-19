package com.github.ssferraz.sires;


import com.github.ssferraz.sires.dao.UsuarioDAO;
import com.github.ssferraz.sires.entity.Usuario;

public class Main {

	public static void main(String[] args) {

		//Cadastrando o primeiro usuário no sistema para poder ter acesso ao mesmo através do login
		UsuarioDAO daoU = new UsuarioDAO();
		Usuario u = new Usuario("1234567", "admin", "Admin", "admin@ifpe.edu.br", true);
		daoU.save(u);
		
		/*Date d1 = new Date();
		
		d1.setHours(07);
		d1.setMinutes(30);
		d1.setSeconds(00);
		
		Date d2 = new Date();
		d2.setHours(8);
		d2.setMinutes(15);
		d2.setSeconds(00);
		
		Date d3 = new Date();
		d1.setHours(9);
		d1.setMinutes(00);
		d1.setSeconds(00);
		
		Date d4 = new Date();
		d1.setHours(9);
		d1.setMinutes(45);
		d1.setSeconds(00);
		
		Date d5 = new Date();
		d1.setHours(10);
		d1.setMinutes(00);
		d1.setSeconds(00);
		
		Date d6 = new Date();
		d1.setHours(10);
		d1.setMinutes(45);
		d1.setSeconds(00);
		
		Date d7 = new Date();
		d1.setHours(11);
		d1.setMinutes(30);
		d1.setSeconds(00);
		
		Date d8 = new Date();
		d1.setHours(12);
		d1.setMinutes(15);
		d1.setSeconds(00);
		
		
		Periodo p1 = new Periodo(d1,d2);
		Periodo p2 = new Periodo(d2,d3);
		Periodo p3 = new Periodo(d3,d4);
		Periodo p4 = new Periodo(d5,d6);
		Periodo p5 = new Periodo(d6,d7);
		Periodo p6 = new Periodo(d7,d8);
		
		PeriodoDAO pD = new PeriodoDAO();
		pD.persist(p1);
		pD.persist(p2);
		pD.persist(p3);
		pD.persist(p4);
		pD.persist(p5);
		pD.persist(p6);*/

		
		
		
	}
}
