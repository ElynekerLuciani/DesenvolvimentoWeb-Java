package web.jdbc.model;

public class Marca {
	private int idMarca;
	private String nomeMarca;
	private String modelo;
	
	public Marca() {
		
	}

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
