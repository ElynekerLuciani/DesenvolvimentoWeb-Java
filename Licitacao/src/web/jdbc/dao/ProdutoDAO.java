package web.jdbc.dao;

import com.mysql.jdbc.Connection;
import web.jdbc.dao.conexao.ConnectionFactory;
import web.jdbc.model.Produto;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProdutoDAO {
	private ConnectionFactory dao = ConnectionFactory.getInstancia();
	
	private static ProdutoDAO instancia;
	
	protected ProdutoDAO() {
		
	}
	
	public static ProdutoDAO getInstancia() {
		if(instancia == null) {
			instancia = new ProdutoDAO();
		}
		return instancia;
	}

	
	public void adicionarProduto(Produto produto) throws SQLException, ClassNotFoundException {
		Connection con = (Connection) dao.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("insert into produto(nomeProd, descricaoPro, idMarca, idCat)" + 
					" values(?,?,?,?,?,?)");
			stmt.setString(1, produto.getNomeProduto());
			stmt.setString(2, produto.getDescricaoProduto());
			stmt.setInt(3, produto.getIdMarca());
			stmt.setString(4, produto.getCategoriaProduto().getNomeCategoria());
			
			stmt.execute();
			System.out.println("cadastrou novo produto");
			stmt.close();	
		}catch (SQLException e) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	

}
