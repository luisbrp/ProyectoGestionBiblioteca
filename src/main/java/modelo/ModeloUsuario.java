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
			pst = conexion.prepareStatement("INSERT INTO usuario (Id_Usuario, Dni, Nombre, Apellido, Direccion, Tlfno, Email, Rol) VALUES (Secuencia_Usuario.nextval,?,?,?,?,?,?,?)");
			pst.setInt(1, usuario.getId_usuario());
			pst.setString(2, usuario.getDni());
			pst.setString(3, usuario.getNombre());
			pst.setString(4, usuario.getApellido());
			pst.setString(5, usuario.getDireccion());
			pst.setInt(6, usuario.getTelefono());
			pst.setString(7, usuario.getEmail());
			pst.setString(8, usuario.getRol());
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void eliminarUsuario(int id_usuario) {
		try {
			pst = conexion.prepareStatement("DELETE * FROM usuario WHERE Id_Usuario = ?");
			pst.setInt(1, id_usuario);
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void modificarUsuario(int id_usuario) {
		Usuario usuario = new Usuario();
		try {
			pst = conexion.prepareStatement("UPDATE usuario SET Dni = ? Nombre = ? Apellido = ? Direccion = ? Tlfno = ? Email = ? Rol = ? WHERE Id_Usuario = ?");
			pst.setInt(1, id_usuario);
			pst.setString(2, usuario.getDni());
			pst.setString(3, usuario.getNombre());
			pst.setString(3, usuario.getNombre());
			pst.setString(5, usuario.getDireccion());
			pst.setInt(6, usuario.getTelefono());
			pst.setString(7, usuario.getEmail());
			pst.setString(8, usuario.getRol());
			
			
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
			pst = conexion.prepareStatement("SELECT * FROM usuario WHERE Id_Usuario = ?");
			
			pst.setInt(1, id_usuario);
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				usuario.setId_usuario(rs.getInt("Id_Usuario"));
				usuario.setDni(rs.getString("Dni"));
				usuario.setNombre(rs.getString("Nombre"));
				usuario.setApellido(rs.getString("Apellido"));
				usuario.setDireccion(rs.getString("Direccion"));
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
			pst = conexion.prepareStatement("SELECT * FROM usuario");
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId_usuario(rs.getInt("Id_Usuario"));
				usuario.setDni(rs.getString("Dni"));
				usuario.setNombre(rs.getString("Nombre"));
				usuario.setApellido(rs.getString("Apellido"));
				usuario.setDireccion(rs.getString("Direccion"));
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
}