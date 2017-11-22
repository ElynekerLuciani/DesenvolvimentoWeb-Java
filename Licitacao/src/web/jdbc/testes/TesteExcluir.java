package web.jdbc.testes;

import web.jdbc.model.Funcionario;

public class TesteExcluir {

	public static void main(String[] args) {
		try {
		Funcionario funcionario = new Funcionario();
		funcionario.excluirFuncionario(1);
		System.out.println("Teste excluir");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//Teste do git	
		}

	}

}
