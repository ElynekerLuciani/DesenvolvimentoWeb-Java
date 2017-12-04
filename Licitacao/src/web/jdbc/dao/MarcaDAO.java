package web.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;

import web.jdbc.dao.conexao.ConnectionFactory;
import web.jdbc.model.Marca;

public class MarcaDAO {
	private ConnectionFactory dao = ConnectionFactory.getInstancia();
	private static MarcaDAO instancia;
	
	protected MarcaDAO() {
		
	}
	//teste
	public static MarcaDAO getInstancia() {
		if(instancia == null) {
			instancia = new MarcaDAO();
		}
		return instancia;
	}
	
	
	public void adicionarMarca(Marca marca) {
		Connection con = (Connection) dao.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("SQL DE ADICIONAR MARCA");
			stmt.setString(1, marca.getNomeMarca());
			stmt.setString(2, marca.getModelo());
			
			stmt.execute();
			
			
		} catch (SQLException e) {
			Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	
	
}
