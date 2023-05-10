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
 * Servlet implementation class VerLibro
 */
@WebServlet("/VerLibro")
public class VerLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerLibro() {
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
		
		
		ModeloLibro modeloLibro = new ModeloLibro();
		Libro libro = new Libro();
		
		modeloLibro.conectar();
		int id_libro = Integer.parseInt(request.getParameter("id_libro"));
		libro = modeloLibro.getLibro(id_libro);
		
		ModeloAutor modeloAutor = new ModeloAutor();
		modeloAutor.conectar();
		ArrayList<Autor> AutoresdelLibro = new ArrayList<Autor>();
		
		AutoresdelLibro = modeloAutor.getAutoresDeLibro(libro.getId_libro());
		modeloAutor.cerrar();
		modeloLibro.cerrar();
		
		request.setAttribute("AutoresdelLibro", AutoresdelLibro);
		request.setAttribute("libro", libro);
		
		/*Cargar las categorias para el header*/

		modeloLibro.conectar();
		
		ArrayList<CategoriaLibros> Todascategorias= modeloLibro.TodasLasCategorias();
      
        request.setAttribute("Todascategorias", Todascategorias);
        modeloLibro.cerrar();
		request.getRequestDispatcher("/JSPFinal/VerLibro.jsp").forward(request, response);
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
