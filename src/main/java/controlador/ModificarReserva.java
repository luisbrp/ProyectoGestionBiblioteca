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
        
        String fechaVieja = request.getParameter("fecha_Reserva");
        int id_usuarioViejo = Integer.parseInt(request.getParameter("id_usuario"));
        int id_libroViejo = Integer.parseInt(request.getParameter("id_libro"));
        
        try {
            Date fecha = fechaFormato.parse(fechaVieja);
            reserva.setFecha_Reserva(fecha);
            reserva.setId_usuario(id_usuarioViejo);
            reserva.setId_libro(id_libroViejo);
            
            modeloReserva.conectar();
            reserva = modeloReserva.getReserva(fecha, id_libroViejo, id_usuarioViejo);
            modeloReserva.cerrar();
            
            request.setAttribute("reserva", reserva);
            request.setAttribute("fecha", fecha);
            request.setAttribute("id_usuario", id_usuarioViejo);
            request.setAttribute("id_libro", id_libroViejo);
            
            request.getRequestDispatcher("ModificarReserva.jsp").forward(request, response);
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat fechaFormato = new SimpleDateFormat("yyyy-MM-dd");
        Reserva reserva = new Reserva();
        ModeloReserva modeloReserva = new ModeloReserva();
        
        //recibimos los paramtros nuevos
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        int id_libro = Integer.parseInt(request.getParameter("id_libro"));
        
        //y aqui los viejos
        String fechaRVieja = request.getParameter("fecha");
        int id_usuario_viejo = Integer.parseInt(request.getParameter("id_usuario_viejo"));
        int id_libro_viejo = Integer.parseInt(request.getParameter("id_libro_viejo"));
        
        try {
            Date fechaVieja = new java.sql.Date(fechaFormato.parse(fechaRVieja).getTime());
            Date fechaNueva = new java.sql.Date(fechaFormato.parse(request.getParameter("fechaNueva")).getTime());
            
            reserva.setFecha_Reserva(fechaNueva);
            reserva.setId_usuario(id_usuario);
            reserva.setId_libro(id_libro);
            
            modeloReserva.conectar();
            modeloReserva.modificarReserva(fechaVieja, id_libro_viejo, id_usuario_viejo, reserva);
            modeloReserva.cerrar();
            
            response.sendRedirect("OpcionesDeAdministrador");
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
