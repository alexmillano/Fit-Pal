package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Interfaces.RutinaRepository;
import Modelo.Cliente;
import Modelo.Profesor;
import Modelo.Rutina;

public class RutinaControlador implements RutinaRepository {
	private final Connection connection;
	
	
	  public RutinaControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }


	@Override
	public List<Rutina> getAllRutina() {
        List<Rutina> rutinas_bd = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM rutinas ");
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	Rutina rutina = new Rutina (resultSet.getInt("ID_Rutinas"),resultSet.getInt("ID_Profesor")
            			, resultSet.getInt("ID_Nivel"), resultSet.getString("Nombre"));
                rutinas_bd.add(rutina);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rutinas_bd;
	}


	@Override
	public Profesor getRutinaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addRutina(Rutina rutina) {
		 try {
	        	PreparedStatement statement = connection.prepareStatement("INSERT INTO rutinas( ID_Rutinas, ID_Profesor, ID_Nivel, Nombre) "
	        			+ "VALUES (?,?,?,?)");
	        	statement.setInt(1, rutina.getID_Rutinas());
	        	statement.setInt(2, rutina.getID_Profesor());
	        	statement.setInt(3, rutina.getNivel());
	        	statement.setString(4, rutina.getNombre());
  
	        int rowsInserted = statement.executeUpdate();
	        	if (rowsInserted > 0) {
	            System.out.println("Rutina insertada exitosamente");
	        	}
	        	} catch (SQLException e) {
	        		e.printStackTrace();
	        	}
		
	}


	@Override
	public void updateRutina(Rutina rutina) {
	try {
			
			PreparedStatement statement = connection.prepareStatement("UPDATE rutinas SET ID_Profesor = ? ,ID_Nivel= ? ,Nombre= ? ");
        	statement.setInt(1, rutina.getID_Profesor());
        	statement.setInt(2, rutina.getNivel());
        	statement.setString(3, rutina.getNombre());
	        
	        int rowsUpdated = statement.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Rutina actualizada correctamente");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		
	}


	@Override
	public void deleteRutina(int id) {
		 try {
	            PreparedStatement statement = connection.prepareStatement("DELETE FROM rutinas WHERE ID_Rutinas  = ?");
	            statement.setInt(1, id);

	            int rowsDeleted = statement.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Rutina eliminada exitosamente");
	            }
	        } catch (SQLException e) {
	        	System.out.println("Error en los datos ingresados o la rutina no existe");
	            e.printStackTrace();
	        }
		
	}
	  
}
