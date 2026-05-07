package dominio;

import java.time.LocalDate;
import java.time.LocalTime;

public class Organizador extends Usuario{ // Esta clase hereda directamente de la clase Usuario
	// Declaramos el atributo extra que no hereda de Usuario
	private String telefono; 
	
	// Creamos este constructor donde recibe solo el correo y el teléfono para validar en el princial su login 
	public Organizador (String correo, String telefono) {
		setCorreo(correo); 
		this.telefono = telefono; 
	}
	// Creamos este constructor que recibe todos los atributos suyos y heredados para el momento del registro 
	public Organizador (String nombre, String correo, String contrasenia, String telefono) {
		super (nombre, correo, contrasenia); 
		this.telefono = telefono; 
	}
	// Creamos los setters y los getters 
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	// Declaramos el método toString que hereda con el super.toString el método de la clase padre
	@Override
	public String toString() {
		return super.toString() + "Organizador [telefono=" + telefono + "]";
	}
	
	// Con este método instanciamos un evento que es lo que el organizador puede hacer. Devuelve un evento instanciado
	public Evento organizarEvento(String nombre, String descripcion, LocalDate fecha, LocalTime hora, int duracion, String ubicacion, Categoria categoria) {
		
		return new Evento (nombre, descripcion, fecha, hora, duracion, ubicacion, categoria, this); // La palabra this que se ha utilizado en otra ocasión hace referencia a que el organizador que organiza el evento es ESTE mismo el que lo está creando
		
	}
	
}
