package web.jdbc.model;

import web.jdbc.dao.SetorDAO;

public class Setor {
	private int idSetor;
	private String nomeSetor;
	private int nivelAcesso;
	
	private SetorDAO setorDAO = SetorDAO.getInstancia();
	
	public Setor() {
		
	}

	public void criarCategoria(Setor setor) {
		Setor novoSetor = new Setor();
		try {
			novoSetor.setIdSetor(setor.getIdSetor());
			novoSetor.setNomeSetor(setor.getNomeSetor());
			novoSetor.setNivelAcesso(setor.getNivelAcesso());
			setorDAO.adicionarSetor(novoSetor);
		} catch (Exception e) {
			System.out.println(e.getStackTrace() + "Erro em criar categoria");
		}
	}
	
	
	//metodos gette e setters
	public int getIdSetor() { return idSetor; }
	public void setIdSetor(int idSetor) {
		this.idSetor = idSetor;
	}
	public String getNomeSetor() { return nomeSetor; }
	public void setNomeSetor(String nomeSetor) {
		this.nomeSetor = nomeSetor;
	}
	public int getNivelAcesso() { return nivelAcesso; }
	public void setNivelAcesso(int nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
	
}
