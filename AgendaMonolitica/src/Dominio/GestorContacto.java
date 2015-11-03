package Dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;


import Persistencia.Agente;

@SuppressWarnings("unused")
public class GestorContacto{
	private Connection conn;
	public Vector<Contacto> cargarDatos() throws SQLException{
		List<String[]> contactos= Agente.getAgente().executeQuery("SELECT * FROM contactos");
		Vector<Contacto> listaContactos=new Vector<Contacto>();
		
		for(String[] contacto: contactos){
			listaContactos.addElement(new Contacto(contacto[0],contacto[1]));
		}
			
		
		return listaContactos;
	}
	
	public void add(String Nombre, String Telefono) throws SQLException{
		Agente.getAgente().executeNonQuery("INSERT INTO contactos VALUES('"+Nombre+"', '"+Telefono+"')");	
	}

	
}