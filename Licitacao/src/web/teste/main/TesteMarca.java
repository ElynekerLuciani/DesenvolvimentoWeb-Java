package web.teste.main;

import web.jdbc.model.Marca;

public class TesteMarca {

	public static void main(String[] args) {
		try {
			Marca marca = new Marca();
			marca.setNomeMarca("Acer");
			marca.setModelo("Aspire");
			marca.cadastrarMarca(marca);
		} catch (Exception e) {
			System.out.println(e.getMessage() + "erro no teste");
		}

	}

}
