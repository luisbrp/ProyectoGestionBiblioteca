package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloEditorial extends Conector {
	PreparedStatement pst;
	ResultSet rs;
	
	public void registrarEditorial(Editorial editorial) {
		try {
			pst = conexion.prepareStatement("INSERT INTO editorial (Nombre) VALUES (?)");
			pst.setString(1, editorial.getNombre());	
			pst.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void eliminarEditorial(int id_editorial) {
		try {
			pst = conexion.prepareStatement("DELETE FROM editorial WHERE Id_Editorial = ?");
			pst.setInt(1, id_editorial);
			
			pst.execute();
		} catch (SQLException e) {
		    
			e.printStackTrace();
		}
	}
	
	public void modificarEditorial(int id_editorial, Editorial editorial) {
		try {
			pst = conexion.prepareStatement("UPDATE editorial SET Nombre = ? WHERE Id_Editorial = ?");
			pst.setString(1, editorial.getNombre());
			pst.setInt(2, id_editorial);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Editorial getEditorial(int id_editorial) {
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		try {
			pst = conexion.prepareStatement("SELECT * FROM editorial WHERE Id_Editorial = ?");
			pst.setInt(1, id_editorial);
			
			rs = pst.executeQuery();
			while(rs.next()) {
				Editorial editorial = new Editorial();
				editorial.setId_editorial(rs.getInt("Id_Editorial"));
				editorial.setNombre(rs.getString("Nombre"));
				editoriales.add(editorial);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(editoriales.size() > 0) {
			return editoriales.get(0);
		} else {
			return null;
		}
	}

	
	public ArrayList<Editorial> getEditoriales() {
		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		try {
			pst = conexion.prepareStatement("SELECT * FROM editorial");
			
			pst.executeQuery();
			
			rs = pst.executeQuery();
			while(rs.next()) {
				Editorial editorial = new Editorial();
				editorial.setId_editorial(rs.getInt("Id_Editorial"));
				editorial.setNombre(rs.getString("Nombre"));
				editoriales.add(editorial);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return editoriales;
	}
	public Editorial getEditorialPorNombre(String nombre) {
        ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
        Editorial editorial = new Editorial();
        try {
            pst = conexion.prepareStatement("SELECT * FROM editorial WHERE Nombre = ?");
            pst.setString(1, nombre);
            
            rs = pst.executeQuery();
            while(rs.next()) {
                editorial.setId_editorial(rs.getInt("Id_Editorial"));
                editorial.setNombre(rs.getString("Nombre"));
                editoriales.add(editorial);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return editorial;
    }
}
