package web.jdbc.model;

public class Produto {
	private int idProduto;
	private String nomeProduto;
	private String descricaoProduto;
	private int idMarca;
	private Categoria categoriaProduto = new Categoria();
	
	public Produto() {
		
	}
	
	public Produto(String nomeProd, String descProd, int idMarca, Categoria catProd) {
		
		setNomeProduto(nomeProd);
		setDescricaoProduto(descProd);
		setIdMarca(idMarca);
		setCategoriaProduto(catProd);
		
	}

	public int getIdProduto() { return idProduto; }
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeProduto() { return nomeProduto; }
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getDescricaoProduto() { return descricaoProduto; }
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public int getIdMarca() { return idMarca; }
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	public Categoria getCategoriaProduto() { return categoriaProduto; }
	public void setCategoriaProduto(Categoria categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}
	
	public void cadastrarProduto(Produto cadProd) {
		Produto novoProduto = new Produto();
		novoProduto.setNomeProduto(cadProd.getNomeProduto());
		novoProduto.setDescricaoProduto(cadProd.getDescricaoProduto());
		novoProduto.setIdMarca(cadProd.getIdMarca());
		novoProduto.setCategoriaProduto(cadProd.getCategoriaProduto());
		
		
	}
	
	
	
	

}
