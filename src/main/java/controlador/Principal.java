package controlador;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Libro;
import modelo.CategoriaLibros;
import modelo.ModeloLibro;

/**
 * Servlet Principal
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
        ModeloLibro modeloLibro = new ModeloLibro();
        modeloLibro.conectar();

        ArrayList<CategoriaLibros> categoriasLibros = modeloLibro.categoriasRecomendadas();
        request.setAttribute("categoriasLibros", categoriasLibros);

        String categoriaSeleccionada = request.getParameter("categoriaSeleccionada");
        if (categoriaSeleccionada != null && !categoriaSeleccionada.isEmpty()) {
            ArrayList<Libro> librosPorCategoria = modeloLibro.buscarPorCategoria(categoriaSeleccionada);
            request.setAttribute("librosPorCategoria", librosPorCategoria);
            request.getRequestDispatcher("librosPorCategoria.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }

        modeloLibro.cerrar();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ModeloLibro modeloLibro = new ModeloLibro();
			
			ArrayList<Libro> librosEncontrados = new ArrayList<Libro>();
		    ArrayList<Libro> librosPorCategoria = new ArrayList<Libro>(); 
		    

			String busqueda = request.getParameter("busqueda");
		    String categoriaSeleccionada = request.getParameter("categoriaSeleccionada");
		   
		
		       
		        if (categoriaSeleccionada.equals("Fantasia")) {
		        	librosPorCategoria = modeloLibro.buscarPorCategoria(categoriaSeleccionada);
		        } else if (categoriaSeleccionada.equals("Ciencia Ficcion")) {
		        	librosPorCategoria = modeloLibro.buscarPorCategoria(categoriaSeleccionada);
		        } else if (categoriaSeleccionada.equals("Romance")) {
		        	librosPorCategoria = modeloLibro.buscarPorCategoria(categoriaSeleccionada);
		        } else if (categoriaSeleccionada.equals("Misterio")) {
		        	librosPorCategoria = modeloLibro.buscarPorCategoria(categoriaSeleccionada);
		        } else if (categoriaSeleccionada.equals("Aventura")) {
		        	librosPorCategoria = modeloLibro.buscarPorCategoria(categoriaSeleccionada);
		        } else if (categoriaSeleccionada.equals("Erotismo")) {
		        	librosPorCategoria = modeloLibro.buscarPorCategoria(categoriaSeleccionada);
		        } else if (categoriaSeleccionada.equals("Biografia")) {
		        	librosPorCategoria = modeloLibro.buscarPorCategoria(categoriaSeleccionada);
		        } else if (categoriaSeleccionada.equals("Autobiografia")) {
		        	librosPorCategoria = modeloLibro.buscarPorCategoria(categoriaSeleccionada);
		        } else if (categoriaSeleccionada.equals("Ensayo")) {
		        	librosPorCategoria = modeloLibro.buscarPorCategoria(categoriaSeleccionada);
		        } else if (categoriaSeleccionada.equals("Poesia")) {
		        	librosPorCategoria = modeloLibro.buscarPorCategoria(categoriaSeleccionada);
		        } else if (categoriaSeleccionada.equals("Drama")) {
		        	librosPorCategoria = modeloLibro.buscarPorCategoria(categoriaSeleccionada);
		        } else if (categoriaSeleccionada.equals("Comedia")) {
		        	librosPorCategoria = modeloLibro.buscarPorCategoria(categoriaSeleccionada);
		        }	
		        modeloLibro.cerrar();
		       	request.setAttribute("librosPorCategoria", librosPorCategoria);
		        request.getRequestDispatcher("librosPorCategoria.jsp").forward(request, response);
		    } 
		    
	}


