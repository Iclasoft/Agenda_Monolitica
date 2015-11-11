package Dominio.Gestores;

import java.sql.SQLException;
import java.util.Vector;

import Dominio.POJO.Contacto;

public class GestorBuscar {
private GestorConsultas gestorconsultas;
	
	public GestorBuscar(){
		gestorconsultas = new GestorConsultas();
	}
	
	public Vector<Contacto> searchName(String Nombre) throws SQLException{
		return gestorconsultas.realizarConsultaQUERY("SELECT * FROM contactos WHERE nombre like '%"+Nombre+"%'");	
	}
	
	public Vector<Contacto> searchTlf(String Telefono) throws SQLException{
		return gestorconsultas.realizarConsultaQUERY("SELECT * FROM contactos WHERE tfno like '%"+Telefono+"%'");	
	}
}
