package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Editorial;
import modelo.ModeloEditorial;

/**
 * Servlet Modificar una Editorial
 */
@WebServlet("/ModificarEditorial")
public class ModificarEditorial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarEditorial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloEditorial modeloEditorial = new ModeloEditorial();
		modeloEditorial.conectar();
		
		int id_editorial = Integer.parseInt(request.getParameter("id_editorial"));
		Editorial editorial = modeloEditorial.getEditorial(id_editorial);
		
		modeloEditorial.cerrar();
		
		request.setAttribute("editorial", editorial);
		request.getRequestDispatcher("ModificarEditorial.jsp").forward(request, response);;
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloEditorial modeloEditorial = new ModeloEditorial();
		Editorial editorial = new Editorial();
		
		int id_editorial = Integer.parseInt(request.getParameter("id_editorial"));
		String nombre = request.getParameter("nombre");
		
		
		editorial.setNombre(nombre);
		
	
		
		modeloEditorial.conectar();
		modeloEditorial.modificarEditorial(id_editorial, editorial);
		modeloEditorial.cerrar();
	}
	

}
