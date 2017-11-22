package web.jdbc.dao.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class DAO_Conexao {
	private Connection conexaoBD;
	
	//responsavel pela conexao com a base de dados
	public void conexao() {
		String driver = "org.postgresql.Driver";
		String caminho = "jdbc:postgresql://localhost:5432/NOME_DO_BANCO_DE_DADOS";
		String usuario = "NOME_DO_USUARIO";
		String senha = "SENHA";
		try {
			System.setProperty("jdbc.Drivers", driver);
			conexaoBD = DriverManager.getConnection(caminho, usuario, senha);
		}catch(SQLException erro) {
			
		}
	}
	//responsavel por desconectar a base de dados
	public void desconectar() {
		try {
			conexaoBD.close();
		}catch(SQLException erro) {
			
		}
	}
	//responsavel por realizar a consulta na base de dados
	public void executarSQL(String sql) {
		Statement pesquisar;
		ResultSet resultado = null;
		try {
			pesquisar = conexaoBD.createStatement(resultado.TYPE_SCROLL_INSENSITIVE, resultado.CONCUR_READ_ONLY);
			resultado = pesquisar.executeQuery(sql);
		}catch(SQLException erro) {
			
		}
	}

}
