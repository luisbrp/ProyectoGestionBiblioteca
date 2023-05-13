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
 * Servlet Insertar una Editorial
 */
@WebServlet("/InsertarEditorialNormal")
public class InsertarEditorialNormal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarEditorialNormal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("InsertarEditorialNormal.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloEditorial modeloEditorial = new ModeloEditorial();
		Editorial editorial = new Editorial();
		
		String nombre = request.getParameter("nombre");
		
		
		editorial.setNombre(nombre);
	
		
		modeloEditorial.conectar();
		modeloEditorial.registrarEditorial(editorial);
		modeloEditorial.cerrar();
		response.sendRedirect("OpcionesDeAdministrador");
	}

}
