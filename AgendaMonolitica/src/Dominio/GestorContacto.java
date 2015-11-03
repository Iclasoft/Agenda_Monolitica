package Dominio;

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
	
	public Vector<Contacto> buscarContactoNombre(String nombre) throws SQLException{
		return realizarConsulta("SELECT * FROM contactos WHERE nombre = %"+nombre);
	}
	public Vector<Contacto> buscarContactoTfno(String tfno) throws SQLException{
		return realizarConsulta("SELECT * FROM contactos WHERE nombre = %"+tfno);
	}
	private Vector<Contacto> realizarConsulta(String sentencia) throws SQLException{
		Vector<Contacto> listaContactos = new Vector<Contacto>();
		List<String[]> contactos=Agente.getAgente().executeQuery(sentencia);
		for(String[] contacto: contactos){
			listaContactos.addElement(new Contacto(contacto[0],contacto[1]));
		}
		return listaContactos;
	}
}
