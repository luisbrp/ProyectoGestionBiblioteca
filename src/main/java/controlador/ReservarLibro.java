package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Libro;
import modelo.ModeloLibro;
import modelo.ModeloReserva;
import modelo.Reserva;

/**
 * Servlet implementation class ReservarLibro
 */
@WebServlet("/ReservarLibro")
public class ReservarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservarLibro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*Consigue la cantidad de stock del libro*/
		int id_libro = Integer.parseInt(request.getParameter("id_libro"));
		int cantidadDisponible = 0;
		
		ModeloLibro modeloLibro = new ModeloLibro();
		
		modeloLibro.conectar();
		Libro libro = modeloLibro.getLibro(id_libro);
		modeloLibro.cerrar();
		
		if (libro != null) {
		  cantidadDisponible = libro.getStock();
		}
		
		ModeloReserva modeloReserva = new ModeloReserva();
		modeloReserva.conectar();
		int cantidadReservas = modeloReserva.getCantidadReservasPorLibro(id_libro);
		modeloReserva.cerrar();
		if (cantidadReservas >= cantidadDisponible) {
			  response.getWriter().append("Lo sentimos, No hay stock.");
			} else {
				
				
			
				Calendar calendar = Calendar.getInstance();
		        Date currentDate = calendar.getTime();
		        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		        String fechaFormateada = formatoFecha.format(currentDate);
	  
	        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
	       
	        
	       ModeloReserva ModeloReserva = new ModeloReserva();
	       
	       Reserva reserva = new Reserva();
	       Date fechaReserva = null;
		try {
			fechaReserva = formatoFecha.parse(fechaFormateada);
			reserva.setFecha_Reserva(fechaReserva);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       reserva.setId_libro(id_libro);
	       reserva.setId_usuario(id_usuario);
	       
	       modeloReserva.conectar();
			int cantidadReservasTotales = modeloReserva.getCantidadReservasPorUsuarioEnFecha(id_usuario, fechaReserva);
		
			modeloReserva.cerrar();
			if (cantidadReservasTotales < 5) {
				
				modeloReserva.conectar();
				
				int cantidadReservasMismoLibro = modeloReserva.getCantidadReservasPorUsuarioYlibroEnFecha(id_usuario, id_libro, fechaReserva);
				modeloReserva.cerrar();
				System.out.println(fechaReserva);
				if (cantidadReservasMismoLibro > 0) {
				    // Mostrar mensaje de reserva duplicada
				    response.getWriter().append("Lo sentimos, ya ha realizado una reserva para este libro el día de hoy.");
				} else {
					
					ModeloReserva.conectar();
				       
				       ModeloReserva.registrarReserva(reserva);
				       
				       ModeloReserva.cerrar();
				}
				
			} else {
			    response.getWriter().append("Lo sentimos, ya ha alcanzado el límite máximo de reservas para el día de hoy.");
			  
			}

	       
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
