package dominio;

public class Categoria {
	// Declaramos los atributos de la clase Categoría
	private String nombre; 
	private String descripcion; 
	
	// Declaramos en constructor 
	public Categoria (String nombre, String descripcion) {
		this.nombre = nombre; 
		this.descripcion = descripcion; 
	}
	
	// Creamos los setters y los getters de los atributos
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	// Declaramos el método toString
	@Override
	public String toString() {
		return "Categoria [nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
}
