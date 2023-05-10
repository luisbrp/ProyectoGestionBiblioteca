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
import modelo.Editorial;

import modelo.ModeloEditorial;

/**
 * Servlet implementation class InsertarEditorial
 */
@WebServlet("/InsertarEditorial")
public class InsertarEditorial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarEditorial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ModeloEditorial modeloEditorial = new ModeloEditorial();
    	modeloEditorial.conectar();
		ArrayList<Editorial> editoriales = modeloEditorial.getEditoriales();
		modeloEditorial.cerrar();
		
		request.setAttribute("editoriales", editoriales);
		request.getRequestDispatcher("InsertarEditorial.jsp").forward(request, response);    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloEditorial modeloEditorial = new ModeloEditorial();
		Editorial editorial = new Editorial();
		HttpSession session = request.getSession();
		Autor autor = (Autor) session.getAttribute("autor");
		Autor autorId = (Autor) session.getAttribute("autorId");
		
		String id_editorialString = request.getParameter("id_editorial");
		String nombre = request.getParameter("nombre");
		
		
		editorial.setNombre(nombre);
	
	
		
		modeloEditorial.conectar();
		if (id_editorialString != null) {
		    int id_editorial = Integer.parseInt(id_editorialString);
		    HttpSession session2 = request.getSession();
		    session2.setAttribute("id_editorial", id_editorial);
		    session.setAttribute("autorId", autorId);
		    response.sendRedirect("InsertarLibro");
		} else if (editorial != null) {
		    modeloEditorial.registrarEditorial(editorial);
		    Editorial editorialCompleta = modeloEditorial.getEditorialPorNombre(nombre);
		    HttpSession session2 = request.getSession();
		    session2.setAttribute("editorialCompleta", editorialCompleta);
		    session.setAttribute("autor", autor);
		    response.sendRedirect("InsertarLibro");
		}

		modeloEditorial.cerrar();
	}

}
