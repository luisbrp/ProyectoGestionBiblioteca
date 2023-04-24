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
 * Servlet implementation class RealizarPrestamo
 */
@WebServlet("/RealizarPrestamo")
public class RealizarPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RealizarPrestamo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("RealizarPrestamo.jsp").forward(request, response);
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
		
		try {
		Date fecha = fechaFormato.parse(fechaP);
		prestamo.setFecha_prestamo(fecha);
		prestamo.setId_usuario(id_usuario);
		prestamo.setId_libro(id_libro);
		prestamo.setDevuelto(devuelto);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		modeloPrestamo.conectar();
		modeloPrestamo.realizarPrestamo(prestamo);
		modeloPrestamo.cerrar();
	}

}
