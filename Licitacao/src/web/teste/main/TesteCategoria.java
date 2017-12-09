package web.teste.main;

import web.jdbc.model.Categoria;

public class TesteCategoria {

	public static void main(String[] args) {
		try {
			Categoria categoria = new Categoria();
			categoria.setNomeCategoria("Informatica");
			categoria.adicionarCategoria(categoria);
		} catch (Exception e) {
			System.out.println(e.getMessage() + "erro teste categoria");
		}

	}

}
