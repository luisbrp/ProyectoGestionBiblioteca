package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloLibro_Info extends Conector{
	PreparedStatement pst;
	ResultSet rs;
	
	public void insertarLibro_Info(Libro_Info libro_info) {
		try {
			pst = conexion.prepareStatement("INSERT INTO Libro_Info (Id_Libro, Id_Autor) VALUES (?,?)");
			pst.setInt(2, libro_info.getId_libro());
			pst.setInt(3, libro_info.getId_autor());
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void EliminarLibro_Info(Libro_Info libro_info) {
		try {
			pst = conexion.prepareStatement("DELETE * FROM Libro_Info WHERE Id_Libro = ? Id_Autor = ?");
			pst.setInt(2, libro_info.getId_libro());
			pst.setInt(3, libro_info.getId_autor());
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void modificarLibro_Info(Libro_Info libro_info) {
		try {
			pst = conexion.prepareStatement("UPDATE Libro_Info Id_Libro = ? Id_Usuario = ? WHERE Id_Libro = ? Id_Usuario = ?");
			pst.setInt(2, libro_info.getId_libro());
			pst.setInt(3, libro_info.getId_autor());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Libro_Info getLibro_Info(Libro_Info libro_info) {
		ArrayList<Libro_Info> libros_info = new ArrayList<Libro_Info>();
		
		try {
			pst = conexion.prepareStatement("SELECT * FROM Libro_Info WHERE Id_Libro = ? Id_Usuario = ?");
			pst.setInt(2, libro_info.getId_libro());
			pst.setInt(3, libro_info.getId_autor());
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				libro_info.setId_libro(rs.getInt("Id_Libro"));
				libro_info.setId_autor(rs.getInt("Id_Autor"));
				libros_info .add(libro_info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libro_info;
	}
	
	public ArrayList<Libro_Info> getReservas() {
		ArrayList<Libro_Info> libros_info = new ArrayList<Libro_Info>();
		
		try {
			pst = conexion.prepareStatement("SELECT * FROM Reserva");
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				Libro_Info libro_info = new Libro_Info();
				libro_info.setId_libro(rs.getInt("Id_Libro"));
				libro_info.setId_autor(rs.getInt("Id_Autor"));
				libros_info .add(libro_info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libros_info;
	}
}
