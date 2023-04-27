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
		//Ver Usuarios
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		modeloUsuario.conectar();
		usuarios = modeloUsuario.getUsuarios();
		modeloUsuario.cerrar();
		
		//Ver Libros
		ModeloLibro modeloLibro = new ModeloLibro();
		
		ArrayList<Libro> libros = new ArrayList<Libro>();
		
		modeloLibro.conectar();
		libros = modeloLibro.getLibros();
		modeloLibro.cerrar();
	
		//Ver Autores
		ModeloAutor modeloAutor = new ModeloAutor();
		
		ArrayList<Autor> autores = new ArrayList<Autor>();
		
		modeloAutor.conectar();
		autores = modeloAutor.getAutores();
		modeloAutor.cerrar();
		
		//Ver Reservas
		ModeloReserva modeloReserva = new ModeloReserva();
		
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		
		modeloReserva.conectar();
		reservas = modeloReserva.getReservas();
		modeloReserva.cerrar();
	
		//Ver Prestamos
		ModeloPrestamo modeloPrestamo = new ModeloPrestamo();
		
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		
		modeloPrestamo.conectar();
		prestamos = modeloPrestamo.getPrestamos();
		modeloPrestamo.cerrar();
	
		//Ver Editoriales
		ModeloEditorial modeloEditorial = new ModeloEditorial();
		
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		
		modeloEditorial.conectar();
		editoriales = modeloEditorial.getEditoriales();
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
