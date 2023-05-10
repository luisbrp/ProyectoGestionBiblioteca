package controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Autor;
import modelo.Editorial;
import modelo.Libro;
import modelo.ModeloAutor;
import modelo.ModeloEditorial;
import modelo.ModeloLibro;
import modelo.ModeloPrestamo;
import modelo.ModeloReserva;
import modelo.ModeloUsuario;
import modelo.Prestamo;
import modelo.Reserva;
import modelo.Usuario;

/**
 * Servlet implementation class OpcionesDeAdministrador
 */
@WebServlet("/OpcionesDeAdministrador")
public class OpcionesDeAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpcionesDeAdministrador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Gestionar  Usuarios
		ModeloUsuario modeloUsuario = new ModeloUsuario();		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		modeloUsuario.conectar();
		
		//Verifcar si se debe recargar la lista de Usuarios.
		String recargarUsuarioString = request.getParameter("recargarUsuarios");
		boolean recargarUsuario = (recargarUsuarioString != null && recargarUsuarioString.equals("true"));
		
		if (recargarUsuario) {
			usuarios = modeloUsuario.getUsuarios();
		} else {
			String dni = request.getParameter("dni");
			if(dni != null && !dni .isEmpty()) {
				Usuario usuario = modeloUsuario.getUsuarioPorDni(dni);
				if (usuario != null) {
				usuarios.add(usuario);
			} else {
				
			}	
		} else {
				usuarios = modeloUsuario.getUsuarios();			}
		}
		modeloUsuario.cerrar();
		
		
		//Gestionar libros
		ModeloLibro modeloLibro = new ModeloLibro();
		ArrayList<Libro> libros = new ArrayList<Libro>();
		
		modeloLibro.conectar();
	
		// Verificar si se debe recargar la lista de libros
		String recargarLibrosString = request.getParameter("recargarLibros");
		boolean recargarLibros = (recargarLibrosString != null && recargarLibrosString.equals("true"));

		if (recargarLibros) {
		    libros = modeloLibro.getLibros();
		} else {
		    String isbnString = request.getParameter("isbn");
		    if (isbnString != null && !isbnString.isEmpty()) {
		        Long isbn = Long.parseLong(isbnString);
		        Libro libro = modeloLibro.buscarPorISBN(isbn);
		        if (libro != null) {
		            libros.add(libro);
		        } else {
		           
		        }
		    } else {
		        libros = modeloLibro.getLibros();
		    }
		}
		modeloLibro.cerrar();
		

		//Gestionar Autores
		ModeloAutor modeloAutor = new ModeloAutor();		
		ArrayList<Autor> autores = new ArrayList<Autor>();	
	
		modeloAutor.conectar();
		
		// Verificar si se debe recargar la lista de Autores
		String recargarAutoresString = request.getParameter("recargarAutores");
		boolean recargarAutores = (recargarAutoresString != null && recargarAutoresString.equals("true"));
		
		if (recargarAutores) {
		autores = modeloAutor.getAutores();
		} else {
		    String nombre = request.getParameter("nombre");
		    if (nombre!= null && !nombre.isEmpty()) {
		        Autor autor = modeloAutor.getAutorPorNombre(nombre);
		        if (autor != null) {
		            autores.add(autor);
		        } else {
		           
		        }
		    } else {
		    	autores = modeloAutor.getAutores();
		    }
		}
		modeloAutor.cerrar();
		
		
		//Gestionar Reservas
		ModeloReserva modeloReserva = new ModeloReserva();
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();

		modeloReserva.conectar();

		// Verificar si se debe recargar la lista de Reservas
		 String recargarReservasString = request.getParameter("recargarReservas");
		 boolean recargarReservas = (recargarReservasString != null && recargarReservasString.equals("true"));
		 
		 if (recargarReservas) {
			    reservas = modeloReserva.getReservas();
			    request.setAttribute("hayBusquedaReserva", false);
			} else {
			    String dniReserva = request.getParameter("dniReserva");
			    
			    //comprobar si el dni es no nulo (buscador)
			     if (dniReserva != null && !dniReserva.isEmpty()) {     
			        ArrayList<Reserva> reservasUsuario = modeloReserva.getReservasPorDni(dniReserva);
			        
			      //comprobar si el arraylist de reservasPorDni no esta vacia
			        if (!reservasUsuario.isEmpty()) { 				
			            request.setAttribute("hayBusquedaReserva", true);
			            request.setAttribute("reservasUsuario", reservasUsuario);    
			        } else {
			            request.setAttribute("hayBusquedaReserva", false);
			        }
			    } else {
			        reservas = modeloReserva.getReservas();
			        request.setAttribute("hayBusquedaReserva", false);
			    }
			}	 
		 
		//Gestionar Prestamos
		ModeloPrestamo modeloPrestamo = new ModeloPrestamo();		
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();		
		
		modeloPrestamo.conectar();
		
		// Verificar si se debe recargar la lista de Prestamos
		String recargarPrestamoString = request.getParameter("recargarPrestamos");
		boolean recargarPrestamo = (recargarPrestamoString != null && recargarPrestamoString.equals("true"));
		
		
		if (recargarPrestamo) {
			prestamos = modeloPrestamo.getPrestamos();
			request.setAttribute("hayBusquedaPrestamo", false);
			} else {
				String dniPrestamo = request.getParameter("dniPrestamo");
				
				//comprobar si el dni es no nulo (buscador)
			    if (dniPrestamo != null && !dniPrestamo.isEmpty()) {
			       ArrayList<Prestamo> prestamosUsuario = modeloPrestamo.getPrestamoPorDni(dniPrestamo);
			        
			       //comprobar si el arraylist de prestamosUsuario no esta vacia
			       if (!prestamosUsuario.isEmpty()){
			        	request.setAttribute("hayBusquedaPrestamo", true);
			            request.setAttribute("prestamosUsuario", prestamosUsuario);
			        }
			       	  
			    } else {
			    	prestamos = modeloPrestamo.getPrestamos();
			    	request.setAttribute("HayBusquedaPrestamo", false);
			    }
			}
			modeloPrestamo.cerrar();
		
		
		
		//Gestionar Editoriales
		ModeloEditorial modeloEditorial = new ModeloEditorial();		
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
			
		modeloEditorial.conectar();
		
		//Verificar si se debe recargar la lista de editoriales
		String recargarEditorialString = request.getParameter("recargarEditoriales");
		boolean recargarEditorial = (recargarEditorialString != null && recargarEditorialString.equals("true"));
		
		if (recargarEditorial) {
			editoriales  = modeloEditorial.getEditoriales();
			} else {
			    String nombre = request.getParameter("nombre"); 
			    
			    //comprobar que el nombre de la editorial no sea nulo
			    if (nombre != null && !nombre.isEmpty()) {
			        Editorial editorial = modeloEditorial.getEditorialPorNombre(nombre);
			        
			        //comprobar que la editorial que viene de la bbdd, no sea nulo
			        if (editorial != null) {
			        	editoriales.add(editorial);
			        } else {
			           
			        }
			    } else {
			    	editoriales  = modeloEditorial.getEditoriales();
			    }
			}
		modeloEditorial.cerrar();
			
		request.setAttribute("editoriales", editoriales);
		request.setAttribute("prestamos", prestamos);
		request.setAttribute("reservas", reservas);
		request.setAttribute("autores", autores);
		request.setAttribute("libros", libros);
		request.setAttribute("usuarios", usuarios);
		
		request.getRequestDispatcher("OpcionesDeAdministrador.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
