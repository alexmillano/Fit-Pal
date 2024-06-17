package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Interfaces.ZonaRepository;
import Modelo.Cliente;
import Modelo.Zona_Ejercicio;

public class ZonaControlador implements ZonaRepository{
		private final Connection connection;
	
	
	  public ZonaControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }


	@Override
	public List<Zona_Ejercicio> getAllZonas() {
        List<Zona_Ejercicio> zonas = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM zona_ejercicio ");
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	Zona_Ejercicio zona = new Zona_Ejercicio(resultSet.getInt("ID_Zona_Ejercicio"),resultSet.getString("Nombre"));
            	zonas.add(zona);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zonas;
	}


	@Override
	public Zona_Ejercicio getZonaById(int id) {
	 	Zona_Ejercicio zona = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM zona_ejercicio WHERE ID_Zona_Ejercicio = ?");
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            	zona = new Zona_Ejercicio(resultSet.getString("Nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zona;
	}


	@Override
	public void addZona(Zona_Ejercicio zona_ejercicio) {
		 try {
	        	PreparedStatement statement = connection.prepareStatement("INSERT INTO zona_ejercicio( Nombre) "
	        			+ "VALUES (?)");
	        	statement.setString(1, zona_ejercicio.getNombre());
        
	        int rowsInserted = statement.executeUpdate();
	        	if (rowsInserted > 0) {
	            System.out.println("Zona insertada exitosamente");
	        	}
	        	} catch (SQLException e) {
	        		e.printStackTrace();
	        	}
		
	}


	@Override
	public void updateZona(Zona_Ejercicio zona_ejercicio) {
		try {
			PreparedStatement statement = connection.prepareStatement("UPDATE zona_ejercicio SET Nombre = ? WHERE ID_Zona_Ejercicio = ?");
	        statement.setString(1, zona_ejercicio.getNombre());
	        statement.setInt(2, zona_ejercicio.getID_Zona_Ejercicio());
	        
	        int rowsUpdated = statement.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Zona actualizada correctamente");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}


	@Override
	public void deleteZona(int id) {
		 try {
	            PreparedStatement statement = connection.prepareStatement("DELETE FROM zona_ejercicio WHERE ID_Zona_Ejercicio = ?");
	            statement.setInt(1, id);

	            int rowsDeleted = statement.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Zona eliminada exitosamente");
	            }
	        } catch (SQLException e) {
	        	System.out.println("Error en los datos ingresados o la zona no existe");
	            e.printStackTrace();
	        }
		
	}


	  
}
