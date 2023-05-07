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
import modelo.ModeloUsuario;
import modelo.Usuario;

/**
 * Servlet implementation class VerAutor
 */
@WebServlet("/VerAutor")
public class VerAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerAutor() {
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
			
		
		ModeloAutor modeloAutor = new ModeloAutor();
		Autor autor = new Autor();
		
		modeloAutor.conectar();
		int id_autor = Integer.parseInt(request.getParameter("id_autor").trim());
		autor = modeloAutor.getAutor(id_autor);
		
		ModeloLibro modeloLibro = new ModeloLibro();
		modeloLibro.conectar();
		ArrayList<Libro> librosDelAutor = new ArrayList<Libro>();
		librosDelAutor = modeloLibro.getLibrosPorNombreAutor(autor.getNombre());
		modeloLibro.cerrar();
		modeloAutor.cerrar();
		
		request.setAttribute("librosDelAutor", librosDelAutor);
		request.setAttribute("autor", autor);
		
		request.getRequestDispatcher("/JSPFinal/VerAutor.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
