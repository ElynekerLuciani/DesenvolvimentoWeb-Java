package web.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import web.jdbc.dao.conexao.ConnectionFactory;
import web.jdbc.model.Validacao;

public class ValidacaoDAO {
	//private Connection connection;
	//private String sql;
	private ConnectionFactory dao = ConnectionFactory.getInstancia();
	private static ValidacaoDAO instancia;
	
	protected ValidacaoDAO() {
		
	}
	
	public static ValidacaoDAO getInstancia() {
		if(instancia == null) {
			instancia = new ValidacaoDAO();
		}
		return instancia;
	}
	
	/*
	public ValidacaoDAO() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}
	*/ 
	
	public boolean acessarSistema(Validacao validar) throws SQLException, ClassNotFoundException {
		Connection con = dao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			if(validar.getNivel() == 1) {
				stmt = con.prepareStatement("SELECT senha FROM funcionario WHERE login = '"+ validar.getLogin() + "'");
			} else {
				stmt = con.prepareStatement("SELECT senha FROM fornecedor WHERE login = '"+ validar.getLogin() + "'");
			}
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				if(validar.getSenha().equals(rs.getString("senha"))) {
					return true;
				}
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage() + "erro em acessar sistema funcionario");
		}finally {
			ConnectionFactory.closeConnection(con, stmt,rs);
		}
		return false;
	}
	
	
	
	
	/*
	public int validarAcesso(Validacao acesso) {
		sql = "CONSULTA DE LOGIN NA TABELA VALIDACAO";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			stmt.close();
			rs.close();
			if(rs.getString("login").equals(acesso.getLogin()) ) {
				return acesso.getNivel();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Erro em validar Acesso.");
		}
		return 0;
	}
	
	public void inserirAcesso(Validacao inserir){
		sql = "INSERT INTO validacao(login, nivel, idUser) VALUES (?,?,?)";
		System.out.println("entrou em inserir validacao");
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, inserir.getLogin());
			stmt.setInt(2, inserir.getNivel());
			stmt.setInt(3, inserir.getIdCliente());
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Erro em Inserir Acesso");
		}
	}
*/
}
