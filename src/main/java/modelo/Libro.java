package modelo;

import java.util.Date;

public class Libro {
	private int id_libro;
	private long isbn;
	private String titulo;
	private int num_paginas;
	private Date fecha_publicacion;
	private String idioma;
	private int stock;
	private String categoria;
	private String descripcion;
	private String foto;
	private String editorial;
	
	
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public int getId_libro() {
		return id_libro;
	}
	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getNum_paginas() {
		return num_paginas;
	}
	public void setNum_paginas(int num_paginas) {
		this.num_paginas = num_paginas;
	}
	public Date getFecha_publicacion() {
		return fecha_publicacion;
	}
	public void setFecha_publicacion(Date fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
}
