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
			pst.setString(4, prestamo.getDevuelto());
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void AnularPrestamo(java.util.Date fecha, int id_libro, int id_usuario) {
		try {
			pst = conexion.prepareStatement("DELETE FROM Prestamo WHERE Fecha_Prestamo = ? AND Id_Libro = ? AND Id_Usuario = ?");
			pst.setDate(1, new Date(fecha.getTime()));
			pst.setInt(2, id_libro);
			pst.setInt(3, id_usuario);
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void modificarPrestamo(java.util.Date fechaVieja, int id_libroViejo, int id_usuarioViejo, Prestamo prestamo) {
	    try {
	        pst = conexion.prepareStatement("UPDATE prestamo SET Fecha_Prestamo = ?, Id_Libro = ?, Id_Usuario = ?, Devuelto = ? WHERE Fecha_Prestamo = ? AND Id_Libro = ? AND Id_Usuario = ?");
	        pst.setDate(1, new Date(prestamo.getFecha_prestamo().getTime()));
	        pst.setInt(2, prestamo.getId_libro());
	        pst.setInt(3, prestamo.getId_usuario());
	        pst.setString(4, prestamo.getDevuelto());
	        pst.setDate(5, new Date(fechaVieja.getTime()));
	        pst.setInt(6, id_libroViejo);
	        pst.setInt(7, id_usuarioViejo);
	        
	        pst.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public Prestamo getPrestamo(java.util.Date fecha, int id_libro, int id_usuario) {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		Prestamo prestamo = new Prestamo();
		try {
			pst = conexion.prepareStatement("SELECT * FROM Prestamo WHERE Fecha_Prestamo = ? AND Id_Libro = ? AND Id_Usuario = ?");
			pst.setDate(1, new Date(fecha.getTime()));
			pst.setInt(2, id_libro);
			pst.setInt(3, id_usuario);
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				prestamo.setFecha_prestamo(rs.getDate("Fecha_Prestamo"));
				prestamo.setDevuelto(rs.getString("Devuelto"));
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
	
	public ArrayList<Prestamo> getPrestamos() {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		
		try {
			pst = conexion.prepareStatement("SELECT * FROM prestamo");
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setFecha_prestamo(rs.getDate("Fecha_Prestamo"));
				prestamo.setDevuelto(rs.getString("Devuelto"));
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

	public Prestamo getReservaPorUsuario(int id_usuarioPrestamo) {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		Prestamo prestamo = new Prestamo();
		try {
			pst = conexion.prepareStatement("SELECT * FROM Prestamo WHERE Id_Usuario = ?");
			pst.setInt(1, id_usuarioPrestamo);
					
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				prestamo.setFecha_prestamo(rs.getDate("Fecha_Prestamo"));
				prestamo.setDevuelto(rs.getString("Devuelto"));
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
		
	public ArrayList<Prestamo> getPrestamoPorDni(String dniPrestamo) {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		try {
			pst = conexion.prepareStatement("SELECT * FROM prestamo JOIN usuario on usuario.Id_Usuario = prestamo.Id_Usuario  \r\n"
					+ "	JOIN libro on libro.Id_Libro = prestamo.Id_Libro\r\n"
					+ "	WHERE Dni = ?");
			pst.setString(1, dniPrestamo);
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setFecha_prestamo(rs.getDate("Fecha_Prestamo"));
				prestamo.setId_libro(rs.getInt("Id_Libro"));
				prestamo.setId_usuario(rs.getInt("Id_Usuario"));
				prestamo.setDevuelto(rs.getString("Devuelto"));
				prestamos.add(prestamo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prestamos;
	}
}
