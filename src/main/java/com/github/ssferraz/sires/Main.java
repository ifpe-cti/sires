package com.github.ssferraz.sires;


import com.github.ssferraz.sires.dao.UsuarioDAO;
import com.github.ssferraz.sires.entity.Usuario;

public class Main {

	public static void main(String[] args) {

		//Cadastrando o primeiro usuário no sistema para poder ter acesso ao mesmo através do login
		UsuarioDAO daoU = new UsuarioDAO();
		Usuario u = new Usuario("1234567", "admin", "Admin", "admin@ifpe.edu.br", true);
		daoU.save(u);
		
		
	}
}
