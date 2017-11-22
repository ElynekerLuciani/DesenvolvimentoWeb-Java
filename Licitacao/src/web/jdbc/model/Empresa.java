package web.jdbc.model;

public class Empresa {
	private String nome;
	private CNPJ cnpj = new CNPJ();
	private Contato contatoEmpresa = new Contato();
	private Endereco enderecoEmpresa = new Endereco();
	
	public Empresa() {
		
	}

	public String getNome() { return nome; }
	public void setNome(String nome) {
		this.nome = nome;
	}
	public CNPJ getCnpj() { return cnpj; }
	public void setCnpj(CNPJ cnpj) {
		this.cnpj = cnpj;
	}
	public Contato getContatoEmpresa() { return contatoEmpresa; }
	public void setContatoEmpresa(Contato contatoEmpresa) {
		this.contatoEmpresa = contatoEmpresa;
	}
	public Endereco getEnderecoEmpresa() { return enderecoEmpresa; }
	public void setEnderecoEmpresa(Endereco enderecoEmpresa) {
		this.enderecoEmpresa = enderecoEmpresa;
	}
	
	public void cadastrarEmpresa() {
		
	}

}
