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

import modelo.Libro;
import modelo.ModeloLibro;

/**
 * Servlet implementation class ModificarLibro
 */
@WebServlet("/ModificarLibro")
public class ModificarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarLibro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloLibro modeloLibro = new ModeloLibro();
		Libro libro = new Libro();
		
		modeloLibro.conectar();
		int id_libro = Integer.parseInt(request.getParameter("id_libro"));
		libro = modeloLibro.getLibro(id_libro);
		modeloLibro.cerrar();
		
		request.setAttribute("libro", libro);
		
		request.getRequestDispatcher("ModificarLibro.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat fechaFormato = new SimpleDateFormat("yyyy-MM-dd");
		Libro libro = new Libro();
		ModeloLibro modeloLibro = new ModeloLibro();
		
		int id_libro = Integer.parseInt(request.getParameter("id_libro"));
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
		System.out.println(id_libro);
		try {
			libro.setId_libro(id_libro);
			libro.setIsbn(isbn);
			libro.setTitulo(titulo);
			libro.setNum_paginas(num_pag);
			Date fecha = fechaFormato.parse(fechaR);
			libro.setFecha_publicacion(fecha);
			libro.setIdioma(idioma);
			libro.setStock(stock);
			libro.setCategoria(categoria);
			libro.setFoto(foto);
			libro.setDescripcion(descripcion);
			libro.setId_editorial(id_editorial);
			modeloLibro.conectar();
			modeloLibro.modificarLibro(id_libro, libro);
			modeloLibro.cerrar();
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
	}
		

}
