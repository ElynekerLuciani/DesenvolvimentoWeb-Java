package web.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.jdbc.dao.conexao.ConnectionFactory;
import web.jdbc.model.Validacao;

public class ValidacaoDAO {
	private Connection connection;
	private String sql;
	
	public ValidacaoDAO() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
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

}
