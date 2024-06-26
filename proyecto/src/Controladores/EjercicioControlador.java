package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Interfaces.EjercicioRepository;
import Modelo.Ejercicio;
import Modelo.Zona_Ejercicio;

public class EjercicioControlador implements EjercicioRepository{
	private final Connection connection;
	
	
	  public EjercicioControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }


	@Override
	public List<Ejercicio> getAllEjercicio() {
        List<Ejercicio> ejercicios = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ejercicio ");
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	Ejercicio ejercicio = new Ejercicio(resultSet.getInt("ID_Ejercicios"),resultSet.getString("Nombre"),resultSet.getInt("Repeticiones"), resultSet.getInt("Series") , resultSet.getInt("ID_Zona_Ejercicio"));
            	ejercicios.add(ejercicio);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ejercicios;
	}


	@Override
	public Ejercicio getEjercicioById(int id) {
	 	Ejercicio ejercicio = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ejercicio WHERE ID_Ejercicios = ?");
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            	ejercicio = new Ejercicio(resultSet.getString("Nombre"),resultSet.getInt("Repeticiones"), resultSet.getInt("Series") , resultSet.getInt("ID_Zona_Ejercicio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ejercicio;
	}


	@Override
	public void addEjercicio(Ejercicio ejercicio) {
		 try {
	        	PreparedStatement statement = connection.prepareStatement("INSERT INTO ejercicio( Repeticiones,Nombre, Series, ID_Zona_Ejercicio) "
	        			+ "VALUES (?,?,?,?)");
	        	statement.setInt(1, ejercicio.getRepeticion());
	        	statement.setString(2, ejercicio.getNombre());
	        	statement.setInt(3, ejercicio.getSeries());
	        	statement.setInt(4, ejercicio.getID_Zona_Ejercicio());
     
	        int rowsInserted = statement.executeUpdate();
	        	if (rowsInserted > 0) {
	            System.out.println("Ejercicio insertado exitosamente");
	        	}
	        	} catch (SQLException e) {
	        		e.printStackTrace();
	        	}
		
	}


	@Override
	public void updateEjercicio(Ejercicio ejercicio) {
		try {
			
			PreparedStatement statement = connection.prepareStatement("UPDATE ejercicio SET Repeticiones = ? ,Nombre= ? ,Series= ? , ID_Zona_Ejercicio= ? WHERE ID_Ejercicios  = ?");
        	statement.setInt(1, ejercicio.getRepeticion());
        	statement.setString(2, ejercicio.getNombre());
        	statement.setInt(3, ejercicio.getSeries());
        	statement.setInt(4, ejercicio.getID_Zona_Ejercicio());
        	statement.setInt(5, ejercicio.getID_Ejercicios());
	        
	        int rowsUpdated = statement.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Ejercicio actualizado correctamente");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}


	@Override
	public void deleteEjercicio(int id) {
		 try {
	            PreparedStatement statement = connection.prepareStatement("DELETE FROM ejercicio WHERE ID_Ejercicios  = ?");
	            statement.setInt(1, id);

	            int rowsDeleted = statement.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Ejercicio eliminado exitosamente");
	            }
	        } catch (SQLException e) {
	        	System.out.println("Error en los datos ingresados o el ejercicio no existe");
	            e.printStackTrace();
	        }
		
		
	}


}
