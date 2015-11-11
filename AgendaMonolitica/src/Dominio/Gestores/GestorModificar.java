package Dominio.Gestores;

import java.sql.SQLException;

import Dominio.Gestores.GestorConsultas;

public class GestorModificar {
	private GestorConsultas gestorconsultas;
	
	public GestorModificar(){
		gestorconsultas = new GestorConsultas();
	}
	
	public void modify(String Nombre,String Telefono)throws SQLException{
		gestorconsultas.realizarConsultaNONQUERY("UPDATE contactos SET nombre='"+Nombre+"' WHERE TFNO= '"+Telefono+"'");
	}
}
