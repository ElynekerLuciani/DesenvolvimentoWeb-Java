package web.jdbc.dao;

import com.mysql.jdbc.Connection;
import web.jdbc.dao.conexao.ConnectionFactory;
import web.jdbc.model.Produto;
import java.sql.*;


public class ProdutoDAO {
	private Connection connection;
	private String sql;
	
	public ProdutoDAO() throws SQLException {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}

	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	
	public void adicionarProduto(Produto produto) {
		sql = "insert into produto(nomeProd, descricaoPro, idMarca, idCat)" + 
				" values(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, produto.getNomeProduto());
			stmt.setString(2, produto.getDescricaoProduto());
			stmt.setInt(3, produto.getIdMarca());
			stmt.setString(4, produto.getCategoriaProduto().getNomeCategoria());
			
			stmt.execute();
			System.out.println("cadastrou novo produto");
			stmt.close();	
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
