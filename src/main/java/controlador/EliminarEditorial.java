package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Editorial;
import modelo.ModeloEditorial;

/**
 * Servlet implementation class EliminarEditorial
 */
@WebServlet("/EliminarEditorial")
public class EliminarEditorial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarEditorial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloEditorial modeloEditorial = new ModeloEditorial();
		
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		int id_editorial = Integer.parseInt(request.getParameter("id_editorial"));
		
		modeloEditorial.conectar();
		modeloEditorial.eliminarEditorial(id_editorial);
		editoriales = modeloEditorial.getEditoriales();
		modeloEditorial.cerrar();
	
		request.setAttribute("editoriales", editoriales);
		request.getRequestDispatcher("Editoriales.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
