package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class ModeloLibro extends Conector{
	PreparedStatement pst;
	ResultSet rs;
	
	public void registrarLibro(Libro libro) {
		try {
			pst = conexion.prepareStatement("INSERT INTO Libro (ISBN, Titulo, Num_pag, Fecha_Publicacion, Idioma, Stock, Categoria, Foto) VALUES (?,?,?,?,?,?,?,?)");
			pst.setLong(1, libro.getIsbn());
			pst.setString(2, libro.getTitulo());
			pst.setInt(3, libro.getNum_paginas());
			pst.setDate(4, new Date(libro.getFecha_publicacion().getTime()));
			pst.setString(5, libro.getIdioma());
			pst.setInt(6, libro.getStock());
			pst.setString(7, libro.getCategoria());
			pst.setString(8, libro.getFoto());
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void eliminarLibro(int id_libro) {
		try {
			pst = conexion.prepareStatement("DELETE FROM Libro WHERE Id_Libro = ?");
			pst.setInt(1, id_libro);
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void modificarLibro(int id_libro, Libro libro) {
		try {
			pst = conexion.prepareStatement("UPDATE Libro SET ISBN = ?, Titulo = ?, Num_pag = ?, Fecha_Publicacion = ?, Idioma = ?, Stock = ?, Categoria = ?, Foto = ? WHERE Id_Libro = ?");
			pst.setInt(9, libro.getId_libro());
			pst.setLong(1, libro.getIsbn());
			pst.setString(2, libro.getTitulo());
			pst.setInt(3, libro.getNum_paginas());
			pst.setDate(4, new Date(libro.getFecha_publicacion().getTime()));
			pst.setString(5, libro.getIdioma());
			pst.setInt(6, libro.getStock());
			pst.setString(7, libro.getCategoria());
			pst.setString(8, libro.getFoto());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Libro getLibro(int id_libro) {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		Libro libro = new Libro();
		try {
			pst = conexion.prepareStatement("SELECT * FROM Libro WHERE Id_Libro = ?");
			
			pst.setInt(1, id_libro);
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				libro.setId_libro(rs.getInt("Id_Libro"));
				libro.setIsbn(rs.getLong("ISBN"));
				libro.setTitulo(rs.getString("Titulo"));
				libro.setNum_paginas(rs.getInt("Num_Pag"));
				libro.setFecha_publicacion(rs.getDate("Fecha_Publicacion"));
				libro.setIdioma(rs.getString("Idioma"));
				libro.setStock(rs.getInt("Stock"));
				libro.setCategoria(rs.getString("Categoria"));
				libro.setFoto(rs.getString("Foto"));
				libros.add(libro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libro;
	}
	
	public ArrayList<Libro> getLibros() {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		
		try {
			pst = conexion.prepareStatement("SELECT * FROM Libro");
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				Libro libro = new Libro();
				libro.setId_libro(rs.getInt(1));
				libro.setIsbn(rs.getLong("ISBN"));
				libro.setTitulo(rs.getString("Titulo"));
				libro.setNum_paginas(rs.getInt("Num_Pag"));
				libro.setFecha_publicacion(rs.getDate("Fecha_Publicacion"));
				libro.setIdioma(rs.getString("Idioma"));
				libro.setStock(rs.getInt("Stock"));
				libro.setCategoria(rs.getString("Categoria"));
				libro.setFoto(rs.getString("Foto"));
				libros.add(libro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libros;
	}

	public ArrayList<Libro> getLibrosPorNombreAutor (String nombre) {
		ArrayList<Libro> librosDelAutor = new ArrayList<Libro>();
		try {
			pst = conexion.prepareStatement("SELECT LIBRO.*\r\n"
					+ "FROM Libro\r\n"
					+ "INNER JOIN Libro_Info ON Libro.Id_Libro = Libro.Id_Libro\r\n"
					+ "INNER JOIN Autor ON Libro_Info.Id_Autor = Autor.Id_Autor\r\n"
					+ "WHERE Autor.Nombre = ?");
			pst.setString(1, nombre);
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				Libro libro = new Libro();
				libro.setId_libro(rs.getInt(1));
				libro.setIsbn(rs.getLong("ISBN"));
				libro.setTitulo(rs.getString("Titulo"));
				libro.setNum_paginas(rs.getInt("Num_Pag"));
				libro.setFecha_publicacion(rs.getDate("Fecha_Publicacion"));
				libro.setIdioma(rs.getString("Idioma"));
				libro.setStock(rs.getInt("Stock"));
				libro.setCategoria(rs.getString("Categoria"));
				libro.setFoto(rs.getString("Foto"));
				librosDelAutor.add(libro);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return librosDelAutor;
	}
	
	public ArrayList<Libro> buscarLibro(String busqueda) {
		ArrayList<Libro> librosEncontrados = new ArrayList<Libro>();
		try {
			pst = conexion.prepareStatement("SELECT l.*, a.Nombre AS Autor_Nombre, a.Apellido AS Autor_Apellido, e.Nombre AS Editorial_Nombre FROM Libro l LEFT JOIN Libro_Info li ON l.Id_Libro = li.Id_Libro LEFT JOIN Autor a ON li.Id_Autor = a.Id_Autor LEFT JOIN Editorial e ON l.Id_Libro = e.Id_Libro WHERE l.Titulo LIKE ? OR l.Categoria LIKE ? OR a.Nombre LIKE ? OR a.Apellido LIKE ? OR l.ISBN LIKE ?");
			pst.setString(1, "%" + busqueda + "%");
			pst.setString(2, "%" + busqueda + "%");
			pst.setString(3, "%" + busqueda + "%");
			pst.setString(4, "%" + busqueda + "%");
			pst.setString(5, "%" + busqueda + "%");
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Libro libro = new Libro();
				libro.setId_libro(rs.getInt("Id_Libro"));
				libro.setIsbn(rs.getLong("ISBN"));
				libro.setTitulo(rs.getString("Titulo"));
				libro.setNum_paginas(rs.getInt("Num_Pag"));
				libro.setFecha_publicacion(rs.getDate("Fecha_Publicacion"));
				libro.setIdioma(rs.getString("Idioma"));
				libro.setStock(rs.getInt("Stock"));
				libro.setCategoria(rs.getString("Categoria"));
				libro.setFoto(rs.getString("Foto"));
				
				Autor autor = new Autor();
				autor.setNombre(rs.getString("Autor_Nombre"));
				autor.setApellido(rs.getString("Autor_Apellido"));
				libro.setAutor(autor);
				
				Editorial editorial = new Editorial();
				editorial.setNombre(rs.getString("Editorial_Nombre"));
				libro.setEditorial(editorial);
				
				librosEncontrados.add(libro);
			}
		} catch (SQLException e) {
			
		e.printStackTrace();
		
		}
		return librosEncontrados;
	}

}