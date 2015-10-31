package Dominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;


import Persistencia.Agente;

public class GestorContacto {
	public Vector<Contacto> cargarDatos() throws SQLException{
		List<String[]> contactos= Agente.getAgente().executeQuery("SELECT * FROM contactos");
		Vector<Contacto> listaContactos=new Vector<Contacto>();
		
		for(String[] contacto: contactos){
			listaContactos.addElement(new Contacto(contacto[0],contacto[1]));
		}
			
		
		return listaContactos;
	}
	public Vector<Contacto> borrarContacto(Contacto contacto) throws SQLException{
		List<String[]> contactos;
		Vector<Contacto> listaContactos=new Vector<Contacto>();
		Agente.getAgente().executeNonQuery("DELETE FROM contactos WHERE nombre= '"+contacto.getNombre()+"'");
		contactos= Agente.getAgente().executeQuery("SELECT * FROM contactos");
		for(String[] c: contactos){
			listaContactos.addElement(new Contacto(c[0],c[1]));
		}
		return listaContactos;
	}
}
