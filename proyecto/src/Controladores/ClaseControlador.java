package Controladores;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import Interfaces.ClaseRepository;
import Modelo.Clase;
import Modelo.Profesor;

public class ClaseControlador implements ClaseRepository{
	private final Connection connection;
	
	
	  public ClaseControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }


	@Override
	public List<Clase> getAllClase() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Clase getClaseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean addClase(Profesor profesor, String nombre, LocalDateTime inicio, LocalDateTime fin, int nivel) {
		boolean clasecreada = false;
		try {
        	PreparedStatement statement = connection.prepareStatement("INSERT INTO clases(ID_Profesor, ID_Nivel, Nombre, inicio, fin) "
        			+ "VALUES (?,?,?,?,?)");
        	statement.setInt(1, profesor.getID_Profesor());
        	statement.setInt(2, nivel);
        	statement.setString(3, nombre);
        	statement.setTimestamp(4, Timestamp.valueOf(inicio));
            statement.setTimestamp(5, Timestamp.valueOf(fin));

        int rowsInserted = statement.executeUpdate();
        	if (rowsInserted > 0) {
            System.out.println("Clase insertada exitosamente");
            clasecreada=true;
        	}
        	} catch (SQLException e) {
        		System.out.println("Error al agregar clase: " + e.getMessage());
        		e.printStackTrace();
        		clasecreada=false;
        	}
		return clasecreada;
	}


	@Override
	public boolean updateClase(Clase clase) {
		boolean actualizar = false;
		try {
			PreparedStatement statement = connection.prepareStatement("UPDATE users SET ID_Profesor = ?, ID_Nivel = ?, Nombre = ? WHERE ID_Clases = ?");
	        statement.setInt(1, clase.getProfesor());
	        statement.setInt(2, clase.getNivel());
	        statement.setString(3, clase.getNombre());

	        
	        int rowsUpdated = statement.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Clase actualizada correctamente");
	            actualizar = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        actualizar = false;
	    }
		return actualizar;
		
	}


	@Override
	public boolean deleteClase(int idClase) {
		boolean claseborrada = false;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM clases WHERE ID_Clases = ?");
            statement.setInt(1, idClase);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Clase eliminada exitosamente");
                claseborrada = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            claseborrada = false;
        }
        return claseborrada;
		
	}

}
