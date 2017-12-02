package web.jdbc.dao.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//gera conexao com a base de dados
public class ConnectionFactory {
	
	private static ConnectionFactory instancia;
	
	private final String DRIVE = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost/webprojectdatabase"; 
	private final String USER = "root";
	private final String PASSWORD = "";
	
	public ConnectionFactory() {

	}
	
	public static ConnectionFactory getInstancia() {
		System.out.println("Ate aki ok ");
		if(instancia == null){
			instancia = new ConnectionFactory();
		}
		return instancia;
	}
	
	public Connection getConnection(){
		try {
			Class.forName(DRIVE);
			return DriverManager.getConnection(URL, USER, PASSWORD);
			
			} catch (SQLException | ClassNotFoundException e) {
				throw new RuntimeException(e);
			}

	}

	public static void closeConnection(Connection con){
        try {
            if(con != null){
                con.close();
            }
        } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void closeConnection(Connection con,PreparedStatement stmt){
        closeConnection(con);
        
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void closeConnection(Connection con,PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
