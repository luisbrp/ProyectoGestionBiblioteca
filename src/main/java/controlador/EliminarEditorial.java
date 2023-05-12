package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Editorial;
import modelo.Libro;
import modelo.ModeloEditorial;
import modelo.ModeloLibro;

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
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloEditorial modeloEditorial = new ModeloEditorial();
	
		
		int id_editorial = Integer.parseInt(request.getParameter("id_editorial"));
	
			
	
		modeloEditorial.conectar();
		modeloEditorial.eliminarEditorial(id_editorial);

		modeloEditorial.cerrar();
	
		

			request.getRequestDispatcher("OpcionesDeAdministrador").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
