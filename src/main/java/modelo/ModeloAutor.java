package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloAutor extends Conector {
	PreparedStatement pst;
	ResultSet rs;
	
	/**
	Registra un nuevo autor en la base de datos.
	@param autor objeto de la clase Autor que contiene los datos del autor a registrar
	@throws SQLException si hay un error al ejecutar la sentencia SQL
	*/
	public void registrarAutor(Autor autor) {
		try {
			pst = conexion.prepareStatement("INSERT INTO Autor (Nombre, Apellido, Descripcion) VALUES (?,?,?)");
			pst.setString(1, autor.getNombre());
			pst.setString(2, autor.getApellido());
			pst.setString(3, autor.getDescripcion());
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	Elimina un autor de la base de datos según su identificador.
	@param id_autor el identificador del autor a eliminar
	@throws SQLException si hay un error al ejecutar la sentencia SQL
	*/
	public void eliminarAutor(int id_autor) {
		try {
			pst = conexion.prepareStatement("DELETE FROM Autor WHERE Id_Autor = ?");
			pst.setInt(1, id_autor);
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	Modifica los datos de un autor en la base de datos según su identificador.
	@param id_autor el identificador del autor a modificar
	@param autor objeto de la clase Autor que contiene los nuevos datos del autor
	@throws SQLException si hay un error al ejecutar la sentencia SQL
	*/
	public void modificarAutor(int id_autor, Autor autor) {
		try {
			pst = conexion.prepareStatement("UPDATE autor SET Nombre = ?, Apellido = ?, Descripcion = ? WHERE Id_Autor = ?");
			pst.setInt(4, id_autor);
			pst.setString(1, autor.getNombre());
			pst.setString(2, autor.getApellido());
			pst.setString(3, autor.getDescripcion());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	Devuelve un objeto de la clase Autor que corresponde al autor con el identificador especificado.
	@param id_autor el identificador del autor buscado
	@return el objeto Autor correspondiente al autor con el identificador especificado, o null si no se encuentra
	@throws SQLException si hay un error al ejecutar la sentencia SQL
	*/
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
	
	
	
	/**
	Devuelve un objeto de la clase Autor que corresponde al autor del libro con el identificador especificado.
	@param id_libro el identificador del libro para el cual se busca el autor
	@return el objeto Autor correspondiente al autor del libro con el identificador especificado, o null si no se encuentra
	@throws SQLException si hay un error al ejecutar la sentencia SQL
	*/
	
	public Autor getAutorDeLibro(int id_libro) {
		ArrayList<Autor> autores = new ArrayList<Autor>();
		Autor autor = new Autor();
		try {
			pst = conexion.prepareStatement("SELECT AUTOR.*\n"
					+ "					FROM autor\n"
					+ "					INNER JOIN Libro_Info ON Libro_Info.Id_Autor = autor.Id_Autor\n"
					+ "					INNER JOIN libro ON Libro_Info.Id_Libro = libro.Id_Libro\n"
					+ "					WHERE libro.Id_Libro = ?;");
			pst.setInt(1, id_libro);
			
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
	
	
	public ArrayList<Autor> getAutoresDeLibro(int id_libro) {
		ArrayList<Autor> autores = new ArrayList<Autor>();
		
		try {
			pst = conexion.prepareStatement("SELECT AUTOR.*\n"
					+ "					FROM autor\n"
					+ "					INNER JOIN Libro_Info ON Libro_Info.Id_Autor = autor.Id_Autor\n"
					+ "					INNER JOIN libro ON Libro_Info.Id_Libro = libro.Id_Libro\n"
					+ "					WHERE libro.Id_Libro = ?;");
			pst.setInt(1, id_libro);
			
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
	
	/**
	 * Obtiene una lista de autores que han escrito un libro dado.
	 *
	 * @param id_libro el identificador del libro del que se quieren obtener los autores
	 * @return una lista de autores que han escrito el libro correspondiente
	 */
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
				autores.add(autor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return autor;
	}
	
	/**
	Devuelve una lista de todos los autores en la base de datos.
	@return una lista de objetos Autor que representan a los autores en la base de datos
	*/
	
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
				autor.setFoto(rs.getString("foto"));
				autores.add(autor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return autores;
	}

}
