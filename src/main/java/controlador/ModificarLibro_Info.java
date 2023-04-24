package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Libro_Info;
import modelo.ModeloLibro_Info;

/**
 * Servlet implementation class ModificarLibro_Info
 */
@WebServlet("/ModificarLibro_Info")
public class ModificarLibro_Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarLibro_Info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloLibro_Info modeloLibro_Info = new ModeloLibro_Info();
		
		Libro_Info libro_Info = new Libro_Info();
		
		ArrayList<Libro_Info> libros_Info = new ArrayList<Libro_Info>();
		
		int id_autor = Integer.parseInt(request.getParameter("id_autor"));
		int id_libro = Integer.parseInt(request.getParameter("id_libro"));
		
		
		modeloLibro_Info.conectar();
		libro_Info  = modeloLibro_Info.getLibro_Info(id_libro, id_autor, libro_Info);
		modeloLibro_Info.cerrar();
		
		request.setAttribute("libro_Info", libro_Info);
		
		request.getRequestDispatcher("ModificarLibro_Info.jsp").forward(request, response);
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
		modeloLibro_Info.modificarLibro_Info(id_libro, id_autor);
		modeloLibro_Info.cerrar();
	}

}
