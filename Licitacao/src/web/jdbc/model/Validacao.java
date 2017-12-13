package web.jdbc.model;

import web.jdbc.dao.ValidacaoDAO;
import web.jdbc.dao.conexao.ConnectionFactory;

public class Validacao {
	private String login;
	private String senha;
	private int nivel;
	private int idCliente;
	
	private ValidacaoDAO dao = ValidacaoDAO.getInstancia();
	
	public Validacao() {
		
	}
	
	public boolean acessar(Validacao validarAcesso) {
		try {
			if(validarAcesso.getNivel() == 1|| validarAcesso.getNivel() == 2) {
				System.out.println("entrou em validar acesso funcionario");
				return dao.acessarSistema(validarAcesso);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "erro em acessar");
		}
		return false;
	}
	
	
	
	/*
	
	public void inserirAcesso(Validacao valid) {
		Validacao Acesso = new Validacao();
		try {
			Acesso.setLogin(valid.getLogin().toString());
			Acesso.setNivel(valid.getNivel());
			Acesso.setIdCliente(valid.getIdCliente());
			
			ValidacaoDAO valida = new ValidacaoDAO();
			valida.inserirAcesso(Acesso);
			System.out.println("teste dentro");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Erro em Validação: erro ao inserir acesso!");
		}
		
	}
	
	
	

	public void inserirAcesso(String acesso, int nivel, int id) {
		Validacao loginAcesso = new Validacao();
		try {
			loginAcesso.setLogin(acesso);
			loginAcesso.setNivel(nivel);
			loginAcesso.setIdCliente(id);
			
			ValidacaoDAO valid = new ValidacaoDAO();
			valid.inserirAcesso(loginAcesso);
			System.out.println(id + "teste dentro");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Erro em Validação: erro ao inserir acesso!");
		}
		
	}
*/
	//metodos getters e setters
	public String getLogin() { return login; }
	public void setLogin(String login) {
		this.login = login;
	}

	public int getNivel() { return nivel; }
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getIdCliente() { return idCliente; }
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getSenha() { return senha; }
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

}
