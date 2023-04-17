package modelo;

public class Editorial {
	private int id_editorial;
	private String nombre;
	private Libro id_libro;
	
	public int getId_editorial() {
		return id_editorial;
	}
	public void setId_editorial(int id_editorial) {
		this.id_editorial = id_editorial;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Libro getId_libro() {
		return id_libro;
	}
	public void setId_libro(Libro id_libro) {
		this.id_libro = id_libro;
	}
	
}
