package servicio;

import java.util.Scanner;

import dominio.Usuario;
import persistencia.UsuarioDao;

public class UsuarioServicio implements IUsuarioServicio{ // Implementamos su interfaz correspondiente
	private final Scanner sc;
	private UsuarioDao usuarioDao;
	
	public UsuarioServicio(Scanner sc) {
		this.sc = sc;
		this.usuarioDao = new UsuarioDao();
	}

	// Desarrollamos el método hacerLogin
	@Override
	public Usuario hacerLogin() {
		// Pedimos los datos que hacen falta y los guardamos en variables
		System.out.println("Por favor, introduce su nombre:");
		String nombre = sc.nextLine(); 
		
		System.out.println("Por favor, introduce la contraseña");
		String contrasenia = sc.nextLine(); 
		
		// Instandiamos un usuario al que le pasamos los datos de las variables anteriores para comprobar si existe o no 
		Usuario usuario = usuarioDao.login(nombre, contrasenia); 
		
		// Si no existe algunos de los datos anteriores se le informa al usuario que las credenciales que ha introducido son incorrectas
		if (usuario == null) {
			System.out.println("Credenciales incorrectas");
		} 
		
		return usuario; 
	}

	// Desarrollamos el método registrarUsuario
	@Override
	public void registrarUsuario() {
		// Pedimos los datos que necesitamos para registrar a un usuario nuevo y los vamos guardando en variables
		System.out.println("Introduce nombre:");
		String nombre = sc.nextLine(); 
		
		System.out.println("Introduce correo electrónico:");
		String correo = sc.nextLine(); 
		
		System.out.println("Cree una contraseña:");
		String contrasenia = sc.nextLine(); 
		
		// Instanciamos un usuario al que le pasamos todas las variables anterioes para crearlo
		Usuario usuario = new Usuario (nombre, correo, contrasenia); 
		
		boolean correcto = usuarioDao.registrar(usuario); 
		
		// Con este if comprobamos si el usuario existe o no 
		if (correcto) {
			System.out.println("Usuario registrado");
		} else {
			System.out.println("El usuario ya existe");
		}
		
	}
	
	
}
