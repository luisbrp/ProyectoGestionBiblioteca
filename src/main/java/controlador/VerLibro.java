package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Libro;
import modelo.ModeloLibro;

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
		ModeloLibro modeloLibro = new ModeloLibro();
		Libro libro = new Libro();
		
		modeloLibro.conectar();
		int id_libro = Integer.parseInt(request.getParameter("id_libro"));
		libro = modeloLibro.getLibro(id_libro);
		modeloLibro.cerrar();
		
		request.setAttribute("libro", libro);
		
		request.getRequestDispatcher("VerLibro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
