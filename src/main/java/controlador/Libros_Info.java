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
 * Servlet implementation class Libros_Info
 */
@WebServlet("/Libros_Info")
public class Libros_Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Libros_Info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloLibro_Info modeloLibro_Info = new ModeloLibro_Info();
		
		ArrayList<Libro_Info> libros_Info = new ArrayList<Libro_Info>();
		
		modeloLibro_Info.conectar();
		libros_Info = modeloLibro_Info.getLibros_Info();
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
