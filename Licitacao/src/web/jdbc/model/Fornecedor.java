package web.jdbc.model;

import web.jdbc.dao.FornecedorDAO;
import web.jdbc.dao.FuncionarioDAO;

public class Fornecedor {
	private int idFornecedor;
	private String nomeFornecedor;
	private Endereco endFornecedor = new Endereco();
	private Contato contatoFornecedor = new Contato();
	private CNPJ cnpjFornecedor = new CNPJ();
	private Login loginFornecedor = new Login();
	private Boolean aprovadoFornecedor;
	private float notaFornecedor;
	private int categoriaFornecedor;
	private int nivel = 2;
	
	private FornecedorDAO fornecDAO = FornecedorDAO.getInstancia();
	
	public Fornecedor() {
		
	}

	public void cadastrarFornecedor(Fornecedor fornecedor) {
		Fornecedor cadForn = new Fornecedor();
		try {
			System.out.println("entrou no try cadastrar");
			cadForn.setNomeFornecedor(fornecedor.getNomeFornecedor());
			cadForn.cnpjFornecedor.setCnpj(fornecedor.getCnpjFornecedor().getCnpj());
			cadForn.endFornecedor.setRua(fornecedor.getEndFornecedor().getRua());
			cadForn.endFornecedor.setNumero(fornecedor.getEndFornecedor().getNumero());
			cadForn.endFornecedor.setBairro(fornecedor.getEndFornecedor().getBairro());
			cadForn.endFornecedor.setBloco(fornecedor.getEndFornecedor().getBloco());
			cadForn.endFornecedor.setCidade(fornecedor.getEndFornecedor().getCidade());
			cadForn.endFornecedor.setEstado(fornecedor.getEndFornecedor().getEstado());
			cadForn.endFornecedor.setCep(fornecedor.getEndFornecedor().getCep());
			cadForn.contatoFornecedor.setEmail(fornecedor.getContatoFornecedor().getEmail());
			cadForn.contatoFornecedor.setTelefone(fornecedor.getContatoFornecedor().getTelefone());
			cadForn.contatoFornecedor.setCelular(fornecedor.getContatoFornecedor().getCelular());
			cadForn.loginFornecedor.setLogin(fornecedor.getLoginFornecedor().getLogin());
			cadForn.loginFornecedor.setSenha(fornecedor.getLoginFornecedor().getSenha());
			//cadForn.setAprovadoFornecedor(fornecedor.getAprovadoFornecedor());
			//cadForn.setNotaFornecedor(fornecedor.getNotaFornecedor());
			cadForn.setCategoriaFornecedor(fornecedor.getCategoriaFornecedor());
			
			fornecDAO.adicionaFornecedor(cadForn);
			System.out.println("passou depois de adicionar");
			
			/*
			Fornecedor fresult = new Fornecedor();
			System.out.println("Erro não é akiS");
			FornecedorDAO fun = FornecedorDAO.getInstancia();
			fresult = fun.retornarId(cadForn);
			System.out.println("resultado " + fresult.getIdFornecedor());
			*/
			
			
			//esse trecho de codigo insere na tabela com todos os outros logins
			/*
			Validacao validarNovo = new Validacao();
			validarNovo.setLogin(cadForn.getLoginFornecedor().getLogin());
			validarNovo.setNivel(nivel);
			validarNovo.setIdCliente(fresult.getIdFornecedor());
			validarNovo.inserirAcesso(validarNovo);
			*/
			
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
	public int getCategoriaFornecedor() { return categoriaFornecedor; }
	public void setCategoriaFornecedor(int categoriaFornecedor) {
		this.categoriaFornecedor = categoriaFornecedor;
	}
	public int getNivel() { return nivel; }
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	
	
	
	
	
}
