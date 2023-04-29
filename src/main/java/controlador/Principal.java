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
 * Servlet implementation class Principal
 */
@WebServlet("/Principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Principal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		    request.getRequestDispatcher("Principal.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloLibro modeloLibro = new ModeloLibro();
	    ArrayList<Libro> librosEncontrados = new ArrayList<Libro>();
	    
	    String busqueda = request.getParameter("busqueda");
	    
	    modeloLibro.conectar();
	    librosEncontrados = modeloLibro.buscarLibro(busqueda);
	    modeloLibro.cerrar();
	    
	    request.setAttribute("librosEncontrados", librosEncontrados);
	    request.getRequestDispatcher("ResultadoDeBusqueda.jsp").forward(request, response);
	}

}
