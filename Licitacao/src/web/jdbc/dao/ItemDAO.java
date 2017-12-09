package web.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import com.mysql.jdbc.Connection;

import web.jdbc.dao.conexao.ConnectionFactory;
import web.jdbc.model.Item;

public class ItemDAO {
	private ConnectionFactory dao = ConnectionFactory.getInstancia();
	
	private static ItemDAO instancia;
	
	protected ItemDAO() {
		
	}
	
	public static ItemDAO getInstancia() {
		if(instancia == null) {
			instancia = new ItemDAO();
		}
		return instancia;
	}
	
	public void adicionarItem(Item item) throws SQLException, ClassNotFoundException{
		Connection con = (Connection) dao.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("INSTE INTO item(idProduto, descricao, quantidade) VALUES (?, ?, ?)");
			stmt.setInt(1, item.getIdProduto());
			stmt.setString(2, item.getDescricaoItem());
			stmt.setInt(3, item.getQuantidade());
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			throw new RuntimeErrorException(null, e.getMessage() + "ItemDAO: erro em adicionar item");
		}
	}

}
