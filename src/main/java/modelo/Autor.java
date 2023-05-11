package modelo;

public class Autor {
	@Override
	public String toString() {
		return "Autor [id_autor=" + id_autor + ", nombre=" + nombre + ", apellido=" + apellido + ", descripcion="
				+ descripcion + "]";
	}
	private int id_autor;
	private String nombre;
	private String apellido;
	private String descripcion;
	private String foto;
	
	public int getId_autor() {
		return id_autor;
	}
	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
}
