package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloAutor extends Conector {
	PreparedStatement pst;
	ResultSet rs;
	
	public void registrarAutor(Autor autor) {
		try {
			pst = conexion.prepareStatement("INSERT INTO Autor (Nombre, Apellido, Descripcion, Foto) VALUES (?,?,?,?)");
			pst.setString(1, autor.getNombre());
			pst.setString(2, autor.getApellido());
			pst.setString(3, autor.getDescripcion());
			pst.setString(4, autor.getFoto());
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void eliminarAutor(int id_autor) {
		try {
			pst = conexion.prepareStatement("DELETE FROM Autor WHERE Id_Autor = ?");
			pst.setInt(1, id_autor);
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void modificarAutor(int id_autor, Autor autor) {
		try {
			pst = conexion.prepareStatement("UPDATE autor SET Nombre = ?, Apellido = ?, Descripcion = ?, Foto = ? WHERE Id_Autor = ?");
			pst.setInt(4, id_autor);
			pst.setString(1, autor.getNombre());
			pst.setString(2, autor.getApellido());
			pst.setString(3, autor.getDescripcion());
			pst.setString(4, autor.getFoto());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Autor getAutor(int id_autor) {
		ArrayList<Autor> autores = new ArrayList<Autor>();
		Autor autor = new Autor();
		try {
			pst = conexion.prepareStatement("SELECT * FROM autor WHERE Id_Autor = ?");
			pst.setInt(1, id_autor);
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				autor.setId_autor(rs.getInt("Id_Autor"));
				autor.setNombre(rs.getString("Nombre"));
				autor.setApellido(rs.getString("Apellido"));
				autor.setDescripcion(rs.getString("Descripcion"));
				autor.setFoto(rs.getString("Foto"));
				autores.add(autor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return autor;
	}
	
	public Autor AutorPorNombre(Autor autor) {
		ArrayList<Autor> autores = new ArrayList<Autor>();
		try {
			pst = conexion.prepareStatement("SELECT * FROM autor WHERE Nombre = ?");
			pst.setString(1, autor.getNombre());
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				autor.setId_autor(rs.getInt("Id_Autor"));
				autor.setNombre(rs.getString("Nombre"));
				autor.setApellido(rs.getString("Apellido"));
				autor.setDescripcion(rs.getString("Descripcion"));
				autor.setFoto(rs.getString("Foto"));
				autores.add(autor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return autor;
	}
	
	public Autor getAutorPorNombre(String nombre) {
		ArrayList<Autor> autores = new ArrayList<Autor>();
		Autor autor = new Autor();
		try {
			pst = conexion.prepareStatement("SELECT * FROM autor WHERE Nombre = ?");
			pst.setString(1, nombre);
			
			pst.executeQuery();
		
			rs = pst.executeQuery();
			while(rs.next()) {
				autor.setId_autor(rs.getInt("Id_Autor"));
				autor.setNombre(rs.getString("Nombre"));
				autor.setApellido(rs.getString("Apellido"));
				autor.setDescripcion(rs.getString("Descripcion"));
				autor.setFoto(rs.getString("Foto"));
				autores.add(autor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return autor;
	}
	
	public ArrayList<Autor> getAutores() {
		ArrayList<Autor> autores = new ArrayList<Autor>();
		
		try {
			pst = conexion.prepareStatement("SELECT * FROM Autor");
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				Autor autor = new Autor();
				autor.setId_autor(rs.getInt("Id_Autor"));
				autor.setNombre(rs.getString("Nombre"));
				autor.setApellido(rs.getString("Apellido"));
				autor.setDescripcion(rs.getString("Descripcion"));
				autor.setFoto(rs.getString("Foto"));
				autores.add(autor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return autores;
	}
	

}
