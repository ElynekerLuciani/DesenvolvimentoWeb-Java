package web.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import web.jdbc.dao.conexao.ConnectionFactory;
import web.jdbc.model.Setor;

public class SetorDAO {
	private ConnectionFactory dao = ConnectionFactory.getInstancia();
	private static SetorDAO instancia;
	
	protected SetorDAO() {
		
	}
	
	public static SetorDAO getInstancia() {
		if(instancia == null) {
			instancia = new SetorDAO();
		}
		return instancia;
	}
	
	public void adicionarSetor(Setor setor) throws SQLException, ClassNotFoundException {
		Connection con = dao.getConnection();
		PreparedStatement stmt = null;
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
