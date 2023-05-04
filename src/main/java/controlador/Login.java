package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.ModeloUsuario;
import modelo.Usuario;

/**
 * Servlet implementation class Login
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
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/JSPFinal/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Dni;
		String contraseña;
		String ContraseñaBBDD;
		
		Dni = request.getParameter("Dni");
		contraseña = request.getParameter("password");
		ModeloUsuario ModeloUsuario = new ModeloUsuario();
		
		ModeloUsuario.conectar();
		

			try {
				ContraseñaBBDD = ModeloUsuario.getContraseña(Dni);
			
				if (contraseña.equals(ContraseñaBBDD)) {
			
						
					
					
					Usuario usuariologeado = ModeloUsuario.getUsuarioLogin(Dni,contraseña);
					
					
					
					HttpSession session = request.getSession();
					
					session.setAttribute("usuariologeado", usuariologeado);
					String rol = "Cliente";
					response.sendRedirect("PaginaPrincipal");
				} else {
					request.getRequestDispatcher("/JSPFinal/Login.jsp").forward(request, response);
					
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ModeloUsuario.cerrar();
		

	
  }
}
