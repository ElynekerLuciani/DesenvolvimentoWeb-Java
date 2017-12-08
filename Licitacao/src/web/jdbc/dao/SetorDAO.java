package web.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;




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
	
	public synchronized void adicionarSetor(Setor setor) throws SQLException, ClassNotFoundException {
		Connection con = dao.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("INSERT INTO setor (nomeSetor) VALUES (?)");
			stmt.setString(1, setor.getNomeSetor());
			stmt.executeUpdate();
		} catch (Exception e) {
			Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public Vector<Setor> getLista(){
		Vector<Setor> setores = new Vector<Setor>();
		Connection con = dao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			stmt = con.prepareStatement("SELECT * FROM setor");
			rs = stmt.executeQuery();
			while(rs.next()){
				Setor setor = new Setor();
				setor.setIdSetor(rs.getInt("idSetor"));
				setor.setNomeSetor(rs.getString("nomeSetor"));
				
				setores.add(setor);
			}
		}catch (Exception e) {
			Logger.getLogger(SetorDAO.class.getName()).log(Level.SEVERE, null, e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return setores;
	}
	
	public int funcionarioSizeSetror(int idSetor){
		int quantidade = 0;
		Connection con = dao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs =null;
		try {
			stmt= con.prepareStatement("SELECT COUNT(*) AS qtd  FROM funcionario where idSetor = "+idSetor+";");
			rs = stmt.executeQuery();
			while(rs.next()) {
				quantidade = rs.getInt("qtd");
				
			}
			
			
		} catch(SQLException e) {
			Logger.getLogger(SetorDAO.class.getName()).log(Level.SEVERE, null, e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return quantidade;
	}

}
