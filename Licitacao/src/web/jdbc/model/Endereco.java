package web.jdbc.model;

public class Endereco {
	private String rua;
	private int numero;
	private int bloco;
	private String bairro;
	private String cidade;
	private String cep;
	private String estado;
	
	public Endereco() {
		
	}

	//metodos getters setters
	public String getRua() { return rua; }
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() { return numero; }
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getBloco() { return bloco; }
	public void setBloco(int bloco) {
		this.bloco = bloco;
	}
	public String getBairro() { return bairro; }
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() { return cidade; }
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() { return cep; }
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() { return estado; }
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
