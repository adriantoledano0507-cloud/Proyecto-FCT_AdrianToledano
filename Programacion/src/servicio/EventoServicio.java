package servicio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import dominio.Categoria;
import dominio.Evento;
import dominio.Organizador;
import dominio.Usuario;
import persistencia.CategoriaDao;
import persistencia.EventoDao;

public class EventoServicio implements IEventoServicio{ // Implementamos la interfaz correspondiente y desarrollamos sus métodos
	private final Scanner sc;
	private EventoDao eventoDao;
	private CategoriaDao categoriaDao;
	
	public EventoServicio(Scanner sc) {
		this.sc = sc;
		this.eventoDao = new EventoDao();
		this.categoriaDao = new CategoriaDao();
	}
	// Desarrollamos el método de mostrarEventos
	@Override
	public void mostrarEventos() {
		// Con un bucle for los mostramos 
		for (Evento e: eventoDao.obtenerEventos().values()) {
			System.out.println(e);
		}
	}

	// Desarrollamos el método de mostrarEventosUsuario que son los eventos a los que el usuario se ha inscrito 
	@Override
	public void mostrarEventosUsuario(Usuario usuario) {
		// Con el bucle for recorremos todos los eventos 
		for (Evento e: eventoDao.obtenerEventos().values()) {
			// Con el if solo mostramos (filtramos) los que tenga el usuario que le facilitemos, en este caso los del usuario que esté logueado en ese momento
			if (e.getAsistentes().contains(usuario)) {
				System.out.println(e);
			}
		}
	}

	// Desarrollamos el método incribir usuario
	@Override
	public void inscribirUsuario(Usuario usuario) {
		// Pedimos el nombre del evento 
		System.out.println("Introduzca el nombre del evento:");
		String nombre = sc.nextLine(); 
		// Comprobamos si hay algún evento guardado en nuestra lista de eventos
		Evento evento = eventoDao.obtenerEventos().get(nombre); 
		
		// Le indicamos al usuario que si el evento existe el usuario se puede inscribir, y si no se encuentra el evento pues el usuario no se puede inscribir 
		if (evento != null) {
			usuario.inscribirEvento(evento);
		} else {
			System.out.println("No se ha encontrado el evento");
		}
		
	}

	// Desarrollamos el método cancelarInscripcion para que el usuario cancele alguna de sus inscripciones
	@Override
	public void cancelarInscripcion(Usuario usuario) {
		// Pedimos al usuario que introduzca el nombre del evento del que el usuario quiere cancelar su inscripcion
		System.out.println("Introduzca el nombre del evento:");
		String nombre = sc.nextLine(); 
		// Comprobamos si el nombre del evento existe en la lista
		Evento evento = eventoDao.obtenerEventos().get(nombre); 
		// Con este if tomamos la decisión, si el evento es diferente a null se puede cancelar la inscripción, si no se encuentra el evento facilitado por el usuario pues no hay ningún evento del que cancelar 
		if (evento != null) {
			usuario.cancelarInscripcion(evento);
		} else {
			System.out.println("No se ha encontrado el evento");
		}
	}

	// Desarrollamos el métdo mostrarEventosOrganizador
	@Override
	public void mostrarEventosOrganizador(Organizador organizador) {
		// Con este bucle for mostramos los eventos que haya organizado el organizador logueado
		for (Evento e : eventoDao.obtenerEventos().values()) {
			// Con este if comprobamos cuales coinciden con los datos del organizador
			if (e.getOrganizador().equals(organizador)) {
				System.out.println(e);
			}
		}
	}

	// Desarrollamos el método crearEvento que solo es para los Organizadores
	@Override
	public void crearEvento(Organizador organizador) {
		// Pedimos todos los datos del evento guandándolos en variables
		System.out.println("Nombre del evento:");
		String nombre = sc.nextLine();
		
		System.out.println("Descripción del evento:");
		String descripcion = sc.nextLine(); 
		
		System.out.println("Introduzca la fecha del evento en formato (YYYY-MM-DD");
		LocalDate fecha = LocalDate.parse(sc.nextLine()); 
		
		System.out.println("Introduzca la hora del evento en formato (HH:MM)");
		LocalTime hora = LocalTime.parse(sc.nextLine()); 
		
		System.out.println("¿Cuánto dura el evento?");
		int duracion = Integer.parseInt(sc.nextLine()); 
		
		System.out.println("¿Dónde se va a desarrollar el evento?");
		String ubicacion = sc.nextLine(); 
		
		System.out.println("A qué categoría pertece el evento?");
		String nombreCategoria = sc.nextLine(); 
		// Comprobamos que el nombre de la categoría exista en nuestro sistema
		Categoria categoria = categoriaDao.obtenerCategoria(nombreCategoria); 
		
		// Miramos que la categoría esté o no 
		if (categoria == null) {
			System.out.println("No se ha encontrado esta categoría");
		}
		
		// Instanciamos un nuevo evento al que le pasamos todos los datos que hemos recogido en las variables anteriores
		Evento evento = organizador.organizarEvento(nombre, descripcion, fecha, hora, duracion, ubicacion, categoria); 
		
		boolean creado = eventoDao.insertarEvento(evento); 
		// Con este if comprobamos que el evento que vaya a crear no exista otro con el mismo nombre
		if (creado) {
			System.out.println("El evento se ha creado correctamente");
		} else {
			System.out.println("Ya existe un evento con este nombre");
		}
		
		
	}

}
