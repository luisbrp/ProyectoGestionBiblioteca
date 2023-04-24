package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Autor;
import modelo.ModeloAutor;
import modelo.ModeloUsuario;
import modelo.Usuario;

/**
 * Servlet implementation class ModificarAutor
 */
@WebServlet("/ModificarAutor")
public class ModificarAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarAutor() {
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
		int id_autor = Integer.parseInt(request.getParameter("id_autor"));
		autor = modeloAutor.getAutor(id_autor);
		modeloAutor.cerrar();
		
		request.setAttribute("autor", autor);
		
		request.getRequestDispatcher("ModificarAutor.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloAutor modeloAutor = new ModeloAutor();
		Autor autor = new Autor();
		
		int id_autor = Integer.parseInt(request.getParameter("id_autor"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String descripcion = request.getParameter("descripcion");
		
		autor.setNombre(nombre);
		autor.setApellido(apellido);
		autor.setDescripcion(descripcion);
		
		modeloAutor.conectar();
		modeloAutor.modificarAutor(id_autor, autor);
		modeloAutor.cerrar();
	}

}
