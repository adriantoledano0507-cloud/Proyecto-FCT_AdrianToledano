package servicio;

import java.util.Scanner;

import dominio.Organizador;
import dominio.Usuario;
import persistencia.OrganizadorDao;

public class OrganizadorServicio implements IOrganizadorServicio{ // Implementamos la interfaz correspondiente
	private final Scanner sc;
	private OrganizadorDao organizadorDao;
	
	public OrganizadorServicio(Scanner sc) {
		this.sc = sc;
		this.organizadorDao = new OrganizadorDao();
	}

	// Desarrollamos el método para hacr login de la parte de los Organizadores
	@Override
	public Organizador hacerLogin() {
		// Pedimos los datos para hacer login 
		System.out.println("Por favor, introduce su nombre:");
		String nombre = sc.nextLine(); 
		
		System.out.println("Por favor, introduce la contraseña");
		String contrasenia = sc.nextLine(); 
		
		// Comprobamos que las credenciales que se han ido recogiendo pertenezcan a un organizador
		Organizador organizador = organizadorDao.login(nombre, contrasenia); 
		
		// Con este if le indicamos al usuario si las credenciales que ha facilitado son correctas o no 
		if (organizador == null) {
			System.out.println("Credenciales incorrectas");
		} 
		
		return organizador; 
	}

	// Desarrollamos el método registrarOrganizador
	@Override
	public void registrarOrganizador() {
		// Recogemos en variables que necesitamos para registrar a un organizador
		System.out.println("Introduce nombre:");
		String nombre = sc.nextLine(); 
		
		System.out.println("Introduce correo electrónico:");
		String correo = sc.nextLine(); 
		
		System.out.println("Cree una contraseña:");
		String contrasenia = sc.nextLine(); 
		
		System.out.println("Introduzca su número de teléfono:");
		String telefono = sc.nextLine(); 
		
		// Instanciamos un organizador al que le pasamos las variables anteriores
		Organizador organizador = new Organizador (nombre, correo, contrasenia, telefono); 
		
		boolean correcto = organizadorDao.registrar(organizador); 
		
		// Comprobamos con este if si el organizador que estamos registrando existe o no 
		if (correcto) {
			System.out.println("Organizador registrado");
		} else {
			System.out.println("El organizador ya existe");
		}
		
	}
	
}
