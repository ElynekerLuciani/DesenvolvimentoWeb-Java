package web.jdbc.model;

import web.jdbc.dao.FornecedorDAO;

public class Fornecedor {
	private int idFornecedor;
	private String nomeFornecedor;
	private Endereco endFornecedor = new Endereco();
	private Contato contatoFornecedor = new Contato();
	private CNPJ cnpjFornecedor = new CNPJ();
	private Login loginFornecedor = new Login();
	private Boolean aprovadoFornecedor;
	private float notaFornecedor;
	private Categoria categoriaFornecedor = new Categoria();
	private int nivel = 2;
	
	private FornecedorDAO fornecDAO = FornecedorDAO.getInstancia();
	
	public Fornecedor() {
		
	}

	public void cadastrarFornecedor(Fornecedor fornecedor) {
		Fornecedor cadForn = new Fornecedor();
		try {
			cadForn.setNomeFornecedor(fornecedor.getNomeFornecedor());
			cadForn.cnpjFornecedor.setCnpj(fornecedor.getCnpjFornecedor().getCnpj());
			cadForn.contatoFornecedor.setEmail(fornecedor.getContatoFornecedor().getEmail());
			cadForn.contatoFornecedor.setTelefone(fornecedor.getContatoFornecedor().getTelefone());
			cadForn.contatoFornecedor.setCelular(fornecedor.getContatoFornecedor().getCelular());
			cadForn.endFornecedor.setRua(fornecedor.getEndFornecedor().getRua());
			cadForn.endFornecedor.setNumero(fornecedor.getEndFornecedor().getNumero());
			cadForn.endFornecedor.setBairro(fornecedor.getEndFornecedor().getBairro());
			cadForn.endFornecedor.setBloco(fornecedor.getEndFornecedor().getBloco());
			cadForn.endFornecedor.setCidade(fornecedor.getEndFornecedor().getCidade());
			cadForn.endFornecedor.setEstado(fornecedor.getEndFornecedor().getEstado());
			cadForn.endFornecedor.setCep(fornecedor.getEndFornecedor().getCep());
			cadForn.loginFornecedor.setLogin(fornecedor.getLoginFornecedor().getLogin());
			cadForn.loginFornecedor.setLogin(fornecedor.getLoginFornecedor().getSenha());
			cadForn.setAprovadoFornecedor(fornecedor.getAprovadoFornecedor());
			cadForn.setNotaFornecedor(fornecedor.getNotaFornecedor());
			cadForn.categoriaFornecedor.setIdCategoria(fornecedor.getCategoriaFornecedor().getIdCategoria());
			
			fornecDAO.adicionaFornecedor(cadForn);
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace() + " Erro em fornecedor");
		}
		
	}
	
	public void validar(String login) {
		
		
	}
	
	
	
	
	//metodos getters e setters
	public int getIdFornecedor() { return idFornecedor; }
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public String getNomeFornecedor() { return nomeFornecedor; }
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	public Endereco getEndFornecedor() { return endFornecedor; }
	public void setEndFornecedor(Endereco endFornecedor) {
		this.endFornecedor = endFornecedor;
	}
	public Contato getContatoFornecedor() { return contatoFornecedor; }
	public void setContatoFornecedor(Contato contatoFornecedor) {
		this.contatoFornecedor = contatoFornecedor;
	}
	public CNPJ getCnpjFornecedor() { return cnpjFornecedor; }
	public void setCnpjFornecedor(CNPJ cnpjFornecedor) {
		this.cnpjFornecedor = cnpjFornecedor;
	}
	public Login getLoginFornecedor() { return loginFornecedor; }
	public void setLoginFornecedor(Login loginFornecedor) {
		this.loginFornecedor = loginFornecedor;
	}
	public Boolean getAprovadoFornecedor() { return aprovadoFornecedor; }
	public void setAprovadoFornecedor(Boolean aprovadoFornecedor) {
		this.aprovadoFornecedor = aprovadoFornecedor;
	}
	public float getNotaFornecedor() { return notaFornecedor; }
	public void setNotaFornecedor(float notaFornecedor) {
		this.notaFornecedor = notaFornecedor;
	}
	public Categoria getCategoriaFornecedor() { return categoriaFornecedor; }
	public void setCategoriaFornecedor(Categoria categoriaFornecedor) {
		this.categoriaFornecedor = categoriaFornecedor;
	}
	public int getNivel() { return nivel; }
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
}
