package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloPrestamo extends Conector{
	PreparedStatement pst;
	ResultSet rs;
	
	public void realizarPrestamo(Prestamo prestamo) {
		try {
			pst = conexion.prepareStatement("INSERT INTO Prestamo (Fecha_Prestamo, Id_Libro, Id_Usuario, Devuelto) VALUES (?,?,?,?)");
			pst.setDate(1, new Date(prestamo.getFecha_prestamo().getTime()));
			pst.setInt(2, prestamo.getId_libro());
			pst.setInt(3, prestamo.getId_usuario());
			pst.setBoolean(4, prestamo.getDevuelto());
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void AnularPrestamo(Prestamo prestamo) {
		try {
			pst = conexion.prepareStatement("DELETE * FROM Prestamo WHERE Fecha_Prestamo = ?  Id_Lbro = ? Id_Usuario = ?");
			pst.setDate(1, new Date(prestamo.getFecha_prestamo().getTime()));
			pst.setInt(2, prestamo.getId_libro());
			pst.setInt(3, prestamo.getId_usuario());
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void modificarPrestamo(Prestamo prestamo) {
		try {
			pst = conexion.prepareStatement("UPDATE Prestamo SET Fecha_Prestamo = ? Id_Libro = ? Id_Usuario = ? WHERE Fecha_Prestamo = ? Id_Lbro = ? Id_Usuario = ?");
			pst.setDate(1, new Date(prestamo.getFecha_prestamo().getTime()));
			pst.setInt(2, prestamo.getId_libro());
			pst.setInt(3, prestamo.getId_usuario());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Prestamo getPrestamo(Prestamo prestamo) {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		
		try {
			pst = conexion.prepareStatement("SELECT * FROM Prestamo WHERE Fecha_Prestamo = ? Id_Lbro = ? Id_Usuario = ?");
			pst.setDate(1, new Date(prestamo.getFecha_prestamo().getTime()));
			pst.setInt(2, prestamo.getId_libro());
			pst.setInt(3, prestamo.getId_usuario());
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				prestamo.setFecha_prestamo(rs.getDate("Fecha_Prestamo"));
				prestamo.setDevuelto(rs.getBoolean("Devuelto"));
				prestamo.setId_libro(rs.getInt("Id_Libro"));
				prestamo.setId_usuario(rs.getInt("Id_Usuario"));
				prestamos.add(prestamo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prestamo;
	}
	
	public ArrayList<Prestamo> getReservas() {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		
		try {
			pst = conexion.prepareStatement("SELECT * FROM Reserva");
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setFecha_prestamo(rs.getDate("Fecha_Prestamo"));
				prestamo.setDevuelto(rs.getBoolean("Devuelto"));
				prestamo.setId_libro(rs.getInt("Id_Libro"));
				prestamo.setId_usuario(rs.getInt("Id_Usuario"));
				prestamos.add(prestamo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prestamos;
	}
}
