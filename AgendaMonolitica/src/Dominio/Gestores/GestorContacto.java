package Dominio.Gestores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;


import Persistencia.Agente;
import Dominio.Gestores.GestorAnadir;
import Dominio.Gestores.GestorConsultas;
import Dominio.POJO.Contacto;

@SuppressWarnings("unused")
public class GestorContacto {
	private GestorAnadir gestoranadir;
	private GestorModificar gestormodificar;
	private GestorBorrar gestorborrar;
	private GestorBuscar gestorbuscar;
	private GestorConsultas gestorconsultas;
	
	public GestorContacto(){
		gestoranadir = new GestorAnadir();
		gestormodificar = new GestorModificar();
		gestorborrar = new GestorBorrar();
		gestorbuscar = new GestorBuscar();
		gestorconsultas = new GestorConsultas();
	}
	
	
	public Vector<Contacto> cargarDatos() throws SQLException{
		List<String[]> contactos= Agente.getAgente().executeQuery("SELECT * FROM contactos");
		Vector<Contacto> listaContactos=new Vector<Contacto>();
		
		for(String[] contacto: contactos){
			listaContactos.addElement(new Contacto(contacto[0],contacto[1]));
		}
			
		
		return listaContactos;
	}
	
	public void add(String Nombre, String Telefono) throws SQLException{
		gestoranadir.add(Nombre, Telefono);
	}
	
	public void borrar(String Telefono)throws SQLException{
		gestorborrar.borrar(Telefono);
	}
	
	public void modify(String Nombre, String Telefono) throws SQLException{
		gestormodificar.modify(Nombre, Telefono);
	}
	
	public Vector<Contacto> buscarContactoNombre(String Nombre) throws SQLException{
		return gestorbuscar.searchName(Nombre);
	}
	
	public Vector<Contacto> buscarContactoTelefono(String Telefono) throws SQLException{
		return gestorbuscar.searchTlf(Telefono);
	}
}
