package web.jdbc.dao;

import java.util.ArrayList;
import java.util.List;
import web.jdbc.dao.conexao.ConnectionFactory;
import web.jdbc.model.Funcionario;

import java.sql.*;

public class FuncionarioDAO {
	private Connection connection;
	private String sql;
	
	public FuncionarioDAO() throws SQLException{
		this.connection = new ConnectionFactory().getConnection();
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



	public void adicionaFuncionario(Funcionario funcionario) {
		sql = "insert into funcionario" +
					 "(nome, cpf, email, celular, telefone, rua, bairro, bloco, numero, cidade, estado, cep, login, senha) "
					 + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNomeFuncionario());
			stmt.setString(2, funcionario.getCpfFuncionario().getCpf());
			stmt.setString(3, funcionario.getContatoFuncionario().getEmail());
			stmt.setString(4, funcionario.getContatoFuncionario().getCelular());
			stmt.setString(5, funcionario.getContatoFuncionario().getTelefone());
			stmt.setString(6, funcionario.getEnderecoFuncionario().getRua());
			stmt.setString(7, funcionario.getEnderecoFuncionario().getBairro());
			stmt.setInt(8, funcionario.getEnderecoFuncionario().getBloco());
			stmt.setInt(9, funcionario.getEnderecoFuncionario().getNumero());
			stmt.setString(10, funcionario.getEnderecoFuncionario().getCidade());
			stmt.setString(11, funcionario.getEnderecoFuncionario().getEstado());
			stmt.setString(12, funcionario.getEnderecoFuncionario().getCep());
			stmt.setString(13, funcionario.getLoginFuncionario().getLogin());
			stmt.setString(14, funcionario.getLoginFuncionario().getSenha());
			//executa 
			System.out.println("passou");
			stmt.execute();
			stmt.close();	
		} catch (SQLException e) {
			throw new RuntimeException(e + " Erro ao tentar salvar");
		}
	}
	
	public void excluirFuncionario(Funcionario funcionario) {
		sql = "delete from funcionario where id=?";

        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
            stmt.setInt(1, funcionario.getIdFuncionario());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
        	throw new RuntimeException(e + " Erro ao tentar excluir");
        }
	}
	
	public List<Funcionario> getLista(){
		try {
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(
									 "SQL DE PESQUISA FUNCIONARIOS");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setNomeFuncionario(rs.getString("nome"));
				//funcionario.setCpf(rs.getString("cpf"));
				//
				
				
			}
			rs.close();
			stmt.close();
			return funcionarios;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

}
