package modelo;

import java.util.Date;

public class Reserva {
	private int id_reserva;
	private Date fecha_prestamo;
	private boolean devuelto;
	private Usuario id_usuario;
	private Libro id_libro;
	
	public int getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}
	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}
	public boolean isDevuelto() {
		return devuelto;
	}
	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}
	public Usuario getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Libro getId_libro() {
		return id_libro;
	}
	public void setId_libro(Libro id_libro) {
		this.id_libro = id_libro;
	}
	
}