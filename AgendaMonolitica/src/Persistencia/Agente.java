package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dominio.Contacto;


@SuppressWarnings("unused")
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
			
			PreparedStatement pstm=conn.prepareStatement("CREATE TABLE CONTACTOS(NOMBRE varchar(50), TFNO varchar(18), PRIMARY KEY(TFNO))");
			pstm.execute();
			pstm.close();
		}
	}
	public void disconnect() throws SQLException{
		if(conn!=null) conn.close();
	}
	public void executeNonQuery(String statement) throws SQLException{
		PreparedStatement pstm=conn.prepareStatement(statement);
		pstm.execute();
		pstm.close();
	}
	public List<String[]> executeQuery(String statement) throws SQLException{
		PreparedStatement pstm= conn.prepareStatement(statement);
		ResultSet resultado= pstm.executeQuery();
		List<String[]> contactos=new ArrayList<String[]>();
		while(resultado.next()){
			String[] array= new String[2];
			array[0]=resultado.getString("nombre");
			array[1]=resultado.getString("tfno");
			contactos.add(array);
		}
		pstm.close();
		return contactos;
	}
	
	
}
