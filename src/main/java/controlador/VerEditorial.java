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
 * Servlet implementation class VerEditorial
 */
@WebServlet("/VerEditorial")
public class VerEditorial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerEditorial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloEditorial modeloEditorial = new ModeloEditorial();
		Editorial editorial = new Editorial();
		
		modeloEditorial.conectar();
		
		int id_editorial = Integer.parseInt(request.getParameter("id_editorial"));
		System.out.println(id_editorial);
		modeloEditorial.getEditorial(id_editorial);
		modeloEditorial.cerrar();
	
		request.setAttribute("editorial", editorial);
		request.getRequestDispatcher("VerEditorial.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
