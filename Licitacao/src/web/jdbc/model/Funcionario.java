package web.jdbc.model;

import web.jdbc.dao.FuncionarioDAO;

public class Funcionario {
	private Integer idFuncionario;
	private String nomeFuncionario;
	private CPF cpfFuncionario = new CPF();
	private Contato contatoFuncionario = new Contato();
	private Endereco enderecoFuncionario = new Endereco();
	private Login loginFuncionario = new Login(); 
	private int nivel = 1; 
	
	private FuncionarioDAO dao = FuncionarioDAO.getInstancia();
	
	
	public Funcionario() {
		
	}
	
	public void cadastrarFuncionario(Funcionario funci) {
		Funcionario cadFunc = new Funcionario();
		try {
			System.out.println("entrou em cadastrar");
			cadFunc.setNomeFuncionario(funci.getNomeFuncionario());
			cadFunc.cpfFuncionario.setCpf(funci.getCpfFuncionario().getCpf());
			cadFunc.enderecoFuncionario.setRua(funci.getEnderecoFuncionario().getRua());
			cadFunc.enderecoFuncionario.setNumero(funci.getEnderecoFuncionario().getNumero());
			cadFunc.enderecoFuncionario.setBairro(funci.getEnderecoFuncionario().getBairro());
			cadFunc.enderecoFuncionario.setBloco(funci.getEnderecoFuncionario().getBloco());
			cadFunc.enderecoFuncionario.setCidade(funci.getEnderecoFuncionario().getCidade());
			cadFunc.enderecoFuncionario.setEstado(funci.getEnderecoFuncionario().getEstado());
			cadFunc.enderecoFuncionario.setCep(funci.getEnderecoFuncionario().getCep());
			cadFunc.contatoFuncionario.setEmail(funci.getContatoFuncionario().getEmail());
			cadFunc.contatoFuncionario.setTelefone(funci.getContatoFuncionario().getTelefone());
			cadFunc.contatoFuncionario.setCelular(funci.getContatoFuncionario().getCelular());
			cadFunc.loginFuncionario.setLogin(funci.getLoginFuncionario().getLogin());
			cadFunc.loginFuncionario.setSenha(funci.getLoginFuncionario().getSenha());
			
			System.out.println("aqui");
			
			
			System.out.println("cadastrar: passou por fundionario dao");
			dao.adicionaFuncionario(cadFunc);
			System.out.println("Funcionario: passou");
			
			
			
			
		}catch (Exception erro){
			System.out.println(erro.getStackTrace() + "erro em funcionario");
		}
		
		
	}
	
	/*public void excluirFuncionario(int idFunc) {
		try {
			Funcionario funcionario = new Funcionario();
			funcionario.setIdFuncionario(idFunc);
			FuncionarioDAO fun = new FuncionarioDAO();
			fun.excluirFuncionario(funcionario);
			System.out.println("passou por excluir");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}*/
	
	//metodos getters e setters
		public Integer getIdFuncionario() { return idFuncionario; }
		public void setIdFuncionario(Integer idFuncionario) { this.idFuncionario = idFuncionario; }
		public String getNomeFuncionario() { return nomeFuncionario; }
		public void setNomeFuncionario(String nome) { this.nomeFuncionario = nome; }
		public CPF getCpfFuncionario() { return cpfFuncionario; }
		public void setCpfFuncionario(CPF cpf) { this.cpfFuncionario = cpf; }
		public Contato getContatoFuncionario() { return contatoFuncionario; }
		public void setContatoFuncionario(Contato contato) { this.contatoFuncionario = contato; }
		public Endereco getEnderecoFuncionario() { return enderecoFuncionario; }
		public void setEnderecoFuncionario(Endereco endereco) { this.enderecoFuncionario = endereco; }
		public Login getLoginFuncionario() { return loginFuncionario; }
		public void setLoginFuncionario(Login login) { this.loginFuncionario = login; }
		
	

}
