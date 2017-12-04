package web.jdbc.model;

import web.jdbc.dao.MarcaDAO;

public class Marca {
	private int idMarca;
	private String nomeMarca;
	private String modelo;
	
	private MarcaDAO marcaDAO = MarcaDAO.getInstancia();
	
	public Marca() {
		
	}

	public void cadastrarMarca(Marca marca) {
		Marca novaMarca = new Marca();
		try {
			novaMarca.setNomeMarca(marca.getNomeMarca());
			novaMarca.setModelo(marca.getModelo());
			marcaDAO.adicionarMarca(novaMarca);
		} catch (Exception e) {
			System.out.println(e.getStackTrace() + "Erro em marca.");
		}
		
		
		
	}
	
	
	//metodos getters e setters
	public int getIdMarca() { return idMarca; }
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	public String getNomeMarca() { return nomeMarca; }
	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}
	public String getModelo() { return modelo; }
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}
