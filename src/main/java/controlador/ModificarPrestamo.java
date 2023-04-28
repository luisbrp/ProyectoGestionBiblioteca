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
			modeloPrestamo.getPrestamo(fecha, id_libro, id_usuario);
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
		
		String nueva_fechaP = request.getParameter("nueva_fecha_prestamo");
		int nuevo_id_usuario = Integer.parseInt(request.getParameter("nuevo_id_usuario"));
		int nuevo_id_libro = Integer.parseInt(request.getParameter("nuevo_id_libro"));
		String nuevo_devuelto = request.getParameter("nuevo_devuelto");
		
		try {
		Date fecha = fechaFormato.parse(fechaP);
		Date nuevaFecha = fechaFormato.parse(nueva_fechaP);
		prestamo.setFecha_prestamo(nuevaFecha);
		prestamo.setId_usuario(nuevo_id_usuario);
		prestamo.setId_libro(nuevo_id_libro);
		prestamo.setDevuelto(nuevo_devuelto);
		modeloPrestamo.conectar();
		modeloPrestamo.modificarPrestamo(fecha, id_libro, id_usuario, prestamo, devuelto);
		modeloPrestamo.cerrar();
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
	}

}
