package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Autor;
import modelo.CategoriaLibros;
import modelo.Libro;
import modelo.ModeloLibro;
import modelo.ModeloUsuario;
import modelo.Usuario;
import modelo.ModeloLibro.ResultadoBusqueda;

/**
 * Servlet implementation class CuentaUsuario
 */
@WebServlet("/CuentaUsuario")
public class CuentaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuentaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession();
		
		Usuario usuariologueado = (Usuario) session.getAttribute("usuariologeado");
		
		if (usuariologueado == null) {//no logeado
			response.sendRedirect("Login");
		} else {
		
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		Usuario usuario = new Usuario();
		
		modeloUsuario.conectar();
		
		int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
		
		usuario = modeloUsuario.getUsuario(id_usuario);
		request.setAttribute("usuario", usuario);
		modeloUsuario.cerrar();
		
		
		/*Cargar las categorias para el header*/
		ModeloLibro modeloLibro = new ModeloLibro();
		modeloLibro.conectar();
		
		ArrayList<CategoriaLibros> Todascategorias= modeloLibro.TodasLasCategorias();
      
        request.setAttribute("Todascategorias", Todascategorias);
        modeloLibro.cerrar();
        
		request.getRequestDispatcher("/JSPFinal/CuentaUsuario.jsp").forward(request, response);
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		Usuario usuario = new Usuario();
		
		int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String direccion = request.getParameter("direccion");
		String contraseña = request.getParameter("contraseña");
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		String email = request.getParameter("email");
		String rol = request.getParameter("rol");
		
		usuario.setId_usuario(id_usuario);
		usuario.setDni(dni);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setDireccion(direccion);
		usuario.setContraseña(contraseña);
		usuario.setTelefono(telefono);
		usuario.setEmail(email);
		usuario.setRol(rol);
		
		
		modeloUsuario.conectar();
		modeloUsuario.modificarUsuario(id_usuario, usuario);
		modeloUsuario.cerrar();
		
		/*Busqueda*/
		
		 String nombreBusqueda = request.getParameter("nombreBusqueda");
		    
		    ModeloLibro modeloLibro = new ModeloLibro();
		    modeloLibro.conectar();
		    ResultadoBusqueda resultado = modeloLibro.BuscarTituloLibroNombreAutor(nombreBusqueda);
		    ArrayList<Libro> librosRelacionados = resultado.getLibrosRelacionados();
		    ArrayList<Autor> autoresRelacionados = resultado.getAutoresRelacionados();
		   
		    modeloLibro.cerrar();
			    
		    request.setAttribute("librosRelacionados", librosRelacionados);
		    request.setAttribute("autoresRelacionados", autoresRelacionados);
		   
		 
		    response.sendRedirect(request.getContextPath() + "/Busqueda?nombreBusqueda=" + nombreBusqueda);
		    
		response.sendRedirect("PaginaPrincipal");
	}

}
