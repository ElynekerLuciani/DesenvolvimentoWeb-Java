package web.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.RuntimeErrorException;

import web.jdbc.dao.conexao.ConnectionFactory;
import web.jdbc.model.Fornecedor;
import web.jdbc.model.Funcionario;

public class FornecedorDAO {
	private ConnectionFactory dao = ConnectionFactory.getInstancia();
	
	private static FornecedorDAO instancia; 
	
	protected FornecedorDAO() {
		
	}
	
	public static FornecedorDAO getInstancia() {
		if (instancia == null) {
			instancia = new FornecedorDAO();
		}
		return instancia;
	}

	
	public void adicionaFornecedor(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
		Connection con = dao.getConnection();
		PreparedStatement stmt = null;
	System.out.println("entrou em add dao");
		try {
			stmt = con.prepareStatement("INSERT INTO fornecedor (nomeForn, cnpj, rua, numero, bairro, bloco, cidade, estado, cep, email, telefone, celular, login, senha, categoria)"+
										"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			System.out.println("depois do sql");
			stmt.setString(1, fornecedor.getNomeFornecedor());
			stmt.setString(2, fornecedor.getCnpjFornecedor().getCnpj());
			stmt.setString(3, fornecedor.getEndFornecedor().getRua());
			stmt.setInt(4, fornecedor.getEndFornecedor().getNumero());
			stmt.setString(5, fornecedor.getEndFornecedor().getBairro());
			stmt.setString(6, fornecedor.getEndFornecedor().getBloco());
			stmt.setString(7, fornecedor.getEndFornecedor().getCidade());
			stmt.setString(8, fornecedor.getEndFornecedor().getEstado());
			stmt.setString(9, fornecedor.getEndFornecedor().getCep());
			stmt.setString(10, fornecedor.getContatoFornecedor().getEmail());
			stmt.setString(11, fornecedor.getContatoFornecedor().getTelefone());
			stmt.setString(12, fornecedor.getContatoFornecedor().getCelular());
			stmt.setString(13, fornecedor.getLoginFornecedor().getLogin());
			stmt.setString(14, fornecedor.getLoginFornecedor().getSenha());
			//stmt.setBoolean(15, fornecedor.getAprovadoFornecedor());
			//stmt.setFloat(16, fornecedor.getNotaFornecedor());
			stmt.setInt(15, fornecedor.getCategoriaFornecedor());
			System.out.println("antes de executar");
			stmt.execute();
			System.out.println("passou depois de executar");
		} catch (SQLException e) {
			Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, e.getMessage() + "erro em dao fornecedor");
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public Vector<Fornecedor> getLista(){
		Vector<Fornecedor> fornecidores = new Vector();
		Connection con = dao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			stmt = con.prepareStatement("SELECT * FROM fornecedor" );
			rs = stmt.executeQuery();
			while(rs.next()){
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setNomeFornecedor(rs.getString("nomeForn"));
				fornecedor.setIdFornecedor(rs.getInt("idForn"));
				fornecedor.setAprovadoFornecedor(rs.getBoolean("aprovado"));
				fornecedor.getCnpjFornecedor().setCnpj(rs.getString("cnpj"));
				fornecedor.setCategoriaFornecedor(rs.getInt("categoria"));
				
				
				fornecidores.add(fornecedor);
			}
		}catch (Exception e) {
			Logger.getLogger(SetorDAO.class.getName()).log(Level.SEVERE, null, e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return fornecidores;
	}
	
	public Fornecedor retornarId (Fornecedor forn) throws  SQLException {
		Connection con = dao.getConnection(); 
		PreparedStatement stmt = null;
		ResultSet rs =null;
		try {
			Fornecedor n = new Fornecedor();
			
			stmt = con.prepareStatement("SELECT idFornecedor FROM fornecedor WHERE cnpj = '"+ forn.getCnpjFornecedor().getCnpj()+"'");
			rs = stmt.executeQuery();
			
			if(rs.next()){
				n.setIdFornecedor(rs.getInt("idFornecedor"));
			}
			
			return n;
			
		
		}  catch (SQLException e) {
			throw new RuntimeException(e.getMessage() + "erro dao fornecedor retornar id");
		}finally {
			ConnectionFactory.closeConnection(con, stmt,rs);
		}
	}
	
	
}
