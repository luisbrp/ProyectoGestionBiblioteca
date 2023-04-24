package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Autor;
import modelo.Libro_Info;
import modelo.ModeloAutor;
import modelo.ModeloLibro_Info;

/**
 * Servlet implementation class EliminarLibro_Info
 */
@WebServlet("/EliminarLibro_Info")
public class EliminarLibro_Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarLibro_Info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloLibro_Info modeloLibro_Info = new ModeloLibro_Info();
		
		
		ArrayList<Libro_Info> libros_Info = new ArrayList<Libro_Info>();
		
		int id_autor = Integer.parseInt(request.getParameter("id_autor"));
		int id_libro = Integer.parseInt(request.getParameter("id_libro"));
		
		
		modeloLibro_Info.conectar();
		modeloLibro_Info.getLibros_Info();
		modeloLibro_Info.EliminarLibro_Info(id_libro, id_autor);
		modeloLibro_Info.cerrar();
		
		request.setAttribute("libros_Info", libros_Info);
		
		request.getRequestDispatcher("Libros_Info.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
