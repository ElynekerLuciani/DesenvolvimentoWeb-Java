package web.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import web.jdbc.dao.conexao.ConnectionFactory;
import web.jdbc.model.Funcionario;

public class FuncionarioDAO {
	
	private ConnectionFactory dao = ConnectionFactory.getInstancia();
	
	private static FuncionarioDAO instancia; 
	
	protected FuncionarioDAO() {
		
	}
	
	public static FuncionarioDAO getInstancia() {
		if (instancia == null) {
			instancia = new FuncionarioDAO();
		}
		return instancia;
	}

	
	public void adicionaFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException {
		Connection con = dao.getConnection();
		PreparedStatement stmt = null;
	
		try {
			
			stmt = con.prepareStatement("insert into funcionario (nomeFunc, cpf, rua, numero, bairro, bloco, cidade, estado, cep, email, telefone, celular, login, senha) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, funcionario.getNomeFuncionario());
			stmt.setString(2, funcionario.getCpfFuncionario().getCpf());
			stmt.setString(3, funcionario.getEnderecoFuncionario().getRua());
			stmt.setInt(4, funcionario.getEnderecoFuncionario().getNumero());
			stmt.setString(5, funcionario.getEnderecoFuncionario().getBairro());
			stmt.setString(6, funcionario.getEnderecoFuncionario().getBloco());
			stmt.setString(7, funcionario.getEnderecoFuncionario().getCidade());
			stmt.setString(8, funcionario.getEnderecoFuncionario().getEstado());
			stmt.setString(9, funcionario.getEnderecoFuncionario().getCep());
			stmt.setString(10, funcionario.getContatoFuncionario().getEmail());
			stmt.setString(11, funcionario.getContatoFuncionario().getTelefone());
			stmt.setString(12, funcionario.getContatoFuncionario().getCelular());
			stmt.setString(13, funcionario.getLoginFuncionario().getLogin());
			stmt.setString(14, funcionario.getLoginFuncionario().getSenha());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public Funcionario retornarId (Funcionario func) throws  SQLException {
		Connection con = dao.getConnection(); 
		PreparedStatement stmt = null;
		ResultSet rs =null;
		try {
			Funcionario n = new Funcionario();
			
			stmt = con.prepareStatement("SELECT idFunc FROM funcionario WHERE cpf = '"+func.getCpfFuncionario().getCpf()+"'");
			rs = stmt.executeQuery();
			
			if(rs.next()){
				n.setIdFuncionario(rs.getInt("idFunc"));
			}
			
			return n;
			
		
		}  catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			ConnectionFactory.closeConnection(con, stmt,rs);
		}
	}
	
	public void excluirFuncionario(Funcionario funcionario) {
		
		Connection con = dao.getConnection();
		PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("delete from funcionario where id=?");
            stmt.setInt(1, funcionario.getIdFuncionario());
            stmt.executeUpdate();
        } catch (SQLException e) {
        	throw new RuntimeException(e + " Erro ao tentar excluir");
        }finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Funcionario> getLista(){
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		Connection con = dao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs =null;
		try {
			stmt= con.prepareStatement("Sql Aqui");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setNomeFuncionario(rs.getString("nomeFunc"));                   
				funcionario.getContatoFuncionario().setCelular(rs.getString("celular"));
				funcionario.getContatoFuncionario().setEmail(rs.getString("email "));
				funcionario.getContatoFuncionario().setTelefone(rs.getString("telefone"));
				funcionario.getCpfFuncionario().setCpf(rs.getString("cpf"));    
				funcionario.getEnderecoFuncionario().setBairro(rs.getString("bairro "));    
				funcionario.getEnderecoFuncionario().setBloco(rs.getString("bloco "));      
				funcionario.getEnderecoFuncionario().setCep(rs.getString("cep"));     
				funcionario.getEnderecoFuncionario().setCidade(rs.getString("cidade")); 
				funcionario.getEnderecoFuncionario().setEstado(rs.getString("estado"));        
				funcionario.getEnderecoFuncionario().setNumero(rs.getInt("numero"));           
				funcionario.getEnderecoFuncionario().setRua(rs.getString("rua"));   
				funcionario.getLoginFuncionario().setLogin(rs.getString("login"));        
				funcionario.getLoginFuncionario().setSenha(rs.getString("senha"));          
				//
				
				funcionarios.add(funcionario);
			}
			
			
		} catch(SQLException e) {
			Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return funcionarios;
	}
	
}
