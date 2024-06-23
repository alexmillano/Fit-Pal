package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Interfaces.ProfesorRepository;
import Modelo.Profesor;

public class ProfesorControlador implements ProfesorRepository{
	private final Connection connection;
	
	
	  public ProfesorControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }


	@Override
	public List<Profesor> getAllProfesor() {
		List<Profesor> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM profesor ");
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	Profesor user = new Profesor(resultSet.getString("Nombre"), resultSet.getString("Apellido"),
            			resultSet.getString("Contraseña"), resultSet.getInt("DNI"),resultSet.getString("Correo"));
                users.add(user);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
	}


	@Override
	public Profesor getProfesorById(int id) {
		Profesor user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            	user = new Profesor(resultSet.getString("Nombre"), resultSet.getString("Apellido"),
            			resultSet.getString("Contraseña"), resultSet.getInt("DNI"),resultSet.getString("Correo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
	}


	@Override
	public void addProfesor(String nombre, String apellido, String contraseña, int dNI, String correo) {
		 try {
	        	PreparedStatement statement = connection.prepareStatement("INSERT INTO profesor( Apellido, Nombre, Correo, DNI, Contraseña) "
	        			+ "VALUES (?,?,?,?,?)");
	        	statement.setString(1, apellido);
	        	statement.setString(2, nombre);
	        	statement.setString(3, correo);
	        	statement.setInt(5, dNI);
	        	statement.setString(6, contraseña);
	        
	        int rowsInserted = statement.executeUpdate();
	        	if (rowsInserted > 0) {
	            System.out.println("Cliente insertado exitosamente");
	        	}
	        	} catch (SQLException e) {
	        		e.printStackTrace();
	        	}
		
	}


	@Override
	public void updateProfesor(Profesor profesor) {
		try {
			PreparedStatement statement = connection.prepareStatement("UPDATE users SET Nombre = ?, Correo = ? WHERE ID_Profesor = ?");
	        statement.setString(1, profesor.getNombre());
	        statement.setString(3, profesor.getCorreo());
	        statement.setInt(6, profesor.getID_Profesor());

	        
	        int rowsUpdated = statement.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Profesor actualizado correctamente");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	@Override
	public void deleteProfesor(int idProfesor) {
		 try {
	            PreparedStatement statement = connection.prepareStatement("DELETE FROM profesor WHERE ID_Profesor = ?");
	            statement.setInt(1, idProfesor);

	            int rowsDeleted = statement.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Profesor eliminado exitosamente");
	            }
	        } catch (SQLException e) {
	        	System.out.println("Error en los datos ingresados o el profesor no existe");
	            e.printStackTrace();
	        }
		
	}
	
	
	
	public List<Profesor> getAllProfesorConIDProfesor() {
		List<Profesor> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM profesor ");
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	Profesor user = new Profesor(resultSet.getInt("ID_Profesor"),resultSet.getString("Nombre"), resultSet.getString("Apellido"),
            			resultSet.getString("Contraseña"), resultSet.getInt("DNI"),resultSet.getString("Correo"));
                users.add(user);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
	}
	
	  
}
