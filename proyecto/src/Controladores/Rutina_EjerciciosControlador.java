package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Interfaces.Rutina_EjerciciosRepository;
import Modelo.Cliente;
import Modelo.Rutinas_Ejercicios;
import Modelo.Zona_Ejercicio;

public class Rutina_EjerciciosControlador implements Rutina_EjerciciosRepository{
		private final Connection connection;
	
	
	  public Rutina_EjerciciosControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }

	

	@Override
	public List<Rutinas_Ejercicios> getAllRutinasEjercicios() {
        List<Rutinas_Ejercicios> intermediaLista = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM rutinas_ejercicio");
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	Rutinas_Ejercicios intermedia = new Rutinas_Ejercicios(resultSet.getInt("ID_Rutinas"),resultSet.getInt("ID_Ejercicios"));
            	intermediaLista.add(intermedia);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return intermediaLista;
	}


	@Override
	public Rutinas_Ejercicios getRutinasEjerciciosById(int rutina) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void addRutinaEjercicio(Rutinas_Ejercicios rutinaejercicio) {
		try {
        	PreparedStatement statement = connection.prepareStatement("INSERT INTO rutinas_ejercicio(ID_Rutinas, ID_Ejercicios) "
        			+ "VALUES (?,?)"); 
        	statement.setInt(1, rutinaejercicio.getID_Rutinas());
        	statement.setInt(2, rutinaejercicio.getID_Ejercicios());
    
        int rowsInserted = statement.executeUpdate();
        	if (rowsInserted > 0) {
            System.out.println("Rutinaejercicio insertada exitosamente");
        	}
        } catch (SQLException e) {
        		e.printStackTrace();
        }
		
		
	}


	
	
	
	@Override
	public void updateRutinaEjercicio(Rutinas_Ejercicios rutinaejercicio) {
		try {
			PreparedStatement statement = connection.prepareStatement("UPDATE rutinas_ejercicio SET ID_Ejercicios = ? WHERE ID_Rutinas = ?");
	        statement.setInt(1, rutinaejercicio.getID_Ejercicios());
	        statement.setInt(2, rutinaejercicio.getID_Rutinas());
	        
	        int rowsUpdated = statement.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Rutinaejercicio actualizada correctamente");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		
		
	}



	@Override
	public void deleteRutinaEjercicio(int idrutina) {
		try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM rutinas_ejercicio WHERE ID_Rutinas = ?");
            statement.setInt(1, idrutina);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("RutinaEjercicio eliminada exitosamente");
            }
        } catch (SQLException e) {
        	System.out.println("Error en los datos ingresados o la RutinaEjercicio no existe");
            e.printStackTrace();
        }
		
	}




	  
}
