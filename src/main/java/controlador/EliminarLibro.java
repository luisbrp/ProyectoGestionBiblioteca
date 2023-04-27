package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Libro;
import modelo.ModeloLibro;

/**
 * Servlet implementation class EliminarLibro
 */
@WebServlet("/EliminarLibro")
public class EliminarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarLibro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloLibro modeloLibro = new ModeloLibro();
		
		ArrayList<Libro> libros = new ArrayList<Libro>();
		
		int id_libro = Integer.parseInt(request.getParameter("id_libro"));
		modeloLibro.conectar();
		modeloLibro.eliminarLibro(id_libro);
		libros = modeloLibro.getLibros();
		modeloLibro.cerrar();
	
		
		request.setAttribute("libros", libros);
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
