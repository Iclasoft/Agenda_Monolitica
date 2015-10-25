package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//1 hora y media

public class Agente {
	private static Agente instancia;
	private Connection conn;
	
	private Agente(){}
	
	public static Agente getAgente(){
		if(instancia==null){
			instancia=new Agente();
		}
		return instancia;
	}
	
	public void connect(String ruta) throws ClassNotFoundException, SQLException{
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
		try{
			conn = DriverManager.getConnection("jdbc:derby:."+ruta+";create=false");
		}
		catch(SQLException e){
			conn = DriverManager.getConnection("jdbc:derby:."+ruta+";create=true");
			
			PreparedStatement pstm=conn.prepareStatement("CREATE TABLE contactos(nombre varchar(50), tfno varchar(18), PRIMARY KEY(nombre)");
			pstm.execute();
			pstm.close();
		}
	}
	public void disconnect() throws SQLException{
		conn.close();
	}
	public void executeNonQuery(String statement) throws SQLException{
		PreparedStatement pstm=conn.prepareStatement(statement);
		pstm.execute();
		pstm.close();
	}
	public ResultSet executeQuery(String statement) throws SQLException{
		PreparedStatement pstm= conn.prepareStatement(statement);
		ResultSet resultado= pstm.executeQuery();
		pstm.close();
		return resultado;
	}
	
	
}
