package web.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;

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
			stmt = con.prepareStatement("INSERT INTO categoria (nomeCategoria) VALUES (?)");
			stmt.setString(1, novaCategoria.getNomeCategoria());
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeErrorException(null, e.getMessage() + "CategoriaDAO: erro em adicionar categoria");
		}
		
	}
	
	public Vector<Categoria> listar(){
		Vector<Categoria> categorias = new Vector<Categoria>();
		Connection con = dao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			stmt = con.prepareStatement("SELECT * FROM categoria");
			rs = stmt.executeQuery();
			while(rs.next()){
				Categoria categoria = new Categoria();
				categoria.setIdCategoria(rs.getInt("idCat"));
				categoria.setNomeCategoria(rs.getString("nomeCat"));
				
				categorias.add(categoria);
			}
		}catch (Exception e) {
			Logger.getLogger(CategoriaDAO.class.getName(), null).log(Level.SEVERE, null, e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return categorias;
		
	}
	
	
	
	
}
