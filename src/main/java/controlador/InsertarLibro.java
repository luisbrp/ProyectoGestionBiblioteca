package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Libro;
import modelo.ModeloAutor;
import modelo.ModeloLibro;
import modelo.ModeloLibro_Info;
import modelo.Editorial;

import modelo.Autor;

/**
 * Servlet implementation class InsertarLibro
 */
@WebServlet("/InsertarLibro")
public class InsertarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarLibro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   HttpSession session = request.getSession();
           Editorial editorialCompleta = (Editorial) session.getAttribute("editorial");
           int id_editorial = (Integer) session.getAttribute("id_editorial");

           if (editorialCompleta != null) {
               request.setAttribute("editorialCompleta", editorialCompleta);
               request.getRequestDispatcher("InsertarLibro.jsp").forward(request, response);
           } else if (id_editorial != 0) {
               request.setAttribute("id_editorial", id_editorial);
               request.getRequestDispatcher("InsertarLibro.jsp").forward(request, response);
           }
       }
    


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @param: Inserta un libro y realiza un insert automatico a la tabla Libro_Info
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloLibro_Info  modeloLibroInfo = new ModeloLibro_Info(); 
		ModeloAutor modeloAutor = new ModeloAutor();
		HttpSession session = request.getSession();
		Autor autor = (Autor) session.getAttribute("autor");
		Autor autorSoloConId = (Autor) session.getAttribute("autorSoloConId");


		
		SimpleDateFormat fechaFormato = new SimpleDateFormat("yyyy-MM-dd");
		Libro libro = new Libro();
		ModeloLibro modeloLibro = new ModeloLibro();
		
		Long isbn = Long.parseLong(request.getParameter("isbn"));
		String titulo = request.getParameter("titulo");
		int num_pag = Integer.parseInt(request.getParameter("num_pag"));
		String fechaR = request.getParameter("fecha");
		String idioma = request.getParameter("idioma");
		int stock = Integer.parseInt(request.getParameter("stock"));
		String categoria = request.getParameter("categoria");
		String foto = request.getParameter("foto");
		String descripcion = request.getParameter("descripcion");
		int id_editorial = Integer.parseInt(request.getParameter("id_editorial"));
		
		System.out.println(autor);
		    try {
		        Date fecha = fechaFormato.parse(fechaR);
		        libro.setFecha_publicacion(fecha);
		        libro.setTitulo(titulo);
				libro.setIsbn(isbn);
				libro.setNum_paginas(num_pag);
				libro.setIdioma(idioma);
				libro.setStock(stock);
				libro.setCategoria(categoria);
				libro.setFoto(foto);
				libro.setDescripcion(descripcion);
				libro.setId_editorial(id_editorial);
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		
		modeloLibro.conectar();
		modeloLibro.registrarLibro(libro);
		
		if (libro != null) {
		    modeloLibro.conectar();
		    Libro libroCompleto = modeloLibro.getLibroPorTitulo(libro);
		    modeloLibro.cerrar();

		    modeloLibroInfo.conectar();
		    if (autor != null) {
		    	String nombre = autor.getNombre();

		    	modeloAutor.conectar();
		    	Autor autorCompleto = modeloAutor.getAutorPorNombre(nombre);
		    	modeloAutor.cerrar();

		        modeloLibroInfo.insertarLibro_Info(autorCompleto, libroCompleto);
		    } else {
		        modeloLibroInfo.insertarLibro_Info(autorSoloConId, libroCompleto);
		    }
		    modeloLibroInfo.cerrar();
		} 
		modeloLibro.cerrar();

	}

}
