package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloUsuario;
import modelo.Usuario;

/**
 * Servlet implementation class EliminarUsuario
 */
@WebServlet("/EliminarUsuario")
public class EliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		ModeloUsuario modeloUsuario = new ModeloUsuario();
		modeloUsuario.conectar();
		
		int id_usuario = Integer.parseInt(request.getParameter("id"));
		
		modeloUsuario.eliminarUsuario(id_usuario);
		ArrayList<Usuario> usuarios = modeloUsuario.getUsuarios();
		modeloUsuario.cerrar();
		
		request.setAttribute("usuarios", usuarios);
		
		request.getRequestDispatcher("VerUsuarios.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
