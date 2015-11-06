package Dominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;


import Persistencia.Agente;

@SuppressWarnings("unused")
public class GestorContacto {
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

	public Vector<Contacto> modify(String Nombre,String Telefono)throws SQLException{
		Agente.getAgente().executeNonQuery("UPDATE contactos SET nombre='"+Nombre+"' WHERE TFNO= '"+Telefono+"'");
		return cargarDatos();
	}
	public void borrarContacto(Contacto contacto) throws SQLException{
		Agente.getAgente().executeNonQuery("DELETE FROM contactos WHERE TFNO= '"+contacto.getTelefono()+"'");
	}
	public Vector<Contacto> buscarContactoNombre(String nombre) throws SQLException{
		return realizarConsulta("SELECT * FROM contactos WHERE nombre like '%"+nombre+"%'");
	}
	public Vector<Contacto> buscarContactoTfno(String tfno) throws SQLException{
		return realizarConsulta("SELECT * FROM contactos WHERE tfno like '%"+tfno+"%'");
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
