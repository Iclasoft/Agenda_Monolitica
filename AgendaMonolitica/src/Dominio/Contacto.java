package Dominio;

public class Contacto {

	private String Nombre;
	private String Telefono;
	
	public Contacto(String nombre, String telefono) {
		super();
		Nombre = nombre;
		Telefono = telefono;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	@Override
	public String toString() {
		return Nombre;
	}
	
	
	
	
}
