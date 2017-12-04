package web.jdbc.model;

import web.jdbc.dao.CategoriaDAO;

public class Categoria {
	private int idCategoria;
	private String nomeCategoria;
	
	private CategoriaDAO catDAO = new CategoriaDAO().getInstancia();
	public Categoria() {
		
	}
	
	
	public void adicionarCategoria(Categoria addCategoria) {
		try {
			Categoria novaCategoria = new Categoria();
			novaCategoria.setIdCategoria(addCategoria.getIdCategoria());
			novaCategoria.setNomeCategoria(addCategoria.getNomeCategoria());
			catDAO.addCategoria(novaCategoria);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void removerCategoria(int idCategoria) {
		
	}
	
	public void editarCategoria(int idCategoria) {
		
	}
	
	
	
	
	// metodos getters e setters
		public int getIdCategoria() { return idCategoria; }
		public void setIdCategoria(int idCategoria) {
			this.idCategoria = idCategoria;
		}
		public String getNomeCategoria() { return nomeCategoria; }
		public void setNomeCategoria(String nomeCategoria) {
			this.nomeCategoria = nomeCategoria;
		}
		
	
	

}
