package web.teste.main;

import web.jdbc.model.Funcionario;
//import web.jdbc.model.Validacao;

public class TesteFuncionario {

	public static void main(String[] args) {
		
		try {
			Funcionario novo = new Funcionario();
			novo.setNomeFuncionario("Elyneker");
			novo.getContatoFuncionario().setCelular("88999794015");
			novo.getContatoFuncionario().setEmail("maria@ela.com"); 
			novo.getContatoFuncionario().setTelefone("8834242053");
			novo.getCpfFuncionario().setCpf("009.111.773-50");
			novo.getEnderecoFuncionario().setBairro("centro");
			novo.getEnderecoFuncionario().setBloco("bloco");
			novo.getEnderecoFuncionario().setCep("62960000");
			novo.getEnderecoFuncionario().setCidade("tabuleiro");
			novo.getEnderecoFuncionario().setEstado("CE");
			novo.getEnderecoFuncionario().setNumero(3);
			novo.getEnderecoFuncionario().setRua("la de casa");
			novo.getLoginFuncionario().setLogin("teste1");
			novo.getLoginFuncionario().setSenha( "1234");
			novo.cadastrarFuncionario(novo);
			
			System.out.println("main: passou");
			//novo.cadastrarFuncionario(nome, cpf, rua, numero, bairro, bloco, cidade, estado, cep, email, telefone, celular, login, senha);
			
			/*
			Funcionario fresult = new Funcionario();
			System.out.println("Erro não é akiS");
			FuncionarioDAO fun = FuncionarioDAO.getInstancia();
			fresult = fun.retornarId(novo);
			
			
			System.out.println("resultado " + fresult.getIdFuncionario());
			*/
			//System.out.println("INSERINDO");
			//Validacao validar = new Validacao();
			//validar.inserirAcesso("teste1", 2, 1);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage() + "nao passou no main");
		}
		System.out.println("finalizado");
		//novo.cadastrarFuncionario(nome, cpf, rua, numero, bairro, bloco, cidade, estado, cep, email, telefone, celular, login, senha);
	}

}
