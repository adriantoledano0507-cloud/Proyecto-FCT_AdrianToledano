package servicio;

import java.util.Scanner;

import dominio.Categoria;
import persistencia.CategoriaDao;

public class CategoriaServicio implements ICategoriaServicio{ // Implementamos la interfaz donde están sus métodos y los desarrollamos en la clase
	private final Scanner sc;
	private CategoriaDao categoriaDao;
	
	public CategoriaServicio(Scanner sc) {
		this.sc = sc;
		this.categoriaDao = new CategoriaDao();
	}
	
	// Desarrollamos el método buscarCategoria
	@Override
	public Categoria buscarCategoria() {
		// Instanciamos una categoría inicializada en null
		Categoria categoria = null; 
		
		// Metemos todo en un bucle while para que el usuario introduzca un valor válido
		while (categoria == null){
			System.out.println("Categorías disponibles:");
			
			// Mostramos con este bucle for cuales son las categorías disponibles
			for (Categoria c : categoriaDao.obtenerCategorias().values()) {
				System.out.println(categoria.getNombre());
			}
			
			// Pedimos que introduza la categoría a la que perteneces su evento
			System.out.println("Por favor intoduce una categoría: ");
			// Guardamos el valor introducido por el usuario en esta variable
			String nombre = sc.nextLine(); 
			
			// Intentamos obtener la categoría introducida por el usuario a ver si pertenece a las que se tienen previamente 
			categoria = categoriaDao.obtenerCategoria(nombre);
			
			// Comprobamos que si la categoria no está le indicamos al usuario que es inválido el tipo de categoria que ha introducido 
			if (categoria == null) {
				System.out.println("Categoría no válida");
			}
		}
		
		// Salimos del método 
		return categoria; 
		 
	}
}
