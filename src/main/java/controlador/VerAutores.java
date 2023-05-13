package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Autor;
import modelo.CategoriaLibros;
import modelo.Libro;
import modelo.ModeloAutor;
import modelo.ModeloLibro;
import modelo.Usuario;
import modelo.ModeloLibro.ResultadoBusqueda;

/**
 * Servlet  Ver todos los Autores
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Usuario usuariologueado = (Usuario) session.getAttribute("usuariologeado");
		
		if (usuariologueado == null) {//no logeado
			response.sendRedirect("Login");
		} else {
		
		ModeloAutor ModeloAutor = new ModeloAutor();
		ArrayList<Autor> autores = new ArrayList<Autor>();
		
		ModeloAutor.conectar();
		
		autores = ModeloAutor.getAutores();
		ModeloAutor.cerrar();
		
		request.setAttribute("autores", autores);
		
		/*Cargar las categorias para el header*/
		ModeloLibro modeloLibro = new ModeloLibro();
		modeloLibro.conectar();
		
		ArrayList<CategoriaLibros> Todascategorias= modeloLibro.TodasLasCategorias();
      
        request.setAttribute("Todascategorias", Todascategorias);
        modeloLibro.cerrar();
		
		request.getRequestDispatcher("/JSPFinal/VerAutores.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Busqueda*/
		
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
