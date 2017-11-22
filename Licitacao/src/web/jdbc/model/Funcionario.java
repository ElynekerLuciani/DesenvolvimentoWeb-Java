package web.jdbc.model;

import web.jdbc.dao.FuncionarioDAO;

public class Funcionario {
	private Integer idFuncionario;
	private String nomeFuncionario;
	private CPF cpfFuncionario = new CPF();
	private Contato contatoFuncionario = new Contato();
	private Endereco enderecoFuncionario = new Endereco();
	private Login loginFuncionario = new Login();
	
	
	public Funcionario() {
		
	}
	
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
	
	
	public void cadastrarFuncionario(String nome, String cpf, String rua, int numero, int bloco, String bairro,
									String cidade, String cep, String estado, String login, String senha, String email,
									String telefone, String celular ) {
		
		Funcionario cadFunc = new Funcionario();
		try {
			cadFunc.setNomeFuncionario(nome);
			cadFunc.cpfFuncionario.setCpf(cpf);
			cadFunc.enderecoFuncionario.setRua(rua);
			cadFunc.enderecoFuncionario.setNumero(numero);
			cadFunc.enderecoFuncionario.setBloco(bloco);
			cadFunc.enderecoFuncionario.setBairro(bairro);
			cadFunc.enderecoFuncionario.setCidade(cidade);
			cadFunc.enderecoFuncionario.setCep(cep);
			cadFunc.enderecoFuncionario.setEstado(estado);
			cadFunc.loginFuncionario.setLogin(login);
			cadFunc.loginFuncionario.setSenha(senha);
			cadFunc.contatoFuncionario.setEmail(email);
			cadFunc.contatoFuncionario.setTelefone(telefone);
			cadFunc.contatoFuncionario.setCelular(celular);
			
			FuncionarioDAO fun = new FuncionarioDAO();
			fun.adicionaFuncionario(cadFunc);
			
		}catch (Exception erro){
			System.out.println(erro.getMessage());
		}
	}
	
	public void excluirFuncionario(int idFunc) {
		try {
			Funcionario funcionario = new Funcionario();
			funcionario.setIdFuncionario(idFunc);
			FuncionarioDAO fun = new FuncionarioDAO();
			fun.excluirFuncionario(funcionario);
			System.out.println("passou por excluir");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	

	

}
