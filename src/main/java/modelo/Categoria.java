package modelo;

import java.util.ArrayList;

public class Categoria {
	private String categoria; 
	private ArrayList<Libro> librosPorCategoria;
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public ArrayList<Libro> getLibrosPorCategoria() {
		return librosPorCategoria;
	}
	public void setLibrosPorCategoria(ArrayList<Libro> librosPorCategoria) {
		this.librosPorCategoria = librosPorCategoria;
	}
	
	
}
