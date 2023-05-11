package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Autor;
import modelo.ModeloAutor;
import modelo.ModeloLibro_Info;
import modelo.ModeloUsuario;
import modelo.Usuario;

/**
 * Servlet implementation class EliminarAutor
 */
@WebServlet("/EliminarAutor")
public class EliminarAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarAutor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloAutor modeloAutor = new ModeloAutor();
		ModeloLibro_Info modeloLibroInfo = new ModeloLibro_Info();
		
		int id_autor1 = Integer.parseInt(request.getParameter("id_autor"));
		int id_autor2 = id_autor1;
		
		modeloLibroInfo.conectar();
		int id_libro = modeloLibroInfo.getIdLibro(id_autor2);
		modeloLibroInfo.EliminarLibro_Info(id_libro, id_autor2);
		modeloLibroInfo.cerrar();
		
		modeloAutor.conectar();
		modeloAutor.eliminarAutor(id_autor1);
		modeloAutor.cerrar();
		
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
