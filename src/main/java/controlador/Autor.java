package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Libro;
import modelo.ModeloAutor;
import modelo.ModeloLibro;

/**
 * Servlet implementation class Autor
 */
@WebServlet("/Autor")
public class Autor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloAutor modeloAutor = new ModeloAutor();
		Autor autor = new Autor();
		
		modeloAutor.conectar();
		String nombre = request.getParameter("nombre");
		modeloAutor.getAutorPorNombre(nombre);
		modeloAutor.cerrar();
		
		
		ModeloLibro modeloLibro = new ModeloLibro();
		
		ArrayList<Libro> librosDelAutor = new ArrayList<Libro>();
		
		modeloLibro.conectar();
		librosDelAutor = modeloLibro.getLibrosPorNombreAutor(nombre);
		modeloLibro.cerrar();
	
		
		request.setAttribute("autor", autor);
		request.setAttribute("librosDelAutor ", librosDelAutor);
		
		request.getRequestDispatcher("Autor.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
