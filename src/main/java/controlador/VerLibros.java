package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.CategoriaLibros;
import modelo.ModeloLibro;

/**
 * Servlet implementation class VerLibros
 */
@WebServlet("/VerLibros")
public class VerLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerLibros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ModeloLibro modeloLibro = new ModeloLibro();
		
		modeloLibro.conectar();
		ArrayList<CategoriaLibros> categoriasLibros = modeloLibro.LibrosPorCategoria();
        request.setAttribute("categoriasLibros", categoriasLibros);
    	modeloLibro.cerrar();
		request.getRequestDispatcher("/JSPFinal/VerLibros.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
