package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloLibro_Info extends Conector{
	PreparedStatement pst;
	ResultSet rs;
	
	/**

	Inserta información de un libro en la tabla Libro_Info, asociándolo a un autor

	@param libro El objeto Libro que contiene la información del libro a insertar
	@param id_autor El ID del autor al que se asociará el libro
	*/
	public void insertarLibroInfo(Libro libro, int id_autor) {
		try {
			pst = conexion.prepareStatement("INSERT INTO Libro_Info (Id_Libro, Id_Autor) VALUES (?,?)");
			pst.setInt(1, libro.getId_libro());
			pst.setInt(2, id_autor);
			
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
	
	/**

	Elimina una entrada en la tabla "Libro_Info" que relaciona un libro con un autor especificados por sus respectivos ID.
	@param id_libro El ID del libro a eliminar de la tabla "Libro_Info".
	@param id_autor El ID del autor a eliminar de la tabla "Libro_Info".
	*/
	public void EliminarLibro_Info( int id_libro, int id_autor) {
		try {
			pst = conexion.prepareStatement("DELETE FROM Libro_Info WHERE Id_Libro = ? AND Id_Autor = ?");
			pst.setInt(1, id_libro);
			pst.setInt(2, id_autor);
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	/**

	Modifica la información de un libro en la tabla Libro_Info de la base de datos.
	@param id_libro El ID del libro a modificar.
	@param id_autor El ID del autor del libro a modificar.
	@param libro_info La información actualizada del libro.
	*/
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


	/**

	Retorna la información del libro con el ID especificado y el ID del autor asociado.
	@param id_libro el ID del libro del cual se desea obtener la información
	@param id_autor el ID del autor asociado al libro del cual se desea obtener la información
	@return la información del libro con el ID especificado y el ID del autor asociado
	*/
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

	/**
	* Devuelve un ArrayList con todos los objetos Libro_Info de la tabla Libro_Info de la base de datos.
	* 
	* @return ArrayList de objetos Libro_Info que contiene toda la información de la tabla Libro_Info de la base de datos.
	* @throws SQLException si hay un error al acceder a la base de datos.
	*/
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
	
	/**

	Obtiene el ID del autor correspondiente a un libro dado.
	@param id_libro el ID del libro del cual se quiere obtener el ID del autor.
	@return el ID del autor correspondiente al libro dado.
	*/
	public int getIdAutor (int id_libro) {
		int id_autor = 0;
		try {
			pst = conexion.prepareStatement("SELECT Id_Autor FROM libro_info where Id_Libro = ?");
			pst.setInt(1, id_libro);
			
			pst.executeQuery();
			rs = pst.executeQuery();
			while (rs.next()) {
				id_autor = rs.getInt("Id_Autor");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id_autor;
	}

	/**
	 * Devuelve el ID del libro correspondiente al autor con el ID especificado.
	 *
	 * @param id_autor El ID del autor cuyo libro se busca.
	 * @return El ID del libro correspondiente al autor con el ID especificado, o 0 si no se encuentra ningún libro.
	 */
	public int getIdLibro(int id_autor) {
		int id_libro = 0;
		try {
			pst = conexion.prepareStatement("SELECT Id_Libro FROM libro_info where Id_Autor = ?");
			pst.setInt(1, id_autor);
			
			pst.executeQuery();
			rs = pst.executeQuery();
			while (rs.next()) {
				id_libro = rs.getInt("Id_Libro");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id_libro;
	}
}
