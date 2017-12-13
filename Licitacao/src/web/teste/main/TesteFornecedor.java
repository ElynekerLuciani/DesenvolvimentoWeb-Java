package web.teste.main;

import web.jdbc.model.Fornecedor;

public class TesteFornecedor {

	public static void main(String[] args) {
		try {
			Fornecedor novo = new Fornecedor();
			novo.setNomeFornecedor("Roberto");
			novo.getCnpjFornecedor().setCnpj("1111111");
			novo.getEndFornecedor().setRua("rua da vitoria");
			novo.getEndFornecedor().setNumero(11);
			novo.getEndFornecedor().setBairro("Do transao");
			novo.getEndFornecedor().setBloco("A");
			novo.getEndFornecedor().setCidade("Fortaleza");
			novo.getEndFornecedor().setEstado("ce");
			novo.getEndFornecedor().setCep("62960000");
			novo.getContatoFornecedor().setEmail("roberto@ele.com");
			novo.getContatoFornecedor().setTelefone("8834241111");
			novo.getContatoFornecedor().setCelular("8888116653");
			novo.getLoginFornecedor().setLogin("teste1");
			novo.getLoginFornecedor().setSenha("1234");
			novo.setCategoriaFornecedor(1);
			novo.cadastrarFornecedor(novo);
			
			System.out.println("main passou concluido");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
