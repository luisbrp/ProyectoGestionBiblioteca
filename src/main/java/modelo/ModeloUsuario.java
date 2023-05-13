package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloUsuario extends Conector{
	PreparedStatement pst;
	ResultSet rs;
	
	/**
	Registra un nuevo usuario en la base de datos.
	@param usuario El objeto Usuario a insertar.
	*/
	public void registrarUsuario(Usuario usuario) {
		try {
			pst = conexion.prepareStatement("INSERT INTO Usuario (Dni, Nombre, Apellido, Direccion, Contraseña, Tlfno, Email, Rol) VALUES (?,?,?,?,?,?,?,?)");
			pst.setString(1, usuario.getDni());
			pst.setString(2, usuario.getNombre());
			pst.setString(3, usuario.getApellido());
			pst.setString(4, usuario.getDireccion());
			pst.setString(5, usuario.getContrasena());
			pst.setInt(6, usuario.getTelefono());
			pst.setString(7, usuario.getEmail());
			pst.setString(8, usuario.getRol());
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	Registra un nuevo usuario en la base de datos, estableciendo "Cliente" como valor por defecto para el campo "Rol" en caso de que este sea nulo o vacío.
	@param usuario El objeto Usuario a insertar.
	*/
	public void registroDeUsuario(Usuario usuario) {
		try {
			pst = conexion.prepareStatement("INSERT INTO Usuario (Dni, Nombre, Apellido, Direccion, Contraseña, Tlfno, Email, Rol) VALUES (?,?,?,?,?,?,?,?)");
			pst.setString(1, usuario.getDni());
			pst.setString(2, usuario.getNombre());
			pst.setString(3, usuario.getApellido());
			pst.setString(4, usuario.getDireccion());
			pst.setString(5, usuario.getContrasena());
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

	/**

	Elimina un usuario de la base de datos.
	@param id_usuario El ID del usuario a eliminar.
	*/
	public void eliminarUsuario(int id_usuario) {
		
		try {
			pst = conexion.prepareStatement("DELETE FROM Usuario WHERE Id_Usuario = ?");
			pst.setInt(1, id_usuario);
			
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	Modifica los datos de un usuario existente en la base de datos.
	@param id_usuario El ID del usuario a modificar.
	@param usuario El objeto Usuario con los nuevos valores a actualizar.
	*/
	public void modificarUsuario(int id_usuario, Usuario usuario) {
		try {
			pst = conexion.prepareStatement("UPDATE Usuario SET Dni = ?, Nombre = ?, Apellido = ?, Direccion = ?, Contraseña = ?, Tlfno = ?, Email = ?, Rol = ? WHERE Id_Usuario = ?");
			pst.setString(1, usuario.getDni());
			pst.setString(2, usuario.getNombre());
			pst.setString(3, usuario.getApellido());
			pst.setString(4, usuario.getDireccion());
			pst.setString(5, usuario.getContrasena());
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
	
	/**

	Busca un usuario en la base de datos a partir de su ID de usuario.
	@param id_usuario El ID del usuario a buscar.
	@return El usuario encontrado o null si no se encuentra.
	*/
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
				usuario.setContrasena(rs.getString("Contraseña"));
				usuario.setEmail(rs.getString("Email"));
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
	
	/**

	Obtiene todos los usuarios de la base de datos.
	@return Un ArrayList que contiene todos los usuarios de la base de datos.
	*/
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
				usuario.setContrasena(rs.getString("Contraseña"));
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
	
	/**

	Obtiene la contraseña de un usuario a partir de su DNI.
	@param Dni El DNI del usuario del que se quiere obtener la contraseña.
	@return La contraseña del usuario.
	@throws SQLException si se produce un error de SQL.
	*/
	public String getContrasena(String Dni) throws SQLException {
		
		pst = conexion.prepareStatement("SELECT Contraseña FROM usuario WHERE Dni = ?; ");
		
		pst.setString(1, Dni);
		
		pst.executeQuery();

		rs = pst.executeQuery();
		
		Usuario usuario = new Usuario();
		
		while(rs.next()) {	
		usuario.setContrasena(rs.getString("Contraseña"));
		}
		
		return usuario.getContrasena();
	}
	
	/**

	Busca un usuario en la base de datos a partir de su DNI y contraseña.
	@param Dni El DNI del usuario a buscar.
	@param contrasena La contraseña del usuario a buscar.
	@return El usuario encontrado o null si no se encuentra.
	@throws SQLException si se produce un error de SQL.
	*/
public Usuario getUsuarioLogin(String Dni, String contrasena) throws SQLException {
	
	pst = conexion.prepareStatement("SELECT u.* FROM usuario u WHERE u.Dni = ? AND u.Contraseña = ?;");
	
	pst.setString(1, Dni);
	pst.setString(2, contrasena);
	
	pst.executeQuery();

	rs = pst.executeQuery();
	
	Usuario usuario = new Usuario();
	
	while(rs.next()) {	
	
	usuario.setId_usuario(rs.getInt("Id_usuario"));
	usuario.setNombre(rs.getString("Nombre"));
	usuario.setContrasena(rs.getString("Contraseña"));
	usuario.setApellido(rs.getString("Apellido"));
	usuario.setDni(rs.getString("Dni"));
	usuario.setDireccion(rs.getString("Direccion"));
	usuario.setTelefono(rs.getInt("Tlfno"));
	usuario.setEmail(rs.getString("Email"));
	usuario.setRol(rs.getString("Rol"));
	}
	
	return usuario;
}
	/**
	Devuelve el objeto Usuario correspondiente al dni especificado.
	@param dni el dni del usuario a buscar
	@return el objeto Usuario correspondiente al dni especificado
	*/
public Usuario getUsuarioPorDni(String dni) {
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    Usuario usuario = new Usuario();
    try {
        pst = conexion.prepareStatement("SELECT * FROM Usuario WHERE Dni = ?");
        
        pst.setString(1, dni);
        
        pst.executeQuery();
        
        rs = pst.executeQuery();
        while(rs.next()) {
            usuario.setId_usuario(rs.getInt("Id_Usuario"));
            usuario.setDni(rs.getString("Dni"));
            usuario.setNombre(rs.getString("Nombre"));
            usuario.setApellido(rs.getString("Apellido"));
            usuario.setDireccion(rs.getString("Direccion"));
            usuario.setContrasena(rs.getString("Contrasena"));
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
}
