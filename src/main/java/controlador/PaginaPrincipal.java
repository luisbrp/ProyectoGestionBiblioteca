package controlador;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.CategoriaLibros;
import modelo.Libro;
import modelo.ModeloAutor;
import modelo.ModeloLibro;
import modelo.ModeloLibro.ResultadoBusqueda;
import modelo.Usuario;
import modelo.Autor;

/**
 * Servlet  PaginaPrincipal
 */
@WebServlet("/PaginaPrincipal")
public class PaginaPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaginaPrincipal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Usuario usuariologueado = (Usuario) session.getAttribute("usuariologeado");
		
		if (usuariologueado == null) {//no logeado
			response.sendRedirect("Login");
		} else {
			/*CARGAR LOS LIBROS POR CATEGORIA*/
			ModeloLibro modeloLibro = new ModeloLibro();
			
			modeloLibro.conectar();
			ArrayList<CategoriaLibros> categoriasLibros = modeloLibro.categoriasRecomendadas();
			ArrayList<CategoriaLibros> Todascategorias= modeloLibro.TodasLasCategorias();
	        request.setAttribute("categoriasLibros", categoriasLibros);
	        request.setAttribute("Todascategorias", Todascategorias);
	        modeloLibro.cerrar();
	        
			request.getRequestDispatcher("/JSPFinal/PaginaPrincipal.jsp").forward(request, response);
		}
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String nombreBusqueda = request.getParameter("nombreBusqueda");
	    
	    ModeloLibro modeloLibro = new ModeloLibro();
	    modeloLibro.conectar();
	    ResultadoBusqueda resultado = modeloLibro.BuscarTituloLibroNombreAutor(nombreBusqueda);
	    ArrayList<Libro> librosRelacionados = resultado.getLibrosRelacionados();
	    ArrayList<Autor> autoresRelacionados = resultado.getAutoresRelacionados();
	   
	    modeloLibro.cerrar();
		    
	    request.setAttribute("librosRelacionados", librosRelacionados);
	    request.setAttribute("autoresRelacionados", autoresRelacionados);
	   
	 
	    response.sendRedirect(request.getContextPath() + "/Busqueda?nombreBusqueda=" + nombreBusqueda);
	
		   
	}

}
