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
			pst = conexion.prepareStatement("SELECT l.*, e.Nombre AS editorial\r\n"
					+ "FROM Libro l\r\n"
					+ "INNER JOIN Editorial e ON l.Id_Editorial = e.Id_Editorial\r\n"
					+ "WHERE l.Id_Libro = ?;");
			
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
				libro.setEditorial(rs.getString("editorial"));
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
	        pst = conexion.prepareStatement("SELECT libro.*\r\n"
	        		+ "FROM libro\r\n"
	        		+ "INNER JOIN Libro_Info ON libro.Id_Libro = Libro_Info.Id_Libro\r\n"
	        		+ "INNER JOIN Autor ON Libro_Info.Id_Autor = Autor.Id_Autor\r\n"
	        		+ "WHERE LOWER(REPLACE(libro.titulo, ' ', '')) = LOWER(REPLACE(?, ' ', '')) OR LOWER(libro.titulo) LIKE LOWER(CONCAT('%', ?, '%'))\r\n"
	        		+ "");

	        pst.setString(1, nombre);
	        pst.setString(2, nombre);
	        
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
	            libro.setDescripcion(rs.getString("Descripcion"));
	            librosRelacionados.add(libro);
	        }

	        // Consulta para buscar autores relacionados con el nombre
	        pst = conexion.prepareStatement("SELECT autor.*\r\n"
	        		+ "FROM libro\r\n"
	        		+ "INNER JOIN Libro_Info ON libro.Id_Libro = Libro_Info.Id_Libro\r\n"
	        		+ "INNER JOIN Autor ON Libro_Info.Id_Autor = Autor.Id_Autor\r\n"
	        		+ "WHERE LOWER(REPLACE(autor.nombre, ' ', '')) = LOWER(REPLACE(?, ' ', '')) OR LOWER(autor.nombre) LIKE LOWER(CONCAT('%', ?, '%'))\r\n"
	        		+ "GROUP BY Autor.Id_Autor\r\n"
	        		+ "");

	        pst.setString(1, nombre);
	        pst.setString(2, nombre);
	        
	        rs  = pst.executeQuery();
	        while (rs.next()) {
	            Autor autor = new Autor();
	            autor.setId_autor(rs.getInt("Id_Autor"));
	            autor.setNombre(rs.getString("Nombre"));
	            autor.setApellido(rs.getString("Apellido"));
	            autor.setDescripcion(rs.getString("Descripcion"));
	            autor.setFoto(rs.getString("Foto"));
	            autoresRelacionados.add(autor);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return new ResultadoBusqueda(librosRelacionados, autoresRelacionados);
	}

	public Libro buscarPorISBN(Long isbn) {
        Libro libro = new Libro();
        try {
            pst = conexion.prepareStatement("SELECT * FROM Libro WHERE isbn = ?");
            pst.setLong(1, isbn);
        
            rs = pst.executeQuery();
            
            while (rs.next()) {
                libro.setId_libro(rs.getInt("Id_Libro"));
                libro.setIsbn(rs.getLong("ISBN"));
                libro.setTitulo(rs.getString("Titulo"));
                libro.setNum_paginas(rs.getInt("Num_Pag"));
                libro.setFecha_publicacion(rs.getDate("Fecha_Publicacion"));
                libro.setIdioma(rs.getString("Idioma"));
                libro.setStock(rs.getInt("Stock"));
                libro.setCategoria(rs.getString("Categoria"));
                libro.setFoto(rs.getString("Foto"));
                
            }
        } catch (SQLException e) {
            
        e.printStackTrace();
        
        }
        return libro;
    }
	
}