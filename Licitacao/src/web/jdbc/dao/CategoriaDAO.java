package web.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import com.sun.istack.internal.logging.Logger;

import web.jdbc.dao.conexao.ConnectionFactory;
import web.jdbc.model.Categoria;

public class CategoriaDAO {
	private ConnectionFactory dao = ConnectionFactory.getInstancia();
	
	private static CategoriaDAO instancia; 
	
	public CategoriaDAO() {
		
	}
	
	public static CategoriaDAO getInstancia() {
		if (instancia == null) {
			instancia = new CategoriaDAO();
		}
		return instancia;
	}
	
	public void addCategoria(Categoria novaCategoria) throws SQLException, ClassNotFoundException {
		Connection con = dao.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO categoria (idCategoria, nomeCategoria) VALUES (?,?)");
			stmt.setInt(1, novaCategoria.getIdCategoria());
			stmt.setString(2, novaCategoria.getNomeCategoria());
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeErrorException(null, e.getMessage() + "CategoriaDAO: erro em adicionar categoria");
		}
		
	}
	
	
	
	
}
