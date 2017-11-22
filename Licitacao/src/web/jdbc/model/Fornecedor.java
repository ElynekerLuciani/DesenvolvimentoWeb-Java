package web.jdbc.model;

public class Fornecedor {
	private int idFornecedor;
	private String nome;
	private Endereco endFornecedor = new Endereco();
	private Contato contatoFornecedor = new Contato();
	private CNPJ cnpj = new CNPJ();
	private Login login = new Login();
	private Boolean aprovado = true;
	private float nota;
	private Categoria categoria = new Categoria();
	
	public Fornecedor() {
		
	}

	//metodos getters e setters
	
	public int getIdFornecedor() { return idFornecedor; }
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public String getNome() { return nome; }
	public void setNome(String nome) {
		this.nome = nome;
	}
	public CNPJ getCnpj() { return cnpj; }
	public void setCnpj(CNPJ cnpj) {
		this.cnpj = cnpj;
	}
	public Login getLogin() { return login; }
	public void setLogin(Login login) {
		this.login = login;
	}
	public Endereco getEndFornecedor() { return endFornecedor; }
	public void setEndFornecedor(Endereco endFornecedor) {
		this.endFornecedor = endFornecedor;
	}
	public Contato getContatoFornecedor() { return contatoFornecedor; }
	public void setContatoFornecedor(Contato contatoFornecedor) {
		this.contatoFornecedor = contatoFornecedor;
	}
	public Boolean getAprovado() { return aprovado; }
	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}
	public float getNota() { return nota; }
	public void setNota(float nota) {
		this.nota = nota;
	}
	public Categoria getCategoria() { return categoria; }
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void cadastrarFornecedor(String nome, String cnpj, String rua, int numero, int bloco, String bairro,
								    String cidade, String cep, String estado, String login, String senha, 
								    String email, String telefone, String celular, String categoria) {
		
		Fornecedor cad = new Fornecedor();
		
		cad.setNome(nome);
		cad.getCnpj().setCnpj(cnpj);
		cad.getEndFornecedor().setRua(rua);
		cad.getEndFornecedor().setNumero(numero);
		cad.getEndFornecedor().setBloco(bloco);
		cad.getEndFornecedor().setBairro(bairro);
		cad.getEndFornecedor().setCep(cep);
		cad.getEndFornecedor().setCidade(cidade);
		cad.getEndFornecedor().setEstado(estado);
		cad.getContatoFornecedor().setCelular(celular);
		cad.getContatoFornecedor().setEmail(email);
		cad.getContatoFornecedor().setTelefone(telefone);
		cad.getLogin().setLogin(login);
		cad.getLogin().setSenha(senha);
		cad.getCategoria().setNomeCategoria(categoria);
		
		
	}

}
