package web.jdbc.model;

public class Categoria {
	private int idCategoria;
	private String nomeCategoria;
	
	public Categoria() {
		
	}

	public int getIdCategoria() { return idCategoria; }
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNomeCategoria() { return nomeCategoria; }
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	public void adicionarCategoria(String addCategoria) {
		try {
			Categoria novaCategoria = new Categoria();
			novaCategoria.setNomeCategoria(addCategoria);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void removerCategoria(int idCategoria) {
		
	}
	
	public void editarCategoria(int idCategoria) {
		
	}
	
	

}
