package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloUsuario extends Conector{
	PreparedStatement pst;
	ResultSet rs;
	public void registrarUsuario(Usuario usuario) {
		try {
			pst = conexion.prepareStatement("INSERT INTO Usuario (Dni, Nombre, Apellido, Direccion, Contraseña, Tlfno, Email, Rol) VALUES (?,?,?,?,?,?,?,?)");
			pst.setString(1, usuario.getDni());
			pst.setString(2, usuario.getNombre());
			pst.setString(3, usuario.getApellido());
			pst.setString(4, usuario.getDireccion());
			pst.setString(5, usuario.getContraseña());
			pst.setInt(6, usuario.getTelefono());
			pst.setString(7, usuario.getEmail());
			pst.setString(8, usuario.getRol());
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void registroDeUsuario(Usuario usuario) {
		try {
			pst = conexion.prepareStatement("INSERT INTO Usuario (Dni, Nombre, Apellido, Direccion, Contraseña, Tlfno, Email, Rol) VALUES (?,?,?,?,?,?,?,?)");
			pst.setString(1, usuario.getDni());
			pst.setString(2, usuario.getNombre());
			pst.setString(3, usuario.getApellido());
			pst.setString(4, usuario.getDireccion());
			pst.setString(5, usuario.getContraseña());
			pst.setInt(6, usuario.getTelefono());
			pst.setString(7, usuario.getEmail());
			if(usuario.getRol() == null || usuario.getRol().isEmpty()) {
				usuario.setRol("Cliente");
			}
			pst.setString(8, usuario.getRol());
			
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	
	public void eliminarUsuario(int id_usuario) {
		
		try {
			pst = conexion.prepareStatement("DELETE FROM Usuario WHERE Id_Usuario = ?");
			pst.setInt(1, id_usuario);
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void modificarUsuario(int id_usuario, Usuario usuario) {
		try {
			pst = conexion.prepareStatement("UPDATE Usuario SET Dni = ?, Nombre = ?, Apellido = ?, Direccion = ?, Contraseña = ?, Tlfno = ?, Email = ?, Rol = ? WHERE Id_Usuario = ?");
			pst.setString(1, usuario.getDni());
			pst.setString(2, usuario.getNombre());
			pst.setString(3, usuario.getApellido());
			pst.setString(4, usuario.getDireccion());
			pst.setString(5, usuario.getContraseña());
			pst.setInt(6, usuario.getTelefono());
			pst.setString(7, usuario.getEmail());
			pst.setString(8, usuario.getRol());
			pst.setInt(9, id_usuario);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Usuario getUsuario(int id_usuario) {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario();
		try {
			pst = conexion.prepareStatement("SELECT * FROM Usuario WHERE Id_Usuario = ?");
			
			pst.setInt(1, id_usuario);
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				usuario.setId_usuario(rs.getInt("Id_Usuario"));
				usuario.setDni(rs.getString("Dni"));
				usuario.setNombre(rs.getString("Nombre"));
				usuario.setApellido(rs.getString("Apellido"));
				usuario.setDireccion(rs.getString("Direccion"));
				usuario.setContraseña(rs.getString("Contraseña"));
				usuario.setTelefono(rs.getInt("Tlfno"));
				usuario.setRol(rs.getString("Rol"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}
	
	public ArrayList<Usuario> getUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			pst = conexion.prepareStatement("SELECT * FROM Usuario");
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId_usuario(rs.getInt("Id_Usuario"));
				usuario.setDni(rs.getString("Dni"));
				usuario.setNombre(rs.getString("Nombre"));
				usuario.setApellido(rs.getString("Apellido"));
				usuario.setDireccion(rs.getString("Direccion"));
				usuario.setContraseña(rs.getString("Contraseña"));
				usuario.setTelefono(rs.getInt("Tlfno"));
				usuario.setRol(rs.getString("Rol"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarios;
	}
public String getContraseña(String Dni) throws SQLException {
		
		pst = conexion.prepareStatement("SELECT Contraseña FROM usuario WHERE Dni = ?; ");
		
		pst.setString(1, Dni);
		
		pst.executeQuery();

		rs = pst.executeQuery();
		
		Usuario usuario = new Usuario();
		
		while(rs.next()) {	
		usuario.setContraseña(rs.getString("Contraseña"));
		}
		
		return usuario.getContraseña();
	}
public Usuario getUsuarioLogin(String Dni, String contraseña) throws SQLException {
	
	pst = conexion.prepareStatement("SELECT u.* FROM usuario u WHERE u.Dni = ? AND u.Contraseña = ?;");
	
	pst.setString(1, Dni);
	pst.setString(2, contraseña);
	
	pst.executeQuery();

	rs = pst.executeQuery();
	
	Usuario usuario = new Usuario();
	
	while(rs.next()) {	
	
	usuario.setId_usuario(rs.getInt("Id_usuario"));
	usuario.setNombre(rs.getString("Nombre"));
	usuario.setContraseña(rs.getString("Contraseña"));
	usuario.setApellido(rs.getString("Apellido"));
	usuario.setDni(rs.getString("Dni"));
	usuario.setDireccion(rs.getString("Direccion"));
	usuario.setTelefono(rs.getInt("Tlfno"));
	usuario.setEmail(rs.getString("Email"));
	usuario.setRol(rs.getString("Rol"));
	}
	
	return usuario;
}
}
