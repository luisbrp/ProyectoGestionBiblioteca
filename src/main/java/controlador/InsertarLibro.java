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
import modelo.ModeloUsuario;
import modelo.Usuario;

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

		request.getRequestDispatcher("InsertarLibro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		try {
			libro.setTitulo(titulo);
			libro.setIsbn(isbn);
			libro.setNum_paginas(num_pag);
			Date fecha = fechaFormato.parse(fechaR);
			libro.setFecha_publicacion(fecha);
			libro.setIdioma(idioma);
			libro.setStock(stock);
			libro.setCategoria(categoria);
			libro.setFoto(foto);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		modeloLibro.conectar();
		modeloLibro.registrarLibro(libro);
		modeloLibro.cerrar();
	}

}
