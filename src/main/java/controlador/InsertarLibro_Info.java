
package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Editorial;
import modelo.Libro_Info;
import modelo.ModeloEditorial;
import modelo.ModeloLibro_Info;

/**
 * Servlet implementation class InsertarLibro_Info
 */
@WebServlet("/InsertarLibro_Info")
public class InsertarLibro_Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarLibro_Info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("InsertarLibro_Info.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloLibro_Info modeloLibro_Info = new ModeloLibro_Info();
		Libro_Info libro_Info = new Libro_Info();
		
		int id_libro = Integer.parseInt(request.getParameter("id_libro"));
		int id_autor = Integer.parseInt(request.getParameter("id_autor"));
		
		
		libro_Info.setId_libro(id_libro);
		libro_Info.setId_autor(id_autor);
	
		
		modeloLibro_Info.conectar();
		modeloLibro_Info.insertarLibro_Info(libro_Info);
		modeloLibro_Info.cerrar();
	}

}
