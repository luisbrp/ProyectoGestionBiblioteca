package modelo;

import java.util.ArrayList;

public class CategoriaLibros {
	private String categoria;
	private ArrayList<Libro> libros;
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public ArrayList<Libro> getLibros() {
		return libros;
	}
	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	
	
}
