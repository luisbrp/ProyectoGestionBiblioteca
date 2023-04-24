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
 * Servlet implementation class AnularPrestamo
 */
@WebServlet("/AnularPrestamo")
public class AnularPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnularPrestamo() {
        super();
        // TODO Auto-generated constructor stub
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
		int id_usuario = Integer.parseInt(request.getParameter("id_libro"));
		
		Date fecha;
		try {
			fecha = fechaFormato.parse(fechaR);
			prestamo.setFecha_prestamo(fecha);
			prestamo.setId_libro(id_libro);
			prestamo.setId_usuario(id_usuario);
			
			modeloPrestamo.conectar();
			modeloPrestamo.AnularPrestamo(fecha, id_libro, id_usuario);
			modeloPrestamo.cerrar();
		
		} catch (ParseException e) {
			e.printStackTrace();
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
