package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.ModeloUsuario;
import modelo.Usuario;

/**
 * Servlet Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		request.getRequestDispatcher("/JSPFinal/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Dni;
		String contrasena;
		String ContrasenaBBDD;
		
		Dni = request.getParameter("Dni");
		contrasena = request.getParameter("password");
		ModeloUsuario ModeloUsuario = new ModeloUsuario();
		
		ModeloUsuario.conectar();
		

			try {
				ContrasenaBBDD = ModeloUsuario.getContrasena(Dni);
			
				if (contrasena.equals(ContrasenaBBDD)) {
			
						
					
					
					Usuario usuariologeado = ModeloUsuario.getUsuarioLogin(Dni,contrasena);
					
					
					
					HttpSession session = request.getSession();
					
					session.setAttribute("usuariologeado", usuariologeado);
					String rol = "Cliente";
					response.sendRedirect("PaginaPrincipal");
				} else {
					
					request.setAttribute("mensaje", "Login Incorrecto, Verifica todos los campos.");
					request.getRequestDispatcher("/JSPFinal/Login.jsp").forward(request, response);
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ModeloUsuario.cerrar();
		

	
  }
}
