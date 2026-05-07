package dominio;

public class Usuario {
	
	// Declaramos los atributos de la clase Usuario
	private String nombre; 
	private String correo; 
	private String contrasenia;
	
	// Creamos el constructor con los atributos inicializados
	public Usuario (String nombre, String correo, String contrasenia) {
		this.nombre = nombre; 
		this.correo = correo; 
		this.contrasenia = contrasenia; 
	}
	
	// Creamos un constructos vacío por si hiciera falta en un futuro su uso
	public Usuario() {
		
	}
	
	// Creamos los setters y los getters 
	public String getNombre() {
		return nombre; 
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre; 
	}
	
	public String getCorreo() {
		return correo; 
	}
	
	public void setCorreo(String correo) {
		this.correo = correo; 
	}
	
	public String getContrasenia() {
		return contrasenia; 
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia; 
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", correo=" + correo + ", contrasenia=" + contrasenia + "]";
	}
	
	// Creamos el método inscribir evento para que los usuarios se puedan inscribir en los eventos disponibles
	public void inscribirEvento (Evento e) {
		// Con este if comprobamos si el usuario estaba o no incrito en el evento
		// En caso de que no se informa de que ha sido inscrito correctamente 
		// En caso de que si se esté inscrito se informa de que ya ha está inscrito 
		if(!e.getAsistentes().contains(this)) {
			e.getAsistentes().add(this); 
			System.out.println("Has sido añadido al evento: " + e.getNombre());
		} else {
			System.out.println("Ya se encontraba inscrito en este evento: " + e.getNombre());
		}
	}
	
	// Igual que el método anterior, creamos este método pero para cancelar si nos hemos inscrito previamente 
	public void cancelarInscripcion (Evento e) {
		// Lo mismo que en el método anterior, con un if se comprueba si el usuario está o no inscrito a un evento
		// Si está incrito se procede a la cancelación y se le informa por consola 
		// Si no está inscrito se el informa de que no lo está y por lo tanto no se puede proceder a una cancelación
		if(e.getAsistentes().contains(this)) {
			e.getAsistentes().remove(this); 
			System.out.println("Te has desincrito en este evento correctamente: " + e.getNombre());
		} else {
			System.out.println("No se encontraba inscrito en este evento: " + e.getNombre());
		}
	}
}
