package web.teste.main;

import web.jdbc.model.Validacao;

public class TesteValidacao {

	public static void main(String[] args) {
		try {
			Validacao valida = new Validacao();
			valida.setLogin("teste1");
			valida.setNivel(1);
			valida.setSenha("12345");
			
			System.out.println(valida.acessar(valida));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
