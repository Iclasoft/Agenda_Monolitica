package Dominio.Gestores;

import java.sql.SQLException;

import Dominio.Gestores.GestorConsultas;

public class GestorAnadir {
	private GestorConsultas gestorconsultas;
	
	public GestorAnadir(){
		gestorconsultas = new GestorConsultas();
	}
	public void add(String Nombre, String Telefono) throws SQLException{
		gestorconsultas.realizarConsultaNONQUERY("INSERT INTO contactos VALUES('"+Nombre+"', '"+Telefono+"')");	
	}
}
