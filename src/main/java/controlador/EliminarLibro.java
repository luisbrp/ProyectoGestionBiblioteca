package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Libro;
import modelo.ModeloAutor;
import modelo.ModeloLibro;
import modelo.ModeloLibro_Info;

/**
 * Servlet implementation class EliminarLibro
 */
@WebServlet("/EliminarLibro")
public class EliminarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarLibro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloLibro modeloLibro = new ModeloLibro();
		ModeloLibro_Info modeloLibroInfo = new ModeloLibro_Info();
		
		
		int id_libro1 = Integer.parseInt(request.getParameter("id_libro"));
		int id_libro2 = id_libro1;
		modeloLibroInfo.conectar();
		int id_autor = modeloLibroInfo.getIdAutor(id_libro2);
		modeloLibroInfo.EliminarLibro_Info(id_libro2, id_autor);
		modeloLibroInfo.cerrar();
		
		modeloLibro.conectar();
		modeloLibro.eliminarLibro(id_libro1);
		modeloLibro.cerrar();
	
		response.sendRedirect("OpcionesDeAdministrador");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
