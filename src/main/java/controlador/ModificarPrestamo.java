package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloPrestamo;
import modelo.Prestamo;

/**
 * Servlet implementation class ModificarPrestamo
 */
@WebServlet("/ModificarPrestamo")
public class ModificarPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarPrestamo() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat fechaFormato = new SimpleDateFormat("yyyy-MM-dd");
		ModeloPrestamo modeloPrestamo = new ModeloPrestamo();
		Prestamo prestamo = new Prestamo();
		
		String fechaR = request.getParameter("fecha_prestamo");
		int id_libro = Integer.parseInt(request.getParameter("id_libro"));
		int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));

		
		Date fecha;
		try {
			fecha = fechaFormato.parse(fechaR);
			prestamo.setFecha_prestamo(fecha);
			prestamo.setId_libro(id_libro);
			prestamo.setId_usuario(id_usuario);
			
			modeloPrestamo.conectar();
			prestamo = modeloPrestamo.getPrestamo(fecha, id_libro, id_usuario);
			request.setAttribute("prestamo", prestamo);
			modeloPrestamo.cerrar();
			request.getRequestDispatcher("ModificarPrestamo.jsp").forward(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
			
			
			
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat fechaFormato = new SimpleDateFormat("yyyy-MM-dd");
		Prestamo prestamo = new Prestamo();
		ModeloPrestamo modeloPrestamo = new ModeloPrestamo();
		
		String fechaP = request.getParameter("fecha_prestamo");
		int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
		int id_libro = Integer.parseInt(request.getParameter("id_libro"));
		String devuelto = request.getParameter("devuelto");
		
		String fechaPVieja = request.getParameter("fecha");
        int id_usuario_viejo = Integer.parseInt(request.getParameter("id_usuario_viejo"));
        int id_libro_viejo = Integer.parseInt(request.getParameter("id_libro_viejo"));
		
		try {
			 Date fechaVieja = new java.sql.Date(fechaFormato.parse(fechaPVieja).getTime());
	         Date fechaNueva = new java.sql.Date(fechaFormato.parse(fechaP).getTime());
		prestamo.setFecha_prestamo(fechaNueva);
		prestamo.setId_usuario(id_usuario);
		prestamo.setId_libro(id_libro);
		prestamo.setDevuelto(devuelto);
		modeloPrestamo.conectar();
		modeloPrestamo.modificarPrestamo(fechaVieja, id_libro_viejo, id_usuario_viejo, prestamo);
		modeloPrestamo.cerrar();
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
	}

}
