//import java.util.ArrayList;
import java.util.Date;

import com.github.ssferraz.sires.dao.PerfilDAO;
import com.github.ssferraz.sires.dao.PeriodoDAO;
import com.github.ssferraz.sires.dao.ReservaDAO;
import com.github.ssferraz.sires.dao.SalaDAO;
import com.github.ssferraz.sires.dao.SolicitacaoDAO;
import com.github.ssferraz.sires.dao.UsuarioDAO;
import com.github.ssferraz.sires.entity.Perfil;
import com.github.ssferraz.sires.entity.Periodo;
import com.github.ssferraz.sires.entity.Reserva;
import com.github.ssferraz.sires.entity.Sala;
import com.github.ssferraz.sires.entity.Solicitacao;
import com.github.ssferraz.sires.entity.Usuario;

public class Principal {

	public static void main(String[] args) {
		SalaDAO salaDao = SalaDAO.getInstance();
	//	ReservaDAO reservaDao = ReservaDAO.getInstance();
	//	UsuarioDAO usuarioDao = UsuarioDAO.getInstance();
	//	SolicitacaoDAO solicitacaoDao = SolicitacaoDAO.getInstance();
	//    PeriodoDAO periodoDao = PeriodoDAO.getInstance();
	//    PerfilDAO perfilDao = PerfilDAO.getInstance();
		
		Sala sala = new Sala();
		sala.setBloco('C');
		sala.setNome("Lab2");
		sala.setTipo("sala");
		
	
	
		
	/*	Usuario usuario = new Usuario();
		usuario.setNome("Mariane");
		usuario.setEmail("mariane@garanhuns.ifpe.edu.br");
		usuario.setSiape("1876521");
		usuario.setSenha("admin");
		usuario.setPerfil(perfil);*/
		
	/*	Solicitacao solicitacao = new Solicitacao();
		solicitacao.setSala(sala);
		solicitacao.setRequisitante(usuario);
		solicitacao.setAutorizado(true);
		solicitacao.setEvento("Monitoria de Algoritmos");
		solicitacao.setPeriodo(periodo);*/
		
	/*	Reserva reserva = new Reserva();
		reserva.setSolicitacao(solicitacao);*/
		
		salaDao.persist(sala);
	//	ArrayList<Sala> salas = (ArrayList<Sala>) salaDao.findAll();
	//	System.out.println(salas.toString());
		
	//	reservaDao.persist(reserva);
	//	ArrayList<Reserva> reservas = (ArrayList<Reserva>) reservaDao.findAll();
	//	System.out.println(reservas.toString());
		
	//	usuarioDao.persist(usuario);
	//	ArrayList<Usuario> usuarios = (ArrayList<Usuario>) usuarioDao.findAll();
	//	System.out.println(usuarios.toString());
		
	//	solicitacaoDao.persist(solicitacao);
	//	ArrayList<Solicitacao> solicitacoes = (ArrayList<Solicitacao>) solicitacaoDao.findAll();
	//	System.out.println(solicitacoes.toString());
		
	//	periodoDao.persist(periodo);
	//	ArrayList<Periodo> periodos = (ArrayList<Periodo>) periodoDao.findAll();
	//	System.out.println(periodos.toString());
		
	//	perfilDao.persist(perfil);
	//	ArrayList<Perfil> perfis = (ArrayList<Perfil>) perfilDao.findAll();
	//	System.out.println(perfis.toString());
		
		
			
	}
}
