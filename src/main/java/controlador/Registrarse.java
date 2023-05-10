package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.ModeloUsuario;
import modelo.Usuario;

/**
 * Servlet implementation class Registrarse
 */
@WebServlet("/Registrarse")
public class Registrarse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrarse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/JSPFinal/Registrarse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloUsuario ModeloUsuario = new ModeloUsuario();
		Usuario usuario = new Usuario();
		
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String direccion = request.getParameter("direccion");
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		modeloUsuario.conectar();
		usuarios = modeloUsuario.getUsuarios();
		modeloUsuario.cerrar();
		
		boolean dniExistente = false;

		for (Usuario u : usuarios) {
		    if (u.getDni().equals(dni)) {
		        dniExistente = true;
		        break;
		    }
		}
		
		if(!dniExistente) {
		ModeloUsuario.conectar();
		usuario.setDni(dni);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setDireccion(direccion);
		usuario.setTelefono(telefono);
		usuario.setEmail(email);
		usuario.setContraseña(password);

	
		ModeloUsuario.registroDeUsuario(usuario);
	
		
		ModeloUsuario.cerrar();
		
		
		ModeloUsuario.conectar();
	
		
		String ContraseñaBBDD;
		try {
			ContraseñaBBDD = ModeloUsuario.getContraseña(dni);
		
			if (password.equals(ContraseñaBBDD)) {
		
					
				
				
				Usuario usuariologeado = ModeloUsuario.getUsuarioLogin(dni, password);
				
				
				
				HttpSession session = request.getSession();
				
				session.setAttribute("usuariologeado", usuariologeado);
			
				response.sendRedirect("PaginaPrincipal");
			} else {
				request.getRequestDispatcher("/JSPFinal/Login.jsp").forward(request, response);
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModeloUsuario.cerrar();
		
	
	}else {
		request.setAttribute("mensaje", "Dni Ya registrado");
		request.getRequestDispatcher("/JSPFinal/Registrarse.jsp").forward(request, response);
	}
	} 
}
