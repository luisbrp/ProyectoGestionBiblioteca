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
import modelo.ModeloLibro;
import modelo.Usuario;
import modelo.ModeloLibro.ResultadoBusqueda;

/**
 * Servlet implementation class Busqueda
 */
@WebServlet("/Busqueda")
public class Busqueda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Busqueda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession();
		
		Usuario usuariologueado = (Usuario) session.getAttribute("usuariologeado");
		
		if (usuariologueado == null) {//no logeado
			response.sendRedirect("Login");
		} else {
		
		/*busqueda*/
		ModeloLibro modeloLibro = new ModeloLibro();
		
        String nombreBusqueda = request.getParameter("nombreBusqueda");
        
        modeloLibro.conectar();
		
		ArrayList<CategoriaLibros> Todascategorias= modeloLibro.TodasLasCategorias();
      
        request.setAttribute("Todascategorias", Todascategorias);
        modeloLibro.cerrar();
        
        modeloLibro.conectar();
        ResultadoBusqueda resultado = modeloLibro.BuscarTituloLibroNombreAutor(nombreBusqueda);
        ArrayList<Libro> librosRelacionados = resultado.getLibrosRelacionados();
        ArrayList<Autor> autoresRelacionados = resultado.getAutoresRelacionados();
        modeloLibro.cerrar();
    	    
        // pasar los resultados de la búsqueda como atributos al request
        request.setAttribute("librosRelacionados", librosRelacionados);
        request.setAttribute("autoresRelacionados", autoresRelacionados);
        
        request.getRequestDispatcher("/JSPFinal/Busqueda.jsp").forward(request, response);
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
