package modelo;

import java.util.Date;

public class Reserva {
	private Date fecha_Reserva;
	private int id_usuario;
	private int id_libro;
	
	public Date getFecha_Reserva() {
		return fecha_Reserva;
	}
	public void setFecha_Reserva(Date fecha_Reserva) {
		this.fecha_Reserva = fecha_Reserva;
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
