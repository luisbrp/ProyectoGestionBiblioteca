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
		modeloAutor.conectar();
		
		int id_autor = Integer.parseInt(request.getParameter("id_autor"));
		
		modeloAutor.eliminarAutor(id_autor);
		ArrayList<Autor> autores = modeloAutor.getAutores();
		modeloAutor.cerrar();
		
		request.setAttribute("autores", autores);
		
		request.getRequestDispatcher("Autores.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
