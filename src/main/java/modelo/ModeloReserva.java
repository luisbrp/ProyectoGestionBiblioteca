package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloReserva extends Conector{
	PreparedStatement pst;
	ResultSet rs;
	
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
}
