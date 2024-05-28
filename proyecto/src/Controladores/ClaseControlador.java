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
	public void addClase(Profesor profesor, String nombre, LocalDateTime inicio, LocalDateTime fin, int nivel) {
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
        	}
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
		
	}


	@Override
	public void updateClase(Clase clase) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteClase(int id) {
		// TODO Auto-generated method stub
		
	}

}
