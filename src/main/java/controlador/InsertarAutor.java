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
import modelo.ModeloAutor;

/**
 * Servlet Inserta un Autor
 */
@WebServlet("/InsertarAutor")
public class InsertarAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarAutor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloAutor modeloAutor = new ModeloAutor();

		modeloAutor.conectar();
		ArrayList<Autor> autores = modeloAutor.getAutores();
		modeloAutor.cerrar();
		
		request.setAttribute("autores", autores);
		
		request.getRequestDispatcher("InsertarAutor.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloAutor modeloAutor = new ModeloAutor();
		Autor autor = new Autor();
		
		String id_autorString = request.getParameter("id_autor");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String descripcion = request.getParameter("descripcion");
		
		autor.setNombre(nombre);
		autor.setApellido(apellido);
		autor.setDescripcion(descripcion);
		
		modeloAutor.conectar();
		if (id_autorString != null) {
		    int id_autor = Integer.parseInt(id_autorString);
		    Autor autorSoloConId = new Autor();
		    autorSoloConId.setId_autor(id_autor);
		    HttpSession session = request.getSession();
		    session.setAttribute("autorSoloConId", autorSoloConId);
		    response.sendRedirect("InsertarEditorial");
		} else if (autor != null) {
		    modeloAutor.registrarAutor(autor);
		    HttpSession session = request.getSession();
		    session.setAttribute("autor", autor);
		    response.sendRedirect("InsertarEditorial");
		} 
		modeloAutor.cerrar();
	}

}
