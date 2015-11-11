package Dominio.Gestores;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import Dominio.POJO.Contacto;
import Persistencia.Agente;

public class GestorConsultas {
	public Vector<Contacto> realizarConsultaQUERY(String sentencia) throws SQLException{
		Vector<Contacto> listaContactos = new Vector<Contacto>();
		List<String[]> contactos=Agente.getAgente().executeQuery(sentencia);
		for(String[] contacto: contactos){
			listaContactos.addElement(new Contacto(contacto[0],contacto[1]));
		}
		return listaContactos;
	}
	
	public void realizarConsultaNONQUERY(String sentencia) throws SQLException{
		Agente.getAgente().executeNonQuery(sentencia);
	}
}
