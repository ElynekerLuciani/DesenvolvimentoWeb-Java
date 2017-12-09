package web.jdbc.model;

import web.jdbc.dao.ItemDAO;

public class Item {
	private int idItem;
	private int idProduto;
	private String descricaoItem;
	private int quantidade;
	
	//private ItemDAO dao = ItemDAO.getInstancia();
	
	public Item() {
		
	}
	
	public void adicionarItem(Item item) {
		Item novoItem = new Item();
		try {
			novoItem.setIdProduto(item.getIdProduto());
			novoItem.setDescricaoItem(item.getDescricaoItem());
			novoItem.setQuantidade(item.getQuantidade());
			
			// NESSA PARTE EU FAÇO UM PEDIDO DESTE ITEM
			Pedido pedido = new Pedido();
			pedido.adicionarPedidoInterno(novoItem);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public int getIdItem() { return idItem; }
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public int getIdProduto() { return idProduto; }
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getDescricaoItem() { return descricaoItem; }
	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}
	public int getQuantidade() { return quantidade; }
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
