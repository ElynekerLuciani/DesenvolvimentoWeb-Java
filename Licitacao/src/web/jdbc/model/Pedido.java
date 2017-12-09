package web.jdbc.model;

import web.jdbc.dao.PedidoDAO;

public class Pedido {
	private Item itemPedido;
	private boolean situacao;
	private int idSetor;
	
	private PedidoDAO dao = PedidoDAO.getInstancia();
	
	Pedido() {
		
	}
	
	Pedido(Item item, boolean situacao, int idSetor) {
		this.itemPedido = item;
		this.idSetor = idSetor;
		this.situacao = situacao;
		
	}
	
	public void adicionarPedidoInterno(Item pedidoInterno) {
		//AQUI EU RECEBO O ITEM QUE ESCOLHI E TENHO AGORA QUE DIZER A SITUAÇÃO SE 
		//ESTÁ APROVADO OU NAO E DIZER O SETOR... ESSA PARTE DA PRA ENVIAR A PARTIR DA VIEW???
		Pedido novoPedido = new Pedido(pedidoInterno, situacao, idSetor);
		try {
			dao.adicionarPedidoInterno(novoPedido);
		} catch (Exception e) {
			System.out.println(e.getMessage() + "erro Pedido: adicionar pedido interno");
		}
		
	}
	
	//metodos getters e setters
	
	public Item getItemPedido() { return itemPedido; }
	public void setItemPedido(Item itemPedido) {
		this.itemPedido = itemPedido;
	}
	public boolean isSituacao() { return situacao; }
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
	public int getIdSetor() { return idSetor; }
	public void setIdSetor(int idSetor) {
		this.idSetor = idSetor;
	}
	
	
	

}
