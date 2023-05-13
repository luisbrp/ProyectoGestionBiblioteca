package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class ModeloLibro extends Conector{
	PreparedStatement pst;
	ResultSet rs;
	
	/**
	Registra un libro en la base de datos.
	@param libro el libro a registrar.
	*/
	public void registrarLibro(Libro libro) {
		try {
			pst = conexion.prepareStatement("INSERT INTO Libro (ISBN, Titulo, Num_pag, Fecha_Publicacion, Idioma, Stock, Categoria, Foto, Descripcion, Id_Editorial) VALUES (?,?,?,?,?,?,?,?,?,?)");
			pst.setLong(1, libro.getIsbn());
			pst.setString(2, libro.getTitulo());
			pst.setInt(3, libro.getNum_paginas());
			pst.setDate(4, new Date(libro.getFecha_publicacion().getTime()));
			pst.setString(5, libro.getIdioma());
			pst.setInt(6, libro.getStock());
			pst.setString(7, libro.getCategoria());
			pst.setString(8, libro.getFoto());
			pst.setString(9, libro.getDescripcion());
			pst.setInt(10, libro.getId_editorial());
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	Elimina un libro de la base de datos.
	@param id_libro el ID del libro a eliminar
	*/
	public void eliminarLibro(int id_libro) {
		try {
			pst = conexion.prepareStatement("DELETE FROM Libro WHERE Id_Libro = ?");
			pst.setInt(1, id_libro);
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	/**

	Modifica la información de un libro en la base de datos.
	@param id_libro El identificador del libro a modificar.
	@param libro El objeto Libro con la información actualizada.
	*/
	public void modificarLibro(int id_libro, Libro libro) {
		try {
			pst = conexion.prepareStatement("UPDATE Libro SET ISBN = ?, Titulo = ?, Num_pag = ?, Fecha_Publicacion = ?, Idioma = ?, Stock = ?, Categoria = ?, Foto = ?, Descripcion = ?, Id_Editorial = ? WHERE Id_Libro = ?");
			pst.setInt(11, libro.getId_libro());
			pst.setLong(1, libro.getIsbn());
			pst.setString(2, libro.getTitulo());
			pst.setInt(3, libro.getNum_paginas());
			pst.setDate(4, new Date(libro.getFecha_publicacion().getTime()));
			pst.setString(5, libro.getIdioma());
			pst.setInt(6, libro.getStock());
			pst.setString(7, libro.getCategoria());
			pst.setString(8, libro.getFoto());
			pst.setString(9, libro.getDescripcion());
			pst.setInt(10, libro.getId_editorial());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**

	Retorna el objeto Libro correspondiente al id proporcionado.
	@param id_libro El id del libro a buscar.
	@return El objeto Libro correspondiente al id proporcionado.
	*/
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
				libro.setId_editorial(rs.getInt("Id_Editorial"));
				libros.add(libro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libro;
	}
	
	/**

	Obtiene una lista de todos los libros registrados en la base de datos.
	@return una lista de objetos Libro que representan los libros registrados en la base de datos.
	*/
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
				libro.setDescripcion(rs.getString("Descripcion"));
				libro.setId_editorial(rs.getInt("Id_Editorial"));
				libros.add(libro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libros;
	}
	
	/**

	Obtiene una lista de libros que tienen como autor al autor con el nombre especificado.
	@param nombre el nombre del autor a buscar
	@return una lista de libros que tienen como autor al autor con el nombre especificado
	*/
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
				libro.setId_editorial(rs.getInt("Id_Editorial"));
				librosDelAutor.add(libro);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return librosDelAutor;
	}
	
	/**

	Busca en la base de datos todos los libros que pertenecen a una determinada categoría.
	@param categoriaSeleccionada la categoría de los libros a buscar
	@return una lista de objetos de tipo Libro que pertenecen a la categoría especificada
	*/
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
				libro.setDescripcion(rs.getString("Descripcion"));
				libro.setId_editorial(rs.getInt("Id_Editorial"));
				librosPorCategoria.add(libro);
			}
		} catch (SQLException e) {
			
		e.printStackTrace();
		
		}
		return librosPorCategoria;
	}	
	
	/**

	Este método devuelve una lista de categorías de libros recomendadas. Para ello, selecciona aleatoriamente
	tres categorías distintas de libros y devuelve una lista con los títulos, fotos y IDs de tres libros de cada categoría.
	Los libros se seleccionan aleatoriamente y se ordenan por categoría y de manera aleatoria dentro de cada categoría.
	La lista resultante contiene un máximo de 25 libros, 3 por cada una de las 3 categorías seleccionadas.
	@return una lista de objetos de la clase CategoriaLibros, que contienen el nombre de la categoría y una lista de libros de esa categoría, cada uno representado por un objeto de la clase Libro con su título, foto e ID.
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
	
	/**

	Obtiene todas las categorías de libros presentes en la base de datos y devuelve una lista de objetos CategoriaLibros
	que contienen la categoría y una lista de libros pertenecientes a esa categoría.
	@return una lista de objetos CategoriaLibros que representan todas las categorías de libros presentes en la base de datos
	*/

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
	
	/**
	Retorna una lista de todas las categorías de libros y los libros que pertenecen a cada una de ellas,
	ordenados por categoría y título del libro.
	@return una lista de objetos CategoriaLibros, cada uno de los cuales contiene una categoría y una lista de libros pertenecientes a esa categoría
	@throws SQLException si ocurre un error al ejecutar la consulta SQL
	*/
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
				libro.setId_editorial(rs.getInt("Id_Editorial"));
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
	
	/**

	Busca un libro por su ISBN en la base de datos y devuelve un objeto Libro con la información encontrada.
	@param isbn el número de ISBN del libro a buscar
	@return un objeto Libro con la información del libro encontrado, o un objeto vacío si no se encontró ningún libro con ese ISBN
	*/
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
                libro.setDescripcion(rs.getString("Descripcion"));
				libro.setId_editorial(rs.getInt("Id_Editorial"));
            }
        } catch (SQLException e) {
            
        e.printStackTrace();
        
        }
        return libro;
    }
	
	/**

	Busca un libro por título en la base de datos y devuelve el objeto Libro correspondiente.
	@param libro El objeto Libro con el título a buscar.
	@return El objeto Libro correspondiente al título buscado, o null si no se encontró.
	*/
	public Libro getLibroPorTitulo(Libro libro) {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		try {
			pst = conexion.prepareStatement("SELECT * FROM Libro WHERE Titulo = ?");
			
			pst.setString(1, libro.getTitulo());
			
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
				libro.setId_editorial(rs.getInt("Id_Editorial"));
				libros.add(libro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libro;
	}
	
}