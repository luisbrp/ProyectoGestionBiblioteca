package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Libro_Info;
import modelo.ModeloLibro_Info;

/**
 * Servlet Ver Libro_Info
 */
@WebServlet("/VerLibro_Info")
public class VerLibro_Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerLibro_Info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloLibro_Info modeloLibro_Info = new ModeloLibro_Info();
		int id_autor = Integer.parseInt(request.getParameter("id_autor"));
		int id_libro = Integer.parseInt(request.getParameter("id_libro"));
		modeloLibro_Info.conectar();
		Libro_Info libro_Info = modeloLibro_Info.getLibro_Info(id_libro, id_autor);
		modeloLibro_Info.cerrar();
		request.setAttribute("libro_Info", libro_Info);
		request.getRequestDispatcher("VerLibro_Info.jsp").forward(request, response);

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
