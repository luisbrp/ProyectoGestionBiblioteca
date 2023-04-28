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

import modelo.ModeloReserva;
import modelo.Reserva;

/**
 * Servlet implementation class ModificarReserva
 */
@WebServlet("/ModificarReserva")
public class ModificarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat fechaFormato = new SimpleDateFormat("yyyy-MM-dd");
		Reserva reserva = new Reserva();
		ModeloReserva modeloReserva = new ModeloReserva();
		
		String fechaR = request.getParameter("fecha_Reserva");
		int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
		int id_libro = Integer.parseInt(request.getParameter("id_libro"));
		
		
		try {
		Date fecha = fechaFormato.parse(fechaR);
		reserva.setFecha_Reserva(fecha);
		reserva.setId_usuario(id_usuario);
		reserva.setId_libro(id_libro);
		modeloReserva.conectar();
		modeloReserva.getReserva(fecha, id_libro, id_usuario);
		request.setAttribute("reserva", reserva);
		request.getRequestDispatcher("ModificarReserva.jsp").forward(request, response);
		modeloReserva.cerrar();
		
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat fechaFormato = new SimpleDateFormat("yyyy-MM-dd");
	    Reserva reserva = new Reserva();
	    ModeloReserva modeloReserva = new ModeloReserva();

	    String fechaR = request.getParameter("fecha_Reserva");
	    int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
	    int id_libro = Integer.parseInt(request.getParameter("id_libro"));

	    if (fechaR == null) {
	        
	        throw new IllegalArgumentException("La fecha de reserva es requerida");
	    } else {
	        try {
	            Date fecha = fechaFormato.parse(fechaR);
	            reserva.setFecha_Reserva(fecha);
	            reserva.setId_usuario(id_usuario);
	            reserva.setId_libro(id_libro);
	            modeloReserva.conectar();
	            modeloReserva.modificarReserva(fecha, id_libro, id_usuario, reserva);
	            modeloReserva.cerrar();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	    }
	}

}
