package Dominio;

import java.sql.SQLException;

import Persistencia.Agente;

public class GestorAgente {
	private static String ruta="Datos";
	public void connect() throws ClassNotFoundException, SQLException{
		Agente.getAgente().connect(ruta);
	}
	
	public void disconect(){
		try {
			Agente.getAgente().disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
