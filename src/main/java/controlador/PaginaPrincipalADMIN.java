package controlador;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.CategoriaLibros;
import modelo.Libro;
import modelo.ModeloLibro;
import modelo.ModeloUsuario;
import modelo.Usuario;

/**
 * Servlet implementation class PaginaPrincipalADMIN
 */
@WebServlet("/PaginaPrincipalADMIN")
public class PaginaPrincipalADMIN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaginaPrincipalADMIN() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				HttpSession session = request.getSession();
				
				Usuario usuariologueado = (Usuario) session.getAttribute("usuariologeado");
				
				if (usuariologueado == null) {//no logeado
					response.sendRedirect("Login");
				} else {
					ModeloLibro modeloLibro = new ModeloLibro();
			        modeloLibro.conectar();

			        ArrayList<CategoriaLibros> categoriasLibros = modeloLibro.categoriasRecomendadas();
			        request.setAttribute("categoriasLibros", categoriasLibros);

			        String categoriaSeleccionada = request.getParameter("categoriaSeleccionada");
			        if (categoriaSeleccionada != null && !categoriaSeleccionada.isEmpty()) {
			            ArrayList<Libro> librosPorCategoria = modeloLibro.buscarPorCategoria(categoriaSeleccionada);
			            request.setAttribute("librosPorCategoria", librosPorCategoria);
			            request.getRequestDispatcher("librosPorCategoria.jsp").forward(request, response);
			        } else {
			            request.getRequestDispatcher("/JSPFinal/VistaADMIN/PaginaPrincipalAdmin.jsp").forward(request, response);
			        }

			        modeloLibro.cerrar();
			    	request.getRequestDispatcher("/JSPFinal/VistaADMIN/PaginaPrincipalAdmin.jsp").forward(request, response);
			    }
				

					
				
				}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
