package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloLibro_Info extends Conector{
	PreparedStatement pst;
	ResultSet rs;
	
	public void insertarLibroInfo(Libro_Info libroInfo) {
		try {
			pst = conexion.prepareStatement("INSERT INTO Libro_Info (Id_Libro, Id_Autor) VALUES (?,?)");
			pst.setInt(1, libroInfo.getId_libro());
			pst.setInt(2, libroInfo.getId_autor());
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void insertarLibro_Info(Autor autor, Libro libro) {
		try {
			pst = conexion.prepareStatement("INSERT INTO Libro_Info (Id_Libro, Id_Autor) VALUES (?,?)");
			pst.setInt(1, libro.getId_libro());
			pst.setInt(2, autor.getId_autor());
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void EliminarLibro_Info(int id_libro, int id_autor) {
		try {
			pst = conexion.prepareStatement("DELETE FROM Libro_Info WHERE Id_Libro = ? AND Id_Autor = ?");
			pst.setInt(1, id_libro);
			pst.setInt(2, id_autor);
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void modificarLibro_Info(int id_libro, int id_autor, Libro_Info libro_info) {
	    try {
	        pst = conexion.prepareStatement("UPDATE Libro_Info SET Id_Libro = IFNULL(?, id_libro), Id_Autor = IFNULL(?, id_autor) WHERE Id_Libro = ? AND Id_Autor = ?");
	        pst.setInt(1, libro_info.getId_libro());
			pst.setInt(2, libro_info.getId_autor());
			pst.setInt(3, id_libro);
			pst.setInt(4, id_autor);
			
	        pst.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	
	public Libro_Info getLibro_Info(int id_libro, int id_autor) {
	    Libro_Info libro_info = new Libro_Info();
	    try {
	        pst = conexion.prepareStatement("SELECT * FROM Libro_Info WHERE Id_Libro = ? AND Id_Autor = ?");
	        pst.setInt(1, id_libro);
	        pst.setInt(2, id_autor);
	        rs = pst.executeQuery();
	        while(rs.next()) {
	            libro_info.setId_libro(rs.getInt("Id_Libro"));
	            libro_info.setId_autor(rs.getInt("Id_Autor"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return libro_info;
	}

	
	public ArrayList<Libro_Info> getLibros_Info() {
		ArrayList<Libro_Info> libros_Info = new ArrayList<Libro_Info>();
		
		try {
			pst = conexion.prepareStatement("SELECT * FROM Libro_Info");
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				Libro_Info libro_info = new Libro_Info();
				libro_info.setId_libro(rs.getInt("Id_Libro"));
				libro_info.setId_autor(rs.getInt("Id_Autor"));
				libros_Info .add(libro_info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libros_Info;
	}
}
