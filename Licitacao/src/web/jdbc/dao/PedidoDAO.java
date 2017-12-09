package web.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import web.jdbc.dao.conexao.ConnectionFactory;
import web.jdbc.model.Pedido;

public class PedidoDAO {
	private ConnectionFactory dao = ConnectionFactory.getInstancia();
	private static PedidoDAO instancia;
	
	protected PedidoDAO() {
		
	}
	
	public static PedidoDAO getInstancia() {
		if(instancia == null) {
			instancia = new PedidoDAO();
		}
		return instancia;
	}
	
	public void adicionarPedidoInterno (Pedido pedidoInterno) throws SQLException {
		Connection con = (Connection) dao.getConnection();
		PreparedStatement stmt = null;
		try {
			
			//AQUE EU VOU TER Q SALVAR NA TABELA SOMENTE O ID DO ITEM PEDIDO, O SETOR E A SITUAÇÃO.
			stmt = con.prepareStatement("SQL PARA INSERIR PEDIDO INTERNO");
			stmt.setInt(1, pedidoInterno.getItemPedido().getIdItem());
			stmt.setInt(2, pedidoInterno.getIdSetor());
			stmt.setBoolean(3, pedidoInterno.isSituacao());
			
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}

}
