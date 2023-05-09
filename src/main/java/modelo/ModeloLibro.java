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
				libro.setDescripcion(rs.getString("Descripcion"));
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
					+ "INNER JOIN Libro_Info ON Libro.Id_Libro = Libro_Info.Id_Libro\r\n"
					+ "INNER JOIN Autor ON Libro_Info.Id_Autor = Autor.Id_Autor\r\n"
					+ "WHERE Autor.Nombre = ?");
			pst.setString(1, nombre);
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
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
				libro.setDescripcion(rs.getString("Descripcion"));
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
			
			rs = pst.executeQuery();
			
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

	public ArrayList<Libro> buscarPorCategoria(String categoriaSeleccionada) {
		ArrayList<Libro> librosPorCategoria = new ArrayList<Libro>();
		try {
			pst = conexion.prepareStatement("SELECT * FROM Libro WHERE categoria = ?");
			pst.setString(1, categoriaSeleccionada);
		
			rs = pst.executeQuery();
			
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
				librosPorCategoria.add(libro);
			}
		} catch (SQLException e) {
			
		e.printStackTrace();
		
		}
		return librosPorCategoria;
	}	
	
	/**
	 * devuleve 3
	 * @return
	 */
	public ArrayList<CategoriaLibros> categoriasRecomendadas() {
		ArrayList<CategoriaLibros> categoriasLibros = new ArrayList<>();

	    try {
	    	pst = conexion.prepareStatement("SELECT l.Id_Libro, l.Titulo, l.Categoria, l.Foto \r\n" +
	                "FROM (\r\n" +
	                "    SELECT Libro.Id_Libro, Libro.Titulo, Libro.Categoria, Libro.Foto, \r\n" +
	                "           @row_num := IF(@prev_cat = Libro.Categoria, @row_num + 1, 1) AS row_number, \r\n" +
	                "           @prev_cat := Libro.Categoria \r\n" +
	                "    FROM Libro\r\n" +
	                "    JOIN (SELECT @row_num := 0, @prev_cat := NULL) AS vars\r\n" +
	                "    JOIN (\r\n" +
	                "        SELECT DISTINCT Categoria \r\n" +
	                "        FROM Libro \r\n" +
	                "        ORDER BY RAND() \r\n" +
	                "        LIMIT 3\r\n" +
	                "    ) AS c ON Libro.Categoria = c.Categoria\r\n" +
	                "    ORDER BY Libro.Categoria, RAND()\r\n" +
	                ") l\r\n" +
	                "WHERE l.row_number <= 3\r\n" +
	                "ORDER BY l.Categoria\r\n" +
	                "LIMIT 0, 25;");

	        rs = pst.executeQuery();

	        while (rs.next()) {
	            Libro libro = new Libro();
	            libro.setId_libro(rs.getInt("Id_Libro"));
	            String categoria = rs.getString("Categoria");
	            libro.setTitulo(rs.getString("Titulo"));
	            libro.setFoto(rs.getString("Foto"));

	            CategoriaLibros categoriaLibros = null;
	            for (CategoriaLibros cl : categoriasLibros) {
	                if (cl.getCategoria().equals(categoria)) {
	                    categoriaLibros = cl;
	                    break;
	                }
	            }

	            if (categoriaLibros == null) {
	                categoriaLibros = new CategoriaLibros();
	                categoriaLibros.setCategoria(categoria);
	                categoriaLibros.setLibros(new ArrayList<>());
	                categoriasLibros.add(categoriaLibros);
	            }

	            categoriaLibros.getLibros().add(libro);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return categoriasLibros;
	}
	
	
	public ArrayList<CategoriaLibros> TodasLasCategorias() {
		ArrayList<CategoriaLibros> categoriasLibros = new ArrayList<>();

	    try {
	    	pst = conexion.prepareStatement("SELECT categoria\r\n"
	    			+ "	FROM libro GROUP BY categoria;"
	    			);

	        rs = pst.executeQuery();

	        while (rs.next()) {
	            Libro libro = new Libro();
	       
	            String categoria = rs.getString("Categoria");
	           

	            CategoriaLibros categoriaLibros = null;
	            for (CategoriaLibros cl : categoriasLibros) {
	                if (cl.getCategoria().equals(categoria)) {
	                    categoriaLibros = cl;
	                    break;
	                }
	            }

	            if (categoriaLibros == null) {
	                categoriaLibros = new CategoriaLibros();
	                categoriaLibros.setCategoria(categoria);
	                categoriaLibros.setLibros(new ArrayList<>());
	                categoriasLibros.add(categoriaLibros);
	            }

	            categoriaLibros.getLibros().add(libro);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return categoriasLibros;
	}
	public ArrayList<CategoriaLibros> LibrosPorCategoria() {
		ArrayList<CategoriaLibros> categoriasLibros = new ArrayList<>();

	    try {
	    	pst = conexion.prepareStatement("SELECT Categoria, Id_Libro, ISBN, Titulo, Num_Pag, Fecha_Publicacion, Idioma, Stock, Foto, Descripcion\r\n"
	    			+ "FROM libro\r\n"
	    			+ "ORDER BY Categoria, Titulo\r\n"
	    			);

	        rs = pst.executeQuery();

	        while (rs.next()) {
	            Libro libro = new Libro();
	            libro.setId_libro(rs.getInt("Id_Libro"));
	            String categoria = rs.getString("Categoria");
	            libro.setTitulo(rs.getString("Titulo"));
	            libro.setFoto(rs.getString("Foto"));

	            CategoriaLibros categoriaLibros = null;
	            for (CategoriaLibros cl : categoriasLibros) {
	                if (cl.getCategoria().equals(categoria)) {
	                    categoriaLibros = cl;
	                    break;
	                }
	            }

	            if (categoriaLibros == null) {
	                categoriaLibros = new CategoriaLibros();
	                categoriaLibros.setCategoria(categoria);
	                categoriaLibros.setLibros(new ArrayList<>());
	                categoriasLibros.add(categoriaLibros);
	            }

	            categoriaLibros.getLibros().add(libro);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return categoriasLibros;
	}
	
	public class ResultadoBusqueda {
	    private ArrayList<Libro> librosRelacionados;
	    private ArrayList<Autor> autoresRelacionados;

	    public ResultadoBusqueda(ArrayList<Libro> librosRelacionados, ArrayList<Autor> autoresRelacionados) {
	        this.librosRelacionados = librosRelacionados;
	        this.autoresRelacionados = autoresRelacionados;
	    }

	    public ArrayList<Libro> getLibrosRelacionados() {
	        return librosRelacionados;
	    }

	    public ArrayList<Autor> getAutoresRelacionados() {
	        return autoresRelacionados;
	    }
	}

	public ResultadoBusqueda BuscarTituloLibroNombreAutor(String nombre) {
	    ArrayList<Libro> librosRelacionados = new ArrayList<Libro>();
	    ArrayList<Autor> autoresRelacionados = new ArrayList<Autor>();
	    try {
	        // Consulta para buscar libros relacionados con el titulo
	        PreparedStatement pstLibros = conexion.prepareStatement("SELECT libro.*\n" +
	                "FROM libro\n" +
	                "INNER JOIN Libro_Info ON libro.Id_Libro = Libro_Info.Id_Libro\n" +
	                "INNER JOIN Autor ON Libro_Info.Id_Autor = Autor.Id_Autor\n" +
	                "WHERE LOWER(REPLACE(libro.titulo, ' ', '')) = LOWER(REPLACE(?, ' ', ''))");

	        pstLibros.setString(1, nombre);

	        ResultSet rsLibros = pstLibros.executeQuery();
	        while (rsLibros.next()) {
	            Libro libro = new Libro();
	            libro.setId_libro(rsLibros.getInt("Id_Libro"));
	            libro.setIsbn(rsLibros.getLong("ISBN"));
	            libro.setTitulo(rsLibros.getString("Titulo"));
	            libro.setNum_paginas(rsLibros.getInt("Num_Pag"));
	            libro.setFecha_publicacion(rsLibros.getDate("Fecha_Publicacion"));
	            libro.setIdioma(rsLibros.getString("Idioma"));
	            libro.setStock(rsLibros.getInt("Stock"));
	            libro.setCategoria(rsLibros.getString("Categoria"));
	            libro.setFoto(rsLibros.getString("Foto"));
	            libro.setDescripcion(rsLibros.getString("Descripcion"));
	            librosRelacionados.add(libro);
	        }

	        // Consulta para buscar autores relacionados con el nombre
	        PreparedStatement pstAutores = conexion.prepareStatement("SELECT autor.*\n"
	        		+ "FROM libro\n"
	        		+ "INNER JOIN Libro_Info ON libro.Id_Libro = Libro_Info.Id_Libro\n"
	        		+ "INNER JOIN Autor ON Libro_Info.Id_Autor = Autor.Id_Autor\n"
	        		+ "WHERE LOWER(REPLACE(autor.nombre, ' ', '')) = LOWER(REPLACE(?, ' ', ''))\n"
	        		+ "GROUP BY Autor.Id_Autor\n"
	        		+ "");

	        pstAutores.setString(1, nombre);

	        ResultSet rsAutores = pstAutores.executeQuery();
	        while (rsAutores.next()) {
	            Autor autor = new Autor();
	            autor.setId_autor(rsAutores.getInt("Id_Autor"));
	            autor.setNombre(rsAutores.getString("Nombre"));
	            autor.setApellido(rsAutores.getString("Apellido"));
	            autor.setDescripcion(rsAutores.getString("Descripcion"));
	            autor.setFoto(rsAutores.getString("Foto"));
	            autoresRelacionados.add(autor);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return new ResultadoBusqueda(librosRelacionados, autoresRelacionados);
	}


	
}