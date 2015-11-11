package Dominio.Gestores;

import java.sql.SQLException;

import Dominio.Gestores.GestorConsultas;

public class GestorBorrar {
	private GestorConsultas gestorconsultas;
	
	public GestorBorrar(){
		gestorconsultas = new GestorConsultas();
	}
	public void borrar(String Telefono) throws SQLException{
		gestorconsultas.realizarConsultaNONQUERY("DELETE FROM contactos WHERE TFNO= '"+Telefono+"'");
	}
}
