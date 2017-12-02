package web.jdbc.testes;

import java.sql.SQLException;

import web.jdbc.dao.FuncionarioDAO;
import web.jdbc.model.CPF;
import web.jdbc.model.Funcionario;

public class TesteInserir {

	public static void main(String[] args) throws SQLException {
		Funcionario funcionario = new Funcionario();
		
		/*
		Funcionario novo = new Funcionario();
		novo.cadastrarFuncionario("elyneker", "00911111111", "rua da vida", 5, 3, "Cento", "Perdida", "61222000",
				"Ceara", "lyneker", "124", "elyneker@eu.com", "34321111", "991122929");
		try {
		funcionario.cadastrarFuncionario("Henrique", "2222222", "Da vida",
										22, 2, "centro", "Tabuleiro", "62999000", 
										"CE", "teste1", "teste1", "ele@eu", "2222", "3333");
		
		
		System.out.println("Gravado!");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
	}

}
