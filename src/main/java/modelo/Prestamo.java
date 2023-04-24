package modelo;

import java.util.Date;

public class Prestamo {

	private Date fecha_prestamo;
	private String devuelto;
	private int id_usuario;
	private int id_libro;
	
	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}
	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}
	
	public String getDevuelto() {
		return devuelto;
	}
	public void setDevuelto(String devuelto) {
		this.devuelto = devuelto;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getId_libro() {
		return id_libro;
	}
	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}
}
