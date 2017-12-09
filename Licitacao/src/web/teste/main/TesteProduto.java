package web.teste.main;

import web.jdbc.model.Produto;

public class TesteProduto {

	public static void main(String[] args) {
		try {
			Produto produto = new Produto();
			produto.setNomeProduto("Notebook");
			produto.setDescricaoProduto("teste");
			produto.setIdMarca(1);
			produto.setCategoriaProduto(1);
			produto.cadastrarProduto(produto);
		} catch (Exception e) {
			System.out.println(e.getMessage() + "erro teste produto");
		}

	}

}
