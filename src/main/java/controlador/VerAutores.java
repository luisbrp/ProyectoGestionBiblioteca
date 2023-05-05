package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Autor;
import modelo.Libro;
import modelo.ModeloAutor;
import modelo.ModeloLibro;

/**
 * Servlet implementation class VerAutores
 */
@WebServlet("/VerAutores")
public class VerAutores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerAutores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloAutor ModeloAutor = new ModeloAutor();
		ArrayList<Autor> autores = new ArrayList<Autor>();
		
		ModeloAutor.conectar();
		
		autores = ModeloAutor.getAutores();
		ModeloAutor.cerrar();
		
		request.setAttribute("autores", autores);
		
		request.getRequestDispatcher("/JSPFinal/VerAutores.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}