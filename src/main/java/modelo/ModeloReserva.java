package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloReserva extends Conector{
	PreparedStatement pst;
	ResultSet rs;
	
	/**

	Este método registra una nueva reserva en la base de datos.
	@param reserva una instancia de la clase Reserva que contiene la información de la reserva.
	@throws SQLException si ocurre un error al ejecutar la consulta SQL.
	*/
	public void registrarReserva(Reserva reserva) {
		try {
			pst = conexion.prepareStatement("INSERT INTO Reserva (Fecha_Reserva, Id_Libro, Id_Usuario) VALUES (?,?,?)");
			pst.setDate(1, new Date(reserva.getFecha_Reserva().getTime()));
			pst.setInt(2, reserva.getId_libro());
			pst.setInt(3, reserva.getId_usuario());
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	/**

	Este método anula una reserva existente en la base de datos.
	@param fecha un objeto Date que representa la fecha de la reserva a anular.
	@param id_libro un entero que representa el identificador del libro de la reserva a anular.
	@param id_usuario un entero que representa el identificador del usuario que hizo la reserva a anular.
	@throws SQLException si ocurre un error al ejecutar la consulta SQL.
	*/
	public void AnularReserva(java.util.Date fecha, int id_libro, int id_usuario) {
		try {
			pst = conexion.prepareStatement("DELETE FROM Reserva WHERE Fecha_Reserva = ? AND Id_Libro = ? AND Id_Usuario = ?");
			pst.setDate(1, new Date(fecha.getTime()));
			pst.setInt(2, id_libro);
			pst.setInt(3, id_usuario);
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	/**

	Este método modifica una reserva existente en la base de datos.
	@param fecha un objeto Date que representa la fecha de la reserva a modificar.
	@param id_libro un entero que representa el identificador del libro de la reserva a modificar.
	@param id_usuario un entero que representa el identificador del usuario que hizo la reserva a modificar.
	@param reserva una instancia de la clase Reserva que contiene la información actualizada de la reserva.
	@throws SQLException si ocurre un error al ejecutar la consulta SQL.
	*/
	public void modificarReserva(java.util.Date fecha, int id_libro, int id_usuario, Reserva reserva) {
		try {
			pst = conexion.prepareStatement("UPDATE Reserva SET Fecha_Reserva = ?, Id_Libro = ?, Id_Usuario = ? WHERE Fecha_Reserva = ? AND Id_Libro = ? AND Id_Usuario = ?");
			 pst.setDate(1, new Date(reserva.getFecha_Reserva().getTime()));
		        pst.setInt(2, reserva.getId_libro());
		        pst.setInt(3, reserva.getId_usuario());
		        pst.setDate(4, new Date(fecha.getTime()));
		        pst.setInt(5, id_libro);
		        pst.setInt(6, id_usuario);
		        
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**

	Este método obtiene una reserva existente en la base de datos.
	@param fecha un objeto Date que representa la fecha de la reserva a obtener.
	@param id_libro un entero que representa el identificador del libro de la reserva a obtener.
	@param id_usuario un entero que representa el identificador del usuario que hizo la reserva a obtener.
	@return una instancia de la clase Reserva que contiene la información de la reserva obtenida.
	@throws SQLException si ocurre un error al ejecutar la consulta SQL.
	*/
	public Reserva getReserva(java.util.Date fecha, int id_libro, int id_usuario) {
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		Reserva reserva = new Reserva();
		try {
			pst = conexion.prepareStatement("SELECT * FROM Reserva WHERE Fecha_Reserva = ? AND Id_Libro = ? AND Id_Usuario = ?");
			pst.setDate(1, new Date(fecha.getTime()));
			pst.setInt(2, id_libro);
			pst.setInt(3, id_usuario);
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				reserva.setFecha_Reserva(rs.getDate("Fecha_Reserva"));
				reserva.setId_libro(rs.getInt("Id_Libro"));
				reserva.setId_usuario(rs.getInt("Id_Usuario"));
				reservas.add(reserva);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reserva;
	}
	
	/**

	Este método obtiene todas las reservas existentes en la base de datos.
	@return un ArrayList de instancias de la clase Reserva que contienen la información de todas las reservas.
	@throws SQLException si ocurre un error al ejecutar la consulta SQL.
	*/
	public ArrayList<Reserva> getReservas() {
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		
		try {
			pst = conexion.prepareStatement("SELECT * FROM Reserva");
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				Reserva reserva = new Reserva();
				reserva.setFecha_Reserva(rs.getDate("Fecha_Reserva"));
				reserva.setId_libro(rs.getInt("Id_Libro"));
				reserva.setId_usuario(rs.getInt("Id_Usuario"));
				reservas.add(reserva);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservas;
	}
	
	/**

	Este método obtiene la cantidad de reservas existentes en la base de datos para un libro dado.
	@param id_libro un entero que representa el identificador del libro del cual se desea obtener la cantidad de reservas.
	@return un entero que representa la cantidad de reservas existentes para el libro especificado.
	@throws SQLException si ocurre un error al ejecutar la consulta SQL.
	*/
	public int getCantidadReservasPorLibro(int id_libro) {
	    int CantidadReservasPorLibro = 0;
	    try {
	        pst = conexion.prepareStatement("SELECT COUNT(*) AS cantidad FROM Reserva WHERE Id_Libro = ?");
	        pst.setInt(1, id_libro);
	        rs = pst.executeQuery(); 
	        if (rs.next()) {
	            CantidadReservasPorLibro = rs.getInt("cantidad");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return CantidadReservasPorLibro;
	}

	
	/**

	Retorna la cantidad de reservas realizadas por un usuario en una fecha determinada.
	@param id_usuario el id del usuario a consultar
	@param fechaReserva la fecha de la reserva a consultar
	@return la cantidad de reservas realizadas por el usuario en la fecha especificada
	*/
	public int getCantidadReservasPorUsuarioEnFecha(int id_usuario, java.util.Date fechaReserva) {
	    int CantidadReservasPorFecha = 0;
	    try {
	        pst = conexion.prepareStatement("SELECT COUNT(*) AS cantidad FROM Reserva WHERE Id_Usuario = ? AND Fecha_Reserva = ?");
	        pst.setInt(1, id_usuario);
	        pst.setDate(2, new Date(fechaReserva.getTime()));
	        rs = pst.executeQuery(); 
	        if (rs.next()) {
	            CantidadReservasPorFecha = rs.getInt("cantidad");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return CantidadReservasPorFecha;
	}
	
	/**

	Retorna la cantidad de reservas realizadas por un usuario en una fecha determinada
	@param id_usuario el id del usuario del cual se desea conocer la cantidad de reservas
	@param fechaReserva la fecha en la que se desea conocer la cantidad de reservas
	@return la cantidad de reservas realizadas por el usuario en la fecha especificada
	*/
	public int getCantidadReservasPorUsuarioEnLibro(int id_usuario, int id_libro) {
	    int CantidadReservasPorLibro = 0;
	    try {
	        pst = conexion.prepareStatement("SELECT COUNT(*) AS cantidad FROM Reserva WHERE Id_Usuario = ? AND Id_Libro = ?");
	        pst.setInt(1, id_usuario);
	        pst.setInt(2, id_libro);	      
	        rs = pst.executeQuery(); 
	        if (rs.next()) {
	        	CantidadReservasPorLibro = rs.getInt("cantidad");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return CantidadReservasPorLibro;
	}
	
	/**

	Retorna la cantidad de reservas realizadas por un usuario para un libro en particular
	@param id_usuario el id del usuario del cual se desea conocer la cantidad de reservas
	@param id_libro el id del libro del cual se desea conocer la cantidad de reservas
	@return la cantidad de reservas realizadas por el usuario para el libro especificado
	*/
	public ArrayList<Reserva> getReservasPorDni(String dniReserva) {
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        try {
            pst = conexion.prepareStatement("SELECT * FROM reserva JOIN usuario on usuario.Id_Usuario = reserva.Id_Usuario  \r\n"
                    + "    JOIN libro on libro.Id_Libro = reserva.Id_Libro\r\n"
                    + "    WHERE Dni = ?");
            pst.setString(1, dniReserva);
            
            pst.executeQuery();
            
            rs = pst.executeQuery();
            while(rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setFecha_Reserva(rs.getDate("Fecha_Reserva"));
                reserva.setId_libro(rs.getInt("Id_Libro"));
                reserva.setId_usuario(rs.getInt("Id_Usuario"));
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return reservas;
    }


}
