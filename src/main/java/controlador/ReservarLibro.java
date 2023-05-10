package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Libro;
import modelo.ModeloLibro;
import modelo.ModeloReserva;
import modelo.Reserva;
import modelo.Usuario;

/**
 * Servlet implementation class ReservarLibro
 */
@WebServlet("/ReservarLibro")
public class ReservarLibro extends HttpServlet {
	public static final int MAX_RESERVAS = 5;
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
HttpSession session = request.getSession();
		
		Usuario usuariologueado = (Usuario) session.getAttribute("usuariologeado");
		
		if (usuariologueado == null) {//no logeado
			response.sendRedirect("Login");
		} else {
		/*Consigue la cantidad de stock del libro*/
		
		/*recoje el parametro id_libro*/
		int id_libro = Integer.parseInt(request.getParameter("id_libro"));
		/*inicializo la variable donde guardare el stock*/
		int cantidadDisponible = 0;
		
		/*creo el modeloLibro para usar sus metodos*/
		ModeloLibro modeloLibro = new ModeloLibro();
		
		modeloLibro.conectar();
		/*Consigo el objeto libro mandandole la id_libro que anteriormente recojimos*/
		Libro libro = modeloLibro.getLibro(id_libro);
		modeloLibro.cerrar();
		/*y aqui compruebo si el objeto esta vacio sino recojo el atributo stock*/
		if (libro != null) {
		  cantidadDisponible = libro.getStock();
		}
		/*creo el modeloReserva para usar sus metodos*/
		ModeloReserva modeloReserva = new ModeloReserva();
		modeloReserva.conectar();
		/*Con este metodo recojo la cantidad de reservas que tiene el libro para compararlo con el stock*/
		int cantidadReservas = modeloReserva.getCantidadReservasPorLibro(id_libro);
		modeloReserva.cerrar();
		
	/* aqui compruebo si la cantidad de libros reservados es mayor o igual que el stock que si es el caso no dejara hacer la reserva y enviara a una vista especial*/
		if (cantidadReservas >= cantidadDisponible) {
			request.setAttribute("mensaje", "Lo sentimos, No hay stock.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/VerLibro?id_libro=" + id_libro);
			dispatcher.forward(request, response);

			
			} else {
				
				
			/*aqui empiezo a crear el atributo fecha necesario para realizar la reserva*/
				Calendar calendar = Calendar.getInstance();
		        Date currentDate = calendar.getTime();
		        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		        String fechaFormateada = formatoFecha.format(currentDate);
		        
		        /*recoje el parametro id_usuario*/
	        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
	       
	        /*creo el modeloReserva para usar sus metodos*/
	       ModeloReserva ModeloReserva = new ModeloReserva();
	       
	       Reserva reserva = new Reserva();
	       Date fechaReserva = null;
		try {
			/*parseo la fecha para darle el formato necesario  (yyyy-MM-dd)*/
			fechaReserva = formatoFecha.parse(fechaFormateada);
			reserva.setFecha_Reserva(fechaReserva);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*hago los sets para insertar la reserva posteriormente*/
	       reserva.setId_libro(id_libro);
	       reserva.setId_usuario(id_usuario);
	       
	       modeloReserva.conectar();
	       
	       /*recibo las reservas realizadas por el usuario en caso de ser 5 no dejara al usuario realizar mas*/
			int cantidadReservasTotales = modeloReserva.getCantidadReservasPorUsuarioEnFecha(id_usuario, fechaReserva);
		
			modeloReserva.cerrar();
			if (cantidadReservasTotales < MAX_RESERVAS) {
				
			
					modeloReserva.conectar();
					/*devuelve la cantidad de reservas que el usuario hace sobre un libro si es mayor que 0 significa que ya reservo ese libro y no le dejara volver a hacerlo*/
					int reservamismolibroydia = modeloReserva.getCantidadReservasPorUsuarioEnLibro(id_usuario, id_libro);
					modeloReserva.cerrar();
					if (reservamismolibroydia > 0) {
						request.setAttribute("mensaje", "ya has reservado este libro.");
						RequestDispatcher dispatcher = request.getRequestDispatcher("/VerLibro?id_libro=" + id_libro);
						dispatcher.forward(request, response);
					   
					} else {
					ModeloReserva.conectar();
				       
				       ModeloReserva.registrarReserva(reserva);
				       
				       ModeloReserva.cerrar();
				       
				       request.setAttribute("mensajeReservaRealizada", "Reserva realizada correctamente, Tienes 5 dias habiles para prestarlo.");
						RequestDispatcher dispatcher = request.getRequestDispatcher("/VerLibro?id_libro=" + id_libro);
						dispatcher.forward(request, response);
				}
				
			} else {
				request.setAttribute("mensaje", "Lo sentimos, ya ha alcanzado el límite máximo de reservas para el día de hoy.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/VerLibro?id_libro=" + id_libro);
				dispatcher.forward(request, response);
			}

	       
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
